import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class MySocket {

	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile(new File("D:/test.txt"),"r") ;
		FileChannel in = file.getChannel() ;
		
		ByteBuffer buffer = ByteBuffer.allocate(1024) ;
		int byteRead = in.read(buffer) ;
		
		while(byteRead != -1) {
			System.out.println("read" + byteRead);
			buffer.flip() ;
			
			while(buffer.hasRemaining()) {
				System.out.println((char) buffer.getChar());
			}
			
			buffer.clear() ;
			byteRead = in.read(buffer) ;
		}
		file.close();
		
	}

}
