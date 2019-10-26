package IStack;

import LinkList.Node;

public class LinkStack implements IStack {
  Node top;
//  int len;
//  LinkStack(int len){
//    this.len = len;
//  }
  @Override
  public void clear() {
    top = null;
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }

  @Override
  public int length() {

    if (isEmpty()){
      return  0;
    }else {
      int count = 0;
      for (Node p = top; !(p == null); p = p.next){
        count ++;
      }
      return count;
    }

  }

  @Override
  public Object peek() {
    return top.data;
  }

  @Override
  public void push(Object x) throws Exception {
    Node node = new Node(x);
    node.next = top;
    top = node;
  }

  @Override
  public Object pop() {
    if (isEmpty()){
      System.out.println("栈为空！");
      return null;
    }else {
      Object obj = top.data;
      top = top.next;
      return obj;
    }
  }

  public void display(){
    Node p = top;
    if (p == null){
      System.out.println("栈为空！");
      return;
    }
    while (p != null){
      System.out.println(p.data.toString() + "");
      p = p.next;
    }
  }
}
