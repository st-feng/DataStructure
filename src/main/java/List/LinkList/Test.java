package List.LinkList;

public class Test {
  public static void main(String[] args) {
    try{
      System.out.println("创建链表...");
      LinkList ll = new LinkList(4,false);
      System.out.println("====创建完成=====");
      ll.display();
//      ll.insert(4,7);
//      ll.display();
//      ll.remove(5);
//      ll.display();
//      ll.get(4);


    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
