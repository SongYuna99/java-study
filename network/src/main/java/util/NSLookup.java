package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			while (true) {
				System.out.print(">> ");
				String line = scanner.nextLine();

				if ("quit".equals(line)) {
					break;
				}

				InetAddress[] inetAddress = InetAddress.getAllByName(line);

				for (InetAddress inet : inetAddress) {
					System.out.println(line + " : " + inet.getHostAddress());
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
