package Stack.IStack;

public interface IStack {
  //栈顶指针，指向栈顶元素存储位置的下一个位置，栈空时指向0

  //1.置栈空操作
  public void clear();
  //2.判栈空操作
  public boolean isEmpty();
  //3.求栈中数据元素操作length（）
  public int length();
  //4.取栈顶元素操作peek（）
  public Object peek();
  //5.入栈操作
  public void push(Object x)throws Exception;
  //6.出栈操作
  public Object pop();

}
