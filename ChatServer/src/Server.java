import java.io.IOException;
import java.net.*;

public class Server implements Runnable {

	ServerSocket ss;
	Socket s;

	public Server() {
		try {
			ss = new ServerSocket(49001);
			//ss.setSoTimeout(1000);
			new Thread(this).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Server in attesa");
				s = ss.accept();
				new Thread(new Connessione(s)).start();
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println();
			System.out.println("Server chiuso");
		}
	}

	public static void main(String[] args) {
		new Server();
	}
}

