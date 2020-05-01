package 人民币转换;

import java.util.Scanner;

public class TestMain {
    final static String[] zi = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
    public static String qian(int m) {
        int qian = m/1000;
        int bai = (m-qian*1000)/100;
        int shi = (m-qian*10000-bai*100)/10;
        int ge = m-qian*1000-bai*100-shi*10;
        StringBuilder sb = new StringBuilder();
        if (qian != 0) {
            sb.append(zi[qian]+"仟");
        }
        if (bai != 0) {
            sb.append(zi[bai]+"佰");
        } else if (qian != 0 && bai == 0 && (shi != 0 || ge != 0)) {
            sb.append("零");
        }
        if (shi != 0 && shi != 1) {
            sb.append(zi[shi]+"拾");
        } else if (bai == 0 &&  ge != 0) {
            sb.append("零");
        }
        if (shi == 1 && bai == 0 && qian == 0) {
            sb.append("拾");
        }
        if (ge != 0) {
            sb.append(zi[ge]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double m = scanner.nextDouble();
            StringBuilder sb = new StringBuilder();
            int yi = (int)m/100000000;
            int wan = (int)(m-yi*100000000)/10000;
            int qiyu = (int)(m-yi*100000000-wan*10000);
            System.out.print("人民币");
            if (yi != 0) {
                sb.append(qian(yi)+"亿");
            }
            if (wan != 0) {
                sb.append(qian(wan)+"万");
            }
            if (qiyu != 0) {
                sb.append(qian(qiyu)+"元");
            }
            int xiaoshu = (int)((m-yi*100000000-wan*10000-qiyu+0.001)*100);
            int jiao = xiaoshu/10;
            int fen = xiaoshu%10;
            if (jiao != 0 && fen != 0) {
                sb.append(zi[jiao]+"角"+zi[fen]+"分");
            } else if(jiao != 0 && fen == 0){
                sb.append(zi[jiao]+"角");
            }else if (jiao == 0 && fen != 0) {
                sb.append("零"+zi[fen]+"分");
            }else if (jiao == 0 && fen == 0) {
                sb.append("整");
            }
            System.out.println(sb.toString());
        }
    }
}
