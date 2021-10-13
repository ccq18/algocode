package algo.tree;

import java.util.ArrayList;
import org.junit.Test;

public class RbTreeTest {

    @Test
    public  void test() {

        System.out.println("傲慢与偏见");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("共有单词数：" + words.size());

            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                //包含则词数加1 不包含则加入新词
                if (rbTree.contains(word)) {
                    rbTree.set(word, rbTree.get(word) + 1);
                } else {
                    rbTree.add(word, 1);
                }
            }

            System.out.println("共有不同单词数：" + rbTree.getSize());
            System.out.println("出现pride的次数: " + rbTree.get("pride"));
            System.out.println("出现prejudice的次数: " + rbTree.get("prejudice"));
        }
    }

    public static void main(String[] args) {

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
