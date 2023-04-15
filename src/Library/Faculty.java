package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class Faculty extends JFrame implements ActionListener,KeyListener{
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1,f2;
    JTextField tf1;
    JPasswordField pf1;
    
    Faculty(){
        super("Faculty Login Page");
        setLocation(500,350);
        setSize(500,200);

        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Helvetica",Font.BOLD,20);
        f2=new Font("Tahoma",Font.PLAIN,20);

        l1=new JLabel("Faculty Login");
        l2=new JLabel("Username");
        l3=new JLabel("Password");

        bt1=new JButton("Login");
        bt2=new JButton("Cancel");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        tf1=new JTextField();
        pf1=new JPasswordField();
        tf1.addKeyListener(this);
        pf1.addKeyListener(this);

        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        bt1.setFont(f2);
        bt2.setFont(f2);
        tf1.setFont(f1);
        pf1.setFont(f1);

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
        p2.add(pf1);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username=tf1.getText();
        char[] pass=pf1.getPassword();

        if(e.getSource()==bt1){
            try {
                ConnectionClass obj=new ConnectionClass();
                String pass1=new String(pass);
                String s="select username,password from faculty where username='"+username+"'and password='"+pass1+"'";
                ResultSet rest=obj.stm.executeQuery(s);
                if(rest.next()){
                    
                    new FacultySection().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your Username and Password is wrong");
                    this.setVisible(false);
                    this.setVisible(true);
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2){
            this.setVisible(false);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        String username=tf1.getText();
        char[] pass=pf1.getPassword();
        char key=e.getKeyChar();
        if(key==KeyEvent.VK_ENTER){
            try {
                ConnectionClass obj=new ConnectionClass();
                String pass1=new String(pass);
                String s="select username,password from faculty where username='"+username+"'and password='"+pass1+"'";
                ResultSet rest=obj.stm.executeQuery(s);
                if(rest.next()){
                    
                    new FacultySection().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your Username and Password is wrong");
                    this.setVisible(false);
                    this.setVisible(true);
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    public static void main(String[] args) {
        new Faculty().setVisible(true);
    }
}
