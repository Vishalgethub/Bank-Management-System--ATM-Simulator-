package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.*;


public class BalanceEnquiry  extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber) {
         this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(330, 450, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn(); 
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = ('"+pinnumber+"'");
            while(rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your Current Account balance is Rs " +balance);
        text.setForeground(Color.WHITE);
        text.setBounds(150, 250, 300, 30);
        image.add(text);
        
        setSize (800, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transacations(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
    
}
