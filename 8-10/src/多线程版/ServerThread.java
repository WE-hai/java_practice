package 多线程版;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread implements Runnable {
    private int index;
    private Socket socket;

    public ServerThread(Socket socket, int i) {
        this.socket = socket;
        this.index = i;
    }

    // 任务是为一个用户提供服务
    @Override
    public void run() {
        try {
            try {
                // 读取客户端传过来信息的DataInputStream
                DataInputStream in = new DataInputStream(socket.getInputStream());
                // 向客户端发送信息的DataOutputStream
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    // 读取来自客户端的信息
                    String accpet = in.readUTF();
                    System.out.println("第" + index + "个客户端发出消息：" + accpet);
                }
            } finally {
                // 建立连接失败的话不会执行
                socket.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
