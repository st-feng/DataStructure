package Stack.IStack.Hanoi;

public class HanoiImpl {

  /*【解题思路】
  * 当 n = 1 时，将圆盘从orgin直接转移到target
  * 当 n > 1 时，需利用塔座temp 作为辅助塔座
  *     若能先设法将压在编号为n的圆盘上的n-1个圆盘从orgin塔移到temp塔上
  *     则可以将编号为n的圆盘从orgin移至target。然后再将temp上的n-1个圆盘移到target上
  *     而将n-1个圆盘移到target上是一个和原问题具有相同性质的问题 规模 - 1
  *     找到递归出口为，n = 1 时，直接挪到。*/

  /* n为圆盘个数
   *  orgin 为初始塔
   *  temp 为缓存塔
   *  target 为目标塔
   */
  int count =0;  //记录第几次移动

  void hanori(int n,char orgin,char temp,char target){
    if(n == 1){
      move(n,orgin,target);
    }else {
      //1.将上面n-1个元素一直temp塔，所以temp塔是目标（target）塔
      hanori(n-1,orgin,target,temp);
      //2.将n号盘从orgin塔移至target塔
      move(n,orgin,target);
      //3.将temp塔上的n-1个元素移到target塔上
      //    相当于原问题规模减1的子问题
      hanori(n-1,temp,orgin,target);
    }
  }

  //打印操作过程n对应的是当前问题规模，也是相应的几号盘
  void move (int n,char orgin,char target){
    System.out.println("第"+ (++count) + "次移动，移动 "+ n + " 号盘 "+orgin + " --> " +target);
  }

  public static void main(String[] args) {
    HanoiImpl hni = new HanoiImpl();
    hni.hanori(4,'x','y','z');
  }
}
