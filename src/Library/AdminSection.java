package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class AdminSection extends JFrame implements ActionListener{
    JLabel l1;
    JButton bt1;
    JPanel p1,p2;
    Font f,f1;

    AdminSection(){
        super("Admin Section");
        setLocation(0,0);
        setSize(1500,800);

        f=new Font("Segoe UI",Font.PLAIN,28);
        f1=new Font("Segoe UI",Font.PLAIN,23);

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Library/icon/admin.png"));
        l1=new JLabel(ic);

        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Add Info");
        JMenuItem ment1=new JMenuItem("Add Faculty");

        JMenu men2=new JMenu("View Info");
        JMenuItem ment2=new JMenuItem("View Faculty");

        JMenu men3=new JMenu("Delete Info");
        JMenuItem ment3=new JMenuItem("Delete Faculty");

        JMenu men4=new JMenu("Exit");
        JMenuItem ment4=new JMenuItem("Logout");

        men1.add(ment1);
        men2.add(ment2);
        men3.add(ment3);
        men4.add(ment4);

        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);

        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);

        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);

        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);

        setJMenuBar(m1);
        add(l1);
    }

    public void actionPerformed(ActionEvent e) {
        String comnd=e.getActionCommand();
        if(comnd.equals("Add Faculty")){
            
            new AddFaculty().setVisible(true);
        }
        else if(comnd.equals("View Faculty")){
            
            new ViewFaculty().setVisible(true);
        }
        else if(comnd.equals("Delete Faculty")){
            
            new DeleteFaculty().setVisible(true);
        }
        else if(comnd.equals("Logout")){
            System.exit(0);
            
        }
    }
    public static void main(String[] args) {
        new AdminSection().setVisible(true);
    }
}
