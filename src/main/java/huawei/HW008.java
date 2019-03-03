package huawei;

import java.util.*;

public class HW008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            SortedMap<Integer, Integer> map = new TreeMap<>();
            while (num != 0) {
                Integer key = scanner.nextInt();
                Integer value = scanner.nextInt();
                addPare(key, value, map);
                num--;
            }
            System.out.println(mapToString(map));
        }
        scanner.close();
    }

    private static void addPare(Integer key, Integer value, SortedMap<Integer, Integer> map) {
        if (map.get(key) == null) {
            map.put(key, value);
        } else {
            int val = map.get(key) + value;
            map.put(key, val);
        }
    }

    private static String mapToString(SortedMap<?, ?> map) {
        StringBuilder builder = new StringBuilder(256);
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            builder.append(entry.getKey()).append(" ");
            builder.append(entry.getValue()).append("\n");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }
}
