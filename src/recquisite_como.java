import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class recquisite_como extends JFrame {

    recquisite_como(Stack<Double> requisite,String lst,Stack<Integer>pr1,Stack<String>foods)
    {

        setTitle("Required Raw Materials");
        setSize(600,600);
        setVisible(true);
        setResizable(false);
        JLabel[] jll=new JLabel[requisite.size()*2];
        JLabel heading1=new JLabel("Required Commodities for preparing "+lst);
        add(heading1);
        heading1.setBounds(120,10,400,15);
        heading1.setForeground(Color.WHITE);
        int p=70;
        JComboBox []jcc=new JComboBox[requisite.size()];
        int i=0,i1=0;
        while(!requisite.isEmpty())
        {
            //String st=Integer.toString(pr1.peek());

            String [] temp=new String[6];
            int countt=0;
            for(int it=pr1.peek();it>=pr1.peek()-5;it--)
            {
                temp[countt]=Integer.toString(it);
                temp[countt]=temp[countt]+" /=";
                countt++;
            }



            //jll[i]=new JLabel(st+" /=");
            jcc[i1]=new JComboBox(temp);
            // jll[i].setForeground(Color.WHITE);
            jll[i]=new JLabel(foods.peek());
            jll[i].setForeground(Color.WHITE);
            String tem=String.valueOf(requisite.peek());
            jll[i+1]=new JLabel(tem+" (kg)");
            jll[i+1].setForeground(Color.WHITE);
            foods.pop();
            pr1.pop();
            requisite.pop();
            jll[i+1].setBounds(250,p,150,20);
            //jll[i].setBounds(475,p,80,20);
            //jcc[i].setBounds(475,p,80,20);
            //jcc[i].setForeground(Color.WHITE);

            jll[i].setBounds(100,p,100,20);
            //add(jll[i]);
            jcc[i1].setBackground(new Color(160, 32, 240));
            jcc[i1].setForeground(Color.WHITE);
            add(jcc[i1]);
            jcc[i1].setBounds(410,p,100,20);
            add(jll[i]);
            add(jll[i+1]);
            p=p+20;
            i=i+2;
            i1=i1+1;

        }
        JButton jb=new JButton("Pay And Prepare The Items! ");
        JCheckBox checkBox1 = new JCheckBox("I am sure to pay for buying these commodities");
        checkBox1.setBounds(110,p+10, 350,20);
        jb.setBackground(Color.WHITE);
        jb.setBounds(183,p+50,250,20);

        add(checkBox1);
        add(jb);
        setLayout(null);
        //Color cn=new Color(160, 32, 240);
        ImagePanel panel = new ImagePanel(
                new ImageIcon("background1.jpg").getImage());
        panel.setSize(600,600);
        add(panel);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (!checkBox1.isSelected()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Please agree with all the terms", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    double sum = 0;
                    for (int i = 0; i < jcc.length; i++) {
                        String an_temp = " " + jcc[i].getSelectedItem();
                        String[] an_temp1 = an_temp.split(" ");
                        sum = sum + Double.parseDouble(an_temp1[1]);

                    }

                    try {

                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Rawmat.txt", true)));
                        out.println(sum);
                        out.flush();
                        out.close();

                        JOptionPane.showMessageDialog(null, "Details added successfully!");
                    } catch (IOException error) {
                        error.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Something went wrong!");
                    }

                    JOptionPane.showMessageDialog(new JFrame(), "Pay total " + String.valueOf(sum) + " /=tk for buyig the required Commodities for preparing foods", "Marketing price", JOptionPane.QUESTION_MESSAGE);


                }
            }
        });

    }




}

