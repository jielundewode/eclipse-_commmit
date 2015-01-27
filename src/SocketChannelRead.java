import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * ��SocketChannel��ȡ���ݡ�
 * 
 * @author ��ѧ�죬Java������(java2000.net)
 * 
 */
public class SocketChannelRead {
	public static SocketChannel createSocketChannel(String hostName, int port)
			throws IOException {
		SocketChannel sChannel = SocketChannel.open();
		sChannel.configureBlocking(false);
		sChannel.connect(new InetSocketAddress(hostName, port));
		return sChannel;
	}

	public static void main(String[] args) {
		ByteBuffer buf = ByteBuffer.allocateDirect(1024);
		byte[] buff = new byte[1024];
		try {
			buf.clear();
			SocketChannel socketChannel = createSocketChannel("163.net", 25);
			while (!socketChannel.finishConnect()) {
				System.out.println("�ȴ����������ӽ���....");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int numBytesRead;
			while ((numBytesRead = socketChannel.read(buf)) != -1) {
				if (numBytesRead == 0) {
					// ���û�����ݣ�����΢�ȴ�һ��
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
				// ת���ʼ
				buf.flip();
				while (buf.remaining() > 0) {
					System.out.print((char) buf.get());
				}
				// Ҳ����ת��Ϊ�ַ�����������Ҫ���������������ˡ�
				// buf.get(buff, 0, numBytesRead);
				// System.out.println(new String(buff, 0, numBytesRead,
				// "UTF-8"));
				// ��λ�����
				buf.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}