public class Abc {
    public static boolean isAdmin(String s) {
        return s.toLowerCase() == "admin";
    }

    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
