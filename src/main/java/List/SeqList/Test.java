package List.SeqList;

public class Test {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,2,2,2,5};
        SeqList s = new SeqList(20,a);
//        s.remove(6);
        s.removeSame();


    }
}
