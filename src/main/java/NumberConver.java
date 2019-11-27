
import java.util.Scanner;

public class NumberConver {
  public static String binaryTransform(int decimalNum){
    String binanylNum = Integer.toBinaryString(decimalNum);
    return binanylNum;
  }
//  测试程序
  public static void main(String[] args) {


//  public void mainTest() {
    System.out.println("请输入一个十进制整数：");
    Scanner sc = new Scanner(System.in);
    int decimalNum = sc.nextInt();
    System.out.println(decimalNum + "：的二进制数位为：" + binaryTransform(decimalNum));
  }
}
