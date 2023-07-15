import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signupThree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formNo ;
    signupThree(String formNo) {
        this.formNo = formNo;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,30));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,120,200,40);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,150,20);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,15));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,250,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,15));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel cNumber = new JLabel("XXXX-XXXX-XXXX-XXXX-1234");
        cNumber.setFont(new Font("Raleway",Font.BOLD,20));
        cNumber.setBounds(330,300,300,30);
        add(cNumber);

        JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,330,300,20);
        add(cardDetails);

        JLabel Pin = new JLabel("PIN : ");
        Pin.setFont(new Font("Raleway",Font.BOLD,20));
        Pin.setBounds(100,370,200,30);
        add(Pin);

        JLabel pNumber = new JLabel("XXXX");
        pNumber.setFont(new Font("Raleway",Font.BOLD,20));
        pNumber.setBounds(330,370,300,30);
        add(pNumber);

        JLabel pinDetails = new JLabel("Your 4 Digit Pin Number");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100,400,300,20);
        add(pinDetails);

        JLabel services = new JLabel("Service Required");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(100,450,200,30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        c2.setBounds(400,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        c4.setBounds(400,550,200,30);
        add(c4);

        c5 = new JCheckBox("ChequeBook");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        c6.setBounds(400,600,200,30);
        add(c6);

        c7 = new JCheckBox("I here by declares the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,650,600,30);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(200,700,200,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(500,700,200,30);
        cancel.addActionListener(this);
        add(cancel);


        // creating frame
        getContentPane().setBackground(Color.WHITE);

        setSize(900,850);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String accountType = null;
            if(r1.isSelected()) {
                accountType = "Saving AAccount";
            }
            else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            }
            else if (r3.isSelected()) {
                accountType = "Current Account";
            }
            else if (r4.isSelected()) {
                accountType = "Reccuring Deposit Account";
            }
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String PinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected()) {
                facility += "ATM CARD";
            } else if (c2.isSelected()) {
                facility += " Internet Banking";
            } else if (c3.isSelected()) {
                facility += " Mobile Banking";
            } else if (c4.isSelected()) {
                facility += " EMAILS & SMS ALERT";
            } else if (c5.isSelected()) {
                facility += " Cheque Book";
            } else if (c6.isSelected()) {
                facility += " E-Statement";
            }
            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }else {
                    Conn connection = new Conn();
                    String query1 = "insert into signUpThree values('"+formNo+"','"+accountType+"','"+ cardNumber+"','"+PinNumber+"','"+facility+"')";
                    String query2 = "insert into Login values('"+formNo+"','"+ cardNumber+"','"+ PinNumber+"')";
                    connection.s.executeUpdate(query1);
                    connection.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"CARD NUMBER :" + cardNumber +"\n Pin :" + PinNumber);

                    setVisible(false);
                    new Deposit(PinNumber).setVisible(true);


                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new signupThree("");
    }
}
