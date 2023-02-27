package bank.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
  JTextField panno, aadhar;
  JButton next;
  JRadioButton syes,sno,eyes,eno;
  JComboBox religion, category, occupation, education,income;
  String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
        JLabel addtionalDetails = new JLabel("Page 1: Additional Details");
        addtionalDetails.setFont(new Font("Raleway", Font.BOLD, 18));
        addtionalDetails.setBounds (230, 20 , 400 , 30);
        add(addtionalDetails);
        
        JLabel name = new JLabel ("Relegion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds (60 , 100 , 200 , 30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBackground(Color.WHITE);
        religion.setFont(new Font ("Raleway", Font.BOLD, 14));
        religion.setBounds(300, 100, 300 ,30);
        add(religion);
        
        
        JLabel categoryy = new JLabel ("Category: ");
        categoryy.setFont (new Font("Raleway", Font.BOLD, 18));
        categoryy.setBounds(60 , 150 , 200 , 30);
        add(categoryy);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setBackground(Color.WHITE);
        category.setFont(new Font ("Raleway", Font.BOLD, 14));
        category.setBounds(300, 150, 300 ,30);
        add(category);
        
        JLabel dateofbirth = new JLabel ("Income");
        dateofbirth.setFont (new Font("Raleway", Font.BOLD, 18));
        dateofbirth.setBounds(60 , 200 , 200 ,30);
        add(dateofbirth);
        
        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000","< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBackground(Color.WHITE);
        income.setFont(new Font ("Raleway", Font.BOLD, 14));
        income.setBounds(300, 200, 300 ,30);
        add(income);
        
        JLabel qualification = new JLabel ("Qualification:");
        qualification.setFont (new Font("Raleway", Font.BOLD, 18));
        qualification.setBounds(60 ,250 , 400 , 30 );
        add(qualification);
        
        String educationalValues[] = {"Non-Graduational", "Post-Graduation", "Docate", "Other"};
        education = new JComboBox(educationalValues);
        education.setBackground(Color.WHITE);
        education.setFont(new Font ("Raleway", Font.BOLD, 14));
        education.setBounds(300, 250, 300 ,30);
        add(education);
        
        JLabel occuption = new JLabel ("Occuption:");
        occuption.setFont (new Font ("Raleway", Font.BOLD, 18));
        occuption.setBounds (60 ,300, 400 , 30);
        add(occuption);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student","Retied","Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBackground(Color.WHITE);
        occupation.setFont(new Font ("Raleway", Font.BOLD, 14));
        occupation.setBounds(300, 300, 300 ,30);
        add(occupation);
     
        JLabel pan = new JLabel ("Pan no:");
        pan.setFont (new Font("Raleway", Font.BOLD, 18));
        pan.setBounds (60 , 350 , 200 , 30);
        add(pan);
        
        panno = new JTextField();
        panno.setFont(new Font ("Raleway", Font.BOLD, 14));
        panno.setBounds(300, 350, 300 ,30);
        add(panno);
        
        JLabel addhar = new JLabel ("Addhar no:");
        addhar.setFont (new Font("Raleway", Font.BOLD, 18));
        addhar.setBounds (60 , 400 , 200 , 30);
        add(addhar);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font ("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 400, 300 ,30);
        add(aadhar);
        
        JLabel seniorcitizen = new JLabel ("Senior Citizen:");
        seniorcitizen.setFont (new Font("Raleway", Font.BOLD, 18));
        seniorcitizen.setBounds (60 , 450 , 200 , 30);
        add(seniorcitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 450, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(400, 450, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup gsenior = new ButtonGroup();
        gsenior.add(syes);
        gsenior.add(sno);                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        
        JLabel eaccount = new JLabel ("Existing account:");
        eaccount.setFont (new Font("Raleway", Font.BOLD, 18));
        eaccount.setBounds (60 , 500 , 200 , 30);
        add(eaccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 500, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(400, 500, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
                
        ButtonGroup eacc = new ButtonGroup();
        eacc.add(eyes);
        eacc.add(eno);                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont (new Font("Raleway", Font.BOLD, 14));
        next.setBounds(200 ,550 , 100 , 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize (800, 700);
        setLocation(250, 10);
        setVisible(true);
    }
 
    public void actionPerformed (ActionEvent ae){
       
        String sreligion = (String)religion.getSelectedItem();  // setText
        String scategory = (String)category.getSelectedItem(); //
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "Yes";
        } else if (sno.isSelected()){
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount = "Yes";
        }else if (eno.isSelected()){
            existingaccount = "No";
       }
        String spanno = panno.getText();
        String saadhar = aadhar.getText();
        
        
        try{
            if (sreligion.equals("")) {
                JOptionPane.showMessageDialog(null, "Religion is Required");
            } 
            if (scategory.equals("")) {
                JOptionPane.showMessageDialog(null, "Category is Required");
            }if (sincome.equals("")) {
                JOptionPane.showMessageDialog(null, "Income is Required");
            } if (seducation.equals("")) {
                JOptionPane.showMessageDialog(null, "Education is Required");
            } if (soccupation.equals("")) {
                JOptionPane.showMessageDialog(null, "Occupation is Required");
            } if (spanno.equals("")) {
                JOptionPane.showMessageDialog(null, "Panno is Required");
            } if (saadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar is Required");
            }
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+spanno+"','"+saadhar+"', '"+existingaccount+"','"+seniorcitizen+"')";
                c.s.executeUpdate(query); 
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
