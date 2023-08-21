package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 9999;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters;

		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림 " + hostAddress + ":" + PORT);
			listWriters = new ArrayList<Writer>();

			// 3. 요청 대기
			while (true) {
				Socket socket = serverSocket.accept();

				// 4. 요청 위임
				new ChatServerThread(socket, listWriters).start();

			}
		} catch (Exception e) {
			log("Error : " + e);
		} finally {
			// 5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				log("Error:" + ex);
			}
		}
	}

	public static void log(String message) {
		System.out.println("[ChatServer#" + Thread.currentThread().getId() + "] " + message);
	}

}
