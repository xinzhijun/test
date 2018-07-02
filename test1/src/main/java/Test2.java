import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Test2
 * Created by IntelliJ IDEA.
 *
 * @Author Wang Qi
 * @Date 2018/5/22
 * @Time: 16:45
 * @description: Test2
 * To change this template use File | Settings | File Templates.
 */

public class Test2 {
    static int o=10;
    static Test2 test2 = new Test2();
    static int a;
    static int b=0;

    static {
        o=9;
    }
    static {
        o=3;
    }

    public Test2() {
        super();
        a++;
        b++;
    }
    public static Test2 getInstence() {
        return test2;
    }

    public static void v(int[] aa) {
        int[] ss = {3, 4, 5};
        aa = ss;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("orderId", "YSPf0b2000003800-2");
        map.put("status", "success");
        map.put("userId", "13ad335920e455e0e053268d640abf0b");
        String a="1";
        String c="后";
        Integer uu =11;
        System.out.println(uu.byteValue());
        System.out.println(a.getBytes().length);
        System.out.println(c.getBytes().length);
        Test2 test2 = Test2.getInstence();
        System.out.println(o+"  "+test2.a+"   "+test2.b);
//        System.out.println(Md5Tools.MD5("amt=1000&code=889948&custMobile=13111111112&merchId=13111111112&orderId=2111111111&parentProductId=61&payAccount=6212260200077617724&period=1&platform=shandong1&repayAccount=6212260200077617724&subProductId=606004&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("money=1000000&name=wq&platform=shandong1&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("amount=16000&bankNo=6212260200077617724&contractId=CO201706120000006932&loanId=LO201707310000000868&mobile=13111111112&orderId=2222212222&payType=DK&planId=AM201708020000001406&platform=shandong1&type=R&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("platform=shandong1&userName=15001050853&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("mobile=13111111112&platform=shandong1&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("platform=shandong&tobaccoId=123111111&userName=13111111113&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("bankNo=6212260200077617724&identity=140402198510253211&mobile=13111111112&platform=shangdong1&userName=王琪&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("code=11111&mobile=13111111112&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("identity=140402198510253211&mobile=13111111112&platform=shangdong1&userName=王琪&gole_pool_wq").toUpperCase());
//        System.out.println(JSONObject.parseObject("{'user_id':'13111111112','lice_id':'123111111'}", Map.class));
//        System.out.println(Md5Tools.MD5("id=271&name=wq&gole_pool_wq").toUpperCase());
//        System.out.println(Md5Tools.MD5("bank=gongshang-工商银行-102&name=wq&type=add&gole_pool_wq").toUpperCase());
//        System.out.println("gongshang-工商银行-102".split("\\-")[1]);
//        Map map1 = new HashMap();
//        map1.put("execCode", JSONArray.fromArray(new String[]{"00"}));
//        System.out.println(String.valueOf(JSONArray.fromObject(map1.get("execCode")).get(0)));
//        String aa = "abc";
//        String cc = "ab" + "c";
//        String e = "ab";
//        String f = "c";
//        String bb = new String("a") + "b";
//        String g = e + f;
//        System.out.println(aa == g);
//        System.out.println(aa == cc);
//        System.out.println(aa.hashCode());
//        System.out.println(g.hashCode());
//        String s = new String("abc");
//        String s1 = "abc";
//        String s2 = new String("abc");
//        System.out.println(s == s1.intern());
//        System.out.println(s == s2.intern());
//        System.out.println(s1 == s2.intern());
//        System.out.println(s2.intern());
        int[] ss = new int[1000];
        int[] aa = new int[1000];
        int[] bb = new int[1000];
        for(int i=0;i<ss.length;i++){
            ss[i] = new Random().nextInt(100000);
            aa[i] = new Random().nextInt(100000);
            bb[i] = new Random().nextInt(100000);
        }

//        int[] ss = {1, 9, 8, 5, 2, 2, 2, 1, 7, 2, 1};
//        v(ss);
//        System.out.println(ss[0]);
//        Long start = System.currentTimeMillis();
//        fast(ss);
////        select(ss);
//        Long end = System.currentTimeMillis();
//        System.out.println("time" + (end-start));
//        Long start2 = System.currentTimeMillis();
//        select(ss);
//        Long end2 = System.currentTimeMillis();
//        System.out.println("time" + (end2-start2));
//        Long start3 = System.currentTimeMillis();
//        Bubble(ss);
//        Long end3 = System.currentTimeMillis();
//        System.out.println("time" + (end3-start3));
//        for (int i = 0; i < ss.length; i++) {
//            System.out.print(ss[i] + ",");
//        }
    }

    static void Bubble(int[] ss) {
        for (int i = 0; i < ss.length - 1; i++) {
            for (int j = 0; j < ss.length - 1 - i; j++) {
                if (ss[j] > ss[j + 1]) {//找大的往后排
                    int temp = ss[j + 1];
                    ss[j + 1] = ss[j];
                    ss[j] = temp;
                }
            }
        }
    }

    static void select(int[] ss) {
        for (int i = 0; i < ss.length - 1; i++) {
            for (int j = i + 1; j < ss.length; j++) {
                if (ss[j] < ss[i]) {//找小的往前排
                    int temp = ss[i];
                    ss[i] = ss[j];
                    ss[j] = temp;
                }
            }
        }
    }

    static void insert(int[] ss){
        int j;
        for(int i=1;i<ss.length;i++){
            int temp = ss[i];
            for(j=i;j>0&temp<ss[j-1];j--){
                ss[j]=ss[j-1];
            }
            ss[j] =temp;
        }
    }

    static void fast(int[] ss) {
        int label = ss[ss.length - 1];
        int i = 0;
        int j = ss.length - 2;
        while (i <= j && i<ss.length) {
            boolean left = false;
            boolean right = false;
            if (!left && ss[i] > label) {
                left = true;
            } else {
                i++;
                continue;
            }
            if (!right && ss[j] < label && j>=0) {
                right = true;
            } else {
                j--;
                continue;
            }
            if (left && right) {
                int temp = ss[i];
                ss[i] = ss[j];
                ss[j] = temp;
            }
        }
        if (i > j) {
            if (i > ss.length - 1) {
                i = ss.length - 1;
            }
            if(j<0){
                j=0;
            }
            ss[ss.length - 1] = ss[i];
            ss[i] = label; //替换标志位
            if(i>0){
                int[] aa =  new int[i];
                for(int a=0;a<i;a++){
                    aa[a] = ss[a];
                }
                if(aa.length == 1){
                    System.out.println(aa[0]);//左侧数组成员为1
                }else{
                    fast(aa);
                }

            }
            System.out.println(ss[i]);//标志位置

            if(j<ss.length){
                if(ss.length-i-1>0){
                    int[] aa =  new int[ss.length-i-1];
                    for(int a=i+1;a<ss.length;a++){
                        aa[a-i-1] = ss[a];
                    }
                    if(aa.length == 1){
                        System.out.println(aa[0]);//右侧数组成员为1
                    }else{
                        fast(aa);
                    }
                }
            }

        }
    }
}
