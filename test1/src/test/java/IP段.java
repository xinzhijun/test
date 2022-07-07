import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import jdk.nashorn.internal.runtime.BitVector;
import sun.security.util.BitArray;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;

public class IP段 {

    public static void main(String[] args) {
        System.out.println(BitSet.valueOf("192.168.1.0".getBytes()));
        System.out.println(BitSet.valueOf("192.168.1.100".getBytes()).length());
        System.out.println(Integer.toBinaryString(192));

    }
//    "192.168.1.0/24", "192.168.1.100" => true
    public boolean isMatched(String cidrBlock, String ipv4Addr){
        String[] ips = cidrBlock.split("\\/");
        StringBuffer index = new StringBuffer();
        StringBuffer index2 = new StringBuffer();
        for(String ip:ips[0].split("\\.")){
            index.append(Integer.toBinaryString(Integer.parseInt(ip)));
        }
        for(String ip:ipv4Addr.split("\\.")){
            index2.append(Integer.toBinaryString(Integer.parseInt(ip)));
        }
        String pre1 = index.toString().substring(0,Integer.parseInt(ips[1]));
        String pre2 = index2.toString().substring(0,Integer.parseInt(ips[1]));
        return pre1.equals(pre2);
    }
}
