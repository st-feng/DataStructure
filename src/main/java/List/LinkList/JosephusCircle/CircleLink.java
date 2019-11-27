package List.LinkList.JosephusCircle;
import List.LinkList.Node;

public class CircleLink {
  int n = 0;  //基数
  int m = 0;  //密码
  //定义尾指针、临时指针
  Node dowm ,point;

  //构造方法，创建长度为n的循环链表
  CircleLink(int n,int m){
    this.n = n;
    this.m = m;
    // 为尾指针赋值
    dowm = new Node("NODE: "+n);
    // 临时指针，指向尾指针
    Node p = dowm;
    //采用头插法，依次创建节点
    for (int i =n-1;i>0 ;i--){
      Node node = new Node("NODE: "+i);
      //新节点与前一次创建的节点连接，首次时连接到尾指针
      node.next = p;
      // 临时指针指向新创建的节点
      p = node;
      //尾指针next指针指向新创建节点，形成闭环
      dowm.next = node;
    }
  }

  //下面实现约瑟夫环
  public void killNode (){
    //指向尾指针节点
    point = dowm;
    // 计数器
    int count = 0;
    //当不止一个节点
    while (point.next != point){
      //先记数，后改变指针
      count ++;
      if (count == m){
        System.out.println(point.next.data);
        point.next = point.next.next;
        //因为采用先计数后指针，计数器重置要重置到1
        count = 1;
      }
      point = point.next;
    }
  }


  public static void main(String[] args) {
    //创建基数为6，密码为3的环形链表
    CircleLink c = new CircleLink(6,3);
      //下面实现约瑟夫环
    System.out.println("出圈人员的编号依次输出顺序为：");
    c.killNode();
  }




}
