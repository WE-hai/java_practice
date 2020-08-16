package TCPsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器启动了....");
        boolean isShow = true;
        // 设置第一次输出[服务器启动了....]，启动后不再显示。
        while (true){
            try {
                Socket client = server.accept();
                String clientName = client.getInetAddress().getLocalHost().toString();
                if(isShow){
                    System.out.println("客户端:"+clientName+" 已连接到服务器");
                }
                isShow = false;
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String word = br.readLine();
                // word 客户端发送来的消息
                if(null != word) {
                    System.out.println("客户端输入的是："+word+",服务器响应的是："+word);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    bw.write(word+"\n");
                    bw.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
