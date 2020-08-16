package TCPsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpDictServer {
    // 定义map集合，用来存放需要翻译的单词。
    private static Map<String, String> maps = new HashMap<>();
    // 向map中添加数据
    static {
        maps.put("dog", "狗");
        maps.put("cat", "猫");
        maps.put("fish", "鱼");
        maps.put("bird", "鸟");
        maps.put("pig", "猪");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务器启动了....");
        boolean isShow = true;
        // 设置第一次输出[服务器启动了....]，启动后不再显示。
        while (true) {
            try {
                Socket client = server.accept();
                String clientName = client.getInetAddress().getLocalHost().toString();
                if(isShow) {
                    System.out.println("客户端:"+clientName+"已连接到服务器");
                }
                isShow = false;
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                // key 客户端发送来的消息
                String key = br.readLine();
                // 服务器翻译后的结果
                String value = maps.get(key);
                if(null != key) {
                    if(null == value){
                        value = "default";
                        System.out.println("客户端输入的是:"+key+",服务端返回的是默认值：default");
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                        bw.write(value+"\n");
                        bw.flush();
                    } else {
                        System.out.println("客户端输入的是:"+key+",服务器翻译后是:"+value);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                        bw.write(value+"\n"); bw.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
