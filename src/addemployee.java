import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addemployee {
    private JPanel main;
    private JButton button1;
    private JTextField id;
    private JTextField des;
    private JTextField date;
    private JTextField salary;
    private JLabel pic;

    public addemployee() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1=0,n2=0;
                String aa=id.getText();
                    try{
                        int a= Integer.parseInt(aa);
                    }catch (Exception f){
                        n1=1;
                    }
                String bb=des.getText();
                String cc=date.getText();
                String dd=salary.getText();
                boolean d=dateverify(cc);
                try{
                    int b= Integer.parseInt(dd);
                }catch (Exception f){
                    n2=1;
                }
                if(aa.length()==0 || bb.length()==0 || cc.length()==0 || dd.length()==0)JOptionPane.showMessageDialog(null,"Fillup all fields!");
                else if(n1==1)JOptionPane.showMessageDialog(null,"Enter Id field only Number!");
                else if(n2==1)JOptionPane.showMessageDialog(null,"Enter Salary field only Number!");
                else if(d==false)JOptionPane.showMessageDialog(null,"Enter Correct Date Format!");
                else {
                    addline(aa, bb, cc, dd);
                    drive.callEmployeframe();
                    drive.addemployee.dispose();
                }
            }
        });
    }
    public void addline(String f,String b,String c,String d){
        int a=10;
        String[] line1 = {f,b,c,d};
        CSVWriter wr=null;

        String csvFile="Employe.csv";

        try {
            wr = new CSVWriter(new FileWriter("Employe.csv",true));
            wr.writeNext(line1);
            wr.close();
            JOptionPane.showMessageDialog(null, "New Employee Id has been added successfully!");


        }catch(IOException e)
        {   JOptionPane.showMessageDialog(null, "Something went wrong !Try again.");
            e.printStackTrace();
        }
    }
    public static boolean dateverify(String date){
        DateFormat df=new SimpleDateFormat("dd/mm/yyyy");
        df.setLenient(false);
        Date BOD=null;
        try{
            BOD=df.parse(date);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    JPanel getMainPanel(){return main;}
}