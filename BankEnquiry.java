package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BankEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton b1;
    
    BankEnquiry(String pinnumber){
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        connection c=new connection();
         int balance=0;
            try{
                ResultSet rs=c.s.executeQuery("select * from Bank where pin='"+pinnumber+"'");
               
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }    
           }     catch(Exception e){
                System.out.println(e);
           }
            
        JLabel l1=new JLabel("YOUR CURRENT ACCOUNT BALANCE IS Rs" + balance);
        l1.setForeground(Color.WHITE);
        l1.setBounds(170,300,400,35);
        image.add(l1);
                    
        b1=new JButton("BACK");
        b1.setBounds(400,510,100,25);
        b1.setFont(new Font("SYSTEM",Font.BOLD,15));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        image.add(b1);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b1){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
    }
    public static void main(String[]args){
        new BankEnquiry("");
    }
}
