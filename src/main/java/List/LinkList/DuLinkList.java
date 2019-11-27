package List.LinkList;
public class DuLinkList extends LinkList {
  DuLNode head;
  DuLinkList(){
    super();
    head = new DuLNode();
    head.prior = head;
    head.next = head;
  }
  DuLinkList(int n) throws Exception{
    head = new DuLNode();
    head.prior = head;
    head.next = head;
    for (int i=n;i>0;i--) insert(1,i);
  }
  @Override
  public void display() {
    DuLNode p = head;//重置游标
    int count = 0;
    if (len == 0){
      System.out.println("当前链表没有元素！");
    }else {
      while (count < len) { //
        ++ count;  //先自增
        p = p.next;
        System.out.println("第"+count+"个元素为：" + p.data);
      }
      System.out.println("链表共有"+ len +"个元素");
    }
  }
  @Override
  public Object get(int i) throws Exception {
    DuLNode p = head;
    int count = 0;
    //检验输入值是否合理
    if (i>len || i<0){
      throw new Exception("输入值不合法");
    }else {
      while (count < i){
        p = p.next;
        ++ count;  //先自增计数定位
      }
    }
    System.out.println("第"+i+"个元素的值为："+p.data);
    return p.data; //返回第i个元素的data
  }
  @Override
  public void remove(int i) throws Exception{
    DuLNode p = head; //重置游标
    int count = 0;
    if (i>len ||i <0){
      throw new Exception("输入值不合法");
    }else {
      while (count < i) { //定位到第i-1个元素
        ++count;  //先自增计数定位
        p = p.next;
      }
      System.out.println("移除第"+i+"个元素");
      p.next.prior = p.prior;
      p.prior.next = p.next;
      len--;

    }
  }
  @Override
  public void insert(int i, Object x) throws Exception{
    DuLNode p = head; //重置游标
    int j = 0; //计数器
    //寻找第i个节点前驱
    while (j< i){
      p = p.next;
      ++j;  //计算器加1
    }
    //检查上下边界
    if (j > i) throw  new Exception("插入位置不合法");
    //生成新节点
    DuLNode node = new DuLNode(x);
    //修改链，将新节点插入单链表中
    node.prior = p.prior;
    node.next = p;
    p.prior.next = node;
    p.prior = node;

    len++;
  }

  public static void main(String[] args) throws Exception {
    System.out.println("创建链表...");
    DuLinkList dll = new DuLinkList(4);
    dll.display();
    dll.length();
    dll.remove(1);
    dll.display();
    dll.get(1);
  }
}


