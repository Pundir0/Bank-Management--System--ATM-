
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JLabel l1;
    JTextField t1;
    JButton b1,b2;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900 ,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        l1=new JLabel("Enter Your Withdrawl Amount");
        l1.setForeground(Color.WHITE);
        l1.setBounds(230,300,220,20);
        l1.setFont(new Font("SYSTEM",Font.BOLD,15));
        image.add(l1);
        
        t1=new JTextField();
        t1.setBounds(200,340,260,25);
        image.add(t1);
        
        b1=new JButton("Withdraw");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("SYSTEM",Font.BOLD,15));
        b1.setBounds(400,450,180,25);
        b1.addActionListener(this);
        image.add(b1);
        
        b2=new JButton("Back");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("SYSTEM",Font.BOLD,15));
        b2.setBounds(400,500,180,25);
        b2.addActionListener(this);
        image.add(b2);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String amount=t1.getText();
            Date date=new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdrawl");
            }else{
                try{
                    connection c= new connection();
                    String query="insert into Bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs"+amount+"Withdraw Successfully");
                    setVisible(false);
            new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==b2){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    
    }
    
    public static void main(String [] args){
        new Withdrawl("");
    }
}
