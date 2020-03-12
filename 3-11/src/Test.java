public class Test{
    public String name="abc";
    public static void main(String[] args){
        Test test = new Test();
        Test testB = new Test();
        System.out.println(test.equals(testB)+","+test.name.equals(testB.name));
    }
}