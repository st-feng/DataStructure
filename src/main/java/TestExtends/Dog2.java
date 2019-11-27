package TestExtends;

public class Dog2 extends Animal implements Hobby{
    String nickname;

    Dog2(String str,int age,String nickname){
        super(str,age);
        this.nickname = nickname;
    }


    public String[] getHobby() {
        System.out.println("Dogs' hobbies are: ");

        String [] str = {"bone","meat","rice","bread"};
        for(int i=0; i<str.length ; i++) {
            System.out.println(str[i]);
        }
        return str;
    }
    public String run() {
        return nickname + " run by four feet";
    }
}

