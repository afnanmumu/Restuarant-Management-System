import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Login_form {
    private JPasswordField PASSWORD;
    private JTextField USERNAME;
    private JButton LOGINButton;
    private JPanel MainPanel;
    private JLabel pic;
    private JButton customerWatchButton;

    public Login_form() {
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int u=0,p=0;
                String username=USERNAME.getText();
                String password=new String(PASSWORD.getPassword());
                if(username.equals(""))u=1;
                else if(password.equals(""))p=1;

                CSVReader reader=null;
                try {
                    reader=new CSVReader(new FileReader("login.csv"));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                boolean b;
                String[] a;
                int f=0;
                while (true) {
                    try {
                        if (!( null != (a=reader.readNext()))) {
                            break;
                        }
                        //System.out.println(a[0]);
                        if(username.equals(a[0]) && Objects.equals(password, a[1]))
                        {
                            f=1;
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (CsvValidationException csvValidationException) {
                        csvValidationException.printStackTrace();
                    }
                }
                if(f==1){
                    JOptionPane.showMessageDialog(null,"Logged in");
                    drive.callAdminframe();
                    drive.Login.dispose();

                }
                else if(u==1)JOptionPane.showMessageDialog(null,"Input your name!");
                else if(p==1)JOptionPane.showMessageDialog(null,"Enter Password!");
                else JOptionPane.showMessageDialog(null,"Login failed");
            }
        });
        customerWatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.callcustomerframe();
            }
        });
    }
    JPanel getMainPanel(){return MainPanel;}
}
