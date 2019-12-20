package test;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Test for AccountingPersistentMgr
 * @author wangqi
 */
public class TestFunciton {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @FunctionalInterface
    public interface FunctionalTest {
        int calculate(int i, int j);
    }
    class Functional implements  FunctionalTest{
        @Override
        public    int calculate(int i, int j){
            return i-j;
        }
    }

    private static void test(int i, int j, FunctionalTest functionalTest) {
        System.out.println(functionalTest.calculate(i, j));
    }

    @org.junit.Test
    public void test() {
        FunctionalTest functionalTest = new Functional()::calculate;
        test(6, 5, functionalTest);
        test(6, 5, (i, j) -> i + j);
    }

    @org.junit.Test
    public void testBatchInsertEntry() {
        int i = 1;
        change(i);
        System.out.println(i);

        String i2 = "1";
        change(i2);
        System.out.println(i2);

        Integer[] i3 = new Integer[]{1};
        change(i3);
        System.out.println(i3[0]);

        Integer[] i4 = new Integer[]{1};
        change2(i4);
        System.out.println(i4[0]);

        TestFunciton test = new TestFunciton();
        test.setI(1);
        change(test);
        System.out.println(test.getI());


        List<Integer> a = new ArrayList<>();
        a.add(1);
        change(a);
        System.out.println(a.get(1));

        List<Integer> a2 = new ArrayList<>();
        a2.add(1);
        change2(a2);
        System.out.println(a2.get(0));

    }


    public  void change(int i){
        i = 10;
    }

    public  void change(String i){
        i = "10";
    }


    public  void change(Integer[]  i){
        i = new Integer[10];
    }

    public  void change2(Integer[]  i){
        i[0]= 10;
    }

    public  void change(TestFunciton test){
        test.setI(10);
    }

    public  void change(List<Integer> test){
        test.add(10);
    }

    public  void change2(List<Integer> test){
        test = new ArrayList<>();
        test.add(10);
    }

    @org.junit.Test
    public void test2() {
       List<String> list= new ArrayList<>();
       list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(list.subList(1,2));
        System.out.println(list.subList(1,1));
        int length =3;
        for(int i=0;i<list.size()/length;i++){
            if(i==list.size()/length-1){
                List<String> list2=list.subList(i*length,list.size());
                System.out.println(list2);
            }else {
                List<String> list2=list.subList(i*length,(i+1)*length);
                System.out.println(list2);
            }


        }

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = fmt.parse("1970-01-01 00:00:00");
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void st(){
//        HashMap<String,String> hashMap = new HashMap<>();
//        hashMap.put("kid","0");
//        hashMap.put("tid","0");
//        hashMap.put("start",String.valueOf(0));
//        hashMap.put("size",String.valueOf(1000));
//
//        String rs = HttpClientUtil.doGet("http://172.19.187.199:8081/getLoanList", hashMap);
//        JSONObject js = JSON.parseObject(rs);
//        String ss = (String) js.get("resInfo");
//        JSONArray jsonArray = (JSONArray) js.get("obj");
//
//        System.out.println(ss+"----"+((JSONObject)jsonArray.get(0)).get("loanId"));
        List<TestFunciton> list = new ArrayList();
        TestFunciton s = new TestFunciton();
        s.setI(1);
        TestFunciton s2 = new TestFunciton();
        s2.setI(1);
        list.add(s);
        list.add(s2);
        Map map = list.stream().collect(Collectors.toMap(TestFunciton::getI, a->a,(a1, a2)->a1));
        map = list.stream().collect(Collectors.groupingBy(TestFunciton::getI));
        System.out.println(map);
    }
}
