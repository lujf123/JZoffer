package other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Test {
    static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Iterator it1 = hashMap.entrySet().iterator();
                    while (it1.hasNext()) {
                        System.out.println("it1  " + it1.next());
                        Thread.sleep(2000);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Iterator it2 = hashMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        Thread.sleep(1000);
                        Map.Entry entry = (Map.Entry) it2.next();
                        Object key = entry.getKey();
                        Object val = entry.getValue();
                        hashMap.remove(key);
                        //System.out.println("it2  " + it2.next());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
