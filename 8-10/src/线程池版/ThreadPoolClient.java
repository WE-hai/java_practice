package 线程池版;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ThreadPoolClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",9999);
            //构建IO
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            Scanner scanner = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String key = null;
            // 输入的单词
            String value = null;
            // 单词的翻译结果
            while (true){
                System.out.println("请输入数据");
                if(scanner.hasNext()) {
                    key = scanner.nextLine();
                    //向服务器端发送一条消息
                    bw.write(key+"\n");
                    bw.flush();
                    //读取服务器返回的消息
                    value = br.readLine();
                    System.out.println("客户端输入的是:"+key+",服务器翻译后是："+value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
