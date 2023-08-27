
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JLabel text;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnumber;
       
    Transactions(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900 ,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("Please Select Your Transaction");
        text.setBounds(220,300,240,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("SYSTEM",Font.BOLD,15));
        image.add(text);
        
        b1=new JButton("Deposit");
        b1.setBounds(260,390,150,30);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        image.add(b1);
        
        b2=new JButton("Fast Cash");
        b2.setBounds(160,430,150,30);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        image.add(b2);
        
        b3=new JButton("Pin Change");
        b3.setBounds(160,470,150,30);
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        image.add(b3);
        
        b4=new JButton("Cash Withdrawl");
        b4.setBounds(160,510,150,30);
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        image.add(b4);
        
        b5=new JButton("Mini Statement");
        b5.setBounds(360,430,150,30);
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        image.add(b5);
        
        b6=new JButton("Balance Enquiry");
        b6.setBounds(360,470,150,30);
        b6.setForeground(Color.BLACK);
        b6.addActionListener(this);
        image.add(b6);
        
        b7=new JButton("Exit");
        b7.setBounds(360,510,150,30);
        b7.setForeground(Color.BLACK);
        b7.addActionListener(this);
        image.add(b7);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b7){
            System.exit(0);
        }else if(ae.getSource()==b1){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==b4){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==b2){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==b3){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==b5){
            new MiniStatement(pinnumber).setVisible(true); 
        }
    }
    
    public static void main(String[]args){
        new Transactions("");
    }
}
