package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatWindow {
	public final static String SERVER_IP = "127.0.0.1";
	public final static int PORT = 9999;

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private String name;
	Socket socket;

	PrintWriter printWriter;
	BufferedReader br;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		this.name = name;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Textfield
		textField.setColumns(40);

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));

			// IOStream 받아오기
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			printWriter.println("join:" + name);

			new ChatClientThread(socket, br).start();

			// ChatClientThread 생성하고 실행
		} catch (Exception e) {
			System.out.println("[Client] Error : " + e);
		}

	}

	private void finish() {
		// quit 프로토콜 구현y
		// exit java(JVM)
		printWriter.println("quit:" + name);
		System.exit(0);
	}

	private void sendMessage() {
		String message = textField.getText();

		if (!message.isBlank()) {
			String data = "message:" + name + ":" + message;
			printWriter.println(data);
			textField.setText("");
		}
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");

	}

	private void setLeader(String name) {
		this.name += name;
		printWriter.println("leader:" + this.name);
	}

	private class ChatClientThread extends Thread {
		Socket socket;
		BufferedReader br;

		public ChatClientThread(Socket socket, BufferedReader br) {
			this.socket = socket;
			this.br = br;
		}

		@Override
		public void run() {
			try {
				while (true) {
					String line = br.readLine();
					if (!line.isBlank()) {
						if (line.startsWith("leader:")) {
							setLeader("(방장)");
						} else {
							updateTextArea(line);
						}
					}

				}
			} catch (Exception e) {
				System.out.println("[Client_Thread] Error : " + e);
			}
		}

	}
}
