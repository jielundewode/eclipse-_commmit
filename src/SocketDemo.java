import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;


public class SocketDemo {

	/**
	   * ����һ����������Socketͨ����
	   * 
	   * @param hostName
	   *          ����
	   * @param port
	   *          �˿�
	   * @return Socket�˿�
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
	      System.out.println("��ͨ��������....");
	      Socket socket = new Socket("www.baidu.com", 80);
	      System.out.println(socket.isConnected());
	      // ��������
	      SocketChannel sChannel = createSocketChannel("www.baidu.com", 80);
	      // ����ͨ���ж��Ƿ����ӣ������ӳɹ�����ǰ��һЩ����������
	      while (!sChannel.finishConnect()) {
	        System.out.println("�ȴ����������ӽ���....");
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
