import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CalculatorPage implements ActionListener
{
    int Qk;
    boolean U2 = false;
    int valueHex;
    double valueDec;
    String userLogin;

    JFrame page = new JFrame();
    JLabel titleLabel = new JLabel("Qn value ∈ (0,15), Dec value ∈ (-1,1), Hex value - 16 bits");
    JLabel qkLabel = new JLabel("Qn value: ");
    JLabel u2Label = new JLabel("U2");
    JLabel hexLabel = new JLabel("Hexadecimal value:");
    JLabel hexChceckBoxLabel = new JLabel("HEX");
    JLabel decLabel = new JLabel("Decimal value:");
    JLabel infoTextLabel = new JLabel();
    JTextField qkField =  new JTextField();
    JTextField hexField = new JTextField();
    JTextField decField = new JTextField();
    JCheckBox u2CheckBox = new JCheckBox();
    JCheckBox hexChceckBox = new JCheckBox();
    JButton calculateButton = new JButton("Calculate");
    JButton saveButton = new JButton("Save");
    JButton backButton = new JButton("Back");

    File valueFile = new File("values.txt");

    CalculatorPage(String userLogin)
    {
        this.userLogin = userLogin;
        System.out.println(userLogin);
        System.out.println(this.userLogin);

        titleLabel.setBounds(15,0,415,35);
        titleLabel.setFont(new Font(null,Font.BOLD,15));
        infoTextLabel.setBounds(35,240,220,15);
        infoTextLabel.setFont(new Font(null,Font.ITALIC,12));
        infoTextLabel.setForeground(Color.red);

        qkLabel.setBounds(35,45,100,15);
        u2Label.setBounds(35,70,100,15);
        hexChceckBoxLabel.setBounds(80,70,100,15);

        qkField.setBounds(100,45,100,20);
        u2CheckBox.setBounds(55,70,20,15);
        u2CheckBox.addActionListener(this);
        hexChceckBox.setBounds(110,70,20,15);
        hexChceckBox.addActionListener(this);

        decLabel.setBounds(35,100,120,15);
        hexLabel.setBounds(35,120,120,15);

        decField.setBounds(150,100,120,17);
        hexField.setBounds(150,120,120,17);
        hexField.setEnabled(false);

        calculateButton.setBounds(35,140,235,30);
        calculateButton.addActionListener(this);
        calculateButton.setFocusable(false);

        saveButton.setBounds(35,175,235,30);
        saveButton.addActionListener(this);
        saveButton.setFocusable(false);

        backButton.setBounds(35,210,235,30);
        backButton.addActionListener(this);
        backButton.setFocusable(false);

        page.add(titleLabel);
        page.add(infoTextLabel);
        page.add(qkLabel);
        page.add(u2Label);
        page.add(hexChceckBoxLabel);
        page.add(qkField);
        page.add(u2CheckBox);
        page.add(hexChceckBox);
        page.add(decLabel);
        page.add(hexLabel);
        page.add(decField);
        page.add(hexField);
        page.add(calculateButton);
        page.add(saveButton);
        page.add(backButton);

        page.setTitle("InQk Calculator");
        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setLayout(null);
        page.setSize(450,400);
        page.setResizable(false);
        page.setVisible(true);
    }

    int decToHex()
    {
        int ans = (int)Math.round(valueDec*Math.pow(2,Qk));
        hexField.setText("0x" + (Integer.toHexString(ans)).toUpperCase());
        return ans;
    }

    int decToHexU2()
    {
        int ans = (int)Math.round(valueDec*Math.pow(2,Qk)) + (int)Math.pow(2,16);
        hexField.setText("0x" + (Integer.toHexString(ans)).toUpperCase());
        return ans;
    }

    double hexToDec()
    {
        double ans = valueHex/(Math.pow(2,Qk));
        decField.setText(Double.toString(ans));
        return ans;
    }

    double hexToDecU2()
    {
        double ans = (valueHex - Math.pow(2,16))/(Math.pow(2,Qk));
        decField.setText(Double.toString(ans));
        return 0;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==hexChceckBox)
        {
            if(hexChceckBox.isSelected())
            {
                hexField.setEnabled(true);
                decField.setEnabled(false);
                decField.setText("");
            }
            else
            {
                decField.setEnabled(true);
                hexField.setEnabled(false);
                hexField.setText("");
            }
        }

        if(e.getSource()==u2CheckBox)
        {
            u2CheckBox.setSelected(!U2);
            U2 = u2CheckBox.isSelected();
        }

        if(e.getSource()==calculateButton)
        {
            Qk = Integer.valueOf(qkField.getText());
            if(Qk < 0 || Qk > 15)
            {

                infoTextLabel.setText("Wrong Qk value!");
            }
            else
            {
                infoTextLabel.setText("");

                if(hexChceckBox.isSelected())
                {
                    String value = hexField.getText().substring(2);
                    valueHex =  Integer.parseInt(value,16);

                    if(u2CheckBox.isSelected())
                    {
                        hexToDecU2();
                    }
                    else
                    {
                        hexToDec();
                    }
                }
                else
                {
                    valueDec = Double.valueOf(decField.getText());

                    if (valueDec >= 1 || valueDec <= -1)
                    {

                        infoTextLabel.setText("Wrong decimal value!");
                    }
                    else
                    {
                        infoTextLabel.setText("");

                        if(valueDec>0)
                        {
                            decToHex();
                        }
                        else
                        {
                            decToHexU2();
                        }
                    }
                }
            }
        }

        if(e.getSource()==backButton)
        {
            new MainPage(userLogin);
            page.dispose();
        }

        if(e.getSource()==saveButton)
        {
            char c;
            if(!hexChceckBox.isSelected())
            {
                String value = hexField.getText().substring(2);
                valueHex = Integer.parseInt(value, 16);
                c = 'h';
            }
            else
            {
                valueDec = Double.valueOf(decField.getText());
                c = 'd';
            }

            try {
                FileWriter writer = new FileWriter(valueFile,true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                switch(c)
                {
                    case 'h':
                    {
                        bufferedWriter.append(hexField.getText() + "\n");
                        bufferedWriter.close();
                    }
                    break;

                    case 'd':
                    {
                        bufferedWriter.append(decField.getText() + "\n");
                        bufferedWriter.close();
                    }
                    break;

                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
