import com.opencsv.CSVWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Price {
    private JPanel main;
    private JButton goBackButton;
    private JButton confirmButton;
    private JTextField InitPrice;
    private JTextField netpay;
    private JTable price;
    private JScrollPane pricelist;
    private JLabel pic;
    private JTextField date;
    private JComboBox comboBox1;
    String data="";

    public Price(){
        Createtable();
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.AdminPanel.setVisible(true);
                drive.Price.setVisible(false);
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x=date.getText();
                if(x.length()==0)JOptionPane.showMessageDialog(null,"Insert date");
                else if(dateverify(x)==false)JOptionPane.showMessageDialog(null,"Invalid date format");
                else{
                    readfile("Order.csv");
                    addline(date.getText(),netpay.getText(),data);
                    drive.callAdminframe();
                    drive.Price.dispose();
                }
            }
        });
    }
    public void addline(String a,String b,String c){
        String[] line1 = new String[4];
        line1[0]=a;
        line1[1]=b;
        line1[2]=c;
        //line1[3]=d;
        //line1[3]=d;
        CSVWriter wr=null;

        String csvFile="Orderdetails.csv";

        try {
            wr = new CSVWriter(new FileWriter("Orderdetail.csv",true));
            wr.writeNext(line1);
            wr.close();
            JOptionPane.showMessageDialog(null, "Thanku you order has been successfully placed!");


        }catch(IOException e)
        {   JOptionPane.showMessageDialog(null, "Something went wrong !Try again.");
            e.printStackTrace();
        }
    }
    public void readfile(String csvFile){
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] co = line.split(",");

                data+=co[0]+"*"+co[2]+"  ";
            }

        } catch (IOException e) {
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

    private void Createtable() {
        String csvFile = "Order.csv";
        String line = "";
        String cvsSplitBy = ",";
        String data[][]=new String[30][9];
        int i=1;
        int j=0;
        float sum=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] co = line.split(cvsSplitBy);

                //System.out.println("Country [code= " + co[0] + " , name=" + co[1] + "]");
                data[j][0]=String.valueOf(i);
                data[j][1]=co[0];
                data[j][2]=co[1]+"/-";
                data[j][3]=co[2];
                //data[j][4]=co[3];
                sum+= (Integer.parseInt(co[1])*Integer.parseInt(co[2]))*((100-Integer.parseInt(co[3])*1.0)/100);
                System.out.println(co[2]);
                i++;
                j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        price.setModel(new DefaultTableModel(
                data,
                new String[]{"No.","Food Name","Price","Amount"}
        ));
        TableColumnModel columns=price.getColumnModel();
        columns.getColumn(1).setMinWidth(200);
        System.out.println(sum);
        InitPrice.setDisabledTextColor(Color.BLUE);
        InitPrice.setText(String.valueOf(sum));
        InitPrice.setEnabled(false);
        netpay.setDisabledTextColor(Color.BLUE);
        netpay.setText(String.valueOf(sum+(sum*(1.0/100))));
        netpay.setEnabled(false);
    }
    JPanel getMainPanel(){return main;}
}
