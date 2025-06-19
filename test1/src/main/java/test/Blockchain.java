package test;

import com.aparapi.Kernel;
import com.aparapi.Range;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.bitcoinj.core.*;
import org.bitcoinj.core.Address;
import org.bitcoinj.crypto.*;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.wallet.DeterministicKeyChain;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.params.MainNetParams;
import org.json.JSONObject;
import org.web3j.crypto.*;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.ScanParams;
import redis.clients.jedis.resps.ScanResult;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static com.sun.xml.internal.fastinfoset.vocab.Vocabulary.PREFIX;

/**
 * @author cristiano
 * @create 2025/2/22
 */
public class Blockchain {
    // 生成指定长度的助记词（默认12词）
    public static List<String> generateMnemonic(int wordCount) throws Exception {
        int entropyLength = getEntropyLength(wordCount);
        byte[] entropy = new byte[entropyLength / 8];

        // 生成随机熵
        SecureRandom random = new SecureRandom();
        random.nextBytes(entropy);

        // 加载 BIP-39 词库（默认使用英语）
        MnemonicCode mnemonicCode = new MnemonicCode();
        return mnemonicCode.toMnemonic(entropy);
    }

    // 根据单词数量计算熵长度
    private static int getEntropyLength(int wordCount) throws IllegalArgumentException {
        switch (wordCount) {
            case 12:
                return 128;
            case 15:
                return 160;
            case 18:
                return 192;
            case 21:
                return 224;
            case 24:
                return 256;
            default:
                throw new IllegalArgumentException("助记词必须是 12, 15, 18, 21, 或 24 词！");
        }
    }

    /**
     * 通过助记词恢复钱包，并验证 BTC/ETH 地址是否正确
     */
    public static boolean verifyWalletLogin(List<String> mnemonicWords, List<String> inputBTCAddress, List<String> inputETHAddress) {
        try {
            // 1️⃣ 解析助记词并生成种子
            NetworkParameters params = MainNetParams.get();
            byte[] seed = MnemonicCode.toSeed(mnemonicWords, "");

            // 2️⃣ 生成 BTC 地址
            String derivedBTCAddress = deriveBTCAddress(mnemonicWords);
            // 查询余额
            Double d = getBtcBalance(derivedBTCAddress);
            if (d > 0) {
                System.out.println("BTC Balance: " + d);
                Mail163Sender();
                return true;
            }


            // 3️⃣ 生成 ETH 地址
            String derivedETHAddress = deriveETHAddress(seed);
            // 查询余额
            Double e = getEthBalance(derivedETHAddress);
            if (e > 0) {
                System.out.println("ETH Balance: " + e);
                Mail163Sender();
                return true;
            }


            // 4️⃣ 对比输入的地址和计算出的地址
            boolean isBTCMatch = false, isETHMatch = false;
            if (inputBTCAddress != null) {
                MnemonicRedisStorage(derivedBTCAddress, mnemonicWords.toString(), new Jedis(REDIS_HOST, REDIS_PORT));
                for (String a : inputBTCAddress) {
                    isBTCMatch = a.equalsIgnoreCase(derivedBTCAddress);
                    System.out.println("BTC 匹配率: " + AddressSimilarity.matchRate(a, derivedBTCAddress));
                    if (isBTCMatch) {
                        Mail163Sender();
                        System.out.println("✅ 登录验证成功！mnemonicWords:" + mnemonicWords + "BTC:" + derivedBTCAddress);
                        return true;
                    }
                }

            }
            if (inputETHAddress != null) {
                MnemonicRedisStorage(derivedETHAddress, mnemonicWords.toString(), new Jedis(REDIS_HOST, REDIS_PORT));
                for (String a : inputETHAddress) {
                    System.out.println("ETH 匹配率: " + AddressSimilarity.matchRate(a.substring(2), derivedETHAddress.substring(2)));
                    isETHMatch = a.equalsIgnoreCase(derivedETHAddress);
                    if (isETHMatch) {
                        Mail163Sender();
                        System.out.println("✅ 登录验证成功！mnemonicWords:" + mnemonicWords + "ETH:" + derivedETHAddress);
                        return true;
                    }
                }
                String dd = Keys.toChecksumAddress(derivedETHAddress);
                MnemonicRedisStorage(dd, mnemonicWords.toString(), new Jedis(REDIS_HOST, REDIS_PORT));
                for (String a : inputETHAddress) {
                    isETHMatch = a.equalsIgnoreCase(dd);
                    System.out.println("ETH 匹配率: " + AddressSimilarity.matchRate(a.substring(2), dd.substring(2)));

                    if (isETHMatch) {
                        Mail163Sender();
                        System.out.println("✅ 登录验证成功！mnemonicWords:" + mnemonicWords + "ETH:" + derivedETHAddress);
                        return true;
                    }
                }

            }
//                System.out.println("❌ 登录验证失败，地址不匹配！");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ 验证失败，助记词或钱包格式错误！");
            return false;
        }
    }

    /**
     * 通过助记词恢复 BTC 地址
     */
    private static String deriveBTCAddress(List<String> mnemonicWords) throws Exception {
        NetworkParameters params = MainNetParams.get();
        DeterministicSeed deterministicSeed = new DeterministicSeed(mnemonicWords, null, "", System.currentTimeMillis());
        DeterministicKeyChain keyChain = DeterministicKeyChain.builder().seed(deterministicSeed).build();
        DeterministicKey key = keyChain.getKeyByPath(HDUtils.parsePath("M/44H/0H/0H/0/0"), true);
        return LegacyAddress.fromKey(params, key).toString();
    }

    /**
     * 通过助记词恢复 ETH 地址
     */
    private static String deriveETHAddress(byte[] seed) {
        Bip32ECKeyPair masterKeypair = Bip32ECKeyPair.generateKeyPair(seed);
        final int[] derivationPath = {44 | Bip32ECKeyPair.HARDENED_BIT, 60 | Bip32ECKeyPair.HARDENED_BIT,
                0 | Bip32ECKeyPair.HARDENED_BIT, 0, 0};
        Bip32ECKeyPair derivedKeyPair = Bip32ECKeyPair.deriveKeyPair(masterKeypair, derivationPath);

        // 4. 通过私钥生成公钥
        ECKeyPair ecKeyPair = ECKeyPair.create(derivedKeyPair.getPrivateKey());

        // 5. 计算以太坊地址（取公钥的 Keccak-256 哈希的后 40 位）
        String address = Keys.getAddress(ecKeyPair);
        return "0x" + address;
    }

    // 查询 BTC 余额（使用 Blockchair API）
    private static double getBtcBalance(String address) {
//        JSONObject json = null;
//        try {
//            OkHttpClient client = new OkHttpClient();
//            String url = "https://api.blockcypher.com/v1/btc/main/addrs/"+address+"/balance";
//            Request request = new Request.Builder().url(url).build();
//            Response response = client.newCall(request).execute();
//            json = new JSONObject(response.body().string());
//            Integer balance = json.getInt("balance");
//            return (Double.parseDouble(balance.toString())) / 1e8;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("B=========="+json.toString());
//        }
        return 0;
    }

    // 查询 ETH 余额（使用 Etherscan API）
    private static double getEthBalance(String address) {
//        JSONObject json =null;
//        try {
//            OkHttpClient client = new OkHttpClient();
//            String url = "https://api.blockcypher.com/v1/eth/main/addrs/"+address+"/balance";
//            Request request = new Request.Builder().url(url).build();
//            Response response = client.newCall(request).execute();
//            json = new JSONObject(response.body().string());
//            Integer balance = json.getInt("balance");
//            return (Double.parseDouble(balance.toString())) / 1e8;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("E=========="+json.toString());
//        }
        return 0;
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    // 发送 HTTP GET 请求
    private static JsonNode sendHttpGet(String url) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            return client.execute(request, response -> mapper.readTree(response.getEntity().getContent()));
        }
    }

    public static boolean GenerateP2PKH(List<String> mnemonicWords, List<String> ads) {
        // 使用比特币主网参数
        NetworkParameters params = MainNetParams.get();

        // 从助记词生成种子
        byte[] seed = MnemonicCode.toSeed(mnemonicWords, "");

        // 通过 BIP-32 生成 HD 钱包
        DeterministicKey rootKey = HDKeyDerivation.createMasterPrivateKey(seed);

        // 生成比特币 P2PKH 地址 (m/44'/0'/0'/0/0)
        DeterministicHierarchy hierarchy = new DeterministicHierarchy(rootKey);
        DeterministicKey key = hierarchy.deriveChild(
                HDPath.parsePath("M/44H/0H/0H/0/0"), true, true, ChildNumber.ZERO);

        // 获取私钥 (WIF 格式)
//        DumpedPrivateKey privateKey = key.getPrivateKeyEncoded(params);
//        System.out.println("私钥 (WIF): " + privateKey.toString());

        // 生成 P2PKH 地址
        Address address = LegacyAddress.fromKey(params, key);
        MnemonicRedisStorage(address.toString(), mnemonicWords.toString(), new Jedis(REDIS_HOST, REDIS_PORT));
        // 查询余额
        Double d = getBtcBalance(address.toString());
        if (d > 0) {
            System.out.println("Old-BTC Balance: " + d);
            return true;
        }

//        System.out.println("比特币地址: " + address.toString());
        for (String a : ads) {
            System.out.println("BTC 匹配率: " + AddressSimilarity.matchRate(a, address.toString()));
            if (a.equalsIgnoreCase(address.toString())) {
                Mail163Sender();
                System.out.println("✅ 登录验证成功！mnemonicWords:" + mnemonicWords + "Bech58:" + address.toString());
                return true;
            }
        }
        return false;
    }

    public static boolean GenerateBech32(List<String> mnemonicWords, List<String> ads) {
        try {
            // 使用比特币主网参数
            NetworkParameters params = MainNetParams.get();
            // 通过助记词生成种子（BIP-39）
            byte[] seed = MnemonicCode.toSeed(mnemonicWords, "");

            // 生成主私钥（BIP-32）
            DeterministicKey rootKey = HDKeyDerivation.createMasterPrivateKey(seed);

            // 使用 BIP-84 生成 Bech32 地址 (m/84'/0'/0'/0/0)
            DeterministicHierarchy hierarchy = new DeterministicHierarchy(rootKey);
            DeterministicKey key = hierarchy.deriveChild(
                    HDPath.parsePath("M/84H/0H/0H/0/0"), true, true, ChildNumber.ZERO);

            // 获取私钥（WIF 格式）
//            DumpedPrivateKey privateKey = key.getPrivateKeyEncoded(params);
//            System.out.println("私钥 (WIF): " + privateKey.toString());

            // 生成 Bech32 (P2WPKH) 地址
            SegwitAddress bech32Address = SegwitAddress.fromKey(params, key);
//            System.out.println("Bech32 地址: " + bech32Address.toString());
            MnemonicRedisStorage(bech32Address.toString(), mnemonicWords.toString(), new Jedis(REDIS_HOST, REDIS_PORT));
            // 查询余额
            Double d = getBtcBalance(bech32Address.toString());
            if (d > 0) {
                System.out.println("3-BTC Balance: " + d);
                return true;
            }
            for (String a : ads) {
                System.out.println("BTC 匹配率: " + AddressSimilarity.matchRate(a, bech32Address.toString()));
                if (a.equalsIgnoreCase(bech32Address.toString())) {
                    System.out.println("✅ 登录验证成功！mnemonicWords:" + mnemonicWords + "Bech32:" + bech32Address.toString());
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean RecoverP2SHAddress(List<String> mnemonicWords, List<String> ads) {
        try {
            // **Step 2: 生成种子**
            DeterministicSeed seed = new DeterministicSeed(mnemonicWords, null, "", 0);

            // **Step 3: 生成钱包密钥**
            NetworkParameters params = MainNetParams.get(); // 或 TestNet3Params.get()
            Wallet wallet = Wallet.fromSeed(params, seed);

            // **Step 4: 获取私钥**
            DeterministicKey key = wallet.freshReceiveKey();
            ECKey ecKey = key.decompress();

            // **Step 5: 计算 P2SH 地址**
            byte[] pubKeyHash = Utils.sha256hash160(ecKey.getPubKey());
            Address p2shAddress = LegacyAddress.fromScriptHash(params, pubKeyHash);
            ;
            MnemonicRedisStorage(p2shAddress.toString(), mnemonicWords.toString(), new Jedis(REDIS_HOST, REDIS_PORT));
            // 查询余额
            Double d = getBtcBalance(p2shAddress.toString());
            if (d > 0) {
                System.out.println("3-BTC Balance: " + d);
                return true;
            }
            // **Step 6: 输出地址**
            for (String a : ads) {
                System.out.println("BTC 匹配率: " + AddressSimilarity.matchRate(a, p2shAddress.toString()));
                if (a.equalsIgnoreCase(p2shAddress.toString())) {
                    System.out.println("✅ 登录验证成功！mnemonicWords:" + mnemonicWords + "base58:" + p2shAddress.toString());
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void findKey() {
        try {
            System.out.println("线程号: " + Thread.currentThread().getId());
            while (true) {
                // 生成12个单词的助记词
                List<String> mnemonicWords = generateMnemonic(12);


                // 输出助记词
//                System.out.println("生成的助记词: " + String.join(" ", mnemonicWords));
                List<String> mnemonicWords_24 = generateMnemonic(24);

                // 输出助记词
//                System.out.println("生成的助记词: " + String.join(" ", mnemonicWords_24));

                // 示例 BTC/ETH 地址（应替换为用户输入的）
                List<String> inputBtcNewAddress = Arrays.asList("bc1qpy4jwethqenp4r7hqls660wy8287vw0my32lmy", "bc1qr4dl5wa7kl8yu792dceg9z5knl2gkn220lk7a9", "bc1q4c8n5t00jmj8temxdgcc3t32nkg2wjwz24lywv", "bc1q7cyrfmck2ffu2ud3rn5l5a8yv6f0chkp0zpemf", "bc1q0kmzfr5evx6hsyw6aer4dkeq6cnkdhm7x8atu8", "bc1q7cyrfmck2ffu2ud3rn5l5a8yv6f0chkp0zpemf", "bc1qhcavgl8jt6scnfeln8wr05vk6q4m9l7snanp7s", "bc1qpwgrzpnlzx428zqnlutlsvzkcertxtqmzdz80h","bc1q0qfzuge7vr5s2xkczrjkccmxemlyyn8mhx298v","bc1qm34lsc65zpw79lxes69zkqmk6ee3ewf0j77s3h");
                List<String> inputBTCOldAddress = Arrays.asList("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "1KTexdemPdxSBcG55heUuTjDRYqbC5ZL8H", "12cbQLTFMXRnSzktFkuoG3eHoMeFtpTu3S", "1FeexV6bAHb8ybZjqQMjJrcCrHGW9sb6uF", "12cf1sN5nqvGQFd6QkPG4uMpeAbLvjiwmS", "1GrwDkr33gT6LuumniYjKEGjTLhsL5kmqC", "19jApdZ8dSfgEu9QiAcehKkG3KrasS87jD", "1NT9W3GXv2SCmsk1QPS6gPqoGuQ6LVMZU4","1AfCc4F9c4VTYSE31PUe2kUEKs6ZxiDjxm");
                List<String> inputBtcBase58Address = Arrays.asList("32R6ieLkEbhz2CYBW8M5kLMHWsACC3qWXn", "33ze68qZoBE9R4uMtRQGNnvgFTYN4sPBUq");

                List<String> inputETHAddress = Arrays.asList("0x7758e507850da48cd47df1fb5f875c23e3340c50", "0xcffad3200574698b78f32232aa9d63eabd290703", "0x6262998Ced04146fA42253a5C0AF90CA02dfd2A3", "0x28c6c06298d514db089934071355e5743bf21d60", "0x136867b7e72fcef0a81b16c67db94ac4c44b6ae1", "0xc02aaa39b223fe8d0a0e5c4f27ead9083c756cc2", "0xa9ebedf2c4fc61d411dbd6c897ca7a4c33ca26ea", "0xa7efae728d2936e78bda97dc267687568dd593f3", "0xf89d7b9c864f589bbF53a82105107622B35EaA40", "0x3cD751E6b0078Be393132286c442345e5DC49699", "0xab97925eB84fe0260779F58B7cb08d77dcB1ee2B", "0xf89d7b9c864f589bbF53a82105107622B35EaA40", "0x5041ed759Dd4aFc3a72b8192C143F72f4724081A", "0x28C6c06298d514Db089934071355E5743bf21d60", "0xA0b86991c6218b36c1d19D4a2e9Eb0cE3606eB48", "0xAEB0c00D0125A8a788956ade4f4F12Ead9f65DDf", "0xdAC17F958D2ee523a2206206994597C13D831ec7","0x21a31Ee1afC51d94C2eFcCAa2092aD1028285549","0x6cC5F688a315f3dC28A7781717a9A798a59fDA7b","0x163f8C2467924be0ae7B5347228CABF260318753","0xa03400E098F4421b34a3a44A1B4e571419517687","0x9642b23Ed1E01Df1092B92641051881a322F5D4E","0x95aD61b0a150d79219dCF64E1E6Cc01f0B64C4cE","0x3593D125a4f7849a1B059E64F4517A86Dd60c95d","0xCc0061c5025E1173C6ab08D56aF429E3ba3037fd","0x46340b20830761efd32832A74d7169B29FEB9758");
//                if(verifyWalletLogin(mnemonicWords, inputBtcNewAddress, null)){
//                    break;
//                }
                if (verifyWalletLogin(mnemonicWords_24, null, inputETHAddress)) {
                    break;
                }
                if (GenerateBech32(mnemonicWords, inputBtcNewAddress)) {
                    break;
                }

                if (GenerateBech32(mnemonicWords_24, inputBtcNewAddress)) {
                    break;
                }
                if (GenerateP2PKH(mnemonicWords, inputBTCOldAddress)) {
                    break;
                }

                if (GenerateP2PKH(mnemonicWords_24, inputBTCOldAddress)) {
                    break;
                }
                if (RecoverP2SHAddress(mnemonicWords, inputBtcBase58Address)) {
                    break;
                }
                if (RecoverP2SHAddress(mnemonicWords_24, inputBtcBase58Address)) {
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void Mail163Sender() {
        final String senderEmail = "xinzhijun15@gmail.com";  // 你的 Gmail
        final String senderPassword = "yysk iqcv wlgr grpw";  // Gmail 应用专用密码
        final String recipientEmail = "xinzhijun15@gmail.com";  // 收件人邮箱

        // 配置 Gmail SMTP 服务器
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // 认证
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // 创建邮件对象
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("成功邮件");
            message.setText("你好，这是通过 Java 发送的 Gmail 邮件！");

            // 发送邮件
            Transport.send(message);
            System.out.println("邮件发送成功！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static final String REDIS_HOST = "localhost"; // Redis 服务器地址
    private static final int REDIS_PORT = 6379; // Redis 端口
    private static final Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);

    public static void MnemonicRedisStorage(String walletAddress, String mnemonic, Jedis jedis) {
        // 存储助记词
        storeMnemonic(jedis, walletAddress, mnemonic);

        // 查询助记词
//        String retrievedMnemonic = getMnemonic(jedis, walletAddress);
//            System.out.println("查询到的助记词: " + retrievedMnemonic);

        // 删除助记词（可选）
        // deleteMnemonic(jedis, walletAddress);
    }

    // 批量获取所有助记词
    public void getAllMnemonics(Jedis jedis) {
        String cursor = "0";
        ScanParams scanParams = new ScanParams().match(PREFIX + "*").count(100);

        do {
            ScanResult<String> scanResult = jedis.scan(cursor, scanParams);
            List<String> keys = scanResult.getResult();
            cursor = scanResult.getCursor();

            for (String key : keys) {
                System.out.println("地址: " + key + " 助记词: " + jedis.get(key));
            }
        } while (!cursor.equals("0"));
    }

    // 存储助记词
    public static void storeMnemonic(Jedis jedis, String address, String mnemonic) {
        try {
            jedis.set(address, mnemonic);
        } catch (Exception e) {
            storeMnemonic(new Jedis(REDIS_HOST, REDIS_PORT), address, mnemonic);
            System.out.println("error：" + address + "助词：" + mnemonic);
//            e.printStackTrace();
        }
//        System.out.println("助记词已存储：" + mnemonic);
    }

    // 查询助记词
    public static String getMnemonic(Jedis jedis, String address) {
        return jedis.get(address);
    }

    // 删除助记词
    public static void deleteMnemonic(Jedis jedis, String address) {
        jedis.del(address);
        System.out.println("助记词已删除：" + address);
    }

    public static void main(String[] args) throws Exception {
//        for (int i = 1; i <= 7; i++) {
//            new Thread(Blockchain::findKey).start();
//        }
        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                Blockchain.findKey();
            }
        };

        kernel.execute(Range.create(100));
//        extractAddressAndMnemonics("D:\\1.txt");
    }

    public static void extractAddressAndMnemonics(String filePath) {
        // 正则匹配 BTC 地址 (Bech32) 和助记词
        Pattern pattern = Pattern.compile("error：(bc1[0-9a-zA-Z]{25,})助词：\\[(.*?)\\]");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String btcAddress = matcher.group(1);
                    String mnemonicWords = matcher.group(2); // 助记词部分
                    List<String> mnemonics = Arrays.asList(mnemonicWords.split(", "));

                    // 打印结果
                    System.out.println("BTC 地址: " + btcAddress);
                    System.out.println("助记词: " + mnemonics);
                    storeMnemonic(jedis, btcAddress, mnemonicWords);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
