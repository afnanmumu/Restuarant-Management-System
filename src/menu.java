import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.*;
import java.util.Date;


public class menu extends NullPointerException{
    private JPanel main;
    private JTable List;
    private JButton deleteButton;
    private JTextField Foodno;
    private JComboBox FA;
    private JButton orderButton;
    private JButton goBackButton;
    private JButton addButton1;
    private JScrollPane ListScroll;
    private JTable Ordered;
    private JScrollPane Orderedjsp;
    private JTextField cancel;
    private JLabel pic;
    String[] items=new String[100];

    public menu() throws textnotfoundexp{
        CreateTable();
        //date.setText("dd/mm/yyyy");

        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0,n=0;
                String s = Foodno.getText();
                try{
                    i=Integer.parseInt(s);
                }catch (Exception f){
                    //System.err.print(f);
                    n=1;
                    try {
                        throw new textnotfoundexp("Enter Food no. only digit!");
                    } catch (textnotfoundexp textnotfoundexp) {
                        textnotfoundexp.printStackTrace();
                        JOptionPane.showMessageDialog(null,"Ender food no.");
                    }
                }
                if(Foodno.getText().equals("") && n==0)JOptionPane.showMessageDialog(null,"Enter Food no.");
                else if(n!=1){
                    DefaultTableModel t=(DefaultTableModel)Ordered.getModel();
                    int z=FA.getSelectedIndex()+1;
                    System.out.println(s+z);
                    Createordertable(i,z);
                    new Storage_condition(items,z,i-1);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel t = (DefaultTableModel) Ordered.getModel();
                String s=cancel.getText();
                int i=0,n=0;
                if(s.length()!=0){
                    try {
                        i = Integer.parseInt(s) - 1;
                    }catch (Exception f){
                        n=1;
                    }
                }
                if(n==1)JOptionPane.showMessageDialog(null,"The text field should only contain number!");
                else if (s.length()==0)JOptionPane.showMessageDialog(null,"Enter the row Number to delete");
                else if(t.getRowCount()<i || i<0)JOptionPane.showMessageDialog(null,"Sorry the specified row does not exist for deletion");
                else {
                    t.removeRow(i);
                    cancel.setText("");
                }
            }
        });
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel t1=(DefaultTableModel)Ordered.getModel();
                DefaultTableModel t2=(DefaultTableModel)List.getModel();
                int i=t1.getRowCount();
                FileOutputStream fos= null;
                try {
                    fos = new FileOutputStream("Order.csv");
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                PrintWriter pw=new PrintWriter(fos);
                for(int j=0;j<i;j++) {
                    String a= (String) t1.getValueAt(j, 0);
                    String b= (String) t1.getValueAt(j, 1);
                    String c= (String) t1.getValueAt(j, 2);
                    String d= (String) t1.getValueAt(j,3);

                    try{
                        int p=Integer.valueOf(d);
                    }catch(Exception f){
                        a=a.substring(1,a.length()-1);
                        b=b.substring(1,b.length()-1);
                        d=d.substring(1,d.length()-1);
                    }

                    pw.println(a+ "," + b + "," + c+","+d);
                }
                //pw.println("mumu,59,20");
                //pw.println("nafi,57,16");
                pw.close();
                if(i==0)JOptionPane.showMessageDialog(null,"Select a Food");
                else {
                    System.out.println("yes");
                    drive.callpriceframe();
                    drive.menu.setVisible(false);
                }

            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.callAdminframe();
                drive.menu.dispose();
            }
        });

    }
    private void Createordertable(int i,int z){
        String[] date=new String[4];
        String csvFile = "Items.csv";
        String line = "";
        String cvsSplitBy = ",";
        int j=0;
        String a=String.valueOf(i);
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] co = line.split(cvsSplitBy);
                if(j+1==i){
                    date[1]=co[1];
                    date[0]=co[0];
                    date[3]=co[3];
                }
                j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String k=String.valueOf(z);
        date[2]=k;
        System.out.println(date[0]+date[1]+date[2]);
        DefaultTableModel t=(DefaultTableModel)Ordered.getModel();
        t.addRow(new String[]{date[0] , date[1] , date[2],date[3]});
        Foodno.setText("");
        FA.setSelectedIndex(0);

    }
    private void CreateTable(){
        String csvFile = "Items.csv";
        String line = "";
        String cvsSplitBy = ",";
        String data[][]=new String[30][5];
        //String column[]={"Food No.","Food Name","Price"};
        JFrame fn=new JFrame("Menu");
        int c=0;String space=" ";
        for(int i=0;i<25;i++) space=space+" ";
        int i=1;
        int j=0;
        int l=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] co = line.split(cvsSplitBy);

                //System.out.println("Country [code= " + co[0] + " , name=" + co[1] + "]");
                items[l]=co[0];
                data[j][0]=String.valueOf(i);
                data[j][1]=co[0];
                data[j][2]=co[1]+"/-";
                data[j][3]=co[3]+"%";
                c++;
                i++;
                j++;
                l++;
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
        Ordered.setModel(new DefaultTableModel(
                null,
                new String[]{"Food Name","Price","Amount","Discount"}
        ));
        //TableColumnModel columns=Ordered.getColumnModel();
    }
    JPanel getMainPanel(){return main;}


}