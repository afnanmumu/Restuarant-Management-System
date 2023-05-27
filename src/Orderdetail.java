import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Orderdetail {
    private JPanel main;
    private JTable ordertable;
    private JLabel pic;
    private JScrollPane Order;

    public Orderdetail(){
        CreateTable();
    }
    public void CreateTable(){
        String csvFile = "Orderdetail.csv";
        String line = "";
        String cvsSplitBy = ",";
        String data[][]=new String[30][5];
        int j=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] co = line.split(cvsSplitBy);

                //System.out.println("Country [code= " + co[0] + " , name=" + co[1] + "]");
                data[j][0]=co[0];
                data[j][1]=co[1];
                data[j][2]=co[2];
                j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ordertable.setModel(new DefaultTableModel(
                data,
                new String[]{"Date","Total amount","Order details"}
        ));
        TableColumnModel columns= ordertable.getColumnModel();
        columns.getColumn(2).setMinWidth(200);
    }
    JPanel getMainPanel(){return main;}
}
