package huawei;

import java.util.*;

public class HW021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Key, List<String>> map = new HashMap<>();

        while (scanner.hasNext()) {
            map.clear();
            int n = scanner.nextInt();
            // 构造一个字典
            while ((--n) >= 0) {
                String s = scanner.next();
                Key k = new Key(s);
                if (map.containsKey(k)) {
                    map.get(k).add(s);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(s);
                    map.put(k, list);
                }
            }

            String s = scanner.next();
            // s 的第i个兄弟节点
            int i = scanner.nextInt();
            Key k = new Key(s);
            List<String> list = map.get(k);
            if (list != null) {
                Collections.sort(list);
                // 删除 s
                while (list.contains(s)) {
                    list.remove(s);
                }
                System.out.println(list.size());
                int cnt = 0;
                Iterator<String> iterator = list.iterator();
                String t = "";
                while (cnt < i && iterator.hasNext()) {
                    t = iterator.next();
                    if (!t.equals(s)) {
                        cnt++;
                        if (cnt == i) {
                            System.out.println(t);
                        }
                    }
                }
            } else {
                System.out.println(0);
            }
        }
        scanner.close();
    }


    private static class Key {
        private String s;
        private String t;
        private int hashCode;

        public Key(String s) {
            this.s = s;
            if (s == null) {
                hashCode = 0;
            } else {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                t = new String(chars);
                hashCode = t.hashCode();
            }
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            return t != null ? t.equals(key.t) : key.t == null;
        }
    }
}
