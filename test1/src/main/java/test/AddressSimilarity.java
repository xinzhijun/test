package test;
import java.math.BigInteger;
/**
 * @author cristiano
 * @create 2025/6/19
 */
public class AddressSimilarity {
    // 汉明距离（Hex）
    public static int hammingDistance(String addr1, String addr2) {
        if (addr1.length() != addr2.length()) {
            throw new IllegalArgumentException("地址长度必须一致");
        }
        int dist = 0;
        for (int i = 0; i < addr1.length(); i++) {
            if (addr1.charAt(i) != addr2.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }

    // 匹配率（字符重合百分比）
    public static double matchRate(String addr1, String addr2) {
        if (addr1.length() != addr2.length()) {
            throw new IllegalArgumentException("地址长度必须一致");
        }
        int match = 0;
        for (int i = 0; i < addr1.length(); i++) {
            if (addr1.charAt(i) == addr2.charAt(i)) {
                match++;
            }
        }
        return (double) match / addr1.length();
    }

    // 匹配前缀长度
    public static int prefixMatch(String addr1, String addr2) {
        int len = Math.min(addr1.length(), addr2.length());
        for (int i = 0; i < len; i++) {
            if (addr1.charAt(i) != addr2.charAt(i)) {
                return i;
            }
        }
        return len;
    }

    // Ethereum 地址数值差异（仅适用于 ETH，地址为十六进制）
    public static BigInteger ethDistance(String hexAddr1, String hexAddr2) {
        String clean1 = hexAddr1.toLowerCase().replace("0x", "");
        String clean2 = hexAddr2.toLowerCase().replace("0x", "");

        BigInteger a = new BigInteger(clean1, 16);
        BigInteger b = new BigInteger(clean2, 16);
        return a.subtract(b).abs();
    }

    public static void main(String[] args) {
        String eth1 = "0x1234567890abcdef1234567890abcdef12345678";
        String eth2 = "0x1234567890abcdee1234567890abcdee12345678";

        System.out.println("ETH 汉明距离: " + AddressSimilarity.hammingDistance(eth1.substring(2), eth2.substring(2)));
        System.out.println("ETH 匹配率: " + AddressSimilarity.matchRate(eth1.substring(2), eth2.substring(2)));
        System.out.println("ETH 前缀长度: " + AddressSimilarity.prefixMatch(eth1.substring(2), eth2.substring(2)));
        System.out.println("ETH 数值距离: " + AddressSimilarity.ethDistance(eth1, eth2));

        String btc1 = "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa";
        String btc2 = "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNb";
        System.out.println("BTC 匹配率: " + AddressSimilarity.matchRate(btc1, btc2));
        System.out.println("BTC 前缀长度: " + AddressSimilarity.prefixMatch(btc1, btc2));
    }
}
