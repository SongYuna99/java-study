package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");

			if (!file.exists()) {
				System.out.println("File Not Found.");
				return;
			}

			System.out.println("--------- 파일 정보 ---------");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println("last update : "
					+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(file.lastModified())));

//			Long timestamp = file.lastModified();
//			Date d = new Date(timestamp);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
////			String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(file.lastModified()));
//			String date = sdf.format(d);
//			System.out.println("last update : " + date);

			System.out.println("--------- 전화번호 ---------");
			// 1. 기반 스트림 (FileInputStream)
			FileInputStream fis = new FileInputStream(file);

			// 2. 보조 스트림 (byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

			// 3. 보조 스트림2 (char1|char2|char3|\n -> "char1char2char3")
			br = new BufferedReader(isr);

			// 4. 처리
			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");

				int index = 0;
				while (st.hasMoreTokens()) {
					String token = st.nextToken();

					// 이름
					if (index == 0) {
						System.out.print(token + " : ");
					} else if (index == 1) {
						System.out.print(token + "-");
					} else if (index == 2) {
						System.out.print(token + "-");
					} else {
						System.out.print(token + "\n");
					}
					index++;
				}
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error : " + e);
		} catch (IOException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				System.out.println("Error : " + e);
			}
		}

	}

}
