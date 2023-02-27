package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
    
    JButton back, change;
    JPasswordField pin , repin;
    String pinnumber;
    
    PinChange (String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel ("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD, 16));
        text.setBounds(220, 240, 500, 30);
        image.add(text);
        
        JLabel pintext = new JLabel ("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD, 16));
        pintext.setBounds(170, 280, 100, 30);
        image.add(pintext);
        
        JLabel repintext = new JLabel ("Re-Enter PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway",Font.BOLD, 16));
        repintext.setBounds(170, 320, 130, 30);
        image.add(repintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,35));
        pin.setBounds(330, 280, 100, 30);
        image.add(pin);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,35));
        repin.setBounds(330, 320, 100, 30);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(170, 420, 100, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(330, 420, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize (800, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change ){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter PIN");
                }
                
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter new PIN");
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transacations(rpin).setVisible(true);
                
            } catch (Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transacations(pinnumber).setVisible(true);
    }
    }
    public static void main (String args[]) {
    new PinChange("").setVisible(true);
    }
}
