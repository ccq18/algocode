package algo.tree;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * 文件相关操作
 *
 * @author Li Ersan
 */
public class FileOperation {

    /**
     * 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
     *
     * @param filename
     * @param words
     * @return
     */
    public static boolean readFile(String filename, ArrayList<String> words) {

        if (filename == null || words == null) {
            System.out.println("文件名或words不能为空");
            return false;
        }

        //文件读取
        Scanner scanner;

        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                return false;
            }
        } catch (IOException ioe) {
            System.out.println("不能打开" + filename);
            return false;
        }

        /*
         * 简单分词
         * 这个分词方式相对简陋，没有考虑很多文本处理中的特殊问题
         * 这里只做demo展示用
         *
         * 查找字母位置 直到不是字母算一个词，所有结果加入words
         */
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }

        return true;
    }

    /**
     * 寻找字符串s中，从start的位置开始的第一个字母字符的位置
     *
     * @param s
     * @param start
     * @return
     */
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }

        return s.length();
    }

}