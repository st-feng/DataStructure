import Sort.AllSort;

import java.util.Arrays;

public class Test {
@org.junit.Test
    public void sortTest(){
//    创建一个数组
        int [] a = new int[50];
//    产生随机数
        for (int i = 0; i < 50; i++) a[i] = (int)( 50*(Math.random()));
//    打印数组
        System.out.println(Arrays.toString(a));
        AllSort allSort = new AllSort(a);
//        allSort.bubbleSort(a);
//        allSort.insertSort(a);

    Long startTime = System.nanoTime();
        allSort.qSort(0,49);
    Long endTime = System.nanoTime();
    System.out.println(Arrays.toString(a));
    System.out.println("采用快速排序运行时间为："+(endTime-startTime)+"ms");

    }
}
