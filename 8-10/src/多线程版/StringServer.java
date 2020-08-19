package 多线程版;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StringServer {
    // 提供服务
    public void service() {
        int i = 1;
        try {
            // 建立服务器连接,设定客户连接请求队列的长度
            ServerSocket server = new ServerSocket(8080, 3);
            while (true) {
                if (i <= 3) {
                    // 等待客户连接
                    Socket socket = server.accept();
                    System.out.println("第" + i + "个客户连接成功！");
                    new Thread(new ServerThread(socket, i)).start(); i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StringServer().service();
    }


}
