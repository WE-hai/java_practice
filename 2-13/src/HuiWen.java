public class HuiWen {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

    public static void main(MyString[] args) {
        HuiWen test = new HuiWen();
        int x1 = 12321;
        int x2 = 23456;
        System.out.println(test.isPalindrome(x1));
        System.out.println(test.isPalindrome(x2));
    }
}
