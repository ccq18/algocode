package algo.tree;

import java.util.ArrayList;
import org.junit.Test;

public class BSTTest {
    @Test
    public  void test() {
        System.out.println("傲慢与偏见");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("共有单词数：" + words.size());

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word)) {
                    bst.set(word, bst.get(word) + 1);
                } else {
                    bst.add(word, 1);
                }
            }

            System.out.println("共有不同单词数：" + bst.getSize());
            System.out.println("出现pride的次数: " + bst.get("pride"));
            System.out.println("出现prejudice的次数: " + bst.get("prejudice"));
        }
    }
}
