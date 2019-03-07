package huawei;

import java.util.*;

public class Test {

    public int id;

    public static void main(String[] args) {
        HashMap<Integer, String> treeMap = new HashMap<>();
        treeMap.put(3, "c");
        treeMap.put(1, "a");
        treeMap.put(2, "b");
        Iterator iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }



}