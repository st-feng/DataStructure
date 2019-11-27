package TestExtends;

public class Animal {
    String name;
    int age;
    Animal(){}

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String run() {
        return "can run.";
    }
    String run(String name) {
        return name + " can run.";
    }

}
