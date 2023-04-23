package Library;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FindOthers extends JFrame implements ActionListener{
    String x[]={"Name","CorrespondingAuthor","CoAuthorInternal","CoAuthorExternal","PageNumber","VolumeNumber","IssueNumber","ChapterNumber","ISBNNumber","Location","Publisher","Date"};
    JButton bt1;
    String y[][]=new String[20][13];
    int i=0,j=0;
    JTable t;
    Font f,f1,f2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13;
    JPanel p1,p2,p3;
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

        l3=new JLabel("View Publication by Co-Author Internal");
        tf3=new JTextField();

        l4=new JLabel("View Publication by Co-Author External");
        tf4=new JTextField();

        l5=new JLabel("View Publication by Page Number");
        tf5=new JTextField();

        l9=new JLabel("View Publication by Volume Number");
        tf10=new JTextField();
        
        l10=new JLabel("View Publication by Issue Number");
        tf11=new JTextField();

        l7=new JLabel("View Publication by Chapter Number");
        tf8=new JTextField();
         
        l8=new JLabel("View Publication by ISBN Number");
        tf9=new JTextField();

        l11=new JLabel("View Publication by Location");
        tf12=new JTextField();

        l12=new JLabel("View Publication by Publisher");
        tf13=new JTextField();

        l6=new JLabel("View Publication by Date");
        tf6=new JTextField();
        tf7=new JTextField();

        l1.setFont(f1);
        tf1.setFont(f1);
        bt1.setFont(f2);
        l2.setFont(f1);
        tf2.setFont(f1);
        l3.setFont(f1);
        tf3.setFont(f1);
        l4.setFont(f1);
        tf4.setFont(f1);
        l5.setFont(f1);
        tf5.setFont(f1);
        l9.setFont(f1);
        tf10.setFont(f1);
        l10.setFont(f1);
        tf11.setFont(f1);
        l6.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        l7.setFont(f1);
        tf8.setFont(f1);
        l8.setFont(f1);
        tf9.setFont(f1);
        l9.setFont(f1);
        tf10.setFont(f1);
        l10.setFont(f1);
        tf11.setFont(f1);
        l11.setFont(f1);
        tf12.setFont(f1);
        l12.setFont(f1);
        tf13.setFont(f1);

        p3=new JPanel();
        p3.add(bt1);
        p3.setPreferredSize(new Dimension(200,200));
        p3.setLocation(860, 620);

        p1=new JPanel();
        p1.setLayout(new GridLayout(11,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(tf2);
        p1.add(l3);
        p1.add(tf3);
        p1.add(l4);
        p1.add(tf4);
        p1.add(l5);
        p1.add(tf5);
        p1.add(l9);
        p1.add(tf10);
        p1.add(l10);
        p1.add(tf11);
        p1.add(l7);
        p1.add(tf8);
        p1.add(l8);
        p1.add(tf9);
        p1.add(l11);
        p1.add(tf12);
        p1.add(l12);
        p1.add(tf13);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,4,10,10));
        p2.add(l6);
        p2.add(tf6);
        p2.add(tf7);

        setLayout(new BorderLayout(10,10));
        add(sp,"North");
        add(p1,"Center");
        add(p2,"South");
        add(p3,"East");
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
            String corrAuthor=tf2.getText();
            String coAuthorInt=tf3.getText();
            String coAuthorExt=tf4.getText();
            String page=tf5.getText();
            String vol=tf10.getText();
            String issue=tf11.getText();
            String chapter=tf8.getText();
            String isbn=tf9.getText();
            String location=tf12.getText();
            String publisher=tf13.getText();
            String date1=tf6.getText();
            String date2=tf7.getText();
            String q="select * from other where ";
            Boolean flag=false;
            
            try {
                ConnectionClass obj=new ConnectionClass();
                if(!name.equals("")){
                    q=q+"Name like '%"+name+"%'";
                    flag=true;
                }
                if(!corrAuthor.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"CorrespondingAuthor like '%"+corrAuthor+"%'";
                    flag=true;
                }
                if(!coAuthorInt.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"CoAuthorInternal like '%"+coAuthorInt+"%'";
                    flag=true;
                }
                if(!coAuthorExt.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"CoAuthorExternal like '%"+coAuthorExt+"%'";
                    flag=true;
                }
                if(!page.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"PageNumber like '%"+page+"%'";
                    flag=true;
                }
                if(!vol.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"VolumeNumber like '%"+vol+"%'";
                    flag=true;
                }
                if(!issue.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"IssueNumber like '%"+issue+"%'";
                    flag=true;
                }
                if(!chapter.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"ChapterNumber like '%"+chapter+"%'";
                    flag=true;
                }
                if(!isbn.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"ISBNNumber like '%"+isbn+"%'";
                    flag=true;
                }
                if(!location.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"Location like '%"+location+"%'";
                    flag=true;
                }
                if(!publisher.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"Publisher like '%"+publisher+"%'";
                    flag=true;
                }
                if(!date1.equals("")&&!date2.equals("")){
                    if(flag){
                        q=q+" and ";
                    }
                    q=q+"Date between '"+date1+"' and '"+date2+"'";
                    flag=true;
                }
                else if(!date1.equals("")){
                    if(flag){
                        q+=" and ";
                    }
                    q+="Date like '%"+date1+"%'";
                    flag=true;
                }
                else if(!date2.equals("")){
                    if(flag){
                        q+=" and ";
                    }
                    q+="Date like '%"+date2+"%'";
                    flag=true;
                }
                if(!flag){
                    q="select * from other";
                }
    
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
