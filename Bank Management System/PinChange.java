import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    String pinNumber;
    JButton change,back;
    JPasswordField rePinText,newPinText;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        JLabel newPin = new JLabel("ENTER NEW PIN");
        newPin.setBounds(165,320,180,25);
        newPin.setForeground(Color.white);
        newPin.setFont(new Font("System",Font.BOLD,16));
        image.add(newPin);

        newPinText = new JPasswordField();
        newPinText.setFont(new Font("Raleway",Font.BOLD,25));
        newPinText.setBounds(330,320,180,25);
        image.add(newPinText);

        JLabel rePin = new JLabel("RE-ENTER NEW PIN");
        rePin.setBounds(165,360,180,25);
        rePin.setForeground(Color.white);
        rePin.setFont(new Font("System",Font.BOLD,16));
        image.add(rePin);

        rePinText = new JPasswordField();
        rePinText.setFont(new Font("Raleway",Font.BOLD,25));
        rePinText.setBounds(330,360,180,25);
        image.add(rePinText);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {
            try{
                String npin = newPinText.getText();
                String rpin = rePinText.getText();

                if(npin.equals("")) {
                    JOptionPane.showMessageDialog(null," Please Entered new Pin ");
                    return;
                }
                if(rpin.equals("")) {
                    JOptionPane.showMessageDialog(null," Please Re-Entered new Pin ");
                    return;
                }
                if(!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null," Entered Pin does not match ");
                    return;
                }
                else {
                    Conn conn = new Conn();
                    String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinNumber + "'";
                    String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinNumber + "'";
                    String query3 = "update signUpThree set pinNumber = '" + rpin + "' where pinNumber = '" + pinNumber + "'";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);
                }

            }catch(Exception e) {
                System.out.println(e);
            }
        } else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}

