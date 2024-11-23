package wq;

import java.util.ArrayList;


/**
 * @author kaka
 * @create 2023/12/28
 */
public class ChemicalMachine {
    private ArrayList<String> list = new  ArrayList<>();
    public void add(String chemical) {
        list.add(chemical);
    }

    public void applyHeat() {
        if(list.contains("GREEN") && list.contains("YELLOW")){
            list.clear();
            add("BROWN");
            add("1");
        }else if(list.contains("GREEN") && list.contains("CYAN")){
            list.clear();
            add("ORANGE");
            add("1");
        }else if(list.contains("ORANGE")){
            list.clear();
            add("RED");
            add("BLUE");
            add("1");
        }else if(list.contains("BROWN")){
            list.clear();
            add("MAGENTA");
            add("1");
        }else{
            list.clear();
        }
    }

    public ArrayList<String> emptyMachine() {
        ArrayList<String> rs = new ArrayList<>();
        rs.addAll(list);

        if(rs.size()==0||  !rs.contains("1")){
            rs.clear();
            rs.add("UNKNOWN");
            return rs;
        }
        list.clear();
        rs.remove("1");
        return rs;
    }

    public static void main(String[] args) {
        ChemicalMachine machine = new ChemicalMachine();
//        System.out.println(String.join(",", machine.emptyMachine())); // should print BROWN
        machine.add("GREEN");
        machine.add("YELLOW");
        System.out.println(String.join(",", machine.emptyMachine())); // should print BROWN
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print BROWN

        machine.add("RED");
        machine.add("YELLOW");
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print UNKNOWN
    }
}
