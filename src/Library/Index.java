package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
// import java.awt.geom.Ellipse2D;
public class Index extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JButton bt1,bt2;
    JPanel p1,p2,p3,p4,p5;
    Font f,f1,f2;
    Index(){
        super("Login Page");
        setLocation(500,350);
        setSize(500,235);
        // setUndecorated(true);
        // setResizable(true);
        
        // setShape(new Ellipse2D.Double(0, 0, 0, 0));
        


        f=new Font("Georgia",Font.BOLD,30);
        f1=new Font("Helvetica",Font.BOLD,25);
        f2=new Font("Tahoma",Font.PLAIN,20);

        l1=new JLabel("Admin Login");
        l2=new JLabel("Faculty login");
        l3=new JLabel("Publication Management");

        bt1=new JButton("Login");
        bt1.setPreferredSize(new Dimension(100, 50));
        bt2=new JButton("Login");
        bt2.setPreferredSize(new Dimension(100, 50));

        p4=new JPanel();
        p4.add(bt1);
        p4.setPreferredSize(new Dimension(100, 50));
        

        p5=new JPanel();
        p5.add(bt2);
        p5.setPreferredSize(new Dimension(100, 50));

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Library/icon/lock.png"));
        Image i=img.getImage().getScaledInstance(130, 120, Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i);
        l4=new JLabel(img2);

        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f);
        bt1.setFont(f2);
        bt2.setFont(f2);

        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setForeground(Color.WHITE);

        p1=new JPanel();
        p1.setLayout(new GridLayout(2,2,10,10));
        p1.add(l1);
        p1.add(p4);
        p1.add(l2);
        p1.add(p5);
        
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l4);

        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l3);
        p3.setBackground(Color.DARK_GRAY);

        setLayout(new BorderLayout(10,10));
        add(p3,"North");
        add(p2,"West");
        add(p1,"Center");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==bt1){
            
            new Admin().setVisible(true);
            this.setVisible(false);
       }
       if(e.getSource()==bt2){
        
        new Faculty().setVisible(true);
        this.setVisible(false);
       } 
    }
    public static void main(String[] args) {
        new Index().setVisible(true);
    }
    public class setVisiblity {
    }
}
