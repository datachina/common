package com.data.common.lang.util;

import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Nano Id 工具类。<br>
 * 基于 JavaScript 版本的 NanoId 实现
 *
 * @author jidaojiuyou
 * @see <a href="https://github.com/ai/nanoid">NanoId</a>
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class NanoIdUtils {

    /**
     * 字母表长度上限
     */
    public static final int MAX_ALPHABET_TABLE_LENGTH = 256;

    /**
     * NanoId 的默认长度
     */
    private static final int SIZE = 21;

    /**
     * 加密的随机数生成器
     */
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 默认字母表
     */
    private static final char[] ALPHABET_TABLE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_-abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * 生成一个nanoId
     *
     * @return 生成的id
     */
    public static String nanoId() {
        return nanoId(RANDOM, ALPHABET_TABLE, SIZE);
    }

    /**
     * 生成一个nanoId
     *
     * @param random   随机数生成器
     * @param alphabet 字母表
     * @param size     生成nanoId长度
     * @return 生成的id
     */
    public static String nanoId(final Random random, final char[] alphabet, final int size) {
        if (random == null) {
            throw new IllegalArgumentException("随机数生成器不能为空");
        }

        if (alphabet == null) {
            throw new IllegalArgumentException("字母表不能为空");
        }

        if (alphabet.length == 0 || alphabet.length >= MAX_ALPHABET_TABLE_LENGTH) {
            throw new IllegalArgumentException("字母表的大小应该在 1 ~ 256 之间(包括 1,不包括 256)");
        }

        if (size <= 0) {
            throw new IllegalArgumentException("NanoId 的长度必须大于 0");
        }

        final int mask = (2 << (int) Math.floor(Math.log(alphabet.length - 1.0) / Math.log(2.0))) - 1;
        final int step = (int) Math.ceil(1.6 * mask * size / alphabet.length);
        final StringBuilder idBuilder = new StringBuilder();

        while (true) {
            final byte[] bytes = new byte[step];
            random.nextBytes(bytes);
            for (int i = 0; i < step; i++) {
                final int alphabetIndex = bytes[i] & mask;
                if (alphabetIndex < alphabet.length) {
                    idBuilder.append(alphabet[alphabetIndex]);
                    if (idBuilder.length() == size) {
                        return idBuilder.toString();
                    }
                }
            }
        }
    }
}