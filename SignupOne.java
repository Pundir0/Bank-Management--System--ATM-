
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField fnameTextField,lnameTextField,fatherTextField,contactTextField,
               emailTextField,addressTextField,cityTextField,stateTextField,
               codeTextField;
    JLabel     heading,formno,fname,lname,father,dob,contact,mail,gender,marital,
               address,city,state,pincode;
    JButton    next;
    JDateChooser dateChooser;
    JRadioButton man,female,unmarried,married;
    ButtonGroup genderGroup,maritalGroup;
    
  SignupOne(){
    setTitle("SignUp");
    
    setLayout(null);
    
    //Produce Random numbers to the application form
    Random ran=new Random();
    random=Math.abs((ran.nextLong()%9000L)+1000L);
     
    setSize(750,800);
    setLocation(350,20);
    setVisible(true);
    
    getContentPane().setBackground(Color.WHITE);
    
    heading=new JLabel("Page 1: Personal Details ");
    heading.setBounds(240,50,600,100);
    add(heading);
    heading.setFont(new Font("RALEWAY",Font.BOLD,25));
    
    formno=new JLabel("Application No. :"+ random);
    formno.setBounds(200,1,600,100);
    add(formno);
    formno.setFont(new Font("RALEWAY",Font.BOLD,35));
    
    fname=new JLabel("First Name :");
    fname.setBounds(50,120,150,100);
    fname.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(fname);
   
    lname=new JLabel("Last Name :");
    lname.setBounds(50,165,150,100);
    lname.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(lname);
    
    father=new JLabel("Father's Name :");
    father.setBounds(50,210,150,100);
    father.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(father);
    
    dob=new JLabel("Date of Birth :");
    dob.setBounds(50,255,160,100);
    dob.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(dob);
    
    
    contact=new JLabel("Contact No. :");
    contact.setBounds(50,300,160,100);
    contact.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(contact);
    
    mail=new JLabel("Email :");
    mail.setBounds(50,345,100,100);
    mail.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(mail);
    
    gender=new JLabel("Gender :");
    gender.setBounds(50,390,120,100);
    gender.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(gender);
    
    marital=new JLabel("Marital Status :");
    marital.setBounds(50,435,160,100);
    marital.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(marital);
    
    address=new JLabel("Address :");
    address.setBounds(50,480,160,100);
    address.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(address);
    
    city=new JLabel("City :");
    city.setBounds(50,525,160,100);
    city.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(city);
    
    state=new JLabel("State :");
    state.setBounds(50,570,160,100);
    state.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(state);
    
    pincode=new JLabel("Pin Code :");
    pincode.setBounds(50,615,160,100);
    pincode.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(pincode);
    
    //add ext field in the frame
    fnameTextField=new JTextField();
    add(fnameTextField);
    fnameTextField.setBounds(220, 154, 400, 22);
    fnameTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
   
    lnameTextField=new JTextField();
    add(lnameTextField);
    lnameTextField.setBounds(220, 199, 400, 22);
    lnameTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    fatherTextField=new JTextField();
    add(fatherTextField);
    fatherTextField.setBounds(220, 245, 400, 22);
    fatherTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    contactTextField=new JTextField();
    add(contactTextField);
    contactTextField.setBounds(220, 338, 400, 22);
    contactTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    emailTextField=new JTextField();
    add(emailTextField);
    emailTextField.setBounds(220, 386, 400, 22);
    emailTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    addressTextField=new JTextField();
    add(addressTextField);
    addressTextField.setBounds(220, 515, 400, 22);
    addressTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    cityTextField=new JTextField();
    add(cityTextField);
    cityTextField.setBounds(220, 560, 400, 22);
    cityTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    stateTextField=new JTextField();
    add(stateTextField);
    stateTextField.setBounds(220, 605, 400, 22);
    stateTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    codeTextField=new JTextField();
    add(codeTextField);
    codeTextField.setBounds(220, 650, 400, 22);
    codeTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    next=new JButton("Next");
    next.addActionListener(this);
    add(next);
    next.setBounds(560, 700, 60, 30);
    next.setFont(new Font("RALEWAY",Font.BOLD,12));
    
    dateChooser=new JDateChooser();
    dateChooser.setBounds(220,290,400,30);
    add(dateChooser);
    dateChooser.setFont(new Font("RALEWAY",Font.BOLD,12));
    
    man=new JRadioButton("Male");
    add(man);
    man.setBounds(220, 420, 80, 40);
    man.setFont(new Font("RALEWAY",Font.BOLD,15));
    man.setBackground(Color.WHITE);
    
    female=new JRadioButton("Female");
    add(female);
    female.setBounds(320, 420, 80, 40);
    female.setFont(new Font("RALEWAY",Font.BOLD,15));
    female.setBackground(Color.WHITE);
    
    genderGroup=new ButtonGroup();
    genderGroup.add(man);
    genderGroup.add(female);
    
    unmarried=new JRadioButton("Unmarried");
    add(unmarried);
    unmarried.setBounds(220, 465, 110, 40);
    unmarried.setFont(new Font("RALEWAY",Font.BOLD,15));
    unmarried.setBackground(Color.WHITE);
    
    married=new JRadioButton("Married");
    add(married);
    married.setBounds(340, 465, 110, 40);
    married.setFont(new Font("RALEWAY",Font.BOLD,15));
    married.setBackground(Color.WHITE);
    
    maritalGroup=new ButtonGroup();
    maritalGroup.add(unmarried);
    maritalGroup.add(married);
    
  }  
  
  public void actionPerformed(ActionEvent ae){
      String formno="" + random;
      String fname=fnameTextField.getText();
      String lname=lnameTextField.getText();
      String father=fatherTextField.getText();
      String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
      String contact=contactTextField.getText();
      String email=emailTextField.getText();
      String gender=null;
      if(man.isSelected()){
          gender="Male";
      }
      else if(female.isSelected()){
            gender="Female";
      }
      String address=addressTextField.getText();
      String marital=null;
      if(married.isSelected()){
          marital="Married";
      }else if(unmarried.isSelected()){
           marital="Unmarried";
      }
      String city=cityTextField.getText();
      String state=stateTextField.getText();
      String code=codeTextField.getText();
      
      try{
       if(fname.equals("")){
           JOptionPane.showMessageDialog(null, "First Name Is Required");
       }else if(lname.equals("")){
           JOptionPane.showMessageDialog(null, "Last Name Is Required");
       }else if(father.equals("")){
           JOptionPane.showMessageDialog(null, "Father's Name Is Required");
       }else if(dob.equals("")){
           JOptionPane.showMessageDialog(null, "Date Of Birth Is Required");
       }else if(contact.equals("")){
           JOptionPane.showMessageDialog(null, "Contact Is Required");
       }else if(email.equals("")){
           JOptionPane.showMessageDialog(null, "Email Is Required");
       }else if(gender.equals("")){
           JOptionPane.showMessageDialog(null, "Selection Of Gender Is Required");
       }else if(address.equals("")){
           JOptionPane.showMessageDialog(null, "Address Is Required");
       }else if(marital.equals("")){
           JOptionPane.showMessageDialog(null, "Selection Of Marital Status Is Required");
       }else if(city.equals("")){
           JOptionPane.showMessageDialog(null, "City Is Required");
       }else if(state.equals("")){
           JOptionPane.showMessageDialog(null, "State Is Required");
       }else if(code.equals("")){
           JOptionPane.showMessageDialog(null, "Pin Code Is Required");
       }
       else{
           connection c= new connection();
           String query="insert into signup values('"+formno+"','"+fname+"','"+lname+"','"+father+"','"+dob+"','"+contact+"','"+email+"','"+gender+"','"+address+"','"+marital+"','"+city+"','"+state+"','"+code+"')";
           c.s.executeUpdate(query);
           
           setVisible(false);
           new SignupTwo(formno).setVisible(true);
       }
      }catch(Exception e){
          System.out.println(e);
      }
  }
    public static void main(String[]args){
    
            new SignupOne();
    }
  }
