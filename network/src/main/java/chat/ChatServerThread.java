package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	Socket socket;
	static List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		ChatServerThread.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			// 1. Remote Host Information
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			log("Connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			// 2. 스트림 얻기
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			// 3. 요청 처리
			while (true) {
				String line = br.readLine();
				if (line == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(printWriter);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = line.split(":");

				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
				}

			}
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

	private void doMessage(String message) {
		String data = nickname + " : " + message;
		broadcast(data);
	}

	private void doJoin(String nickname, Writer writer) {
		this.nickname = nickname;

		String data = nickname + "님이 참여하였습니다.";
		broadcast(data);

		addWriter(writer);

		((PrintWriter) writer).println("입장하였습니다. 즐거운 채팅 되세요.");
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
			}
		}
	}

	public static void log(String message) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId() + "] " + message);
	}

}
