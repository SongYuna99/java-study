package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 9000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);

			log("starts... [port : " + PORT + "]");

			Socket socket = serverSocket.accept();

			try {
				InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
				int remotePort = remoteInetSocketAddress.getPort();

				log("connected by client[" + remoteHostAddress + " : " + remotePort + "]");

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
		// Exception
		catch (IOException e) {
			log("Error : " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				log("Error : " + e);
			}
		}
	}

	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}

}
