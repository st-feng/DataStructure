package TestExtends;
public class TestAnimal{
    public static void main (String[] args){
        Animal mini = new Animal("Mini",3);
        Animal tom = new Animal("Tom",1);
        System.out.println(mini.name + " is " + mini.age + " years old.");
        System.out.println(tom.name + " is " + tom.age + " years old.");
        System.out.println(mini.name + " and " +  tom.name + mini.run());
    }
}