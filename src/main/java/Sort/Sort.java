package Sort;
public class Sort {
    public static void main(String[] args) {

        int[] arr = {25, 30, 11, 7, 22, 16, 18, 33, 40, 55};
//        int[] arr = {5,3,1,2,7,9,8,4};

//		bubbleSort(arr);
//		straightSort(arr);
//		insertSort(arr);


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void bubbleSort(int[] a) {        //冒泡排序
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
    }

    static void straightSort(int[] a) {  //直接选择排序
        int temp;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    static void insertSort(int[] a) {   //直接插入法排序
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
    }
//堆排序

//        static void heapSort(int[] a) {  //堆排序
//        int index = a.length - 1;
//        int temp;
//        while (index >=0){
//            creatHead(a,index);
//            a[]
//        }
//
//
//    }
//
//    static void creatHead(int[] a,int i){
////        int len = a.length;
//        int temp ,index,fa,left ,right,count=0;
//        while(i>=0){
////        for(int i=(len/2)-1 ; i>=0 ;i-- ){
//            fa = i;
//            left = 2 * fa +1;
//            right = left + 1;
//            if(count == 0){
//                right = left;
//            }
//            index = fa;
//
//            if (a[left]>a[right]){      //使用空指针，定位数值小的子节点；
//                index = right;
//            }
//            if (a[left]<a[right]){      //使用空指针，定位数值小的子节点；
//                index = left;
//            }
//            if(a[fa] > a[index]){       //将子节点与父节点比较，将小值放于父节点
//                temp = a[fa];
//                a[fa] = a[index];
//                a[index] = temp;
//            }
//            count++;
//            i --;
//        }
//
//
//
//
//    }

//    static void heapSort(int[] a) {    //堆排序
//        int len = a.length;
//        int index,temp;
//
//        for (int fa=(len/2)-1 ; fa>=0 ;fa--){
//            int left = 2 * fa + 1;
//            int right = 2 * fa +2;
//
//            if (right >= len){
//                right = left;
//            }
//            //判断左右子节点大小
//            if ((a[left] - a[right]) > 0){
//                index = left;
//            }else {
//                index = right;
//            }
//            //父节点与子节点交换
//            if (a[fa] < a[index]){
//                temp = a[index];
//                a[index] = a[fa];
//                a[fa] = temp;
//            }
//        }
//    }
}

