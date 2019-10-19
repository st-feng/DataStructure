package LinkList;

public class LinkList implements Ilist {
  public Node head;  //单链表的头指针

  //构造方法
  LinkList(){
    head = new Node();//初始化头指针
  }
  //构造一个长度为n的单链表，可选头插法还是尾插法
  LinkList(int n,boolean Order) throws Exception{
    this(); //初始化头节点
    if (Order) createDown(n);  //使用尾插法顺序建立单链表
    else  createTop(n); //使用头插法逆序建立单链表
  }
  //使用头插法建立长度为n的链表
  public void createTop(int n) throws Exception{
    for (int i=n;i>=1;i--){  //目的在于让第i个元素的data也是i
     insert(1,i);
    }
  }
  //使用尾插法建立长度为n的链表
  public void createDown(int n) throws Exception{
    for (int i=1;i<=n;i++){
      insert(length(),i);
    }
  }

  @Override
  public void clear() {
    head.data = null;
    head.next = null;
  }

  @Override
  public boolean isEmpty() {
    return head.next == null; //头节点后是否有节点
  }

  @Override
  public int length() {
    Node p = head.next;  //游标指针
    int length = 0;
    while (p != null){  //第一个节点存在
      ++length; //先自增计数
      p = p.next;
    }
    return length;
  }

  @Override
  public Object get(int i) throws Exception {
    Node p = head;
    int count = 0;
    //检验输入值是否合理
//    if (i>length()){
//      throw new Exception("输入值超过链表长度");
//    }else {
      while (count < i){
        p = p.next;
        ++ count;  //先自增计数定位
      }
//    }
    return p.data; //返回第i个元素的data
  }

  @Override
  public void insert(int i, Object x) throws Exception{
    Node p = head; //重置游标
    int j = -1; //计数器
    //寻找第i个节点的前驱
    while (p != null && j< i-1){
      p = p.next;
      ++j;  //计算器加1
    }
    //检查上下边界
    if (j > i-1 || p == null) throw  new Exception("插入位置不合法");
    //生成新节点
    Node node = new Node(x);
    //修改链，将新节点插入单链表中
    node.next = p.next;
    p.next = node;

  }

  @Override
  public void remove(int i) throws Exception{
    Node p = head; //重置游标
    int count = 0;
    if (i>length()){
      throw new Exception("输入值超过链表长度");
    }else {
      while (count < i - 1) { //定位到第i-1个元素
        ++count;  //先自增计数定位
        p = p.next;
      }
      p.next = p.next.next;
    }
  }

  @Override
  public int indexOf(Object x)throws Exception {
    Node p = head;//重置游标
    int index = 0;

    while (p.next != null){
      p = p.next;
      index++;
      if (p.data.equals(x)){
        break;
      }
    }
    if (p.next == null){
      throw new Exception("元素不存在");
    }
    return index;
  }

  @Override
  public void display() {
    Node p = head;//重置游标
    int count = 0;
    if (p.next == null){
      System.out.println("当前链表没有元素！");
    }else {
      while (p.next != null) { //
        ++ count;  //先自增
        p = p.next;
        System.out.println("第"+count+"个元素为：" + p.data);
      }
      System.out.println("链表共有"+ count +"个元素");
    }

  }
}
