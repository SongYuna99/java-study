package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String SERVER_IP = "192.168.0.54";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Socket socket = null;
		try {
			// 1. 소켓 생성
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			// 4. 쓰기
			String data = "Hello World!";
			os.write(data.getBytes("UTF-8"));

			// 5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer); // blocking
			if (readByteCount == -1) {
				// 서버가 정상적으로 close() 호출
				System.out.println("[client] closed by server");
				return;
			}

			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[client] received : " + data);

		}
		// Exception
		catch (SocketException e) {
			System.out.println("[client] suddenly closed by server.");
		} catch (IOException e) {
			System.out.println("[client] Error : " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				System.out.println("[client] Error : " + e);
			}
		}

	}
}
