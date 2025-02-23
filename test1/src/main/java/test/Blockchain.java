package test;
import org.bitcoinj.core.LegacyAddress;
import org.bitcoinj.crypto.*;
import org.bitcoinj.wallet.DeterministicKeyChain;
import org.bitcoinj.wallet.DeterministicSeed;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.core.NetworkParameters;
import org.web3j.crypto.*;

import java.security.SecureRandom;
import java.util.List;

import java.util.Arrays;
import java.util.List;

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
            case 12: return 128;
            case 15: return 160;
            case 18: return 192;
            case 21: return 224;
            case 24: return 256;
            default: throw new IllegalArgumentException("助记词必须是 12, 15, 18, 21, 或 24 词！");
        }
    }

    /**
     * 通过助记词恢复钱包，并验证 BTC/ETH 地址是否正确
     */
    public static boolean verifyWalletLogin(List<String> mnemonicWords, String inputBTCAddress, String inputETHAddress) {
        try {
            // 1️⃣ 解析助记词并生成种子
            byte[] seed = MnemonicCode.toSeed(mnemonicWords, "");

            // 2️⃣ 生成 BTC 地址
            String derivedBTCAddress = deriveBTCAddress(mnemonicWords);

            // 3️⃣ 生成 ETH 地址
            String derivedETHAddress = deriveETHAddress(seed);

            // 4️⃣ 对比输入的地址和计算出的地址
            boolean isBTCMatch = false,isETHMatch=false;
            if(inputBTCAddress!=null){
                 isBTCMatch = inputBTCAddress.equalsIgnoreCase(derivedBTCAddress);
            }
            if(inputETHAddress!=null){
                 isETHMatch = inputETHAddress.equalsIgnoreCase(derivedETHAddress);
            }


            if (isBTCMatch) {
                System.out.println("✅ 登录验证成功！mnemonicWords:"+mnemonicWords +"BTC:"+derivedBTCAddress);
                return true;
            } else if (isETHMatch) {
                System.out.println("✅ 登录验证成功！mnemonicWords:"+mnemonicWords +"ETH:"+derivedETHAddress);
                return true;
            } else {
//                if(!isBTCMatch)
//                System.out.println("BTC❌ 登录验证失败，地址不匹配！");
//                if(!isETHMatch)
//                    System.out.println("ETH❌ 登录验证失败，地址不匹配！");
                System.out.println("❌ 登录验证失败，地址不匹配！");
                return false;
            }
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
        Bip32ECKeyPair masterKeyPair = Bip32ECKeyPair.generateKeyPair(seed);
        int[] derivationPath = {44 | 0x80000000, 60 | 0x80000000, 0 | 0x80000000, 0, 0};
        Bip32ECKeyPair childKeyPair = Bip32ECKeyPair.deriveKeyPair(masterKeyPair, derivationPath);

        ECKeyPair ecKeyPair = ECKeyPair.create(childKeyPair.getPrivateKey());
        return "0x" + Keys.getAddress(ecKeyPair);
    }

    public static void main(String[] args) throws Exception {
        while(true){
            // 生成12个单词的助记词
            List<String> mnemonicWords = generateMnemonic(12);

            // 输出助记词
            System.out.println("生成的助记词: " + String.join(" ", mnemonicWords));
            List<String> mnemonicWords_24 = generateMnemonic(24);

            // 输出助记词
            System.out.println("生成的助记词: " + String.join(" ", mnemonicWords_24));

            // 示例 BTC/ETH 地址（应替换为用户输入的）
            List<String> inputBTCAddress = Arrays.asList("bc1qpy4jwethqenp4r7hqls660wy8287vw0my32lmy","bc1qr4dl5wa7kl8yu792dceg9z5knl2gkn220lk7a9","bc1q4c8n5t00jmj8temxdgcc3t32nkg2wjwz24lywv","1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
            List<String> inputETHAddress = Arrays.asList("0x7758e507850da48cd47df1fb5f875c23e3340c50","0xcffad3200574698b78f32232aa9d63eabd290703","0x6262998Ced04146fA42253a5C0AF90CA02dfd2A3");
            for(String btc:inputBTCAddress){
                // 验证登录
                if(verifyWalletLogin(mnemonicWords, btc, null)){
                    break;
                }
                // 验证登录
                if(verifyWalletLogin(mnemonicWords_24, btc, null)){
                    break;
                }
            }
            for(String eth:inputETHAddress){
                // 验证登录
                if(verifyWalletLogin(mnemonicWords, null, eth)){
                    break;
                }
                // 验证登录
                if(verifyWalletLogin(mnemonicWords_24, null, eth)){
                    break;
                }
            }

        }

    }

}
