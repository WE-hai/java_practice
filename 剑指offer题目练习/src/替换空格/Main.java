package 替换空格;

public class Main {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if(c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
