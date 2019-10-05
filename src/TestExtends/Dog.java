package TestExtends;

public class Dog extends Animal{
    String nickname;

    Dog (String name,int age){
        super(name,age);
    }
    Dog(){
        super();
    }
    void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public String run() {
        return nickname + " run by four feet";
    }
}

class TestDog {
    public static void main(String[] args){
        Dog dM = new Dog("Mini",3);
        dM.setNickname("Baby");
        System.out.println(dM.name + " is " + dM.age + " years old.It's nickname is " + dM.nickname);
        System.out.println(dM.run());

        Dog dT = new Dog("Tom",1);
        System.out.println(dT.name + " is " + dT.age + " years old.");
        dT.run();
        System.out.println(dT.run(dT.name));
    }
}