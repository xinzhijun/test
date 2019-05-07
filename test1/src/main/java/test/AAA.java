package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AAA {
    static String findNumber(List<Integer> arr, int k) {
        final boolean[] s = {false};
        arr.forEach(a->{if(a==k){
            s[0] =true;}});
        return s[0] ?"YES":"NO";
    }

    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> s =new ArrayList<>(r-l);
        for(int i=l;i<=r;i++){
            if(i%2==1){
                s.add(i);
            }
        }
        return s;
    }

    static List<String> paginate(int resultsPerPage, List<String> results) {
        List<String> rs = new ArrayList<>(results.size()+results.size()/resultsPerPage+1);
        //todo 头列
        List<String> firstList = new ArrayList<>();
        //todo 重复
        List<String> rpList = new ArrayList<>();
        //todo 未重复集
        StringBuffer result = null;
        for(String one:results){
            boolean rp = false;
            String[] group = one.split("\\,");
            for(String ss:group){
                if(result.indexOf(ss)>=0){
                    rp = true;
                    break;
                }else{
                    result.append(ss).append(",");
                }
            }
            if(rp){
                rpList.add(one);
            }else{
                firstList.add(one);
            }

        }
        //todo 非重复list排序
        for(int i=0;i<firstList.size();i++){
            for(int j=i+1;j<firstList.size();j++){
                String a= firstList.get(i).split("\\,")[0];
                String b = firstList.get(j).split("\\,")[0];
                if(Integer.valueOf(a) > Integer.valueOf(b)){
                    String temp =  firstList.get(i);
                    firstList.set(i, firstList.get(j));
                    firstList.set(j, temp);
                }
            }
        }
        // todo 重复list排序
        StringBuffer  rpRsult = null;
        for (int i = 0; i < rpList.size(); i++) {
            for (int j = i + 1; j < rpList.size(); j++) {
                String a = rpList.get(i).split("\\,")[0];
                String b = rpList.get(j).split("\\,")[0];
                //todo 已排序过的不再排
                if(rpRsult.indexOf(a+"=")>=0){
                    continue;
                }
                //todo 重复的b往后排
                if (a.equals(b)) {
                    rpRsult.append(a+"=");
                    for (int k = j + 1; k < rpList.size(); k++) {
                        String c = rpList.get(k).split("\\,")[0];
                        if(b.equals(c)){
                            break;
                        }else{
                            String temp =  rpList.get(j);
                            rpList.set(j, rpList.get(k));
                            rpList.set(k, temp);
                        }
                    }
                }
            }
        }
        firstList.containsAll(rpList);
        for(int i=0;i<firstList.size();i++){
            rs.add(firstList.get(i));
            if(i == (resultsPerPage-1)){
                rs.add("");
            }
        }
        return rs;
    }
    public static  void  main(String[] args){
        Stack stack = new Stack();
        oddNumbers(2,9);
    }
}
