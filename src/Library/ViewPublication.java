package Library;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
public class ViewPublication extends JFrame{
    String x[]={"pid","PublicationNumber","PublicationName","Author","PublicationType","Collaborators","PublicationDate"};
    JButton bt;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;

    ViewPublication(){
        super("View Publication");
        setLocation(1,1);
        setSize(1000,400);

        f=new Font("Arial",Font.BOLD,15);

        try {
            ConnectionClass obj=new ConnectionClass();
            String q="select*from publication";
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
        add(sp);
    }
    public static void main(String[] args) {
        new ViewPublication().setVisible(true);
    }
    
}
