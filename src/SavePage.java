import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SavePage implements ActionListener
{
    JFrame page = new JFrame();
    JLabel titleLabel = new JLabel("Creat new user");
    JLabel infoTextLabel = new JLabel();
    JLabel userLoginLabel = new JLabel("Login: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextField userLoginField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton saveButton = new JButton("Save");

    JButton backButton = new JButton("Back");

    File dataFile = new File("data.txt");

    String userLogin;

    SavePage(String userLogin)
    {
        this.userLogin = userLogin;

        titleLabel.setBounds(35,0,415,35);
        titleLabel.setFont(new Font(null,Font.BOLD,12));
        infoTextLabel.setBounds(35,100,300,20);
        infoTextLabel.setFont(new Font(null,Font.ITALIC,12));

        userLoginLabel.setBounds(35,45,100,15);
        passwordLabel.setBounds(35,70,100,15);

        userLoginField.setBounds(100,45,100,20);
        passwordField.setBounds(100,70,100,20);

        saveButton.setBounds(210,45,100,44);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);

        backButton.setBounds(35,100,275,20);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        page.add(titleLabel);
        page.add(userLoginLabel);
        page.add(passwordLabel);
        page.add(userLoginField);
        page.add(passwordField);
        page.add(infoTextLabel);
        page.add(saveButton);
        page.add(backButton);

        page.setSize(375,200);
        page.setLayout(null);
        page.setResizable(false);
        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==saveButton)
        {
            String login = userLoginField.getText();
            String password = String.valueOf(passwordField.getPassword());

            try {
                FileWriter writer = new FileWriter(dataFile,true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.append("\n"+login+"\n"+password);
                bufferedWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource()==backButton)
        {
            new MainPage(userLogin);
            page.dispose();
        }

    }
}
