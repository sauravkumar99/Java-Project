import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {
    JButton next;
    JComboBox religionBox,categoryBox,incomeBox,eduBox,occupationBox;
    JRadioButton yes,no,e_no,e_yes;
    JTextField aadharTextField,panTextField;
    String formNo;
    SignUpTwo(String formNo){
        this.formNo = formNo;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        JLabel additionalDetails = new JLabel("PAGE 2 : ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,25));
        additionalDetails.setBounds(300,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("RELIGION");
        religion.setFont(new Font("Raleway",Font.BOLD,25));
        religion.setBounds(100,140,400,30);
        add(religion);

        String []religionVal = {"Hindu","Muslim","Sikh","Christian","Others"};
        religionBox = new JComboBox(religionVal);
        religionBox.setBounds(300,140,400,30);
        religionBox.setBackground(Color.white);
        add(religionBox);

        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway",Font.BOLD,25));
        category.setBounds(100,190,400,30);
        add(category);

        String [] categoryVal = {"General","OBC","ST","SC","Others"};
        categoryBox = new JComboBox(categoryVal);
        categoryBox.setBounds(300,190,400,30);
        categoryBox.setBackground(Color.white);
        add(categoryBox);

        JLabel income = new JLabel("Income");
        income.setFont(new Font("Raleway",Font.BOLD,25));
        income.setBounds(100,240,400,30);
        add(income);

        String [] incomeVal = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        incomeBox = new JComboBox(incomeVal);
        incomeBox.setBounds(300,240,400,30);
        incomeBox.setBackground(Color.white);
        add(incomeBox);

        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,25));
        education.setBounds(100,290,400,30);
        add(education);

        String[] eduVal = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        eduBox = new JComboBox(eduVal);
        eduBox.setBounds(300,290,400,30);
        eduBox.setBackground(Color.white);
        add(eduBox);

        JLabel qualification = new JLabel("Qualification");
        qualification.setFont(new Font("Raleway",Font.BOLD,25));
        qualification.setBounds(100,340,400,30);
        add(qualification);

        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway",Font.BOLD,25));
        occupation.setBounds(100,390,400,30);
        add(occupation);

        String [] occupationVal = {"Salaried","Self-employed","Business","Student","Retired"};
        occupationBox = new JComboBox(occupationVal);
        occupationBox.setBounds(300,390,400,30);
        occupationBox.setBackground(Color.white);
        add(occupationBox);

        JLabel panNumber = new JLabel("Pan_Number");
        panNumber.setFont(new Font("Raleway",Font.BOLD,25));
        panNumber.setBounds(100,440,400,30);
        add(panNumber);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel aadharNumber = new JLabel("Aadhar Number");
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,25));
        aadharNumber.setBounds(100,490,400,30);
        add(aadharNumber);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("SeniorCitizen ");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,25));
        seniorCitizen.setBounds(100,540,400,30);
        add(seniorCitizen);

        yes = new JRadioButton("YES");
        yes.setBounds(300,540,120,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("NO");
        no.setBounds(450,540,120,30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup seniorCitizenStatus = new ButtonGroup();
        seniorCitizenStatus.add(yes);
        seniorCitizenStatus.add(no);

        JLabel existingAcc = new JLabel("ExistingAccount ");
        existingAcc.setFont(new Font("Raleway",Font.BOLD,25));
        existingAcc.setBounds(100,590,400,30);
        add(existingAcc);

        e_yes = new JRadioButton("YES");
        e_yes.setBounds(300,590,120,30);
        e_yes.setBackground(Color.WHITE);
        add(e_yes);

        e_no = new JRadioButton("NO");
        e_no.setBounds(450,590,120,30);
        e_no.setBackground(Color.WHITE);
        add(e_no);

        ButtonGroup existingAccStatus = new ButtonGroup();
        existingAccStatus.add(e_yes);
        existingAccStatus.add(e_no);


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
        String religion = (String)religionBox.getSelectedItem();
        String category = (String)categoryBox.getSelectedItem();
        String income = (String)incomeBox.getSelectedItem();
        String education = (String)eduBox.getSelectedItem();
        String  occupation = (String)occupationBox.getSelectedItem();
        String panNumber =  panTextField.getText();
        String aadharNumber =  aadharTextField.getText();
        String seniorCitizen = null;
        if(yes.isSelected()) {
            seniorCitizen = "Yes";
        }
        else if(no.isSelected()) {
            seniorCitizen = "No";
        }
        String existingAcc = null;
        if(e_yes.isSelected()) {
            existingAcc = "Yes";
        }
        else if(e_no.isSelected()) {
            existingAcc = "No";
        }


        try {
            Conn c = new Conn();
            String query = "insert into signUpTwo values(' " + formNo +" ',' " + religion +" ',' " + category +" ',' " + income +" ',' " + education +" ',' " + occupation +" ',' " + panNumber +" ',' " + aadharNumber +" ',' " + seniorCitizen +" ',' " + existingAcc +" ')";
            c.s.executeUpdate(query);

            setVisible(false);
            new signupThree(formNo).setVisible(true);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}