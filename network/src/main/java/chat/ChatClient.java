package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			// 4. reader/writer 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			printWriter.println("join:" + nickname);

			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(socket, br).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input.toLowerCase()) == true) {
					// 8. quit 프로토콜 처리
					doQuit(nickname, printWriter);
					break;
				} else {
					// 9. 메시지 처리
					doMessage(input, printWriter);
				}
			}

		} catch (IOException ex) {
			log("Error:" + ex);
		} finally {
			// 10. 자원정리
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (IOException ex) {
				log("Error:" + ex);
			}
		}

	}

	private static void doQuit(String nickname, Writer writer) {
		String data = "quit:" + nickname;
		((PrintWriter) writer).println(data);
	}

	private static void doMessage(String message, Writer writer) {
		String data = "message:" + message;
		((PrintWriter) writer).println(data);
	}

	private static void log(String message) {
		System.out.println("[ChatClient#" + Thread.currentThread().getId() + "] " + message);
	}
}
