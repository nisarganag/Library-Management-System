package Library;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FindPublication extends JFrame implements ActionListener{
    String x[]={"pid","PublicationNumber","PublicationName","Author","PublicationType","Collaborators","PublicationDate"};
    JButton bt1,bt2,bt3,bt4,bt5,bt6;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6;  

    FindPublication(){
        super("Find Publication");
        setLocation(1,1);
        setSize(1100,800);

        f=new Font("Arial",Font.BOLD,15);

        
            t=new JTable(y,x);
            t.setFont(f);
        
        JScrollPane sp=new JScrollPane(t);

        l1=new JLabel("View Publication by Number");
        tf1=new JTextField();
        bt1=new JButton("Find");
        bt1.addActionListener(this);

        l2=new JLabel("View Publication by Name");
        tf2=new JTextField();
        bt2=new JButton("Find");
        bt2.addActionListener(this);

        l3=new JLabel("View Publication by Author");
        tf3=new JTextField();
        bt3=new JButton("Find");
        bt3.addActionListener(this);

        l4=new JLabel("View Publication by Type");
        tf4=new JTextField();
        bt4=new JButton("Find");
        bt4.addActionListener(this);

        l5=new JLabel("View Publication by Collaborators");
        tf5=new JTextField();
        bt5=new JButton("Find");
        bt5.addActionListener(this);

        l6=new JLabel("View Publication by Date");
        tf6=new JTextField();
        tf7=new JTextField();
        bt6=new JButton("Find");
        bt6.addActionListener(this);

        l1.setFont(f);
        tf1.setFont(f);
        bt1.setFont(f);
        l2.setFont(f);
        tf2.setFont(f);
        bt2.setFont(f);
        l3.setFont(f);
        tf3.setFont(f);
        bt3.setFont(f);
        l4.setFont(f);
        tf4.setFont(f);
        bt4.setFont(f);
        l5.setFont(f);
        tf5.setFont(f);
        bt5.setFont(f);
        l6.setFont(f);
        tf6.setFont(f);
        tf7.setFont(f);
        bt6.setFont(f);

        p1=new JPanel();
        p1.setLayout(new GridLayout(6,3,10,10));
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
            int id=Integer.parseInt(tf1.getText());
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from publication where PublicationNumber='"+id+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("pid");
                y[i][j++]=rest.getString("PublicationNumber");
                y[i][j++]=rest.getString("PublicationName");
                y[i][j++]=rest.getString("Author");
                y[i][j++]=rest.getString("PublicationType");
                y[i][j++]=rest.getString("Collaborators");
                y[i][j++]=rest.getString("PublicationDate");
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
            String name=tf2.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from publication where PublicationName='"+name+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("pid");
                y[i][j++]=rest.getString("PublicationNumber");
                y[i][j++]=rest.getString("PublicationName");
                y[i][j++]=rest.getString("Author");
                y[i][j++]=rest.getString("PublicationType");
                y[i][j++]=rest.getString("Collaborators");
                y[i][j++]=rest.getString("PublicationDate");
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
            String auth=tf3.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from publication where Author='"+auth+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("pid");
                y[i][j++]=rest.getString("PublicationNumber");
                y[i][j++]=rest.getString("PublicationName");
                y[i][j++]=rest.getString("Author");
                y[i][j++]=rest.getString("PublicationType");
                y[i][j++]=rest.getString("Collaborators");
                y[i][j++]=rest.getString("PublicationDate");
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
            String type=tf4.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from publication where PublicationType='"+type+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("pid");
                y[i][j++]=rest.getString("PublicationNumber");
                y[i][j++]=rest.getString("PublicationName");
                y[i][j++]=rest.getString("Author");
                y[i][j++]=rest.getString("PublicationType");
                y[i][j++]=rest.getString("Collaborators");
                y[i][j++]=rest.getString("PublicationDate");
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
            String coll=tf5.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from publication where Collaborators='"+coll+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("pid");
                y[i][j++]=rest.getString("PublicationNumber");
                y[i][j++]=rest.getString("PublicationName");
                y[i][j++]=rest.getString("Author");
                y[i][j++]=rest.getString("PublicationType");
                y[i][j++]=rest.getString("Collaborators");
                y[i][j++]=rest.getString("PublicationDate");
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
            String date1=tf6.getText();
            String date2=tf7.getText();
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="select * from publication where PublicationDate between '"+date1+"' and '"+date2+"'";
                ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("pid");
                y[i][j++]=rest.getString("PublicationNumber");
                y[i][j++]=rest.getString("PublicationName");
                y[i][j++]=rest.getString("Author");
                y[i][j++]=rest.getString("PublicationType");
                y[i][j++]=rest.getString("Collaborators");
                y[i][j++]=rest.getString("PublicationDate");
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
        new FindPublication().setVisible(true);
    }
}
