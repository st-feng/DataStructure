package Stack.maze;
public class SolutMaze {
  String[][] routeVal; //迷宫图
  String[][] routeSeq; //行走记录板
  String bond; //墙
  int i,j;


//  int[] routeAble = new int[8]; //创建一个栈，路线选择
//  int top = 1;  //栈顶指针

//  初始化迷宫图
public SolutMaze(String[][] routeVal, String bond) throws Exception{
    //获得墙壁
    this.bond = bond;
    /*获取迷宫的规模，为初始化迷宫做准备
    * 如果传入的迷宫是不规则的，需要套一层for循环
    * 这就使得初始化迷宫时，算法时间复杂度O(n^3)
    * 所以，本例只考虑规则形状迷宫*/
    int Vlen = routeVal.length;
    int Hlen = routeVal[0].length;

    /*遍历一次迷宫形状
    * 若迷宫为不规则形状，抛出异常*/
    for (int i = 1; i <Vlen ; i++) {
      if (routeVal[i].length != Hlen){
        throw new Exception("输入的迷宫必须为规则形状的迷宫");
      }
    }

//初始化迷宫（将传进来的迷宫图四周，加上一圈墙壁，这层围墙用户是看不见的）
//因为从角落扫描四周时会出边界，加上一层能简化实现逻辑
    this.routeVal = new String[Vlen+2][Hlen+2];
    routeSeq = new String[Vlen+2][Hlen+2];

    for (int i = 0; i <this.routeVal.length ; i++) {
      for (int j = 0; j <this.routeVal[i].length ; j++) {

        if (i==0 || i==this.routeVal.length-1 ){
          this.routeVal[i][j] = bond;
        }

        else if (j==0 || j==this.routeVal[i].length-1){
          this.routeVal[i][j] = bond;
        }

        else {
          this.routeVal[i][j] = routeVal[i-1][j-1];
        }
      }
    }

//    初始化行劫记录面板
    for (int i = 0; i <routeSeq.length ; i++) {
      for (int j = 0; j <routeSeq[i].length ; j++) {
        routeSeq[i][j] = "0";
        this.routeVal[0][j] = bond;
        this.routeVal[this.routeVal.length-1][j] = bond;
      }
      this.routeVal[i][0] = bond;
      this.routeVal[this.routeVal[0].length-1][0] = bond;
    }

//    寻找迷宫入口
    for (int i = 0; i < routeVal.length; i++) {
      for (int j = 0; j<routeVal[i].length ;j++) {
        if (routeVal[i][j] == "入口"){
          //因为有一层围墙，需要加1
          System.out.println("入口坐标（i，j）为：("+(i+1)+","+(j+1)+")");
          this.i = i;
          this.j = j;
        }
      }
    }

  }

  //启动寻找迷宫出口程序
  public void start(){
//    1.找到出口，接收出口坐标
    int[]result = serchRoute(i+1,j+1);
    if (result[0] == -1){
      System.out.println("========================================");
      System.out.println("          ！！！警告 ！！！");
      System.out.println("您设计的迷宫永远到达不了出口。。。");
      System.out.println("========================================");
    }else{
      System.out.println("出口坐标为：("+result[0]+","+result[1]+")");
      printRoute(result);
    }

//    2.打印行进路线

//    for (int k = 1; k <routeSeq.length ; k++) {
//      for (int l = 1; l <routeSeq[k].length-1 ; l++) {
//        System.out.print(routeSeq[k][l]+" ");
//      }
//      System.out.println();
//    }

    /*int[][] print = serchAround(routeSeq,"0",i+1,j+1);
    int top = 0;
    for (int k = 0; k <print.length ; k++) {
      if (print[k] == null){
        top = k;
        break;
      }
    } //获得真实栈顶top

    System.out.println(print[1].length);
    System.out.println("从当前位置向坐标("+print[1][0]+","+print[1][1]+")移动");
*/
 }

  //输入从什么位置开始搜索，返回“出口”的坐标
  int[] serchRoute(int i,int j){
//接收“出口”坐标(可以省略，直接末尾return)
//    末尾对应的result就是用来传递的，没有实际作用，所以为了省空间
//    提高程序运行速度，决定不创建result，直接return
    int[] result = null;

//1 复制一份迷宫图副本
    /*每进入一层递归
    *复制一份迷宫图
    * 因为搜索周围路径时，为了防止在两个格子间来回跳动的情况
    * 需要关闭来路
    * 但是不能更改迷宫真实信息
    * 所以需要一个副本进行操作，屏蔽入口不扫描*/
    String[][] tempRouteVal = routeVal;
    int top = 1;
//4 关闭来路，防止一直在两个格子间来回走动
    tempRouteVal[i][j] = bond;
//2 判断当前可走区域，是否有“出口”,并将记录压入栈

    //2.1 获得当前位置，搜索后得到的栈
    int[][] e = serchAround(tempRouteVal,bond,i,j);  //搜索可走路线，压入栈

    //2.2 判断当前位置四周，是否有出口
    if (e[0][0] != -1){  //说明周围有出口
//      result =  e[0];  //从栈底取出出口坐标
//      return result;    //返回出口坐标，结束
      routeSeq[e[0][0]][e[0][1]] = "1"; //走至出口，记录行走。同3.1.1
      return e[0];   //返回出口坐标，结束
    }
    //2.3 四周若无出口，从栈中取出一个行进坐标
    else {
      //2.3.1 定位栈顶元素（需要注意：不能让栈底的记录被替换）
//      int top = 1;
      for (int k = 0; k <e.length ; k++) {
        if (e[k] == null){
          top = k;
          break;
        }
      } //获得真实栈顶top

  /*递归出口：当所走路线处于封闭时，返回上一层，走下一条路线
      递归出口，表示栈中1位置也为空，周围没有可行路径
      因为0位置是用于记录出口坐标的，不是记录行进信息*/
      if (top == 1)return e[0];

// 3 从栈中选择一条路径行走
      //3.1 用next记录行至哪个位置
      int[] next = e[--top];
        //3.1.1 记录行走，将挪动到的位置从0改为1（初始全为0）
        // 为下一步打印行进路线提供支持
      routeSeq[next[0]][next[1]] = "1";


//5 递归查找，返回出口信息（如果走进死胡同，出口信息保持（-1，-1））
      result = serchRoute(next[0],next[1]);
//      print();
      return result;
//      return serchRoute(next[0],next[1]);
    }
  }

  //搜索一周可行走路径，返回一个栈底为出口坐标，栈中存有可行路线的二维栈
  int[][] serchAround(String[][]routeVal ,String bond, int i,int j){

    //记录出口位置，默认出口位置为-1
    int[] exitAddr = new int[2];
    exitAddr[0] = -1;
    exitAddr[1] = -1;

    //二维栈，栈中每一个元素是一个数值
    // 记录可走的路线
//    8个方向加1个栈底存出口信息
    int[][] routeAble = new int[9][];

    //栈底压入出口位置，
    routeAble[0] = exitAddr;

    //栈顶指针初始为1，使栈底保持为出口坐标
    int top = 1;

    //检查当前坐标（i,j）四周是否有可行走路径（先判断是否有出口），压入栈中

    //检查 左上 角,是否为墙 （先检查四个角，使路径最短）
    if (routeVal[i-1][j-1] != bond){
        if (routeVal[i-1][j-1] == "出口") { //是否为出口
          exitAddr[0] = i-1;
          exitAddr[1] = j-1;
          routeAble[0] = exitAddr;
          return routeAble; //返回出口位置
        }
        routeAble[top] = new int[]{i-1,j-1}; //压入栈
        top++;
      }

    //右上
    if (routeVal[i-1][j+1] != bond){
      if (routeVal[i-1][j+1] == "出口") { //是否为出口
        exitAddr[0] = i-1;
        exitAddr[1] = j+1;
        routeAble[0] = exitAddr;
        return routeAble; //返回出口位置

      }
      routeAble[top] = new int[]{i-1,j+1}; //压入栈
      top++;
    }

    //左下
    if (routeVal[i+1][j-1] != bond){
      if (routeVal[i+1][j-1] == "出口") { //是否为出口
        exitAddr[0] = i+1;
        exitAddr[1] = j-1;
        routeAble[0] = exitAddr;
        return routeAble; //返回出口位置

      }
      routeAble[top] = new int[]{i+1,j-1}; //压入栈
      top++;
    }

    //右下
    if (routeVal[i+1][j+1] != bond){
      if (routeVal[i+1][j+1] == "出口") { //是否为出口
        exitAddr[0] = i+1;
        exitAddr[1] = j+1;
        routeAble[0] = exitAddr;
        return routeAble; //返回出口位置

      }
      routeAble[top] = new int[]{i+1,j+1}; //压入栈
      top++;
    }

    //上
    if (routeVal[i-1][j] != bond){
      if (routeVal[i-1][j] == "出口") { //是否为出口
        exitAddr[0] = i-1;
        exitAddr[1] = j;
        routeAble[0] = exitAddr;
        return routeAble; //返回出口位置
      }
      routeAble[top] = new int[]{i-1,j}; //压入栈
      top++;
    }

    //左
    if (routeVal[i][j-1] != bond){
      if (routeVal[i][j-1] == "出口") { //是否为出口
        exitAddr[0] = i;
        exitAddr[1] = j-1;
        routeAble[0] = exitAddr;
        return routeAble; //返回出口位置

      }
      routeAble[top] = new int[]{i,j-1}; //压入栈
      top++;
    }

    //右
    if (routeVal[i][j+1] != bond){
      if (routeVal[i][j+1] == "出口") { //是否为出口
        exitAddr[0] = i;
        exitAddr[1] = j+1;
        routeAble[0] = exitAddr;
        return routeAble; //返回出口位置

      }
      routeAble[top] = new int[]{i,j+1}; //压入栈
      top++;
    }

    //下
    if (routeVal[i+1][j] != bond){
        if (routeVal[i+1][j] == "出口") { //是否为出口
          exitAddr[0] = i+1;
          exitAddr[1] = j;
          routeAble[0] = exitAddr;
          return routeAble; //返回出口位置

        }
        routeAble[top] = new int[]{i+1,j}; //压入栈
        top++;
      }

    return routeAble;
  }

  void print (){
    System.out.println("========HEAD==========");
    for (int k = 1; k <routeSeq.length-1 ; k++) {
      for (int l = 1; l <routeSeq[k].length-1 ; l++) {
        System.out.print(routeSeq[k][l]+" ");
      }
      System.out.println();
    }
//    System.out.println("==========END==========");
  }

  void printRoute(int[] exit){
    //反向查找压栈，出栈为行走步骤
    int[][] stack = new int[routeVal.length+routeVal[0].length][];
    int[][] temp ;
    int top = 1;

    //出口入栈
    stack[0] = exit;
    //获取出口前一个位置
    temp = serchAround(routeSeq,"0",exit[0],exit[1]);
    routeSeq[exit[0]][exit[1]] = "0";
    while (true){
      if (temp[1] == null) break;
//      位置入栈后指针自增
      stack[top] = temp[1];
      temp = serchAround(routeSeq,"0",temp[1][0],temp[1][1]);
      routeSeq[stack[top][0]][stack[top][1]] ="0";
      top++;
    }
    System.out.println("从入口开始，依次移动：");
    int i = 1;
    for (int k = top-1; k >= 0; k--) {
      System.out.println("【"+i+"】"+":向坐标("+stack[k][0]+","+stack[k][1]+")移动");
      i++;
    }
    System.out.println("！！！黎明就在脚下！！！");
  }

}

