package List.LinkList;

public class Node {
    public Object data;
    public Node next;
    //无参构造方法
    public Node(){ this(null,null); }
    //带一个参数时的构造方法
    public Node(Object data){
        this.data = data;
    }
    //带两个参数时的构造方法
    public Node(Object data ,Node next){
        this.data = data;
        this.next = next;
    }
}
