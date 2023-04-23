package Library;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FindJournals extends JFrame implements ActionListener{
    String x[]={"Name","CorrespondingAuthor","CoAuthorInternal","CoAuthorExternal","PageNumber","VolumeNumber","IssueNumber","Date"};
    JButton bt1;
    String y[][]=new String[20][8];
    int i=0,j=0;
    JTable t;
    Font f,f1,f2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    JPanel p1,p2,p3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;  

    FindJournals(){
        super("Find Journal");
        setLocation(1,1);
        setSize(1100,800);

        f=new Font("Arial",Font.BOLD,15);
        f1=new Font("Helvetica",Font.BOLD,17);
        f2=new Font("Tahoma",Font.PLAIN,20);
        
            t=new JTable(y,x);
            t.setFont(f);
        
        JScrollPane sp=new JScrollPane(t);

        l1=new JLabel("View Journal by Name");
        tf1=new JTextField();
        bt1=new JButton("Find");
        bt1.addActionListener(this);

        l2=new JLabel("View Journal by Corresponding Author");
        tf2=new JTextField();

        l3=new JLabel("View Journal by Co-Author Internal");
        tf3=new JTextField();

        l4=new JLabel("View Journal by Co-Author External");
        tf4=new JTextField();

        l5=new JLabel("View Journal by Page Number");
        tf5=new JTextField();

        
        l7=new JLabel("View Journal by Volume Number");
        tf8=new JTextField();
        
        l8=new JLabel("View Journal by Issue Number");
        tf9=new JTextField();

        l6=new JLabel("View Journal by Date");
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
        l6.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        l7.setFont(f1);
        tf8.setFont(f1);
        l8.setFont(f1);
        tf9.setFont(f1);

        p3=new JPanel();
        p3.add(bt1);
        p3.setPreferredSize(new Dimension(200,200));
        p3.setLocation(860, 620);

        p1=new JPanel();
        p1.setLayout(new GridLayout(7,2,10,10));
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
        p1.add(l7);
        p1.add(tf8);
        p1.add(l8);
        p1.add(tf9);
        

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
            String coAuthorInternal=tf3.getText();
            String coAuthorExternal=tf4.getText();
            String pageNumber=tf5.getText();
            String volumeNumber=tf8.getText();
            String issueNumber=tf9.getText();
            String date1=tf6.getText();
            String date2=tf7.getText();
            String q="select * from journal where ";

            try {
                ConnectionClass obj=new ConnectionClass();
                if(!name.equals("")){
                    q+="Name like '%"+name+"%'";
                    if(!corrAuthor.equals("")){
                        q+=" and CorrespondingAuthor like '%"+corrAuthor+"%'";
                        if(!coAuthorInternal.equals("")){
                            q+=" and CoAuthorInternal like '%"+coAuthorInternal+"%'";
                            if(!coAuthorExternal.equals("")){
                                q+=" and CoAuthorExternal like '%"+coAuthorExternal+"%'";
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                            else if(coAuthorExternal.equals("")){
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if(coAuthorInternal.equals("")){
                            if(!coAuthorExternal.equals("")){
                                q+=" and CoAuthorExternal like '%"+coAuthorExternal+"%'";
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                            else if(coAuthorExternal.equals("")){
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(corrAuthor.equals("")){
                        if(!coAuthorInternal.equals("")){
                            q+=" and CoAuthorInternal like '%"+coAuthorInternal+"%'";
                            if(!coAuthorExternal.equals("")){
                                q+=" and CoAuthorExternal like '%"+coAuthorExternal+"%'";
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                            else if(coAuthorExternal.equals("")){
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if(coAuthorInternal.equals("")){
                            if(!coAuthorExternal.equals("")){
                                q+=" and CoAuthorExternal like '%"+coAuthorExternal+"%'";
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                            else if(coAuthorExternal.equals("")){
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else if(name.equals("")){
                    if(!corrAuthor.equals("")){
                        q+=" CorrespondingAuthor like '%"+corrAuthor+"%'";
                        if(!coAuthorInternal.equals("")){
                            q+=" and CoAuthorInternal like '%"+coAuthorInternal+"%'";
                            if(!coAuthorExternal.equals("")){
                                q+=" and CoAuthorExternal like '%"+coAuthorExternal+"%'";
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                            else if(coAuthorExternal.equals("")){
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if(coAuthorInternal.equals("")){
                            if(!coAuthorExternal.equals("")){
                                q+=" and CoAuthorExternal like '%"+coAuthorExternal+"%'";
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                            else if(coAuthorExternal.equals("")){
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(corrAuthor.equals("")){
                        if(!coAuthorInternal.equals("")){
                            q+=" CoAuthorInternal like '%"+coAuthorInternal+"%'";
                            if(!coAuthorExternal.equals("")){
                                q+=" and CoAuthorExternal like '%"+coAuthorExternal+"%'";
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                            else if(coAuthorExternal.equals("")){
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else if(coAuthorInternal.equals("")){
                            if(!coAuthorExternal.equals("")){
                                q+=" CoAuthorExternal like '%"+coAuthorExternal+"%'";
                                if(!pageNumber.equals("")){
                                    q+=" and PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                            }
                            else if(coAuthorExternal.equals("")){
                                if(!pageNumber.equals("")){
                                    q+=" PageNumber='"+pageNumber+"'";
                                    if(!volumeNumber.equals("")){
                                        q+=" and VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                }
                                else if(pageNumber.equals("")){
                                    if(!volumeNumber.equals("")){
                                        q+=" VolumeNumber='"+volumeNumber+"'";
                                        if(!issueNumber.equals("")){
                                            q+=" and IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                    }
                                    else if(volumeNumber.equals("")){
                                        if(!issueNumber.equals("")){
                                            q+=" IssueNumber='"+issueNumber+"'";
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                        }
                                        else if(issueNumber.equals("")){
                                            if(!date1.equals("")&&!date2.equals("")){
                                                q+=" and Date between '"+date1+"' and '"+date2+"'";
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null,"Not Enough Input Given");
                                                System.exit(0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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
        new FindJournals().setVisible(true);
    }
}
