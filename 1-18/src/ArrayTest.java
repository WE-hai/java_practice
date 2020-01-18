import java.util.Arrays;

public class ArrayTest {
    private String[] han = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private String[] unit = {"十","佰","仟"};
    private String[] divide(double num) {
        long zheng = (long)num;
        long xiao = Math.round((num - zheng)*100);
        return new String[]{zheng + " ",String.valueOf(xiao)};
    }

    private String toHanStr(String numStr) {
        String result = " ";
        int numLen = numStr.length();
        for (int i = 0;i < numLen;i++) {
            int num = numStr.charAt(i)-48;
            if (i != numLen - 1 && num != 0) {
                result += han[num] + unit[numLen - 2 - i];
            } else {
                result += han[num];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayTest arr = new ArrayTest();
        System.out.println(Arrays.toString(arr.divide(2232342453.7775)));
        System.out.println(arr.toHanStr("6103"));
    }
}
