package Library;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DeleteFaculty extends JFrame implements ActionListener{
    String x[]={"Id","Username","Password","Email","Contact"};
    JButton bt1;
    String y[][]=new String[20][5];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    JTextField tf1;
    JPanel p1;
    JLabel l1;

    DeleteFaculty(){
        super("Delete Faculty");
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

        l1=new JLabel("Delete Faculty by Id");
        tf1=new JTextField();
        bt1=new JButton("Delete");
        bt1.addActionListener(this);

        l1.setFont(f);
        tf1.setFont(f);
        bt1.setFont(f);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt1);

        setLayout(new BorderLayout(10,10));
        add(sp,"Center");
        add(p1,"South");
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1){
            int id=Integer.parseInt(tf1.getText());
            try {
                ConnectionClass obj=new ConnectionClass();
                String q="delete from faculty where Fid='"+id+"'";
                int res=obj.stm.executeUpdate(q);
                if(res==1){
                    JOptionPane.showMessageDialog(null,"Your data successfully deleted");
                    this.setVisible(false);
                    new DeleteFaculty().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your data did not get deleted");
                    this.setVisible(false);
                    new DeleteFaculty().setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new DeleteFaculty().setVisible(true);
    }
}
