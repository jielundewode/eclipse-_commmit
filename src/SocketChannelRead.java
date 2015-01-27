import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 从SocketChannel读取数据。
 * 
 * @author 赵学庆，Java世纪网(java2000.net)
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
				System.out.println("等待非阻塞连接建立....");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int numBytesRead;
			while ((numBytesRead = socketChannel.read(buf)) != -1) {
				if (numBytesRead == 0) {
					// 如果没有数据，则稍微等待一下
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
				// 转到最开始
				buf.flip();
				while (buf.remaining() > 0) {
					System.out.print((char) buf.get());
				}
				// 也可以转化为字符串，不过需要借助第三个变量了。
				// buf.get(buff, 0, numBytesRead);
				// System.out.println(new String(buff, 0, numBytesRead,
				// "UTF-8"));
				// 复位，清空
				buf.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}