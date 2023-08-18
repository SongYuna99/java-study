package httpd;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private static final int PORT = 8088;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			// 1. Create Server Socket
			serverSocket = new ServerSocket();

			// 2. Bind
//			String localhost = InetAddress.getLocalHost().getHostAddress();	// IP가 여러개 나올수 있어 사용하지 않는게 좋음
			String localhost = "0.0.0.0";
			serverSocket.bind(new InetSocketAddress(localhost, PORT));
			log("bind " + localhost + ":" + PORT);

			while (true) {
				// 3. Wait for connecting ( accept )
				Socket socket = serverSocket.accept();

				// 4. Delegate(위임한다) Processing Request
				new RequestHandler(socket).start();
			}

		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			// 5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				log("error:" + ex);
			}
		}
	}

	public static void log(String message) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId() + "] " + message);
	}
}
