import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class dashboard {
    private JTextField Emp;
    private JTextField Income;
    private JTextField profit;
    private JPanel main;
    private JTextField Raw;
    static double sum=0;

    public dashboard(){
        //super();
        Emp.setEnabled(false);
        Emp.setDisabledTextColor(Color.blue);
        Income.setEnabled(false);
        Income.setDisabledTextColor(Color.blue);
        profit.setEnabled(false);
        profit.setDisabledTextColor(Color.blue);
        Raw.setEnabled(false);
        Raw.setDisabledTextColor(Color.blue);
        Emp.setText(Integer.toString(empnum()));
        Income.setText(Float.toString(Income()));
        profit.setText(Float.toString((float) (((30*1.00)/100)*Income())));
        read();
        Raw.setText(Double.toString(sum));
    }
    public static void read(){
        try {
            File myObj = new File("Rawmat.txt");
            Scanner myReader = new Scanner(myObj);
            sum=0.0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Double s= Double.valueOf(data);
                sum=sum+s;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static int empnum(){
        String csvFile = "Employe.csv";
        String line = "";
        String cvsSplitBy = ",";
        String data[][]=new String[30][5];
        JFrame fn=new JFrame("Menu");
        int c=0;String space=" ";
        int i=0;
        int j=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] co = line.split(cvsSplitBy);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
    public static float Income(){
        String csvFile = "Orderdetail.csv";
        String line = "";
        String cvsSplitBy = ",";
        String data[][]=new String[30][5];
        JFrame fn=new JFrame("Menu");
        int c=0;String space=" ";
        float sum=0;
        int j=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] co = line.split(cvsSplitBy);
                String z=co[1].substring(1,co[1].length()-1);
                System.out.println(z);
                Float k= Float.parseFloat(z);
                System.out.println(k);
                sum+=k;
                System.out.println(sum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    JPanel getMainPanel(){return main;}
}
