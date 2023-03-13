import javax.accessibility.AccessibleIcon;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage implements ActionListener
{
    JFrame page = new JFrame("Main page");
    JLabel titleLabel = new JLabel("Choose a calculator you want to use");
    JButton inqkButton = new JButton("InQk Calculator");
    JButton saveUserButton = new JButton("Save user");
    JButton calculatorButton = new JButton("Calculator");
    JButton unitButton = new JButton("Unit Calculator");
    private String userLogin;
    MainPage(String userLogin)
    {
        this.userLogin = userLogin;
        titleLabel.setBounds(85,15,250,31);

        calculatorButton.setBounds(50,50,125,35);
        calculatorButton.setFocusable(false);
        calculatorButton.addActionListener(this);
        inqkButton.setBounds(195,50,125,35);
        inqkButton.setFocusable(false);
        inqkButton.addActionListener(this);
        unitButton.setBounds(50,100,125,35);
        unitButton.setFocusable(false);
        unitButton.addActionListener(this);
        saveUserButton.setBounds(195,100,125,35);
        saveUserButton.setFocusable(false);
        saveUserButton.addActionListener(this);

        page.add(titleLabel);
        page.add(calculatorButton);
        page.add(inqkButton);
        page.add(unitButton);
        page.add(saveUserButton);

        page.setSize(385,200);
        page.setLayout(null);
        page.setResizable(false);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setVisible(true);

    }

    public static void main(String[] args) {
        new MainPage("admin");
    }

    public String getUserLogin()
    {
        return userLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calculatorButton)
        {
            new RegularCalculatorPage(getUserLogin());
            page.dispose();
        }

        if(e.getSource() == inqkButton)
        {
            new CalculatorPage(getUserLogin());
            page.dispose();
        }

        if(e.getSource() == saveUserButton)
        {
            if(userLogin.equals("admin"))
            {
                new SavePage(getUserLogin());
                page.dispose();
            }
            else
            {
                titleLabel.setText("You must be admin to create new user!");
            }
        }

        if(e.getSource() == unitButton)
        {
            new UnitPage(getUserLogin());
            page.dispose();
        }
    }
}
