package List.LinkList;

public class DuLNode extends Node{
//  public Object data;
  public DuLNode prior; //前驱节点
  public DuLNode next; //后继节点
  DuLNode(){
    this(null);
  }
  DuLNode(Object data){
    super();
    this.data = data;
    prior = null;
    next = (DuLNode) super.next;
  }
}
