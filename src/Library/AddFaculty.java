package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.regex.*;
public class AddFaculty extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3;
    JPasswordField pf1;
    Font f,f1,f2;

    AddFaculty(){
        super("Add Faculty");
        setLocation(450,400);
        setSize(650,400);

        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Helvetica",Font.BOLD,20);
        f2=new Font("Tahoma",Font.PLAIN,20);

        l1=new JLabel("Add Faculty");
        l2=new JLabel("Username");
        l3=new JLabel("Password");
        l4=new JLabel("Email");
        l5=new JLabel("Contact");

        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.CENTER);

        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();

        pf1=new JPasswordField();

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);

        pf1.setFont(f1);

        bt1=new JButton("Add Faculty");
        bt2=new JButton("Cancel");

        bt1.setFont(f2);
        bt2.setFont(f2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.DARK_GRAY);

        p2=new JPanel();
        p2.setLayout(new GridLayout(5,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(pf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e) {
        Pattern p1=Pattern.compile("^[a-z][a-z0-9]{5,20}$");
        String username=tf1.getText();
        Matcher m1=p1.matcher(username);
        if(!m1.matches()){
            JOptionPane.showMessageDialog(null, "Username must be 6-20 characters long and start with a letter");
            return;
        }
        Pattern p2=Pattern.compile(".{6,15}");
        char[] pass=pf1.getPassword();
        Matcher m2=p2.matcher(new String(pass));
        if(!m2.matches()){
            JOptionPane.showMessageDialog(null, "Password must be 6-15 characters long");
            return;
        }
        Pattern p3=Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9.]+@[a-zA-Z]+\\.[a-zA-Z]+$");
        String email=tf2.getText();
        Matcher m3=p3.matcher(email);
        if(!m3.matches()){
            JOptionPane.showMessageDialog(null, "Invalid Email");
            return;
        }
        Pattern p4=Pattern.compile("^[1-9][0-9]{9}$");
        String contact=tf3.getText();
        Matcher m4=p4.matcher(contact);
        if(!m4.matches()){
            JOptionPane.showMessageDialog(null, "Invalid Contact");
            return;
        }

        if(e.getSource()==bt1){
            try {
                ConnectionClass obj=new ConnectionClass();
                String pass1=new String(pass);
                String s="insert into faculty(username,password,email,contact) values('"+username+"','"+pass1+"','"+email+"','"+contact+"')";
                int aa=obj.stm.executeUpdate(s);
                
                if(aa==1){
                    JOptionPane.showMessageDialog(null, "Your Data Successfully Inserted");
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please fill all details Carefully");
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
    public static void main(String[] args) {
        new AddFaculty().setVisible(true);
    }
}
