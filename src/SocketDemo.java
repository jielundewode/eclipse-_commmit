import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;


public class SocketDemo {

	/**
	   * 创建一个非阻塞的Socket通道。
	   * 
	   * @param hostName
	   *          主机
	   * @param port
	   *          端口
	   * @return Socket端口
	   * @throws IOException
	   */
	  public static SocketChannel createSocketChannel(String hostName, int port)
	      throws IOException {
	    SocketChannel sChannel = SocketChannel.open();
	    sChannel.configureBlocking(false);
	    sChannel.connect(new InetSocketAddress(hostName, port));
	    return sChannel;
	  }
	  public static void main(String[] args) {
	    try {
	      System.out.println("普通建立连接....");
	      Socket socket = new Socket("www.baidu.com", 80);
	      System.out.println(socket.isConnected());
	      // 创建链接
	      SocketChannel sChannel = createSocketChannel("www.baidu.com", 80);
	      // 可以通过判断是否连接，在链接成功建立前做一些其它的事情
	      while (!sChannel.finishConnect()) {
	        System.out.println("等待非阻塞连接建立....");
	        try {
	          Thread.sleep(10);
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
	      System.out.println(sChannel.isConnected());
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

}
