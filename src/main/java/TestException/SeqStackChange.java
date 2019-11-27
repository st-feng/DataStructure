package TestException;

public class SeqStackChange {
    public static void main(String[] args){
        try{
            push();
        }catch (Exception e){
            System.out.println("Catch the Exception on main");
            e.printStackTrace();
        }
    }

    static void push() throws Exception{
            throw new Exception();
    }
}
