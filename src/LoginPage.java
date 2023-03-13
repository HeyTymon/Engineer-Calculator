import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Stack;

public class LoginPage implements ActionListener
{
    JFrame page = new JFrame();
    JLabel titleLabel = new JLabel("Welcome to the engineer calculator made by Tymon Jastrzębski");
    JLabel infoTextLabel = new JLabel();
    JLabel userLoginLabel = new JLabel("Login: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField userLoginField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Sing in");
    HashMap<String,String> userData;

    String userLogin, password;

    LoginPage(HashMap<String,String> userData)
    {
        this.userData = userData;

        titleLabel.setBounds(35,0,415,35);
        titleLabel.setFont(new Font(null,Font.BOLD,12));
        infoTextLabel.setBounds(35,100,300,20);
        infoTextLabel.setFont(new Font(null,Font.ITALIC,12));

        userLoginLabel.setBounds(35,45,100,15);
        passwordLabel.setBounds(35,70,100,15);

        userLoginField.setBounds(100,45,100,20);
        passwordField.setBounds(100,70,100,20);

        loginButton.setBounds(210,45,100,44);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        page.add(titleLabel);
        page.add(userLoginLabel);
        page.add(passwordLabel);
        page.add(userLoginField);
        page.add(passwordField);
        page.add(infoTextLabel);
        page.add(loginButton);

        page.setTitle("InQk Calculator - Login Page");
        page.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        page.setResizable(false);
        page.setSize(450,180);
        page.setLayout(null);
        page.setVisible(true);
    }

    protected String getUserLogin()
    {
        return userLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==loginButton)
        {
            userLogin = userLoginField.getText();
            password = String.valueOf(passwordField.getPassword());

            if(userData.containsKey(userLogin))
            {
                if(userData.get(userLogin).equals(password))
                {
                    infoTextLabel.setForeground(Color.green);
                    infoTextLabel.setText("Login successful");
                    new MainPage(getUserLogin());
                    page.dispose();
                }
                else
                {
                    userLoginField.setText("");
                    passwordField.setText("");
                    infoTextLabel.setForeground(Color.red);
                    infoTextLabel.setText("Wrong user login or password");
                }
            }
            else
            {
                userLoginField.setText("");
                passwordField.setText("");
                infoTextLabel.setForeground(Color.red);
                infoTextLabel.setText("Wrong user login or password");
            }

        }
    }
}
