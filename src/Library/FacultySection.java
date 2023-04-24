package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class FacultySection extends JFrame implements ActionListener{
    JLabel l1;
    JButton bt1;
    JPanel p1,p2;
    Font f,f1;
    FacultySection(){
        super("Faculty Section");
        setLocation(0,0);
        setSize(1500,800);

        
        f=new Font("Segoe UI",Font.PLAIN,28);
        f1=new Font("Segoe UI",Font.PLAIN,23);

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Library/icon/library.png"));
        Image img=ic.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);

        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Add Info");
        JMenuItem ment1=new JMenuItem("Add Publications");

        JMenu men3=new JMenu("Find Info");
        JMenuItem ment3=new JMenuItem("Find Publications");

        JMenu men4=new JMenu("Exit");
        JMenuItem ment4=new JMenuItem("Logout");

        men1.add(ment1);
        men3.add(ment3);
        men4.add(ment4);

        m1.add(men1);
        m1.add(men3);
        m1.add(men4);

        men1.setFont(f);
        men3.setFont(f);
        men4.setFont(f);

        ment1.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);

        ment1.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);

        setJMenuBar(m1);
        add(l1);

    }
    public void actionPerformed(ActionEvent e) {
        String comnd=e.getActionCommand();
        if(comnd.equals("Add Publications")){
            
            new PublicationType().setVisible(true);
        }
        else if(comnd.equals("Find Publications")){
            
            new FindPublicationType().setVisible(true);
        }
        else if(comnd.equals("Logout")){
            System.exit(0);
            
        }
    }
    public static void main(String[] args) {
        new FacultySection().setVisible(true);
    }
}
