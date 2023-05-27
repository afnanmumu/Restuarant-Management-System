import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Storage_condition{
    private static int size;
    Storage_condition(String[] items,int tempp,int indexx)
    {    double []d=new double [300];
        int it=indexx;
        try {
            File myObj = new File("storage.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String []co=data.split(" ");
                size=co.length;
                for(int i=0;i<co.length;i++)
                    // System.out.println(co[i]+" ");
                    //System.out.println(data);
                    if(co[i]!="")

                    {    // String str=conversion(co[i]);
                        d[i]=Double.parseDouble(co[i]);
                        // System.out.println(d[i]+" ");

                    }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            //System.out.println("An error occurred.");
            JOptionPane.showMessageDialog(new JFrame(),"Something went wrong!","Error!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        Integer [] pr;int prlen=0;

        try {
            File myObj = new File("price.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String []co=data.split(" ");
                prlen=co.length;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            // System.out.println("An error occurred.");
            JOptionPane.showMessageDialog(new JFrame(),"Something went wrong!","Error!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        pr=new Integer[prlen];

        try {
            File myObj = new File("price.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String []co=data.split(" ");
                for(int i=0;i<co.length;i++)
                    pr[i]=Integer.valueOf(co[i]);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String []food_tittles=new String[500];

        Stack<String>foods=new Stack<String>();
        try {
            File myObj = new File("itemtittles.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                food_tittles=data.split(" ");


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



        double temp;
        Stack<Integer>pr1=new Stack<Integer>();
        Stack<Double>requisite=new Stack<Double>();
        Queue<Integer>q=new LinkedList<>();
        Queue<Double>qd=new LinkedList<>();
        int index=0;
        try {
            File myObj = new File("11.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String []co=data.split(" ");
                              /*double req=(double)indexx;
                              String str=conversion(co[indexx]);
                              temp=Double.parseDouble(str);
                              if((temp*req)>d[index])
                              {requisite.add((temp*req)-d[index]);
                               pr1.add(pr[index]*((int)req));
                               foods.add(food_tittles[index]);*/

                if(index==it)
                {
                    for(int j=0;j<co.length;j++)
                    {
                        double cur=Double.parseDouble(co[j]);
                        double exponen=tempp;
                        // System.out.println((cur*exponen)+" "+d[j]);
                        if((cur*exponen)>d[j])
                        {
                            System.out.println((cur*exponen)+" "+d[j]+" "+food_tittles[j]);
                            requisite.add((cur*exponen)-d[j]);
                            pr1.add(pr[j]*(int)exponen);
                            foods.add(food_tittles[j]);

                        }
                        else{
                            q.add(j); qd.add(d[j]-(cur*exponen));
                        }



                    }
                    break ;
                }

                index++;




            }
            myReader.close();
        } catch (FileNotFoundException e) {
            //System.out.println("An error occurred.");
            JOptionPane.showMessageDialog(new JFrame(),"Something went wrong!","Error!",JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();
        }



        if(requisite.empty())
        {    String[] str=new String[size];
            try {
                File myObj = new File("itemtittles.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    str=data.split(" ");



                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            for(int i=0;i<str.length;i++)
                if(i==q.peek())
                {
                    str[i]=String.valueOf(qd.peek());
                    q.poll(); qd.poll();
                }
            String l=str[0];
            for(int i=1;i<str.length;i++)
            {
                l=l+" ";
                l=l+str[i];
            }
            try {
                FileWriter myWriter = new FileWriter("storage.txt");
                myWriter.write(l);
                myWriter.close();
                System.out.println("Preparing Order has been placed successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(new JFrame(),"Something went wrong!","Error!",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

            // System.out.println("Preparing Order has been placed successfully!");
        }
        else new recquisite_como(requisite,items[indexx],pr1,foods);



    }
     /*public static void framework( Stack<Double>requisite)
     {    JFrame jf=new JFrame("Required raw materials list");
           jf.setVisible(true); //jf.setResizable(false);
          jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JLabel[] jll=new JLabel[requisite.size()];
          int p=0;
          System.out.println(requisite.size());
          for(int i=0;i<requisite.size();i++)
          {
               jll[i]=new JLabel("bolod");
               jf.add(jll[i]);
               jll[i].setBounds(200,p,200,15);
               jll[i].setForeground(Color.BLUE);
               p=p+30;
          }
          jf.setBackground(Color.RED);
         // jf.setLayout(jf,BoxLayout.Y_AXIS);


     }
     /*public static String conversion(String st)
     {    char []l=new char[st.length()];
          int c=0;
          for(int i=0;i<st.length();i++)
          {int p=st.charAt(i);
               if((p==46)||(p>=48&&p<=57))
               {
                    l[c]=(char)p;
                    c++;
               }
          }
          String str=new String(l);
          return str;
     }*/
    /* public static void main(String[]args)
     {
          new Storage_condition("");
     }*/



}