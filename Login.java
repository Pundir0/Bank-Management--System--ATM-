
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField CardTextField;
    JPasswordField PinTextField;
            Login(){
                //Title of The Project
                setTitle("Automated Teller Machine");
                
                //Change the default layout of the frmae to null
                setLayout(null);
                
                //Load the image to the fame 
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
                Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
                ImageIcon i3=new ImageIcon(i2);
           
                JLabel label=new JLabel(i3);
                add(label);
                label.setBounds(40,20,100,100);
                
                //Background Color
                getContentPane().setBackground(Color.WHITE);
                
                //add text to the frame
                JLabel text=new JLabel("Welocome to ATM");
                add(text);
                text.setBounds(200,40,500,30);
                
                
                JLabel card=new JLabel("Card No. :");
                add(card);
                card.setBounds(100,150,200,30);
              
                
                JLabel pin=new JLabel("Pin :");
                add(pin);
                pin.setBounds(100,220,120,30);
                
                //add text field to the frame
                CardTextField=new JTextField();
                CardTextField.setBounds(270,150, 270, 30);
                add(CardTextField);
                
                PinTextField=new JPasswordField();
                PinTextField.setBounds(270,220, 270, 30);
                add(PinTextField);
                
                //add Buttons to the frame
                login=new JButton("Sign In");
                login.setBounds(270, 280, 120, 30);
                login.addActionListener(this);
                add(login);
                
                clear=new JButton("Clear");
                clear.setBounds(420, 280, 120, 30);
                clear.addActionListener(this);
                add(clear);
                
                signup=new JButton("Sign Up");
                signup.setBounds(270, 330, 270, 30);
                signup.addActionListener(this);
                add(signup);
                      
                
                //change the size and fonts style of the text
                text.setFont(new Font("OSWARD",Font.BOLD,40));
                card.setFont(new Font("Really",Font.BOLD,30));
                pin.setFont(new Font("OSWARD",Font.BOLD,30));
                 
                //Background Color of the Buttons
                login.setBackground(Color.BLACK);
                login.setForeground(Color.WHITE);
               
                
                
                signup.setBackground(Color.BLACK);
                signup.setForeground(Color.WHITE);
              
                
                clear.setBackground(Color.BLACK);
                clear.setForeground(Color.WHITE);
        
                
                //Change the font style of the Buttons
                login.setFont(new Font("OSWARD",Font.BOLD,20));
                clear.setFont(new Font("OSWARD",Font.BOLD,20));
                signup.setFont(new Font("OSWARD",Font.BOLD,20));
                

                //change the location to where we want to add it
                setLocation(400,200);
        setSize(800,480);
        setVisible(true);
    }
            
            public void actionPerformed(ActionEvent ae){
                if(ae.getSource()==clear){
                    CardTextField.setText("");
                    PinTextField.setText("");
                }
                else if(ae.getSource()==login){
                    connection c=new connection();
                    String cardnumber=CardTextField.getText();
                    String pinnumber=PinTextField.getText();
                    String query="select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
                    try{
                        ResultSet rs=c.s.executeQuery(query);
                        if(rs.next()){
                            setVisible(false);
                            new Transactions(pinnumber).setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                        }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
                else if(ae.getSource()==signup){
                    setVisible(false);
                    new SignupOne().setVisible(true);
                }
            }
    public static void main(String args[]){
        
        new Login();

    }
}
 