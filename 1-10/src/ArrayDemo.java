public class ArrayDemo {
    public static void main(String[] args) {
        int[] a = {5,7,20};
        int[] b = new int[4];
        System.out.println("数组b的长度："+b.length);
        for (int i = 0,len = a.length;i < len;i++) {
            System.out.println(a[i]);
        }
        System.out.println();
        for (int i = 0,len = b.length;i < len;i++) {
            System.out.println(b[i]);
        }
        b = a;
        System.out.println("数组b的长度："+b.length);

        int[] arr;
        arr = new int[5];
        for (int i = 0;i < arr.length;i++) {
            arr[i] = i+10;
            System.out.print(""+arr[i]+" ");
        }
    }
}
