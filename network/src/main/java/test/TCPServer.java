package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		try {
			// 1. Server Socket 생성
			ServerSocket serverSocket = new ServerSocket();

			// 2. 주소 바인딩(Binding)
			// Socket에 InetSocketAddress(IPAddress + port)를 바인딩 한다.
			// IPAddress : 0.0.0.0을 쓰는 이유는 특정 호스트 IP에 바인딩 하지 않기 때문
			// -> 어디에서는 유동적으로 사용 가능
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);

			// 3. Accept
			Socket socket = serverSocket.accept(); // blocking
		} catch (IOException e) {
			System.out.println("[server] Error : " + e);
		}
	}
}
