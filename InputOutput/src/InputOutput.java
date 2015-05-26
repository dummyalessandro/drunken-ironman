import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class InputOutput {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		Scanner in=new Scanner (System.in);
		BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt",true));
		writer.write("\n"+in.nextLine());
		writer.flush();
		BufferedReader reader = new BufferedReader(new FileReader("out.txt"));
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();

		}
		reader.close();
		writer.close();
		in.close();
	}

}