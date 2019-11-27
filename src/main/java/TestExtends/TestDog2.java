package TestExtends;

public class TestDog2 {

    public static void main(String[] args) {
        Dog2 d2 = new Dog2("Mini",1,"Baby");
        System.out.println(d2.name + " is " + d2.age + " years ols. It's nickname is "+d2.nickname);
        System.out.println(d2.run());
        d2.getHobby();
        System.out.println();
        System.out.println("多态实现");
        System.out.println("===========");

        d2.nickname = "Wind";
        System.out.println(d2.run("Dog"));
        System.out.println(d2.run());

    }
}
