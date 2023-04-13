package Library;
import java.io.*;
import java.net.*;
import java.util.*;
  
// Client class
class Client {
    
    // driver code
    public static void main(String[] args)
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 5000)) {
            
            // writing to server
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
  
            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;
  
            while (!"Over".equalsIgnoreCase(line)) {
                
                // reading from user
				System.out.print("Enter Your Command: ");
                line = sc.nextLine();
  
                // sending the user input to server
                out.println(line);
                out.flush();
            }
            
            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}