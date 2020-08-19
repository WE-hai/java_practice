package 线程池版;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolServer {
    private void run() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println("服务器启动了....");
        while (true) {
            Socket client = server.accept();
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(this.getClass().toString());
                        execute(client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void execute(Socket client) throws IOException {
        String clientName = client.getInetAddress().getLocalHost().toString();
        System.out.println("客户端:" + clientName + "已连接到服务器");
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String key = null;
        // key 客户端发送来的消息
        String value = null;
        // 服务器翻译后的结果
        while (true) {
            try {
                key = br.readLine();
                value = maps.get(key);
                if (null != key) {
                    if (null == value) {
                        value = "default";
                        System.out.println("客户端输入的是:" + key + ",服务端返回的是默认值:" + value);
                    } else {
                        System.out.println("客户端输入的是:" + key + ",服务器翻译后是:" + value);
                    }
                    bw.write(value + "\n");
                    bw.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
        new ThreadPoolServer().run();
    }
}
