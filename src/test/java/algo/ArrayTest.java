package algo;

import algo.array.Array;
import algo.array.GenericArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ArrayTest {
    @Test
    public  void array() {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }

    @Test
    public  void genericArray() {
        GenericArray<Integer> array = new GenericArray<>(5);
        log.info("{}",array);
        array.add(0, 3);
        array.add(0, 4);
        array.add(1, 5);
        array.add(3, 9);
        array.add(3, 10);
        //array.insert(3, 11);
      System.out.println(  array.toString());
    }
}
