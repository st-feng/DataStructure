package LinkList.CalculateLink;

public class LinkForm {
    public Node heap = new Node();
    int formLen = 0 ;

    //创捷长度为n的链表
    public void creat (int n) throws NullPointerException {
        for (int i=0;i<n ;i++){
            insert(0,i);
        }
    }
    void creat (Object[] arr) throws NullPointerException {
        for (int i=0;i<arr.length ;i++){
            insert(0,arr[i]);
        }
    }

    //在第i个元素之前插入
    protected void insert(int i, Object data) throws NullPointerException {

        //检验输入值是否正确
        check(i);

        Node p = search(i-1);//找到第i-1个元素,赋给p
        Node n = new Node(data);

        n.next = p.next;        //改变指针
        p.next = n;
        formLen++;  //链表长度加1

    }

    //删除第i个元素
    void delete (int i)throws NullPointerException {
        //检验输入值是否正确
        check(i);
        Node p = search(i-1); //找到第i个元素,赋给p

        p.next = p.next.next;  //第i-1个元素的next元素为第i+1个元素
        formLen --;
    }

    // 修改第i个元素的数据值
    void changeValue (int i) throws Exception {
        //检验输入值是否正确
        check(i);
    }

    //输出当前链表
    void out (){
        Object data;
        Node point = heap;
        for (int i=0; i<formLen; i++){
//        int i = 0;
//        while (point.data != null){
            point = point.next;
            data = point.data;
            System.out.println("链表中，第"+ i + "个元素的数据为： " + data );
//            System.out.println("||" + point);
        }
    }

    //search_1 查找第i个元素
    public Node search(int i){
//        //检验输入值是否正确，该方法会自动终止程序
//        check(i);

        //为了使第（4）题执行后
        // 测试程序继续执行第（5）题后续代码，
        // 不使用check(),采用以下代码检验：
        if(i > formLen){
            System.out.println("该元素不存在");
            return null;
        }

        Node p = heap;
        //找出第i-1个元素Node p
        for (int j = 0; j <= i; j++) {
            p = p.next;
        }
        return p;
    }

    //search_2 查找值为y的元素下标
    protected void search (Object value){
        Node p = heap.next;  //指向第0个元素
        boolean flag = true;
        int count = 0; //记录查到多少次该元素，若为0则代表元素不存在。
        String data;
        int i = 0;//定位元素的下标

        //比较元素是否相等且不超过链表长度。
        while (flag){
            data= String.valueOf(p.data);//将Object类型转化为String类型，尔后进行equal

            while (!value.equals(data) ) {
                if (p.next == null){
                    flag = false;  //当查找至最后一个元素时，跳出循环
                    break;
                }else {
                    p = p.next;
                    data= String.valueOf(p.data);//每次都需转化
                    i++;
                }

            }

            if(i == formLen-1){   //当还有后续元素时，继续查找，否则跳出循环
                break;
            }else {
                System.out.println("查找成功，该元素出现的位序号为： "+ i);
                count ++;
                p = p.next;
                i++;
            }

        }

        if (count == 0){
            System.out.println("该元素不存在。");
        }
    }

    //检验输入值是否正确
    void check(int i) {
        if(i > formLen){
            System.out.println("该元素不存在");
//            System.out.println("超出链表范围，当前链表长度为:" + formLen);
            System.exit(-1);//退出程序
        }
    }


}
