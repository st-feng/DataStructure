package List.ArrList;

public class Arr {
    int[] arr ;
    int len;

//根据输入顺序表的长度n建立一个顺序表，传入arr并输出顺序表中各元素的值。
    Arr(int n, int[] a){
        arr = new int[n];
        for (int i=0 ; i<a.length ;i++){
            this.arr[i] = a[i];
        }  //使用for遍历读入的数值，则可保持线性表有空闲空间
//        this.arr = arr;    使用此语句会导致线性表不好扩展
        len = a.length;
        System.out.println("初始线性表各元素的值：");
        scanArr();  //调用遍历输出方法
    }

    //遍历顺序表，输出各元素的值
    void scanArr(){

        for (int i=0 ; i<len ; i++){
            System.out.print(arr[i]+" , ");
        }
        System.out.println();
    }

    //在顺序表的第i（0≤i≤n）个元素之前插入一个值为x的元素，并输出插入后的顺序表中各元素的值。
    void insert (int i,int x)throws Exception{
        if(i<0 || i>=arr.length) throw new Exception("插入位置不合理，请在0至"+len+"之间进行插入。");

        for(int j=len;j>=i;j--){
            arr[j+1] = arr[j];//从后往前依次挪动，直到第i位置
        }

        arr[i] = x;
        len++;
        System.out.println("输出插入元素【"+x+"】后的顺序表中各元素的值:");
        scanArr();
    }

    //删除顺序表中第i（0≤i≤n-1）个元素，并输出删除之后的顺序表中各元素的值。
    void remove (int i) throws Exception{
        if(i<0 || i>=arr.length) throw new Exception("删除位置不合理，请在0至"+(len-1)+"之间进行删除。");

        for(int j=i;j<len;j++){
            arr[j] = arr[j+1];//从后往前依次挪动，直到第i位置
        }
        len--;
        System.out.println("删除元素第"+i+"个元素之后的顺序表中各元素的值：" );
        scanArr();
    }

//    在顺序表中查找值为x的元素初次出现的位置。
//    如果查找成功，则返回该元素在顺序表中的位序号；
//    如果查找失败，则提示顺序表中不包含此元素。
    void indexIn(int x){
        int index = 0;
        for (int i=0 ; i<len ; i++){
            if(arr[i] == x ){
                index = i;
                System.out.println("元素【"+x+"】在顺序表中的位序号为："+index);
                break;
            }
            if(i==len-1) {
                System.out.println("顺序表中不包含元素【"+x+"】");
            }
        }

    }

//    删除顺序表中相同的元素。
    void removeSame() throws  Exception{
        System.out.println("==========美丽的分割线==============");
        for (int i=0 ; i<len-1 ; i++){  //最后的元素不需要向后遍历比较
            for (int j=i+1;j<len;j++){
                if(arr[i] == arr[j]){
                    System.out.println("开始查重：........");
                    remove(j);  //调用删除元素方法
                    j--;  //删除重复元素后，后继元素会往前移动一个位置，需要自减，避免漏掉补上来的元素

                }
            }
        }
        System.out.println("==========美丽的分割线==============");
        System.out.println("最终顺序表为：");

        scanArr();
    }
}
