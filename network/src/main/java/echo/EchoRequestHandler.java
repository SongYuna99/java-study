package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	Socket socket;

	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();

		log("connected by client[" + remoteHostAddress + " : " + remotePort + "]");

		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			while (true) {
				String data = br.readLine();

				if (data == null) {
					log("closed by client.");
					break;
				}

				log("received : " + data);

				pw.println(data);
			}

		}
		// Exception
		catch (SocketException e) {
			log("suddenly closed by client");
		} catch (IOException e) {
			log("Error : " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				log("Error : " + e);
			}
		}
	}

	private void log(String message) {
		System.out.println("[EchoServer#" + getId() + "] " + message);
	}

}
