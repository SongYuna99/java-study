package chat;

import java.io.BufferedReader;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	Socket socket;

	public ChatClientThread(Socket socket, BufferedReader br) {
		this.socket = socket;
		this.br = br;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String data = br.readLine();
				System.out.println(data);
			}
		} catch (Exception e) {
			log("error:" + e);
		}
	}

	public static void log(String message) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId() + "] " + message);
	}

}
