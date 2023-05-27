
import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.IOException;

public class Available_items {
    Available_items() {

        String csvFile = "Items.csv";
        //String[]cos=new String[19];
        String line = "";
        String cvsSplitBy = ",";
        String data[][]=new String[30][5];
        String column[]={"Items","Price","Amounts","Discounts"};
        JFrame f=new JFrame("Available items");
        //JFrame f = new JFrame();
        //f.getContentPane().add(new JPanelWithBackground("bg.jpg"));
        JTable jt=new JTable(data,column);
        jt.setBackground(new Color(160, 32, 240));
        jt.setFillsViewportHeight(true);
        jt.setForeground(Color.WHITE);
        int c=0;String space=" ";
        for(int i=0;i<25;i++) space=space+" ";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] co = line.split(cvsSplitBy);

                jt.setValueAt(space+co[0],c,0);
                jt.setValueAt(space+co[1]+"/- ",c,1);
                jt.setValueAt(space+co[2],c,2);
                jt.setValueAt(space+co[3],c,3);
                c++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




        JButton jb=new JButton("Add new item");
        jb.setBounds(30,40,80,23); f.add(jb);
        Container contentPane = f.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(jt), BorderLayout.CENTER);
        contentPane.add(jb, BorderLayout.AFTER_LAST_LINE);





        f.setSize(600,500);
        f.setVisible(true); //f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/3-f.getSize().width/2,dim.height/4-f.getSize().height/8);


        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //add_item_frame();
                new add_items();
                f.dispose();
                // new Commodities();
                //new preparing_order();
                // amounts_update("3005",1);
                // new requireditems(6,10);
            }
        });


    }
    /*public static void add_item_frame()
    {

        JFrame f=new JFrame("Add Items"); f.setSize(200,250); f.setVisible(true);

        JLabel item,amount,price,discount; item=new JLabel("New item's name :");
        item.setBounds(130,50,120,20);
        f.add(item);

        amount=new JLabel("Amount :"); amount.setBounds(130,110,100,20); f.add(amount);

        price=new JLabel("Price :"); price.setBounds(130,80,100,20);
        f.add(price);
        discount=new JLabel("Discount :"); price.setBounds(130,140,100,20);
        f.add(discount);
        JTextField it,am,pr,dis;
        it=new JTextField(); it.setBounds(260,50,120,20); f.add(it);

        pr=new JTextField(); pr.setBounds(260,80,120,20); f.add(pr);

        am=new JTextField(); am.setBounds(260,110,120,20); f.add(am);

        dis=new JTextField(); dis.setBounds(260,140,120,20); f.add(dis);

        JButton jb=new JButton("Add"); jb.setBounds(277,170,80,20); f.add(jb);

        f.setSize(600,500);  f.setLayout(null);

        jb.setBackground(Color.WHITE);

        jb.setForeground(Color.WHITE);

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String its=it.getText();
                String ams=am.getText();
                String prs=pr.getText();
                String dis=dis.getText();
                //add_new_item(its,ams,prs,f);

            }
        });
    }
    public static void add_new_item(String its,String ams,String prs,JFrame f)
    {
        //CSVWriter writer = new CSVWriter(new FileWriter("D://output.csv"));
        String line1[] = {its,ams,prs,dis};
        CSVWriter wr=null;
        try {
            wr = new CSVWriter(new FileWriter("Items.csv",true));
            wr.writeNext(line1);
            JOptionPane.showMessageDialog(f, "A new food items has been added successfully!");

        }catch(IOException e)
        {

            e.printStackTrace();
        }



    }*/
    /*public static void amounts_update(String price,int pos) {
        String line = " ";
        String amfile = "amounts.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(amfile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] co = line.split(",");
                co[5]=price;

                //co[pos-1].equals(price);
                // cos[pos-1].equals(price);
                CSVWriter wr = null;
                try {
                    wr = new CSVWriter(new FileWriter("amounts.csv"));

                    wr.writeNext(co);
                    wr.close();
                    //wr.close();JOptionPane.showMessageDialog(f, "food item updated successfully!");
                } catch (IOException e) {   //JOptionPane.showMessageDialog(f, "Something went wrong !Try again.");
                    e.printStackTrace();
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/



}
