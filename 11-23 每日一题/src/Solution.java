public class Solution {
    public static boolean isAdmin(String s) {
        return s.toLowerCase() == "admin";
    }

    //public abstract void m();
    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
