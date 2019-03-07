package huawei;

import java.util.Scanner;

/**
 * 判断两个IP是否属于同一子网
 */
public class HW032 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String mask = scanner.next();
            String ip1 = scanner.next();
            String ip2 = scanner.next();
            System.out.println(checkNetSegment(mask, ip1, ip2));

        }
        scanner.close();
    }

    private static int checkNetSegment(String mask, String ip1, String ip2) {
        if (ipValidate(ip1) == false || ipValidate(ip2) == false) {
            return 1;
        }
        long longmask = ipconvert(mask);
        long longip1 = ipconvert(ip1);
        long longip2 = ipconvert(ip2);
        if ((longmask & longip1) == (longmask & longip2)) {
            return 0;
        }
        return 2;
    }

    private static long ipconvert(String ip) {
        String[] strs = ip.split("[.]");
        long result = 0;
        for (String s : strs) {
            result = (result << 8) + Long.valueOf(s);
        }
        return result;
    }

    /**
     * 验证IP地址的格式是否正确
     *
     * @param ip IP地址
     * @return true：格式正确，false：格式不正确
     */
    private static boolean ipValidate(String ip) {
        String[] part = ip.split("\\.");

//        if (part.length != 4) {
//            return false;
//        }

        for (String s : part) {
            try {
                int num = Integer.parseInt(s);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }

        return true;
    }

    /**
     * 子网掩码验证，网络号部分全为“1”和主机号部分全为“0”
     *
     * @param ip
     * @return
     */
    private static boolean subnetMaskValidate(int ip) {
        boolean hasZero = false;
        int and = 0x80000000;
        while (and != 0) {
            // 所处理的位位置为0
            if ((ip & and) == 0) {
                // 说明出现了0
                hasZero = true;
            }
            // 如果位置为1
            else {
                // 之前已经有0出现过，那说明1是不连续的，所以子网掩码不合法
                if (hasZero) {
                    return false;
                }
            }

            // 无符号右移一位
            and >>>= 1;
        }

        return true;
    }
}
