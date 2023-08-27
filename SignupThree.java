
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup bg1;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton b1,b2;
    String formno;   
    
    SignupThree(String formno){
        
        this.formno=formno;
        
        setLayout(null);
        setSize(750,800);
        setVisible(true);
        setLocation(350,20);
        
        getContentPane().setBackground(Color.WHITE);
        
        l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("RALEWAY",Font.BOLD,25));
        l1.setBounds(220, 30, 280, 20);
        add(l1);
        
        l2=new JLabel("Account Type :");
        l2.setFont(new Font("RALEWAY",Font.BOLD,22));
        l2.setBounds(60,120,170,26);
        add(l2);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("RALEWAY",Font.BOLD,16));
        r1.setBounds(80,160,170,21);
        r1.setBackground(Color.white);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("RALEWAY",Font.BOLD,16));
        r2.setBounds(320,160,230,21);
        r2.setBackground(Color.white);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("RALEWAY",Font.BOLD,16));
        r3.setBounds(80,195,230,21);
        r3.setBackground(Color.white);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("RALEWAY",Font.BOLD,16));
        r4.setBounds(320,195,230,21);
        r4.setBackground(Color.white);
        add(r4);
        
        bg1=new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);
        bg1.add(r4);
        
        l3=new JLabel("Card Number :");
        l3.setFont(new Font("RALEWAY",Font.BOLD,22));
        l3.setBounds(60,240,170,26);
        add(l3);
        
        l4=new JLabel("XXXX-XXXX-XXXX-0128");
        l4.setFont(new Font("RALEWAY",Font.BOLD,22));
        l4.setBounds(280,240,260,26);
        add(l4);
        
        l5=new JLabel("Your 16 Digit card Number");
        l5.setFont(new Font("RALEWAY",Font.BOLD,12));
        l5.setBounds(60,265,170,26);
        add(l5);
        
        l6=new JLabel("PIN :");
        l6.setFont(new Font("RALEWAY",Font.BOLD,22));
        l6.setBounds(60,310,60,26);
        add(l6);
        
        l7=new JLabel("Your 4 digit Password");
        l7.setFont(new Font("RALEWAY",Font.BOLD,12));
        l7.setBounds(60,335,260,26);
        add(l7);
        
        l8=new JLabel("XXXX");
        l8.setFont(new Font("RALEWAY",Font.BOLD,22));
        l8.setBounds(280,310,80,26);
        add(l8);
        
        l9=new JLabel("Service Required :");
        l9.setFont(new Font("RALEWAY",Font.BOLD,22));
        l9.setBounds(60,380,210,22);
        add(l9);
        
        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("RALEWAY",Font.BOLD,16));
        c1.setBounds(80,420,110,21);
        c1.setBackground(Color.white);
        add(c1);
        
        c2=new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("RALEWAY",Font.BOLD,16));
        c2.setBounds(320,420,200,21);
        c2.setBackground(Color.white);
        add(c2);
        
        c3=new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("RALEWAY",Font.BOLD,16));
        c3.setBounds(80,455,200,21);
        c3.setBackground(Color.white);
        add(c3);
        
        c4=new JCheckBox("EMAIL & SMS ALERT");
        c4.setFont(new Font("RALEWAY",Font.BOLD,16));
        c4.setBounds(320,455,220,21);
        c4.setBackground(Color.white);
        add(c4);
        
        c5=new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("RALEWAY",Font.BOLD,16));
        c5.setBounds(80,490,200,21);
        c5.setBackground(Color.white);
        add(c5);
        
        c6=new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("RALEWAY",Font.BOLD,16));
        c6.setBounds(320,490,200,21);
        c6.setBackground(Color.white);
        add(c6);
        
        c7=new JCheckBox("I do hereby declare that all the above information given by me are true "
                + "to the best of my knowledge.");
        c7.setFont(new Font("RALEWAY",Font.BOLD,10));
        c7.setBounds(60,560,550,50);
        c7.setBackground(Color.white);
        add(c7);
        
        b1=new JButton("Submit");
        b1.setFont(new Font("RALEWAY",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(140, 670, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setFont(new Font("RALEWAY",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(380, 670, 100, 25);
        b2.addActionListener(this);
        add(b2);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
         String accountType=null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if(r4.isSelected()){
                accountType="Recurring Deposit Account";
            }
            
            Random random=new Random();
            String cardnumber=""+Math.abs(random.nextLong()%9000000)+85201280000000L;
            String pinnumber=""+Math.abs((random.nextLong()%9000)+10000L);
            
            String facilities="";
            if(c1.isSelected()){
                facilities=facilities + " ATM CARD ";
            }else if(c2.isSelected()){
                facilities=facilities + " INTERNET BANKING ";
            }else if(c3.isSelected()){
                facilities=facilities + " MOBILE BANKING ";
            }else if(c4.isSelected()){
                facilities=facilities + " EMAIL & SMS ALERT ";
            }else if(c5.isSelected()){
                facilities=facilities + " CHEQUE BOOK ";
            }else if(c6.isSelected()){
                facilities=facilities + " E-STATEMENT ";
            }
            
            try{
             connection c=new connection();
             String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facilities+"')";
             String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
             
             c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null, "Card Number:"+cardnumber+"\n Pin:"+pinnumber);
             
             setVisible(false);
             new Deposit(pinnumber).setVisible(false);
             
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==b2){
            setVisible(false);
            new Login().setVisible(true);
           
        }
    
    }
    
    public static void main(String[]args){
        
        new SignupThree("");
    }
}
