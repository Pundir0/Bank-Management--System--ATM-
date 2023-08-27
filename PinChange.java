
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    JLabel image,l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        image=new JLabel(i3);
        image.setBounds(0,0, 900,900);
        add(image);
        
        l1=new JLabel("Change Your Pin");
        l1.setFont(new Font("SYSTEM",Font.BOLD,15));
        l1.setBounds(270,300,150,20);
        l1.setForeground(Color.WHITE);
        image.add(l1);
        
        l2=new JLabel("New Pin:");
        l2.setFont(new Font("SYSTEM",Font.BOLD,15));
        l2.setBounds(170,350,150,20);
        l2.setForeground(Color.WHITE);
        image.add(l2);
        
        t1=new JTextField("");
        t1.setFont(new Font("RALEWAY",Font.BOLD,15));
        t1.setBounds(330,350,150,20);
        t1.setForeground(Color.BLACK);
        image.add(t1);
        
        l3=new JLabel("Re-Enter Your Pin:");
        l3.setFont(new Font("SYSTEM",Font.BOLD,15));
        l3.setBounds(170,400,150,20);
        l3.setForeground(Color.WHITE);
        image.add(l3);
        
        t2=new JTextField("");
        t2.setFont(new Font("RALEWAY",Font.BOLD,15));
        t2.setBounds(330,400,150,20);
        t2.setForeground(Color.BLACK);
        image.add(t2);
        
        b1=new JButton("Change");
        b1.setFont(new Font("System",Font.BOLD,15));
        b1.setBounds(380,450,100,25);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        image.add(b1);
        
        b2=new JButton("Back");
        b2.setFont(new Font("System",Font.BOLD,15));
        b2.setBounds(380,500,100,25);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        image.add(b2);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                 String npin=t1.getText();
                 String repin=t2.getText();
                    
                 if(!npin.equals(repin)){
                     JOptionPane.showMessageDialog(null,"ENTERED PIN DOES NOT MATCHED");
                     return;
                    }
                 if(npin.equals("")){
                     JOptionPane.showMessageDialog(null,"PLEASE ENTER PIN");
                     return;
                 }
                 if(repin.equals("")){
                     JOptionPane.showMessageDialog(null,"PLEASE RE-ENTER PIN");
                     return;
                 }
                 
                 connection c=new connection();
                 String query1="update Bank set pin'"+repin+"'where pin='"+pinnumber+"'";
                 String query2="update login set pin'"+repin+"'where pin='"+pinnumber+"'";
                 String query3="update signupthree set pin'"+repin+"'where pin='"+pinnumber+"'";
                 
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 c.s.executeUpdate(query3);
                 
                 JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
                 
                 setVisible(false);
                 new Transactions(repin).setVisible(true);
                 
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    
    }
    public static void main(String[]args){
        new PinChange("").setVisible(true);
    }
}
