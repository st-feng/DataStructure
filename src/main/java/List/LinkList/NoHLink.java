package List.LinkList;

public class NoHLink  {
  public Node head;  //单链表的头指针
  int len;
  NoHLink(){}

  //构造一个长度为n的单链表，可选头插法还是尾插法
  NoHLink(int n) throws Exception{
    createTop(n); //使用头插法逆序建立单链表
    len = length();
  }
  //使用头插法建立长度为n的链表
  public void createTop(int n) throws Exception{
    for (int i=n;i>=1;i--){  //目的在于让第i个元素的data也是i
     insert(0,i);
    }
  }

  public void clear() {
    head = null;
    len = 0;
  }

  public boolean isEmpty() {
    return head == null; //头节点后是否有节点
  }

  public int length() {
    Node p = head;  //游标指针
    int length = 0;
    while (p != null){  //第一个节点存在
      ++length; //先自增计数
      p = p.next;
    }
    return length;
  }

  public Object get(int i) throws Exception {
    Node p = head;
    int count = 1;
    //检验输入值是否合理
    if (i>len){
      throw new Exception("输入值超过链表长度");
    }else {
      while (count < i){
        ++ count;  //先自增计数定位
        p = p.next;

      }
    }
    System.out.println("第"+i+"个元素的值为："+p.data);
    return p.data; //返回第i个元素的data
  }

  public void insert(int i, Object x) throws Exception{
    Node p = head; //重置游标
    int j = 1; //计数器,heap初始已经指向第1个节点
    //寻找第i个节点的前驱
    while (p != null && j< i-1){
      p = p.next;
      ++j;  //计算器加1
    }
    //检查上下边界
    if (i>len || i<0) throw  new Exception("插入位置不合法");
    //生成新节点
    Node node = new Node(x);
    //修改链，将新节点插入单链表中
    if (i == 0){
      node.next = head;
      head = node;
    }else {
      node.next = p.next;
      p.next = node;
    }
    System.out.println("在第"+i+"个元素前插入了"+x);
    len++;
  }

  public void remove(int i) throws Exception{
    Node p = head; //重置游标
    int count = 1;
    if (i>len){
      throw new Exception("输入值超过链表长度");
    }else {
      while (count < i - 1) { //定位到第i-1个元素
        ++count;  //先自增计数定位
        p = p.next;
      }

      if (i==1){
        System.out.println("删除了第"+i+"个元素"+head.data);
        head = head.next;
      }else {
        System.out.println("删除了第"+i+"个元素"+p.next.data);
        p.next = p.next.next;
      }

    }

    len--;
  }

  public void display() {
    Node p = head;//重置游标
    int count = 0;
    if (p == null){
      System.out.println("当前链表没有元素！");
    }else {
      while (p.next != null) { //
        ++ count;  //先自增
        System.out.println("第"+count+"个元素为：" + p.data);
        p = p.next;
      }
      System.out.println("====链表共有"+ count +"个元素====");
    }

  }
}
