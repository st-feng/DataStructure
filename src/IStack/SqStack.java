package IStack;

public class SqStack implements IStack {
  private int top; //栈顶指针
  private Object[] stackElem;  //对象数组
  //初始化
  SqStack(int maxSize){
    top = 0;
    stackElem = new Object[maxSize];
  }

  @Override
  public void clear() {
    top = 0;
  }

  @Override
  public boolean isEmpty() {
    return top == 0;
  }

  @Override
  public int length() {
    return top;
    //因为数组下标从0开始，top指向下一个位置，所以正好
  }

  @Override
  //4.取栈顶元素操作peek（）
  public Object peek() {
    if (! isEmpty()){  //判是否为空
      return stackElem[top - 1];  //返回栈顶元素
    }else {
      return null;
    }
  }

  @Override
  public void push(Object x) throws Exception {
    if (top == stackElem.length){  //判是否栈满
      throw new Exception("栈满！");
    }else {
      stackElem[top] = x;
      top ++;
    }
  }

  @Override
  public Object pop() {
    if (isEmpty()){
      return null;
    }else {
      top --;
      return stackElem[top];
    }
  }

  //打印栈元素
  public void display(){
    if (isEmpty()){
      System.out.println("栈为空！");
    }else {
      for (int i=top-1 ; i>=0 ; i--){
        System.out.println(stackElem[i].toString() + "");
      }
    }

  }
}
