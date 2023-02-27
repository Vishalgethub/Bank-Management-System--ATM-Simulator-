package bank.management.system;


import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField,addressTextField,
            cityTextField, stateTextField, pinTextField;
    JButton nextt;
    JDateChooser dateChooser;
    JRadioButton male, female, other, married, unmarried;
            
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        long Random = Math.abs((ran.nextLong() % +9000L) + 1000L); 
        
        JLabel formno = new JLabel("APPLICATION FORM NO." + Random );
        formno.setFont(new Font("Raleway", Font.BOLD, 28));
        formno.setBounds (140, 20 , 600 , 30);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        personalDetails.setBounds (230, 60 , 400 , 30);
        add(personalDetails);
        
        JLabel name = new JLabel ("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds (60 , 100 , 200 , 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font ("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 100, 300 ,30);
        add(nameTextField);
        
        JLabel father = new JLabel ("Father's Name: ");
        father.setFont (new Font("Raleway", Font.BOLD, 18));
        father.setBounds(60 , 150 , 200 , 30);
        add(father);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font ("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 150, 300 ,30);
        add(fnameTextField);
        
        JLabel dateofbirth = new JLabel ("Date of Birth:");
        dateofbirth.setFont (new Font("Raleway", Font.BOLD, 18));
        dateofbirth.setBounds(60 , 200 , 200 ,30);
        add(dateofbirth);
        
        dateChooser = new JDateChooser ();
        dateChooser.setBounds(300 , 200 , 300 , 30);
        dateChooser.setForeground(Color.white);
        add(dateChooser);
        
        JLabel gender = new JLabel ("Gender:");
        gender.setFont (new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(60 ,250 , 400 , 30 );
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300 , 250 ,60 ,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
       
        
        female = new JRadioButton("Female");
        female.setBounds(450 ,250 ,90 ,30);
        female.setBackground(Color.WHITE);
        add(female);
        gendergroup.add(female);
         
        JLabel email = new JLabel ("Email Address:");
        email.setFont (new Font("Raleway", Font.BOLD, 18));
        email.setBounds (60 , 300 , 400 , 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font ("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 300, 300 ,30);
        add(emailTextField);
        
        JLabel maritialstatus = new JLabel ("Marital Status:");
        maritialstatus.setFont (new Font ("Raleway", Font.BOLD, 18));
        maritialstatus.setBounds (60 ,350, 400 , 30);
        add(maritialstatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300 , 350 ,90 ,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        ButtonGroup maritialgroup = new ButtonGroup();
        maritialgroup.add(married);
       
        
        unmarried = new JRadioButton("Umarried");
        unmarried.setBounds(400 ,350 ,90 ,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        maritialgroup.add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(500 ,350 ,90 ,30);
        other.setBackground(Color.WHITE);
        add(other);
        maritialgroup.add(other);
     
        JLabel Address = new JLabel ("Address:");
        Address.setFont (new Font("Raleway", Font.BOLD, 18));
        Address.setBounds (60 , 400 , 200 , 30);
        add(Address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font ("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 400, 300 ,30);
        add(addressTextField);
        
        JLabel city = new JLabel ("City:");
        city.setFont (new Font("Raleway", Font.BOLD, 18));
        city.setBounds (60 , 450 , 200 , 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font ("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 450, 300 ,30);
        add(cityTextField);
        
        JLabel state = new JLabel ("State:");
        state.setFont (new Font("Raleway", Font.BOLD, 18));
        state.setBounds (60 , 500 , 200 , 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font ("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 500, 300 ,30);
        add(stateTextField);
        
        JLabel pincode= new JLabel ("Pin Code:");
        pincode.setFont (new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds (60 , 550 , 200 , 30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font ("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 550, 300 ,30);
        add(pinTextField);
        
        nextt = new JButton("Next");
        nextt.setBackground(Color.BLACK);
        nextt.setForeground(Color.WHITE);
        nextt.setFont (new Font("Raleway", Font.BOLD, 14));
        nextt.setBounds(300 ,600 ,  300 , 30);
        nextt.addActionListener(this);
        add(nextt);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize (800, 700);
        setLocation(250, 10);
        setVisible(true);
    }
 
    public void actionPerformed (ActionEvent ae){
        String formno = "" + random; // long
        String name = nameTextField.getText(); // setText
        String fname = fnameTextField.getText(); //
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String maritial = null;
        if (unmarried.isSelected()){
            maritial = "single";
        }else if (married.isSelected()){
            maritial = "married";
        }else if (other.isSelected()){
            maritial = "other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } 
            if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father Name is Required");
            }if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "DOB is Required");
            } if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "ADDRESS is Required");
            } if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "CITY is Required");
            } if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "STATE is Required");
            } if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "PIN is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"', '"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);  
            
              setVisible(false);
              new SignupTwo(formno).setVisible(true);
        
    }
        } catch (Exception e) {
            System.out.println(e);
        }
        
      
    }
    
    private com.toedter.calendar.JCalendar jCalendar1;
    public static void main(String args[]) {
        new SignupOne();
    }
}
