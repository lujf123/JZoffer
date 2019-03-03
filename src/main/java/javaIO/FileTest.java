package javaIO;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileTest {

    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    public static void copyFile(String src, String dist) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] bufffer = new byte[20 * 1024];
        int cnt;

        while ((cnt = in.read(bufffer, 0, bufffer.length)) != -1) {
            out.write(bufffer, 0, cnt);
        }
        in.close();
        out.close();
    }

    public static void readFileContent(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // 装饰者模式使得 BufferReader 组合成了一个 Reader 对象
        // 在调用 BufferReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }


    public static void fastCopy(String src, String dist) throws IOException {
        /* 获得源文件的输入字节流 */
        FileInputStream fin = new FileInputStream(src);

        /* 获取输入字节流的文件通道 */
        FileChannel fcin = fin.getChannel();

        /* 获取目标文件的输出字节流 */
        FileOutputStream fout = new FileOutputStream(dist);

        /* 获取输出字节流的文件通道 */
        FileChannel fcout = fout.getChannel();

        /* 为缓冲区分配 1024 个字节 */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            /* 从输入通道中读取数据到缓冲区中 */
            int r = fcin.read(buffer);

            /* read() 返回 -1 表示 EOF */
            if (r == -1) {
                break;
            }

            /* 切换读写 */
            buffer.flip();

            /* 把缓存区的内容写入输出文件中 */
            fcout.write(buffer);

            /* 清空缓存区 */
            buffer.clear();
        }

    }


    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");

        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
