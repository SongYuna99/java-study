package chat.gui;

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
	Socket socket;
	List<Writer> listWriters;
	String name;

	public ChatServerThread(Socket socket, List<Writer> listWriters, String name) {
		this.socket = socket;
		this.listWriters = listWriters;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			System.out.println("[SERVER_THREAD] Connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			while (true) {
				String line = br.readLine();
				if (line == null) {
					System.out.println("[SERVER_THREAD] 클라이언트로부터 연결 끊김");
					break;
				}

				String[] tokens = line.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(printWriter);
				} else if ("talk".equals(tokens[0])) {
					doTalk(tokens[1], tokens[2], tokens[3], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					System.out.println("[SERVER_THREAD] 알수없는 요청(" + name + ")");
				}
			}

		} catch (Exception e) {
			System.out.println("[SERVER_THREAD] ERROR : " + e);
		}
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = name + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			if (listWriters.indexOf(writer) == 0) {
				delegateManager(listWriters.get(1));
			}

			listWriters.remove(writer);
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

	private void delegateManager(Writer writer) {
		PrintWriter printWriter = (PrintWriter) writer;
		printWriter.println("name:" + name + "(방장)");
		broadcast(name + "님이 방장이 되었습니다.");
	}

	private void doMessage(String message) {
		String data = name + " : " + message;
		broadcast(data);
	}

	private void doTalk(String receiver, String sender, String message, Writer writer) {
		String data = null;

		if (name.equals(receiver)) {
			data = sender + "님의 귓속말 : " + message;
		} else if (name.equals(sender)) {
			data = receiver + "님에게 귓속말 : " + message;
		}

		if (!data.isBlank()) {
			PrintWriter printWriter = (PrintWriter) writer;
			printWriter.println(data);
		}
	}

	private void doJoin(Writer writer) {
		broadcast(name + "님이 참여하였습니다.");

		addWriter(writer);

		PrintWriter printWriter = (PrintWriter) writer;
		printWriter.print("name:" + name);
		printWriter.println("broadcast:입장하였습니다. 즐거운 채팅되세요.");
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			if (listWriters.size() == 0) {
				listWriters.add(writer);
				delegateManager(writer);
			}
		}
	}
}
