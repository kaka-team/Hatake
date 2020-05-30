package boot.spring.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-05-30 11:13
 **/
@SuppressWarnings("all")
public class ReadClient {
        //客户端信道选择器,轮询读取服务端返回数据
        private Selector selector;
        //连接信道
        private SocketChannel sc;
        public ReadClient(){
            try {
                this.sc=SocketChannel.open();//打开信道
                sc.connect(new InetSocketAddress("192.168.24.53",8080));////连接服务端
                sc.configureBlocking(false);//设置非阻塞
                selector = Selector.open();//必须打开
                //将当前客户端注册到多路复用器上,并设置为可读状态
                sc.register(this.selector, SelectionKey.OP_READ);
                //开启线程,一直轮询
                new Thread(()->{
                    while(true){//一直循环
                        try {
                            this.selector.select();//多路复用器开始监听
                            //获取已经注册在多了复用器上的key通道集
                            Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                            //遍历
                            while (keys.hasNext()) {
                                SelectionKey key = keys.next();//获取key
                                //如果是有效的
                                if(key.isValid()){
                                    // 如果为可读状态,读取服务端返回的数据
                                    if(key.isReadable()){
                                        this.read(key);
                                    }
                                }
                                //从容器中移除处理过的key
                                keys.remove();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //客户端获取服务端返回的数据
        private void read(SelectionKey key) {
            try {
                //建立写缓冲区
                ByteBuffer readBuf = ByteBuffer.allocate(1024);
                //2 获取之前注册的socket通道对象
                SocketChannel sc = (SocketChannel) key.channel();
                //3 读取数据
                int count = sc.read(readBuf);
                //4 如果没有数据
                if(count == -1){
                    key.channel().close();
                    key.cancel();
                    return;
                }
                //5 有数据则进行读取 读取之前需要进行复位方法(把position 和limit进行复位)
                readBuf.flip();
                //6 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
                byte[] bytes = new byte[readBuf.remaining()];
                //7 接收缓冲区数据
                readBuf.get(bytes);
                //8 打印结果
                String body = new String(bytes).trim();
                System.out.println("客户端已接受到服务端返回的数据: " + body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            //建立写缓冲区
            ByteBuffer writebuf = ByteBuffer.allocate(1024);
            ReadClient client = new ReadClient();
            try {
                while(true){
                    //定义一个字节数组，然后使用系统录入功能：
                    byte[] bytes = new byte[1024];
                    System.in.read(bytes);
                    //把数据放到缓冲区中
                    writebuf.put(bytes);
                    //对缓冲区进行复位
                    writebuf.flip();
                    //写出数据到服务端
                    client.sc.write(writebuf);
                    //清空缓冲区数据
                    writebuf.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(client.sc != null){
                    try {
                        client.sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
