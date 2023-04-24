package Library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
public class ConnectionClass {
    Connection con;
    Statement stm;
    Encryption enc=new Encryption();
    ConnectionClass(){
      
        try {
            File file = new File("username.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String user=br.readLine();
            String decryptedUsername=enc.decrypt(user);
            File file2 = new File("password.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            String pass=br2.readLine();
            String decryptedPassword=enc.decrypt(pass);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library",decryptedUsername,decryptedPassword);
            stm=con.createStatement();
            br.close();
            br2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    } 
  public static void main(String[] args) {
    new ConnectionClass();
  } 
}

