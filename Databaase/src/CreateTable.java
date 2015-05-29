import java.sql.*;
import java.util.Enumeration;
import java.util.Scanner;


public class CreateTable {
	//JDBC driver name and database URL
	static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/sample";
	//Database Credentilas
	static final String USER="Corso";
	static final String PASS="12345";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database....");
			//Enumeration drivers=DriverManager.getDrivers();
			//while(drivers.hasMoreElements()){
				//Driver driver=(Driver) (drivers.nextElement());
				//System.out.println(driver+" "+driver.acceptsURL(DB_URL)+" "+driver.getMinorVersion()+" "+driver.getMajorVersion()+" "+driver.jdbcCompliant());
		//}
			conn=DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("creating db...");
			stmt=conn.createStatement();
			Scanner in=new Scanner(System.in);
			//String sql="CREATE TABLE impiegato(PK integer,Cognome text, Nome text, Eta integer)";
			//stmt.executeUpdate(sql);
			//String sql1="INSERT impiegato(PK,Cognome,Nome,Eta)VALUES(1,'Zichittella','Fabio',31),(2,'Giliberto','Alessandro',24)";
			//stmt.executeUpdate(sql1);
			System.out.println("Inserisci Cognome e Età ");
			String sql2="SELECT Cognome,Nome,Eta FROM impiegato WHERE Cognome = ? AND Eta =?";
			PreparedStatement ps=conn.prepareStatement(sql2);
			ps.setString(1, in.nextLine());
			ps.setInt(1, in.nextInt());
			ResultSet resultset=ps.executeQuery();
			while(resultset.next()){
				String Cognome = resultset.getString("Cognome");
				String Nome = resultset.getString("Nome");
				int Eta= resultset.getInt("Eta");
				System.out.println("Cognome: "+Cognome+" "+"Nome: "+Nome+" "+"Età: "+Eta);
				in.close();
			}
			System.out.println("Database Aggiornato");
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			}
		System.out.println("Goodbye");
		}	
	}


