package redis;

import redis.clients.jedis.Jedis;

public class ScanTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        for (int i = 0; i < 10000; i++) {
            jedis.set("key" + String.valueOf(i), String.valueOf(i));
        }
        jedis.close();
    }
}
