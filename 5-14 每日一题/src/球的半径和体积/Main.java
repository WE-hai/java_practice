package 球的半径和体积;

import java.util.Scanner;

public class Main {
    private static double getR(double x0, double y0, double z0, double x1, double y1, double z1) {
        return Math.sqrt((x0-x1)*(x0-x1)+(y0-y1)*(y0-y1)+(z0-z1)*(z0-z1));
    }
    private static double getV(double x0, double y0, double z0, double x1, double y1, double z1) {
        return 4*(getR(x0, y0, z0, x1, y1, z1)*getR(x0, y0, z0, x1, y1, z1)*getR(x0, y0, z0, x1, y1, z1))*Math.PI/3;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double x0 = scanner.nextDouble();
            double y0 = scanner.nextDouble();
            double z0 = scanner.nextDouble();
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            System.out.printf("%.3f",getR(x0,y0,z0,x1,y1,z1));
            System.out.println();
            System.out.printf("%.3f",getV(x0,y0,z0,x1,y1,z1));
        }
    }
}
