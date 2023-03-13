import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegularCalculatorPage implements ActionListener
{
    JFrame page = new JFrame();
    JPanel panel = new JPanel();
    JTextField textField = new JTextField("0");
    JButton[] numberButtons = new JButton[10];
    JButton sumButton = new JButton("+"),
            diffButton = new JButton("-"),
            mulButton = new JButton("*"),
            divButton = new JButton("÷"),
            commaButton = new JButton(","),
            powButton = new JButton("x^2"),
            sqrtButton = new JButton("√x"),
            fractionButton = new JButton("1/x"),
            signButton = new JButton("+/-"),
            equalsButton = new JButton("="),

            clearButton = new JButton("C");

    JButton[] functionButtons = {sumButton,diffButton,commaButton,divButton,equalsButton,mulButton,powButton,sqrtButton,fractionButton,signButton};
    JButton saveButton = new JButton("Save");
    JButton backButton = new JButton("Back");

    double x1 = 0, x2 = 0, ans = 0;
    String operation = "";

    File valueFile = new File("values.txt");

    String userLogin;

    RegularCalculatorPage(String userLogin)
    {
        this.userLogin = userLogin;

        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        textField.setFont(new Font(Font.DIALOG,  Font.BOLD, 25));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5,4,10,10));

        saveButton.setBounds(50,445,300,25);
        saveButton.addActionListener(this);
        backButton.setBounds(50,475,300,25);
        backButton.addActionListener(this);
        clearButton.setBounds(50,415,300,25);
        clearButton.addActionListener(this);

        for(int i = 0; i<10; i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        for(int i = 0; i<functionButtons.length; i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        //Row 1
        panel.add(fractionButton);
        panel.add(powButton);
        panel.add(sqrtButton);
        panel.add(divButton);

        //Row 2
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        //Row 3
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(diffButton);

        //Row 4
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(sumButton);

        //Row 5
        panel.add(signButton);
        panel.add(numberButtons[0]);
        panel.add(commaButton);
        panel.add(equalsButton);

        page.add(textField);
        page.add(panel);
        page.add(clearButton);
        page.add(saveButton);
        page.add(backButton);

        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setSize(400,600);
        page.setResizable(false);
        page.setLayout(null);
        page.setVisible(true);
    }

    public static void main(String[] args) {
        new RegularCalculatorPage("admin");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++)
        {
            if(e.getSource() == numberButtons[i])
            {
                if((textField.getText()).equals("0"))
                {
                    textField.setText("");
                    textField.setText(String.valueOf(i));
                }
                else
                {
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                }
            }
        }

        if(e.getSource() == sumButton)
        {
            x1 = Double.valueOf(textField.getText());
            operation = "+";
            textField.setText("");
        }

        if(e.getSource() == diffButton)
        {
            x1 = Double.valueOf(textField.getText());
            operation = "-";
            textField.setText("");
        }

        if(e.getSource() == mulButton)
        {
            x1 = Double.valueOf(textField.getText());
            operation = "*";
            textField.setText("");
        }

        if(e.getSource() == divButton)
        {
            x1 = Double.valueOf(textField.getText());
            operation = "÷";
            textField.setText("");
        }

        if(e.getSource() == powButton)
        {
            x1 = Double.valueOf(textField.getText());
            x1 = Math.pow(x1,2);
            textField.setText(String.valueOf(x1));
        }

        if(e.getSource() == sqrtButton)
        {
            x1 = Double.valueOf(textField.getText());
            x1 = Math.sqrt(x1);
            textField.setText(String.valueOf(x1));
        }

        if(e.getSource() == fractionButton)
        {
            x1 = Double.valueOf(textField.getText());
            x1 = 1/x1;
            textField.setText(String.valueOf(x1));
        }

        if(e.getSource() == equalsButton)
        {
            x2 = Double.valueOf(textField.getText());

            switch(operation)
            {
                case "+":
                {
                    ans = x1 + x2;
                }
                break;

                case "-":
                {
                    ans = x1 - x2;
                }
                break;

                case "*":
                {
                    ans = x1 * x2;
                }
                break;

                case "/":
                {
                    ans = x1 / x2;
                }
                break;
            }

            textField.setText(String.valueOf(ans));
        }

        if(e.getSource() == signButton)
        {
            x1 = Double.valueOf(textField.getText());
            x1 *= -1;
            textField.setText(String.valueOf(x1));
        }

        if(e.getSource() == clearButton)
        {
            textField.setText("0");
            x1 = 0;
        }

        if(e.getSource() == saveButton)
        {
            try {
                FileWriter writer = new FileWriter(valueFile,true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.append(textField.getText() + "\n");
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


