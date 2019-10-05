package CalculateLink;

import java.util.Scanner;

public class TestLinkForm {
    public static void main(String[] args){

        //将输入的参数转化为object类型
        Scanner sc = new Scanner(System.in);//扫描键盘输入
        System.out.println("请输入您的参数，参数之间用英语符号“,”隔开。");
        String str = sc.nextLine();
        Object[] obj = str.split(","); //将字符串分9割后装进数组
//        Object[] obj = {9,1.1,2,6,5,4,3,2,1,0};
        //创建一个链表
        LinkForm lf = new LinkForm();

        try{
            //第（1）题
            System.out.println("=========第(1)题==========");
            lf.creat(obj); //将输入的参数构建成链表
            lf.out();   //输出链表

            //第（2）题
            System.out.println("=========第(2)题==========");
            System.out.println("【在第5个元素之前插入一个值为X的新元素】");
            lf.insert(5,"X"); //在第5个元素之前插入一个值为x的新元素
            lf.out();

            //第（3）题
            System.out.println("=========第(3)题==========");
            System.out.println("【删除单链表中第4个元素】");
            lf.delete(4);
            lf.out();

            //第（4）题
            System.out.println("=========第(4)题==========");
            System.out.println("【查找第6个元素...】");
            System.out.println("第6个元素为："+lf.search(6).data);
            System.out.println("【查找第20个元素...】");
            try{
                System.out.println(lf.search(20).data);
                System.out.println("第20个元素为："+lf.search(20). data);
            }catch (Exception e){
                //忽略掉该异常，继续执行
            }
            //第（5）题
            System.out.println("=========第(5)题==========");
            System.out.println("【查找值为2的元素,输出该元素的位序号】");
            lf.search("2");
            System.out.println("【查找值为9587的元素,输出该元素的位序号】");
            lf.search("9587");

        }catch (NullPointerException e){
            e.printStackTrace();
        }


    }
}
