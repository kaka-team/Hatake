package boot.spring.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-05-30 11:13
 **/
public class WriteClient {
    public static void main(String[] args) {
        ByteBuffer writebuffer = ByteBuffer.allocate(1024);
        ByteBuffer readbuffer = ByteBuffer.allocate(1024);

        SocketChannel socketChannel = null;
        Selector selector = null;
        try{
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("192.168.24.53",8080));
            if(socketChannel.finishConnect()) {
                int i=0;
                while(true)
                {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm "+i+++"-th information from client";
                    writebuffer.clear();
                    readbuffer.clear();
                    writebuffer.put(info.getBytes());
                    while(writebuffer.hasRemaining()){
                        writebuffer.flip();
                        socketChannel.write(writebuffer);
                    }
                }
            }
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }finally{
            try{
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
