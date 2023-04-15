package Library;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FindOthers extends JFrame implements ActionListener{
    String x[]={"Name","CorrespondingAuthor","CoAuthorInternal","CoAuthorExternal","PageNumber","VolumeNumber","IssueNumber","ChapterNumber","ISBNNumber","Location","Publisher","Date"};
    JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12;
    String y[][]=new String[20][13];
    int i=0,j=0;
    JTable t;
    Font f,f1,f2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13;
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;  

    FindOthers(){
        super("Find Other Publication");
        setLocation(1,1);
        setSize(1400,950);

        f=new Font("Arial",Font.BOLD,15);
        f1=new Font("Helvetica",Font.BOLD,17);
        f2=new Font("Tahoma",Font.PLAIN,20);
        
            t=new JTable(y,x);
            t.setFont(f);
        
        JScrollPane sp=new JScrollPane(t);

        l1=new JLabel("View Publication by Name");
        tf1=new JTextField();
        bt1=new JButton("Find");
        bt1.addActionListener(this);

        l2=new JLabel("View Publication by Corresponding Author");
        tf2=new JTextField();
        bt2=new JButton("Find");
        bt2.addActionListener(this);

        l3=new JLabel("View Publication by Co-Author Internal");
        tf3=new JTextField();
        bt3=new JButton("Find");
        bt3.addActionListener(this);

        l4=new JLabel("View Publication by Co-Author External");
        tf4=new JTextField();
        bt4=new JButton("Find");
        bt4.addActionListener(this);

        l5=new JLabel("View Publication by Page Number");
        tf5=new JTextField();
        bt5=new JButton("Find");
        bt5.addActionListener(this);

        l9=new JLabel("View Publication by Volume Number");
        tf10=new JTextField();
        bt9=new JButton("Find");
        bt9.addActionListener(this);
        
        l10=new JLabel("View Publication by Issue Number");
        tf11=new JTextField();
        bt10=new JButton("Find");
        bt10.addActionListener(this);

        l7=new JLabel("View Publication by Chapter Number");
        tf8=new JTextField();
        bt7=new JButton("Find");
        bt7.addActionListener(this);
        
        l8=new JLabel("View Publication by ISBN Number");
        tf9=new JTextField();
        bt8=new JButton("Find");
        bt8.addActionListener(this);
        
        l11=new JLabel("View Publication by Location");
        tf12=new JTextField();
        bt11=new JButton("Find");
        bt11.addActionListener(this);
        
        l12=new JLabel("View Publication by Publisher");
        tf13=new JTextField();
        bt12=new JButton("Find");
        bt12.addActionListener(this);

        l6=new JLabel("View Publication by Date");
        tf6=new JTextField();
        tf7=new JTextField();
        bt6=new JButton("Find");
        bt6.addActionListener(this);


        l1.setFont(f1);
        tf1.setFont(f1);
        bt1.setFont(f2);
        l2.setFont(f1);
        tf2.setFont(f1);
        bt2.setFont(f2);
        l3.setFont(f1);
        tf3.setFont(f1);
        bt3.setFont(f2);
        l4.setFont(f1);
        tf4.setFont(f1);
        bt4.setFont(f2);
        l5.setFont(f1);
        tf5.setFont(f1);
        bt5.setFont(f2);
        l9.setFont(f1);
        tf10.setFont(f1);
        bt9.setFont(f2);
        l10.setFont(f1);
        tf11.setFont(f1);
        bt10.setFont(f2);
        l6.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        bt6.setFont(f2);
        l7.setFont(f1);
        tf8.setFont(f1);
        bt7.setFont(f2);
        l8.setFont(f1);
        tf9.setFont(f1);
        bt8.setFont(f2);
        l9.setFont(f1);
        tf10.setFont(f1);
        bt9.setFont(f2);
        l10.setFont(f1);
        tf11.setFont(f1);
        bt10.setFont(f2);
        l11.setFont(f1);
        tf12.setFont(f1);
        bt11.setFont(f2);
        l12.setFont(f1);
        tf13.setFont(f1);
        bt12.setFont(f2);

        p1=new JPanel();
        p1.setLayout(new GridLayout(11,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt1);
        p1.add(l2);
        p1.add(tf2);
        p1.add(bt2);
        p1.add(l3);
        p1.add(tf3);
        p1.add(bt3);
        p1.add(l4);
        p1.add(tf4);
        p1.add(bt4);
        p1.add(l5);
        p1.add(tf5);
        p1.add(bt5);
        p1.add(l9);
        p1.add(tf10);
        p1.add(bt9);
        p1.add(l10);
        p1.add(tf11);
        p1.add(bt10);
        p1.add(l7);
        p1.add(tf8);
        p1.add(bt7);
        p1.add(l8);
        p1.add(tf9);
        p1.add(bt8);
        p1.add(l11);
        p1.add(tf12);
        p1.add(bt11);
        p1.add(l12);
        p1.add(tf13);
        p1.add(bt12);
        

        p2=new JPanel();
        p2.setLayout(new GridLayout(1,4,10,10));
        p2.add(l6);
        p2.add(tf6);
        p2.add(tf7);
        p2.add(bt6);

        setLayout(new BorderLayout(10,10));
        add(sp,"North");
        add(p1,"Center");
        add(p2,"South");
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String name=tf1.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where Name='"+name+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;
                

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt2){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String corrAuth=tf2.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where CorrespondingAuthor='"+corrAuth+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt3){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String coAuthIn=tf3.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="SELECT * FROM other WHERE CoAuthorInternal LIKE '%" + coAuthIn + "%'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt4){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String coAuthEx=tf4.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where CoAuthorExternal='"+coAuthEx+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt5){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String pgno=tf5.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where PageNumber='"+pgno+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt9){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String volno=tf10.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where VolumeNumber='"+volno+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt10){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String issno=tf11.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where IssueNumber='"+issno+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt7){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String chapno=tf8.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where ChapterNumber='"+chapno+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt8){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String isbnno=tf9.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where ISBNNumber='"+isbnno+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt11){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String loc=tf12.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where Location='"+loc+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt12){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String pub=tf13.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where Publisher='"+pub+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        else if(e.getSource()==bt6){
            for (int k = 0; k < y.length; k++) {
                for (int l = 0; l < y[k].length; l++) {
                    y[k][l]=null;
                }
            }
            int i=0,j=0;
            String date1=tf6.getText();
            String date2=tf7.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from other where Date between '"+date1+"' and '"+date2+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Name");
                y[i][j++]=rest.getString("CorrespondingAuthor");
                y[i][j++]=rest.getString("CoAuthorInternal");
                y[i][j++]=rest.getString("CoAuthorExternal");
                y[i][j++]=rest.getString("PageNumber");
                y[i][j++]=rest.getString("VolumeNumber");
                y[i][j++]=rest.getString("IssueNumber");
                y[i][j++]=rest.getString("ChapterNumber");
                y[i][j++]=rest.getString("ISBNNumber");
                y[i][j++]=rest.getString("Location");
                y[i][j++]=rest.getString("Publisher");
                y[i][j++]=rest.getString("Date");
                i++;
                j=0;

            }
            t=new JTable(y,x);
            t.setFont(f);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            JScrollPane sp=new JScrollPane(t);
            add(sp,"North");
            revalidate();
        }
        
    }
    public static void main(String[] args) {
        new FindOthers().setVisible(true);
    }
}
