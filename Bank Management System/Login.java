import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,signUp,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login() {                  // creating constructor of Login class.
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2  = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text  = new JLabel("WELCOME TO IBS ATM");
        text.setFont(new Font("Osward",Font.BOLD,50));
        text.setBounds(300,40,700,40);
        add(text);


        JLabel CardNo  = new JLabel("CARD NO: ");
        CardNo.setFont(new Font("Raleway",Font.BOLD,26));
        CardNo.setBounds(120,150,150,30);
        add(CardNo);

        // creating card text field...........
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cardTextField);

        JLabel Pin  = new JLabel("PIN :");
        Pin.setFont(new Font("Raleway",Font.BOLD,26));
        Pin.setBounds(120,200,150,30);
        add(Pin);

        // creating pin text field...........
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,200,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(pinTextField);

        //creating button
        login  = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear  = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp  = new JButton("SIGN UP");
        signUp.setBounds(300,350,250,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);

        // getContentPane() --------- it will select the entire frame
        //setBackground (color : ) ------it is used by getContentPane to set the background co;our of frame
        getContentPane().setBackground(Color.pink);

        setSize(1000,500); // giving the size of the frame.
        setVisible(true);   // setVisible is used for displaying the frame by default it is hidden from the user.
        setLocation(250,150);  // by default frame will open at top left corner by using setLocation we can describe its position

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        }else if(ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";

            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception e) {
                System.out.println(e);
            }


        }else if(ae.getSource() == signUp) {
            setVisible(false);
            new SignUpOne().setVisible(true);

        }
    }

    public static void main(String[] args) {

        new Login();
    }

}
