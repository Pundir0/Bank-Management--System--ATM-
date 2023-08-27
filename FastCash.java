
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JLabel l1;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber=pinnumber;
    
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        l1=new JLabel("Please Select your Amount");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("SYSTEM",Font.BOLD,15));
        l1.setBounds(230, 300, 220, 15);
        image.add(l1);
        
        b1=new JButton("RS 100");
        b1.setBounds(270, 360, 120, 20);
        b1.setFont(new Font("SYSTEM",Font.BOLD,15));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        image.add(b1);
        
        b2=new JButton("RS 500");
        b2.setBounds(180, 400, 120, 20);
        b2.setFont(new Font("SYSTEM",Font.BOLD,15));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        image.add(b2);
        
        b3=new JButton("RS 1000");
        b3.setBounds(180, 440, 120, 20);
        b3.setFont(new Font("SYSTEM",Font.BOLD,15));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        image.add(b3);
        
        b4=new JButton("RS 1500");
        b4.setBounds(180, 480, 120, 20);
        b4.setFont(new Font("SYSTEM",Font.BOLD,15));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        image.add(b4);
        
        b5=new JButton("RS 2000");
        b5.setBounds(370, 400, 120, 20);
        b5.setFont(new Font("SYSTEM",Font.BOLD,15));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        image.add(b5);
        
        b6=new JButton("RS 5000");
        b6.setBounds(370, 440, 120, 20);
        b6.setFont(new Font("SYSTEM",Font.BOLD,15));
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        image.add(b6);
        
        b7=new JButton("RS 10000");
        b7.setBounds(370, 480, 120, 20);
        b7.setFont(new Font("SYSTEM",Font.BOLD,15));
        b7.setForeground(Color.BLACK);
        b7.addActionListener(this);
        image.add(b7);
        
        b8=new JButton("Back");
        b8.setBounds(370, 515, 120, 30);
        b8.setFont(new Font("SYSTEM",Font.BOLD,15));
        b8.setForeground(Color.BLACK);
        b8.addActionListener(this);
        image.add(b8);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b7){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            connection c=new connection();
            try{
                ResultSet rs=c.s.executeQuery("select * from Bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                    
                    if(ae.getSource()!=b8&&balance<Integer.parseInt("amount")){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                    }
                    
                    Date date =new Date();
                    String query="insert into Bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs"+amount+"Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    public static void main(String[]args){
        new FastCash("");
    }
}
