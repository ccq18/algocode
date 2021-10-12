package algo;

import algo.sorts.InsertionSortAdd;
import algo.sorts.Sorts;
import algo.sorts.SortsNew;
import algo.sorts.SortsAddOn;
import java.util.Arrays;
import org.junit.Test;

public class SortsTest {
    @Test
    public void test(){
        int[] data = new int[]{4, 6, 5, 3, 7, 1, 2};
        InsertionSortAdd.fromStartToEnd(Arrays.copyOf(data, data.length));
        System.out.println(Arrays.toString(data));
    }


    @Test
    public void testBubbleSort2(){
        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        Sorts.bubbleSort2(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testSortsAddOn(){
        int[] arr = {3, 2, 6, 4, 5, 1, 9, 20, 13, 16};
        // bubbleDownSort(arr);
        SortsAddOn.shellSort(arr);
        SortsAddOn.print(arr);
    }
}
