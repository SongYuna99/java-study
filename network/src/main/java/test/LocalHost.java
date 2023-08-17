package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostname = inetAddress.getHostName();
			String hostIpAddress = inetAddress.getHostAddress();

			System.out.println(hostname);
			System.out.println(hostIpAddress);

			byte[] IpAddress = inetAddress.getAddress();
			for (byte b : IpAddress) {
				System.out.print((b & 0x000000ff) + ".");

//				if (b < 0)
//					System.out.print((int) b + 256 + ".");
//				else
//					System.out.print((int) b + ".");
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
