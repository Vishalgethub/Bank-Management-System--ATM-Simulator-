package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    String formno;
 
    Login(String formno) {
        
        this.formno = formno;
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 650);
        add(image);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(140 , 300 , 400 , 40 );
        text.setForeground(Color.WHITE);
        image.add(text);
         
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(140 , 350 ,250, 30);
        cardno.setForeground(Color.WHITE);
        image.add(cardno);
        
        cardTextField = new JTextField ();
        cardTextField.setBounds(240, 350, 200, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        image.add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(180 , 390 , 290 , 30 );
        pin.setForeground(Color.WHITE);
        image.add(pin);   

        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(240, 390, 200, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        image.add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(240, 430, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image.add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(340, 430, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        image.add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(240, 470, 200, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        image.add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize (800, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == clear) {
        cardTextField.setText("");
        pinTextField.setText("");
    } else if (ae.getSource() == login){
        Conn conn = new Conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
        try {
           ResultSet rs = conn.s.executeQuery(query);
           if (rs.next()){
               setVisible(false);
               new Transacations(pinnumber).setVisible(true);
           } else {
               JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
           }
        }catch(Exception e) {
            System.out.println(e);
        }
    } else if (ae.getSource() == signup){
        setVisible(false);
        new SignupOne().setVisible(true);   
        }
    }
    
public static void main(String args[]){
    new Login("");
    
}    
}
