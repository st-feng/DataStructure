package List.SeqList;

public class SeqList {
    private int [] arr ;//定义线性表
    private int len;//用于记录线性表有效长度
    //创建一个存储空间长度为maxSize的线性表
    public  SeqList(int maxSize ,int [] a){
        arr = new int[maxSize];//定义线性表的最大长度
        //使用for遍历读入的数值
        for (int i=0 ; i<a.length ;i++){
            this.arr[i] = a[i];
        }
        //记录线性表有效长度
        len = a.length;
        //输出初始线性表
        System.out.print("初始线性表为：");
        output();
        System.out.println("len: "+ len );
    }

    void removeSame(){
        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j <len ; j++) {
                if (arr[i] == arr[j]){
                    remove(j);
                    System.out.println(arr);

                }
            }
        }
    }

    //创建输出有效线性表方法
    public void output(){
        System.out.print("[ ");
        for(int i = 0 ; i < len ; i++) {
            if (i == len - 1)
                System.out.print(arr[i] + " ]");
            else
                System.out.print(arr[i] + " ,");
        }
        System.out.println();
    }
    //顺序表的插入方法
    public void insert(int i , int x) throws Exception{
        //如果输出线性表有效长度等于线性表长度，则抛出线性表已满
        if(len == arr.length)
            throw new Exception("顺序表已满");
        //如果插入位置不在线性表范围内，抛出插入位置不合法
        if(i < 0 || i > len)
            throw new Exception("插入位置不合法");
        //如果插入合法，则插入位置的数据整体后移一位，将插入位置数据腾空
        for(int j = len ; j > i ;j--)//////////////////////111111
            arr[ j ] = arr[ j - 1 ];
        arr[i] = x;  //将数据插入指定位置
        len++;//插入数据后，记录线性表有效长度+1
        //输出插入成功后的线性表
        System.out.print("插入后的线性表为：");
        output();
    }

    //顺序表的删除方法
    public void remove(int i){
        //如果删除位置不在线性表范围内输出不合法
        if(i < 0 || i > len)
            System.out.println("删除位置不合法");
        for(int j = i ; j < len; j++){/////////2222222222
            arr[j] = arr[ j + 1 ];
        }
        len--;
        System.out.print("删除后的线性表为：");
        output();
    }
    //顺序表的查找方法
    public void indexOf(int x){
        int index ;//用来记录要查找的元素在表中的位置
        boolean flag = false;//用来记录表中是否存在要查找的元素
        //循环查找表中是否存在要查找的元素
        for( int j = 0; j < len ; j++){
            if( arr[j] == x){
                index = j ;//记录值为x的下标
                System.out.println("值为：" + x + " 的元素在表中的第" + index  + "位");
                flag = true;//如果存在值为x的元素，flag为true
            }
        }
    }
}