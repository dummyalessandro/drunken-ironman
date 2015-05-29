import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.InetAddress;

public class Connessione implements Runnable {

	Socket s;

	public Connessione(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String letto = (String)ois.readObject();
			while (true) {
				if ((!letto.isEmpty())) {
					if (letto.equals("exit")) {
						break;
					}
					System.out.println("Echo --> "+" "+ letto);
				}
				Thread.currentThread().sleep(1000);
				letto = (String) ois.readObject();
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connessione chiusa");
		}
	}
}
