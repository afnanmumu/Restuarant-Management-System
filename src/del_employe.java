import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class del_employe {
    private JTextField idfield;
    private JButton deleteButton;
    private JPanel main;
    private JButton goBackButton;

    public del_employe() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s=idfield.getText();
                int id,index = -1,n=0;
                try{
                id = Integer.parseInt(s);
                index = find(s);}
                catch (Exception f){
                    n=1;
                }
                if(s.length()==0)JOptionPane.showMessageDialog(null,"Enter Id!");
                else if(n==1)JOptionPane.showMessageDialog(null,"Enter Id field only Number!");
                else if(index==-1)JOptionPane.showMessageDialog(null,"Id not found");
                else {

                    JOptionPane.showMessageDialog(null, "The specified id is deleted");
                    drive.callEmployeframe();
                    drive.delemp.dispose();
                }
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.callEmployeframe();
                drive.delemp.dispose();
            }
        });
    }

    private int find(String id) throws ArrayIndexOutOfBoundsException{
        String[] date=new String[4];
        String csvFile = "Employe.csv";
        String line = "";
        String cvsSplitBy = ",";
        int i=0;
        String a=String.valueOf(id);
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] co = line.split(cvsSplitBy);
                int idr;
                System.out.println("before if"+id+co[0]);
                try{
                    idr=Integer.parseInt(co[0]);
                }catch (Exception e){
                    System.out.println(co[0]);
                    String s=co[0].substring(1,co[0].length()-1);
                    System.out.println(s);
                    idr=Integer.parseInt(s);
                    System.out.println(idr);
                }
                int f=Integer.parseInt(id);
                if(f==idr){
                    delete(i);
                    System.out.println(i);
                    return i;
                }
                i++;
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void delete(int i) throws IOException, CsvException {
        if(i==-1)JOptionPane.showMessageDialog(null,"Id not found");
        else {
            CSVReader reader2 = new CSVReader(new FileReader("Employe.csv"));
            List<String[]> allElements = reader2.readAll();
            ((List<?>) allElements).remove(i);
            FileWriter sw = new FileWriter("Employe.csv");
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements);
            writer.close();
        }
    }

    JPanel getMainPanel(){return main;}
}
