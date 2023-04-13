package Library;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
public class ViewFaculty extends JFrame{
    String x[]={"Id","Username","Password","Email","Contact"};
    JButton bt;
    String y[][]=new String[20][5];
    int i=0,j=0;
    JTable t;
    Font f,f1;

    ViewFaculty(){
        super("View Faculty");
        setLocation(1,1);
        setSize(1000,400);

        f=new Font("Arial",Font.BOLD,15);
        
        try {
            ConnectionClass obj=new ConnectionClass();
            String q="select*from faculty";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++]=rest.getString("Fid");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("password");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("contact");
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
        new ViewFaculty().setVisible(true);
    }
}
