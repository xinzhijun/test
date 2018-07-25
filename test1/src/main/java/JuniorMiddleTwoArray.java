/**
 * JuniorMiddleTwoArray
 * Created by IntelliJ IDEA.
 *
 * @author Wang Qi
 * @version 1.0 2018/7/20 20:47
 * @see JuniorMiddleTwoArray
 * To change this template use File | Settings | File Templates.
 */

public class JuniorMiddleTwoArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ss =0;
        double before =0;
        double after =0;
        boolean exist1;
        boolean exist2;
        if(exist1=nums1.length!=0){
            before =nums1[nums1.length-1];
        }
        if(exist2=nums2.length!=0){
            after =nums2[0];
        }

        if(exist1&&exist2&&before<=after){
            ss = (before+after)/2;
            if((ss-before)<1 && (ss-before)>0.5||((ss-before)==0.5&&nums1.length<nums2.length)){
                ss =  before+1;
            }
            if((ss-before)<0.5 && (ss-before)>=0||((ss-before)==0.5&&nums1.length>nums2.length)){
                ss =  before;
            }
        }else if(exist1&&exist2){
            int i=0;
            for(;i<nums1.length;i++){
                ss +=nums1[i];
            }
            ss = ss/i;
            double ss2 =0;
            i=0;
            for(;i<nums2.length;i++){
                ss2 +=nums2[i];
            }
            ss2 = ss2/i;
            ss = (ss+ss2)/2;
            double sub = ss-after;
            int num =0;
            while (sub>1){
                sub--;
                num++;
            }
            if(sub<1 && sub>0.5){
                ss =  after+1;
            }
            if(sub<0.5 && sub>=0){
                ss =  after+num;
            }
        }else{
            int i=0;
            int[] fina = null;
            if(exist1){
                fina =nums1;
            }
            if(exist2){
                fina =nums2;
            }
            for(;i<fina.length;i++){
                ss +=fina[i];
            }
            ss = ss/i;
            if(i>2){
                if((ss-fina[i/2-1])<0.5){
                    ss =  fina[i/2-1];
                }
                if((fina[i/2]-ss)<0.5){
                    ss =  fina[i/2];
                }
            }

        }
        return ss;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }
}
