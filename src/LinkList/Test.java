package LinkList;

public class Test {
  public static void main(String[] args) {
    try{
      LinkList ll = new LinkList(10,true);
      System.out.println(ll.length());
      System.out.println(ll.head);
      ll.display();
      System.out.println("第5个元素为："+ll.get(5));
      System.out.println("所查询元素位于链表第"+ll.indexOf(1)+"个位置");
      ll.remove(6);
      ll.display();

    }catch (Exception e){
      e.printStackTrace();
    }
  }


}
