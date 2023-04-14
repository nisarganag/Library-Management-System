package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class AddConferences extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1,f2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    AddConferences(){
        super("Add Conferences");
        setLocation(0,0);
        setSize(650,400);

        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Helvetica",Font.BOLD,20);
        f2=new Font("Tahoma",Font.PLAIN,20);

        l1=new JLabel("Add Conferences");
        l2=new JLabel("Name");
        l3=new JLabel("Corresponding Author");
        l4=new JLabel("Co-authors");
        l5=new JLabel("Page Number");
        l6=new JLabel("Date");
        l7=new JLabel("Location");

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);

        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();

        bt1=new JButton("Add Conference");
        bt2=new JButton("Cancel");

        bt1.setFont(f2);
        bt2.setFont(f2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.DARK_GRAY);

        p2=new JPanel();
        p2.setLayout(new GridLayout(8,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(l7);
        p2.add(tf6);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

    }
    public void actionPerformed(ActionEvent e) {
        String name=tf1.getText();
        String corrAuth=tf2.getText();
        String coAuth=tf3.getText();
        String pgno=tf4.getText();
        String date=tf5.getText();
        String location=tf6.getText();

        if(e.getSource()==bt1){
            try {
                ConnectionClass obj=new ConnectionClass();
                String s="insert into conference(Name,CorrespondingAuthor,CoAuthor,PageNumber,Date,Location) values('"+name+"','"+corrAuth+"','"+coAuth+"','"+pgno+"','"+date+"','"+location+"')";
                int aa=obj.stm.executeUpdate(s);
                
                if(aa==1){
                    JOptionPane.showMessageDialog(null, "Your Data Successfully Inserted");
                    this.setVisible(false);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please fill all details carefully");
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
        new AddConferences().setVisible(true);
    }
}