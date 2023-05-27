import com.opencsv.CSVWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.util.Stack;
class add_items extends JFrame implements ActionListener {
    JFrame f;
    String itss, amss, prss,diss;
    JTextField it, am, pr,dis;
    JButton jb;

    add_items() {
        f = new JFrame("Add Items");
        //f.setSize(150, 250);
        f.setVisible(true);

        JLabel item, amount, price,discount;
        item = new JLabel("New item's name :");
        item.setBounds(110, 50, 120, 20);
        item.setForeground(Color.WHITE);
        f.add(item);

        price = new JLabel("Price :");
        price.setBounds(110, 80, 100, 20);
        price.setForeground(Color.WHITE);
        f.add(price);

        amount = new JLabel("Amount :");
        amount.setBounds(110, 110, 100, 20);
        amount.setForeground(Color.WHITE);
        f.add(amount);


        discount = new JLabel("Discount :");
        discount.setBounds(110, 140, 100, 20);
        discount.setForeground(Color.WHITE);
        f.add(discount);

        it = new JTextField();
        it.setBounds(240, 50, 120, 20);
        f.add(it);

        pr = new JTextField();
        pr.setBounds(240, 80, 120, 20);
        f.add(pr);

        am = new JTextField();
        am.setBounds(240, 110, 120, 20);
        f.add(am);


        dis = new JTextField();
        dis.setBounds(240, 140, 120, 20);

        f.add(dis);

        jb = new JButton("Add");
        jb.setBounds(257, 170, 80, 20);
        f.add(jb);

        f.setSize(575, 470);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2,dim.height/2-f.getSize().height/2);
        jb.addActionListener(this);

        ImagePanel panel = new ImagePanel(
                new ImageIcon("background.jpg").getImage());
        panel.setSize(600, 500);
        f.getContentPane().add(panel);

    }

    public static void add_new_item(String its, String prs, String ams,String dis) {
        String line1[] = {its, prs,ams,dis};
        CSVWriter wr = null;

        // String csvFile="newitems.csv";

        try {
            wr = new CSVWriter(new FileWriter("Items.csv", true));
            wr.writeNext(line1);
            wr.close();
            // JOptionPane.showMessageDialog(f, "A new food items has been added successfully!");


        } catch (IOException e) {  // JOptionPane.showMessageDialog(f, "Something went wrong !Try again.");
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        //drive.callAdminframe();

    }

    public void actionPerformed(ActionEvent ae) {

        itss = it.getText();
        amss = am.getText();
        prss = pr.getText();
        diss=dis.getText();
        /*if((itss.length()==0)||(amss.length()==0)||(prss.length()==0)||(diss.length()==0))
        {
           // JOptionPane.showMessageDialog(new JFrame(),"Please enter to each fields(items,amounts,price,discounts)","Error",JOptionPane.ERROR_MESSAGE);
          throw new emptyexception1();
        }
        else{
            adddetails(itss,prss,amss,diss);
            dispose();
            //dispose();
        }*/

        try {
            if ((itss.length() == 0) || (amss.length() == 0) || (prss.length() == 0) || (diss.length() == 0))
                throw new emptyexception1("Please enter to each fields(items,amounts,price,discounts)");
            else {
                adddetails(itss, prss, amss, diss);
                f.dispose();
            }
        }
        catch(emptyexception1 e)
        {JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);


        }




    }
    /*public static void main(String []args)
    {
        new add_items();
    }*/


    public static void adddetails(String its, String ams, String prs,String dis) {
        JFrame jf = new JFrame("Add food details");
        jf.setVisible(true);

        /*ImagePanel panel = new ImagePanel(
                new ImageIcon("background.jpg").getImage());
        panel.setSize(600,500);
        jf.getContentPane().add(panel);*/


        Stack<String> st = new Stack<String>();
        jf.setSize(600, 600);
        jf.setResizable(false);

        try {
            File myObj = new File("itemtittles.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] co = data.split(" ");
                for (int i = 0; i < co.length; i++)
                    st.add(co[i]);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        JLabel[] ele = new JLabel[st.size()];
        JTextField[] quan = new JTextField[st.size()];
        int vert = 50;
        int iter = 0;
        //Stack<String>stt=new Stack<String>();
        int sizee = st.size();
        JLabel heading1 = new JLabel("Commodities:");
        heading1.setForeground(Color.WHITE);
        jf.add(heading1);
        heading1.setBounds(130, 25, 120, 15);
        JLabel heading2 = new JLabel("Required amounts for this food:");
        jf.add(heading2);
        heading2.setForeground(Color.WHITE);
        heading2.setBounds(260, 25, 230, 15);
        while (!st.isEmpty()) {
            ele[iter] = new JLabel(st.peek());
            ele[iter].setForeground(Color.WHITE);
            ele[iter].setBackground(new Color(160, 32, 240));
            ele[iter].setBounds(130, vert, 120, 15);
            quan[iter] = new JTextField();
            quan[iter].setBounds(260, vert, 175, 15);
            quan[iter].setBackground(new Color(160, 32, 240));
            quan[iter].setForeground(Color.WHITE);

            jf.add(ele[iter]);
            jf.add(quan[iter]);
            //  stt.add(st.peek());
            st.pop();
            vert = vert + 20;
            iter++;
        }
        jf.setLayout(null);
        ImagePanel panel = new ImagePanel(
                new ImageIcon("background1.jpg").getImage());
        panel.setSize(600, 600);
        jf.getContentPane().add(panel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        jf.setLocation(dim.width/2-jf.getSize().width/2,dim.height/2-jf.getSize().height/2);

        JButton jbe = new JButton("Save Details");
        jbe.setBackground(new Color(160, 32, 240));
        jbe.setForeground(Color.WHITE);
        jbe.setVisible(true);
        jf.add(jbe);
        jbe.setBounds(220, vert + 10, 200, 20);
        jbe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int deter = 1;
                for (int i = 0; i < sizee; i++) {
                    if (quan[i].getText() == null) {
                        deter = 0;
                        break;
                    }
                }
                if (deter == 0) {
                    JOptionPane.showMessageDialog(jf, "Please enter quantity for all the commodities", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String str = quan[0].getText();

                    for (int i = 1; i < sizee; i++) {
                        str = str + " ";
                        str = str + quan[i].getText();


                    }
                    try {

                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("11.txt", true)));
                        out.println(str);
                        out.flush();
                        out.close();
                         /*Writer output=new BufferedWriter(new FileWriter("11.txt",true));
                         output.append(str);
                         output.close();*/
                        add_new_item(its, ams, prs, dis);

                        JOptionPane.showMessageDialog(jf, "Details added successfully!");
                    } catch (IOException error) {
                        error.printStackTrace();
                        JOptionPane.showMessageDialog(jf, "Something went wrong!");
                    }
                    drive.callAdminframe();

                }
            }
        });


    }

    static class ImagePanel extends JPanel {

        private Image img;

        public ImagePanel(String img) {
            this(new ImageIcon(img).getImage());
        }

        public ImagePanel(Image img) {
            this.img = img;
            Dimension size = new Dimension/*(img.getWidth(null), img.getHeight(null));*/(600, 500);
            //setPreferredSize(size);
            // setMinimumSize(size);
            // setMaximumSize(size);
            //  setSize(size);
            setLayout(null);
        }

        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }
}