package chat.gui;

import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatClientApp {
	public final static String SERVER_IP = "127.0.0.1";
	public final static int PORT = 9999;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">> ");
			name = scanner.nextLine();

			if (name.isEmpty() == false) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		scanner.close();

		ServerSocket serverSocket = null;
		List<Writer> listWriters;

		try {
			// 1. create socket
			serverSocket = new ServerSocket();

			// 2. connect server
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));
			System.out.println("[SERVER] 연결 대기중 : " + PORT);
			listWriters = new ArrayList<Writer>();

			while (true) {
				Socket socket = serverSocket.accept();

				new ChatServerThread(socket, listWriters, name).start();
			}
			// 3. join protocol 진행
		} catch (Exception e) {
			System.out.println("[SERVER] ERROR : " + e);
		}

		String line = "JOIN:OK";
		if ("JOIN:OK".equals(line)) {
			new ChatWindow(name).show();
		}
	}

}
