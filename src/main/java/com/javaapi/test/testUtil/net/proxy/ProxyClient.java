package com.javaapi.test.testUtil.net.proxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;


/**
 * http://blog.csdn.net/overmaker/article/details/4166399
 * @project apiTest
 * @author kk
 * @date 2014年8月15日
 */
public class ProxyClient {
    private static final String STRING = "E:\\response.txt";

    public static void main(String[] args) throws IOException {
            URL url = new URL(
                    "http://www.baidu.com/s?wd=ip&rsv_bp=0&ch=&tn=baidu&bar=&rsv_spt=3&ie=utf-8&rsv_enter=1&inputT=548");
            // 创建代理服务器            
            InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 8087);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http 代理            
            // 如果我们知道代理server的名字, 可以直接使用          
            URLConnection conn = url.openConnection(proxy);
            InputStream in = conn.getInputStream();
            StringBuilder sb = new StringBuilder();

            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
        System.out.println("done==>" + STRING);

            OutputStream is = null;
            Writer w = null;
            BufferedWriter bw = null;
            try {
                is = new FileOutputStream(new File(STRING));
                w = new OutputStreamWriter(is);
                bw = new BufferedWriter(w);
            bw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
