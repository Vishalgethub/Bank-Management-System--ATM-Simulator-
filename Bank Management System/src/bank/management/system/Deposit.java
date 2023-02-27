package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener {
    
        JTextField amount;
        JButton deposit, back;
        String pinnumber;
        
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel ("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(150, 250, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        amount.setBounds(160, 280, 250, 25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(340, 400, 110, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
       back = new JButton("Back");
       back.setBounds(340, 450, 110, 30);
       back.addActionListener(this);
       image.add(back); 
        
        setSize (800, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else {
                try{
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','"+"deposit"+"','"+number+"')";
                conn.s.executeUpdate(query);   
              JOptionPane.showMessageDialog(null,"Rs "+number+"Deposited Succesfully");
              setVisible (false);
              new Transacations(pinnumber).setVisible(true);
            }catch (Exception e){
                        System.out.println(e);
                        } 
            }
        } else if (ae.getSource() == back){
            setVisible (false);
            new Transacations(pinnumber).setVisible(true);
                }
        }
    
    
    public static void main (String args[]){
        new Deposit("");
    }
}
