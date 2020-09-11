package com.starlc.pinyin;

import com.github.houbb.heaven.util.io.StreamUtil;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.starlc.common.Watcher;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JPinYinTest {
    /**
     * 1w 次
     */
    private static final int TIMES = 10000;


    /**
     * 单个字符次数统计
     */
    private static final int SINGLE_TIMES = 1000000;
    /**
     * 预热耗时：565 ms
     *
     * 1w 次 cost: 17975 ms
     *
     * 本框架，支持分词的测试。
     */
    @Test
    public void pinyinWithSegmentTest() {
        // 预热
        Watcher watcher = Watcher.get("预热耗时{0}ms");
        String result = HanLP.convertToPinyinString("重庆火锅", ",", false);
        watcher.end();
        System.out.println(result);


        // 验证
        final String text = getText();
        System.out.println(text);
        Watcher batch = Watcher.get();
        for (int i = 0; i < TIMES; i++) {
            System.out.println(HanLP.convertToPinyinString(text,"",false));
        }
        batch.end();
    }

    public String getText(){
        return StreamUtil.getFileContent("D:\\new 4.txt");
    };

    /**
     * 单个字符耗时统计
     *
     * 168 ms
     *
     * 5517ms
     */

    @Test
    public void pinyinCharTest() throws PinyinException {
        Watcher watcher = Watcher.get("预热耗时{0}ms");
        String result =PinyinHelper.convertToPinyinString("重庆火锅","", PinyinFormat.WITHOUT_TONE);
        watcher.end();
        System.out.println(result);
        // 验证

        final String text = getText();
        Watcher batch = Watcher.get();
        // 随机选择一个单字
        for (int i = 0; i < SINGLE_TIMES; i++) {
            int index = ThreadLocalRandom.current().nextInt(text.length() - 1);
            try {
                PinyinHelper.convertToPinyinString(String.valueOf(text.charAt(index)),"", PinyinFormat.WITHOUT_TONE);
            } catch (PinyinException e) {
                e.printStackTrace();
            }
        }
        batch.end();

    }
}
