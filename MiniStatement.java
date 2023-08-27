
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        setTitle("Mini Statement");
        
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel bank=new JLabel("APNA BANK");
        bank.setBounds(130,20,150,20);
        bank.setFont(new Font("SYSTEM",Font.BOLD,20));
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            connection c=new connection();
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+"Card Number:"+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            connection c=new connection();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select *from bank wher pin='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount"+"<br><br><html>"));
                if(rs.getString("type").equals("Deposit")){
                        bal+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal-=Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your Current Account Balance is Rs"+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(200,50);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[]args){
        new MiniStatement("");
    }
}
