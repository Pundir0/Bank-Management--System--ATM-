
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    long random;
    JTextField panTextField,adharTextField;
    JComboBox sreligion,scategory,sincome,seducation,soccupation;
    JButton    next;
    JRadioButton syes,sno,ayes,ano;
    ButtonGroup seniorGroup,accountGroup;
    String formno;
    
  SignupTwo(String formno){
      
    this.formno=formno;
      
    setLayout(null);
     
    setSize(750,800);
    setLocation(350,20);
    setVisible(true);
    
    getContentPane().setBackground(Color.WHITE);
    
    JLabel additionalDetails=new JLabel("Page 1: Additional Details ");
    additionalDetails.setBounds(240,50,600,100);
    add(additionalDetails);
    additionalDetails.setFont(new Font("RALEWAY",Font.BOLD,25));
    
    JLabel religion=new JLabel("Religon :");
    religion.setBounds(50,120,150,100);
    religion.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(religion);
   
    JLabel category=new JLabel("Category :");
    category.setBounds(50,165,150,100);
    category.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(category);
    
    JLabel income=new JLabel("Income :");
    income.setBounds(50,210,150,100);
    income.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(income);
    
    JLabel education=new JLabel("Educational");
    education.setBounds(50,255,160,100);
    education.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(education);
    
    
    JLabel qualification=new JLabel("Qualification :");
    qualification.setBounds(50,285,160,100);
    qualification.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(qualification);
    
    JLabel occupation=new JLabel("Occupation :");
    occupation.setBounds(50,330,150,100);
    occupation.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(occupation);
    
    JLabel pan=new JLabel("Pan Card :");
    pan.setBounds(50,375,120,100);
    pan.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(pan);
    
    JLabel adhar=new JLabel("Adhar Card :");
    adhar.setBounds(50,425,120,100);
    adhar.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(adhar);
    
    JLabel senior=new JLabel("Senior Citizen :");
    senior.setBounds(50,470,160,100);
    senior.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(senior);
    
    JLabel account=new JLabel("Existing Account :");
    account.setBounds(50,515,200,100);
    account.setFont(new Font("RALEWAY",Font.BOLD,20));
    add(account);
    
    //add drop down field in the frame
    
    String valreligion[]={"","Hindu","Sikh","Muslim","Christans","Other"};
    sreligion=new JComboBox(valreligion);
    sreligion.setBounds(230, 154, 400, 22);
    sreligion.setBackground(Color.WHITE);
    add(sreligion);
   
    String valcategory[]={"","General","OBC","SC","ST","Other"};
    scategory=new JComboBox(valcategory);
    scategory.setBounds(230, 199, 400, 22);
    scategory.setBackground(Color.WHITE);
    add(scategory);
    
    String valincome[]={"Null","<1,50,000","<2,50,00","<5,00,000","Up To 10,00,000"};
    sincome=new JComboBox(valincome);
    sincome.setBounds(230, 245, 400, 22);
    sincome.setBackground(Color.WHITE);
    add(sincome);
    
    String valeducation[]={"","Non-Graduation","Graduation","Post Graduation","Other"};
    seducation=new JComboBox(valeducation);
    seducation.setBounds(230, 300, 400, 40);
    seducation.setBackground(Color.WHITE);
    add(seducation);
    
    String valoccupation[]={"","Salaried","Self-Employed","Bussiness Man","Student","Retired"};
    soccupation=new JComboBox(valoccupation);
    soccupation.setBounds(230, 366, 400, 22);
    soccupation.setBackground(Color.WHITE);
    add(soccupation);
    
    panTextField=new JTextField();
    add(panTextField);
    panTextField.setBounds(230, 416, 400, 22);
    panTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    adharTextField=new JTextField();
    add(adharTextField);
    adharTextField.setBounds(230, 462, 400, 22);
    adharTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
    
    syes=new JRadioButton("Yes");
    add(syes);
    syes.setBounds(220, 502, 80, 40);
    syes.setFont(new Font("RALEWAY",Font.BOLD,15));
    syes.setBackground(Color.WHITE);
    
    sno=new JRadioButton("NO");
    add(sno);
    sno.setBounds(320, 502, 80, 40);
    sno.setFont(new Font("RALEWAY",Font.BOLD,15));
    sno.setBackground(Color.WHITE);
    
    seniorGroup=new ButtonGroup();
    seniorGroup.add(syes);
    seniorGroup.add(sno);
    
    ayes=new JRadioButton("Yes");
    add(ayes);
    ayes.setBounds(245, 546, 80, 40);
    ayes.setFont(new Font("RALEWAY",Font.BOLD,15));
    ayes.setBackground(Color.WHITE);
    
    ano=new JRadioButton("NO");
    add(ano);
    ano.setBounds(340, 546, 80, 40);
    ano.setFont(new Font("RALEWAY",Font.BOLD,15));
    ano.setBackground(Color.WHITE);
    
    accountGroup=new ButtonGroup();
    accountGroup.add(ayes);
    accountGroup.add(ano);
            
    next=new JButton("Next");
    next.addActionListener(this);
    add(next);
    next.setBounds(560, 600, 60, 30);
    next.setFont(new Font("RALEWAY",Font.BOLD,12));
    
  }  
  
  public void actionPerformed(ActionEvent ae){
      String formno="" + random;
      String valreligion=(String)sreligion.getSelectedItem();
      String valcategory=(String)scategory.getSelectedItem();
      String valincome=(String)sincome.getSelectedItem();
      String valeducation=(String)seducation.getSelectedItem();
      String valoccupation=(String)soccupation.getSelectedItem();
      String senior=null;
      if(syes.isSelected()){
          senior="Yes";
      }
      else if(sno.isSelected()){
            senior="No";
      }
      
      String account=null;
      if(ayes.isSelected()){
          account="Yes";
      }
      else if(ano.isSelected()){
            account="No";
      }
      
      String pan=panTextField.getText();
      String adhar=adharTextField.getText();
      
      try{
           connection c= new connection();
           String query="insert into signuptwo values('"+formno+"','"+valreligion+"','"+valcategory+"','"+valincome+"','"+valeducation+"','"+valoccupation+"','"+pan+"','"+adhar+"','"+senior+"','"+account+"')";
           c.s.executeUpdate(query);
           
           setVisible(false);
           new SignupThree(formno).setVisible(true);
           
      }catch(Exception e){
          System.out.println(e);
      }
  }
    public static void main(String[]args){
    
            new SignupTwo("");
    }
  }
