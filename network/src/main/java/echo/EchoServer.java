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

			while(true) {
				Socket socket = serverSocket.accept();
				
				new Thread().run();
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
