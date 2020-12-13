package com.chigua.core.tool.utils;

import java.util.UUID;

/**
 * ProjectName: chigua-demo
 * ClassName: com.chigua.core.tool.utils.UUIDGenerator
 *
 * @author Mr.zhou <ijiami.cn>
 * @description UUIDGenerator
 * @copyright (C), 2020 ijiami <https://www.ijiami.cn>
 * @date 2020/12/09 - 14:39
 */

public final class UUIDGenerator {
    private static String[] chars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private UUIDGenerator() {

    }

    /**
     * 得到一个没有'-'字符的UUID。 标准UUID：b8154343-9b22-4a05-a7c1-01ac9e6eaf3e 本方法返回值
     * ：b81543439b224a05a7c101ac9e6eaf3e
     *
     * @return String
     */
    public static String getUUID() {
        String s = UUID.randomUUID().toString();

        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

    /**
     * 得到number个uuid组成的数组
     *
     * @param number number
     * @return String[]
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    /**
     * 构造8位uuid
     *
     * @return
     * @since 1.0
     */
    public static String gen8UUID() {
        StringBuilder builder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            builder.append(chars[(x % 62)]);
        }
        return builder.toString();
    }

}
