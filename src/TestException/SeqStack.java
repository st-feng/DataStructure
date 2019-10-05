package TestException;

public class SeqStack  {
    public static void main(String[] args){
            try{
                throw new Exception();
            }catch (Exception e){
                System.out.println("Catch the Exception");
                e.printStackTrace();
            }
    }
}
