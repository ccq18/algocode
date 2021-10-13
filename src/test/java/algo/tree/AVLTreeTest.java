package algo.tree;

import java.util.ArrayList;
import org.junit.Test;

public class AVLTreeTest {

    @Test
    public  void test() {

        System.out.println("傲慢与偏见");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("共有单词数：" + words.size());

            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word)) {
                    avlTree.set(word, avlTree.get(word) + 1);
                } else {
                    avlTree.add(word, 1);
                }
            }

            System.out.println("共有不同单词数：" + avlTree.getSize());
            System.out.println("出现pride的次数: " + avlTree.get("pride"));
            System.out.println("出现prejudice的次数: " + avlTree.get("prejudice"));

            System.out.println("is BST: " + avlTree.isBST());
            System.out.println("is Balance: " + avlTree.isBalanced());

            for (String word : words) {
                avlTree.remove(word);
                if (!avlTree.isBST() || !avlTree.isBalanced()) {
                    throw new RuntimeException("Error");
                }
            }
        }

        System.out.println();
    }
}
