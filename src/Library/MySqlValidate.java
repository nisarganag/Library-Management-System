package Library;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.awt.*;
import javax.swing.*;

public class MySqlValidate extends JFrame implements ActionListener,KeyListener{
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1,f2;
    JTextField tf1,tf2;
    

    MySqlValidate(){
        super("MYSQL Login");
        setLocation(500,350);
        setSize(500,200);

        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Helvetica",Font.BOLD,20);
        f2=new Font("Tahoma",Font.PLAIN,20);

        l1=new JLabel("MYSQL Login");
        l2=new JLabel("Username");
        l3=new JLabel("Password");

        bt1=new JButton("Login");
        bt2=new JButton("Cancel");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        tf1=new JTextField();
        tf2=new JTextField();
        tf1.addKeyListener(this);
        tf2.addKeyListener(this);

        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        bt1.setFont(f2);
        bt2.setFont(f2);
        tf1.setFont(f1);
        tf2.setFont(f1);

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.DARK_GRAY);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = tf1.getText();
        String password = tf2.getText();
        try {
            
            File file = new File("username.txt");
            file.createNewFile();
            File file2 = new File("password.txt");
            file2.createNewFile();
            // Write data to the file
            FileWriter writer = new FileWriter(file);
            writer.write("toor"+username+"toor");
            FileWriter writer2 = new FileWriter(file2);
            writer2.write("ssap"+password+"ssap");
            writer.flush();
            writer.close();
            writer2.flush();
            writer2.close();
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if(e.getSource()==bt1&&!tf1.getText().equals("")&&!tf2.getText().equals("")){
            new Index().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==bt2){
            this.setVisible(false);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        String username = tf1.getText();
        String password = tf2.getText();
        try {
            
            File file = new File("username.txt");
            file.createNewFile();
            File file2 = new File("password.txt");
            file2.createNewFile();
            // Write data to the file
            FileWriter writer = new FileWriter(file);
            writer.write(username);
            FileWriter writer2 = new FileWriter(file2);
            writer2.write(password);
            writer.flush();
            writer.close();
            writer2.flush();
            writer2.close();
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        char key=e.getKeyChar();
        if(key==KeyEvent.VK_ENTER){
            new Index().setVisible(true);
            this.setVisible(false);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    public static void main(String[] args) {
        new MySqlValidate().setVisible(true);
    }
}
