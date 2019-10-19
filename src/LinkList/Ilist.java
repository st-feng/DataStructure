package LinkList;
public interface Ilist {
  public void clear(); //清空
  public boolean isEmpty(); //判空
  public int length(); //长度
  public Object get(int i) throws Exception; //获得第i个元素
  public void insert(int i,Object x)throws Exception; //在第i位置前插入x
  public void remove(int i)throws Exception; //移出第i个元素
  public int indexOf(Object x)throws Exception; //查找x位置
  public void display(); //打印链表

}
