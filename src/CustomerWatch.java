import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerWatch {
    private JPanel main;
    private JTable List;
    private JScrollPane ListScroll;
    private JLabel pic;

    public CustomerWatch(){
        Createtable();
    }
    public void Createtable(){
        String csvFile = "Items.csv";
        String line = "";
        String cvsSplitBy = ",";
        String data[][]=new String[30][5];
        int i=1;
        int j=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] co = line.split(cvsSplitBy);

                //System.out.println("Country [code= " + co[0] + " , name=" + co[1] + "]");
                data[j][0]=String.valueOf(i);
                data[j][1]=co[0];
                data[j][2]=co[1]+"/-";
                data[j][3]=co[3]+"%";
                i++;
                j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        List.setModel(new DefaultTableModel(
                data,
                new String[]{"Food No.","Food Name","Price","Discount"}
        ));
        TableColumnModel columns=List.getColumnModel();
        columns.getColumn(1).setMinWidth(200);
    }
    JPanel getMainPanel(){return main;}
}
