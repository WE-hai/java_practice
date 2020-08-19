package 多线程版;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class StringClient {
    private String name = String.valueOf(new Random().nextInt(999999));
    //客户端的名字
    public void chat() {
        try {
            // 连接到服务器
            Socket socket = new Socket("localhost", 8080);
            // 读取服务器端传过来信息的DataInputStream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            // 向服务器端发送信息的DataOutputStream
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            // 装饰标准输入流，用于从控制台输入
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入数据：");
                String send = scanner.nextLine();
                // 把从控制台得到的信息传送给服务器
                out.writeUTF("客户端[" + name + "]:" + send);
                // 读取来自服务器的信息
                String accpet = in.readUTF();
                System.out.println(accpet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StringClient().chat();
    }
}
