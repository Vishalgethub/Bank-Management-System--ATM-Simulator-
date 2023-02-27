package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl , ministatement ,pinchange ,fastcash, balanceenquiry, exit;
    String pinnumber;
    
    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
    ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(800, 850, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 800, 800);
    add(image);
    
    JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
    text.setBounds(170, 250, 700, 35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    image.add(text);
    
    deposit = new JButton("Rs 100");
    deposit.setBounds(150, 300, 130, 30);
    deposit.addActionListener(this);
    image.add(deposit);
    
    withdrawl = new JButton("Rs 500");
    withdrawl.setBounds(300, 300, 130, 30);
    withdrawl.addActionListener(this);
    image.add(withdrawl);
    
    fastcash = new JButton("Rs 1000");
    fastcash.setBounds(150, 350, 130, 30);
    fastcash.addActionListener(this);
    image.add(fastcash);
    
    ministatement = new JButton("Rs 2000");
    ministatement.setBounds(300, 350, 130, 30);
    ministatement.addActionListener(this);
    image.add(ministatement);
    
    pinchange = new JButton("Rs 5000");
    pinchange.setBounds(150, 400, 130, 30);
    pinchange.addActionListener(this);
    image.add(pinchange);
    
    balanceenquiry = new JButton("Rs 10000");
    balanceenquiry.setBounds(300, 400, 130, 30);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);
    
        setSize (800, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    
    image.add(deposit);
    
        setSize (800, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transacations(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance = 0;
                while(rs.next()){
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficiant Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values ('"+pinnumber+"','"+date+"','"+"withdrawl"+"','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs" + amount + "Debited Succesfully");
                
                setVisible(false);
                new Transacations(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]) {
         new FastCash("");    
    }
}