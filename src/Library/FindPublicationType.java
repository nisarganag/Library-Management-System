package Library;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class FindPublicationType extends JFrame implements ActionListener{
    JLabel l1,l2;
    
    JPanel p1,p2,p3;
    Font f,f1,f2;
    
    String s1[]={"Conferences","Journals","Book Chapters","Books","Others"};
    JComboBox<String> cb1 = new JComboBox<>(s1);
    
    
    FindPublicationType(){
        super("Find Publication");
        setLocation(500,350);
        setSize(450,175);

        f=new Font("Helvetica",Font.BOLD,25);
        f1=new Font("Helvetica",Font.BOLD,22);
        f2=new Font("Tahoma",Font.PLAIN,18);

        l1=new JLabel("Find Publication");
        l2=new JLabel("Publication Type");

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);
        l2.setHorizontalAlignment(JLabel.CENTER);
        // cb1.setBounds(MAXIMIZED_BOTH, ABORT, 100, 50);
        cb1.setPreferredSize(new Dimension(125, 70));
        


        
        l1.setFont(f);
        l2.setFont(f1);
        cb1.setFont(f2);

        p3=new JPanel();
        p3.add(cb1);
        p3.setPreferredSize(new Dimension(125,70));

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.DARK_GRAY);

        p2=new JPanel();
        p2.setLayout(new GridLayout(1,1,20,20));
        p2.add(l2);
        p2.add(p3);
        

        

        setLayout(new BorderLayout(10,10));
        cb1.setSize(200, 50);
        add(p1,"North");
        add(p2,"Center");
        // add(p3,"Center");
        cb1.setSelectedIndex(-1);
        cb1.addActionListener(this);
        

    }
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==cb1){
              String s=(String)cb1.getSelectedItem();
              if(s.equals("Conferences")){
                new FindConferences().setVisible(true);
                this.dispose();
              }
              else if(s.equals("Journals")){
                new FindJournals().setVisible(true);
                this.dispose();
              }
              else if(s.equals("Book Chapters")){
                new FindBookChapters().setVisible(true);
                this.dispose();
              }
              else if(s.equals("Books")){
                new FindBooks().setVisible(true);
                this.dispose();
              }
              else if(s.equals("Others")){
                // new FindOthers().setVisible(true);
                this.dispose();
              }
       }
    }
    public static void main(String[] args) {
        new FindPublicationType().setVisible(true);
    }
}
