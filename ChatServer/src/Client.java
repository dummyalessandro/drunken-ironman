

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	

	public void simulaClient() {
		Scanner sc = new Scanner(System.in); 
		try {
			Socket s = new Socket("192.168.1.138", 49000);
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			while (true) {
				System.out.println("Messaggio da inviare -->"+" "+InetAddress.getLocalHost());
				String messaggio = sc.nextLine();
				oos.writeObject(messaggio);
				if (messaggio.equals("exit")) {
					break;
				}s.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

 public static void main(String[] args) {
  new Client().simulaClient();
 }

}




