import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UnitPage implements ActionListener
{
    String[] units = {"Tera", "Giga","Mega", "kilo","mili","mikro","nano","piko"};
    JFrame page = new JFrame("Unit Calculator");
    JComboBox unitCombo1 = new JComboBox(units);
    JComboBox unitCombo2 = new JComboBox(units);
    JTextField unitField1 = new JTextField("0");
    JTextField unitField2 = new JTextField("0");
    JButton calculateButton = new JButton("Calculate");
    JButton saveButton = new JButton("Save");
    JButton backButton = new JButton("Back");

    int power1 = 0, power2 = 0;
    String userLogin;

    File valueFile = new File("values.txt");

    UnitPage(String userLogin)
    {
        this.userLogin = userLogin;

        unitCombo1.setBounds(35,35,100,20);
        unitCombo1.addActionListener(this);
        unitCombo2.setBounds(140,35,100,20);
        unitCombo2.addActionListener(this);

        unitField1.setBounds(35,60,100,20);
        unitField2.setBounds(140,60,100,20);
        unitField2.setEditable(false);

        calculateButton.setBounds(35,90,210,30);
        calculateButton.addActionListener(this);
        calculateButton.setFocusable(false);
        saveButton.setBounds(35,130,210,30);
        saveButton.addActionListener(this);
        calculateButton.setFocusable(false);
        backButton.setBounds(35,170,210,30);
        backButton.addActionListener(this);
        calculateButton.setFocusable(false);

        page.add(unitCombo1);
        page.add(unitCombo2);
        page.add(unitField1);
        page.add(unitField2);
        page.add(calculateButton);
        page.add(saveButton);
        page.add(backButton);

        page.setSize(300,300);
        page.setResizable(false);
        page.setLayout(null);
        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setVisible(true);
    }

    public static void main(String[] args) {
        new UnitPage("admin");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == unitCombo1)
        {
            switch(unitCombo1.getSelectedIndex())
            {
                case 0: power1 = 12; break;
                case 1: power1 = 9; break;
                case 2: power1 = 6; break;
                case 3: power1 = 3; break;
                case 4: power1 = -3; break;
                case 5: power1 = -6; break;
                case 6: power1 = -9; break;
                case 7: power1 = -12; break;
            }

            System.out.println(power1);
        }

        if(e.getSource() == unitCombo2)
        {
            switch(unitCombo2.getSelectedIndex())
            {
                case 0: power2 = 12; break;
                case 1: power2 = 9; break;
                case 2: power2 = 6; break;
                case 3: power2 = 3; break;
                case 4: power2 = -3; break;
                case 5: power2 = -6; break;
                case 6: power2 = -9; break;
                case 7: power2 = -12; break;
            }

            System.out.println(power2);
        }

        if(e.getSource() == calculateButton) //sumy kontrolne do szyfrowania MD5 77
        {
            if(power1 == power2)
            {
                unitField2.setText(unitField1.getText());
            } else if(power1 > power2)
            {
                unitField2.setText(String.valueOf(Integer.valueOf(unitField1.getText())/Math.pow(10,power2-power1)));
            }
            else
            {
                unitField2.setText(String.valueOf(Integer.valueOf(unitField1.getText())*Math.pow(10,power1-power2)));
            }
        }

        if(e.getSource() == saveButton)
        {
            try {
                FileWriter writer = new FileWriter(valueFile,true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.append(unitField2.getText() + "\n");
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
