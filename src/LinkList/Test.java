package LinkList;

public class Test {
  public static void main(String[] args) {
    try{
      LinkList ll = new LinkList(10,true);
      System.out.println(ll.length());
      System.out.println(ll.head);
      ll.display();
      System.out.println(ll.get(4));
      System.out.println(ll.indexOf(5));
      ll.remove(6);
      ll.display();

    }catch (Exception e){
      e.printStackTrace();
    }
  }


}
