package redis;


import redis.clients.jedis.Client;

public class BloomTest {

    public static void main(String[] args) {
        Client client = new Client();

//        client.delete("codehole");
//        for (int i = 0; i < 100000; i++) {
//            client.add("codehole", "user" + i);
//            boolean ret = client.exists("codehole", "user" + i);
//            if (!ret) {
//                System.out.println(i);
//                break;
//            }
//        }

        client.close();
    }

}
