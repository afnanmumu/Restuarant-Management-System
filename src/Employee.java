import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Employee {
    private JPanel main;
    private JTable List;
    private JButton addEmployeeButton;
    private JButton deleteEmployeeButton;
    private JLabel pic;
    private JButton goBackButton;
    private JScrollPane Listsp;

    public Employee(){
        CreateTable();
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.Employee.dispose();
                drive.calladdemp();
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.callAdminframe();
                drive.Employee.dispose();
            }
        });
        deleteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.calldelempframe();
                drive.Employee.dispose();
            }
        });
    }
    public void CreateTable(){
        String csvFile = "Employe.csv";
        String line = "";
        String cvsSplitBy = ",";
        String data[][]=new String[30][5];
        //String column[]={"Food No.","Food Name","Price"};
        JFrame fn=new JFrame("Menu");
        int c=0;String space=" ";
        for(int i=0;i<25;i++) space=space+" ";
        int i=1;
        int j=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] co = line.split(cvsSplitBy);

                //System.out.println("Country [code= " + co[0] + " , name=" + co[1] + "]");
                data[j][0]=co[0];
                data[j][1]=co[1];
                data[j][2]=co[2];
                data[j][3]=co[3]+"/-";
                c++;
                i++;
                j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        List.setModel(new DefaultTableModel(
                data,
                new String[]{"Employee Id","Designation","Join date","Salary"}
        ));
        TableColumnModel columns= List.getColumnModel();
        columns.getColumn(0).setMinWidth(200);
    }
    JPanel getMainPanel(){return main;}
}
