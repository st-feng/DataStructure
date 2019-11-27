package Sort;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

//编写程序，要求随机生成50个数，并比较直接插入排序、冒泡排序和快速排序的排序性能。
public class AllSort {
     int [] arr ;
     Long startTime,endTime;
    public AllSort(int[] arr){

        this.arr = arr;

    }

    public void bubbleSort(int[] a) {        //冒泡排序
        startTime = System.nanoTime();
        int temp;
        for (int i = a.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        endTime = System.nanoTime();
        System.out.println("采用冒泡排序运行时间为："+(endTime-startTime)+"ms");
    }

    public void insertSort(int[] a) {   //直接插入法排序
        startTime = System.nanoTime();
        for (int i = 0; i < a.length - 1; i++) {
            int current = a[i + 1];
            int preInt = i;

            while (preInt >= 0 && current < a[preInt]) {
                a[preInt + 1] = a[preInt];
                preInt--;
            }
            preInt++;
            a[preInt] = current;
        }
        endTime = System.nanoTime();
        System.out.println("采用直接插入排序运行时间为："+(endTime-startTime)+"ms");
    }

    //快排
    public  int Pratition(int i, int j) {
        int par = arr[i];
        while (i < j) {
            while (i < j && par <= arr[j]) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;

            }
            while (i < j && par > arr[i]) {

                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }

        }
        arr[i] = par;
        return i;
    }
//快排
    public  void qSort(int low, int high) {

        if (low < high) {
            int privlot = Pratition(low, high);
            qSort(low, privlot - 1);
            qSort(privlot + 1, high);
        }

    }
}
