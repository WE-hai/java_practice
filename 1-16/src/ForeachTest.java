public class ForeachTest {
    public static void main(String[] args) {
        String[] books = {"语文","数学","英语"};
        for (String book : books) {
            book = "化学";
            System.out.println(book);
        }
        System.out.println();
        System.out.println(books[0]);
    }
}
