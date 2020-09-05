package 题目2;

import java.util.*;

class Thing {
    double price;
    double weight;
    int v;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Thing(double price, double weight, int v) {
        this.price = price;
        this.weight = weight;
        this.v = v;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            List<Thing> list = new ArrayList<>();
            for (int i = 0;i < n;i++) {
                list.add(new Thing(scanner.nextDouble(),scanner.nextDouble(),scanner.nextInt()));
            }
            int count = 0;
            double sumPrice = 0;
            for (int i = 0;i < n;i++) {
                sumPrice += list.get(i).price;
            }
            double sumWeight = 0;
            for (int i = 0;i < n;i++) {
                sumWeight += list.get(i).weight;
            }
            if (sumPrice < m && sumWeight < k) {
                System.out.println(n);
            } else {
                int minV = 0;
                for (int i = 0;i < n;i++) {
                    minV = Math.min(list.get(i).v,minV);
                }

            }
        }
    }
}
