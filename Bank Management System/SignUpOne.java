import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener  {
    long random;
    JTextField nameTextField,fnameTextField,birthTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male,female,unmarried,married,others;
    SignUpOne(){
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel PersonalDetails = new JLabel("Page 1 : Personal Details");
        PersonalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        PersonalDetails.setBounds(300,80,400,30);
        add(PersonalDetails);

        // name........
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,150,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,150,400,30);
        add(nameTextField);

        // father name......
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,200,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,200,400,30);
        add(fnameTextField);

        //date of birth...
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,250,200,30);
        add(dob);


        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Raleway",Font.BOLD,14));
        dateChooser.setBounds(300,250,400,30);
        add(dateChooser);

        // gender..........
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,300,200,30);
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(300,300,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(450,300,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // email...........
        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,350,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,350,400,30);
        add(emailTextField);

        // married..............
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,400,200,30);
        add(marital);

        married = new JRadioButton("MARRIED");
        married.setBounds(300,400,120,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,400,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        others = new JRadioButton("OTHERS");
        others.setBounds(590,400,120,30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup MaritalStatus = new ButtonGroup();
        MaritalStatus.add(married);
        MaritalStatus.add(unmarried);
        MaritalStatus.add(others);

        // address.........
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,450,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,450,400,30);
        add(addressTextField);

        //city..........
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,500,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,500,400,30);
        add(cityTextField);

        // state.....
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,550,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,550,400,30);
        add(stateTextField);

        //pin code................
        JLabel pincode = new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,600,200,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,600,400,30);
        add(pinTextField);

        next = new JButton("NEXT");
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String formNo = ""+ random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        //String dob = birthTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }
            else if(female.isSelected()){
                gender = "Female";
            }
        String email = emailTextField.getText();
        String  marital = null;
            if(married.isSelected()) {
                marital = "Married";
            }
            else if(unmarried.isSelected()) {
                marital = "Unmarried";
            } else if (others.isSelected()) {
                marital = "Others";
            }
        String address =  addressTextField.getText();
        String state =  stateTextField.getText();
        String city =  cityTextField.getText();
        String pincode =  pinTextField.getText();


        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else {
                Conn c = new Conn();
                String query = "insert into signUp values(' " + formNo +" ',' " + name +" ',' " + fname +" ',' " + dob +" ',' " + gender +" ',' " + email +" ',' " + marital +" ',' " + address +" ',' " + state +" ',' " + city +" ',' " + pincode +" ')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
