import javax.swing.*;
import java.awt.*;

public class drive extends JFrame{
    static JFrame menu;
    static JFrame CustomerWatch;
    static JFrame Price;
    static JFrame AdminPanel;
    static JFrame Login;
    static JFrame Employee;
    static JFrame addemployee;
    static JFrame Orderdetail;
    private ImageIcon icon;
    static JFrame delemp;
    static JFrame dashboard;
    drive(){init();}
    public void init(){
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
    }

    public static void main(String[] args) {
        callloginframe();
    }
    public static void callloginframe(){
        Login = new JFrame();
        Login.setVisible(true);
        Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Login.setSize(1000,800);
        Login.setLocation(400,10);

        Login.setTitle("RESTURANT MANAGEMENT APP");
        Login.add(new Login_form().getMainPanel());
        Login.setResizable(false);
    }
    public static void calldashboard(){
        dashboard = new JFrame();
        dashboard.setVisible(true);
        dashboard.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dashboard.setSize(1000,800);
        dashboard.setLocation(400,10);

        dashboard.setTitle("RESTURANT MANAGEMENT APP");
        dashboard.add(new dashboard().getMainPanel());
        dashboard.setResizable(false);
    }
    public static void callAdminframe(){
        AdminPanel = new JFrame();
        AdminPanel.setVisible(true);
        AdminPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AdminPanel.setSize(1000,800);
        AdminPanel.setLocation(400,10);

        AdminPanel.setTitle("RESTURANT MANAGEMENT APP");
        AdminPanel.add(new AdminPanel().getMainPanel());
        AdminPanel.setResizable(false);
    }
    public static void callmenuframe() throws textnotfoundexp {
        menu = new JFrame();
        menu.setVisible(true);
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menu.setSize(1000,800);
        menu.setLocation(400,10);

        menu.setTitle("RESTURANT MANAGEMENT APP");
        menu.add(new menu().getMainPanel());
        menu.setResizable(false);
    }
    public static void callpriceframe(){
        Price = new JFrame();
        Price.setVisible(true);
        Price.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Price.setSize(1000,800);
        Price.setLocation(400,10);

        Price.setTitle("RESTURANT MANAGEMENT APP");
        Price.add(new Price().getMainPanel());
        Price.setResizable(false);
    }
    public static void callcustomerframe(){
        CustomerWatch = new JFrame();
        CustomerWatch.setVisible(true);
        CustomerWatch.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        CustomerWatch.setSize(1000,800);
        CustomerWatch.setLocation(400,10);

        CustomerWatch.setTitle("RESTURANT MANAGEMENT APP");
        CustomerWatch.add(new CustomerWatch().getMainPanel());
        CustomerWatch.setResizable(false);
    }
    public static void calladdemp(){
        addemployee = new JFrame();
        addemployee.setVisible(true);
        addemployee.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addemployee.setSize(1000,800);
        addemployee.setLocation(400,10);

        addemployee.setTitle("RESTURANT MANAGEMENT APP");
        addemployee.add(new addemployee().getMainPanel());
        addemployee.setResizable(false);
    }
    public static void signout(){
        //AdminPanel.setVisible(false);
        Login = new JFrame();
        Login.setVisible(true);
        Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Login.setSize(1000,800);
        Login.setLocation(400,10);

        Login.setTitle("RESTURANT MANAGEMENT APP");
        Login.add(new Login_form().getMainPanel());
        Login.setResizable(false);
    }
    public static void callOrderdetailsframe(){
        Orderdetail = new JFrame();
        Orderdetail.setVisible(true);
        Orderdetail.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Orderdetail.setSize(1000,800);
        Orderdetail.setLocation(400,10);

        Orderdetail.setTitle("RESTURANT MANAGEMENT APP");
        Orderdetail.add(new Orderdetail().getMainPanel());
        Orderdetail.setResizable(false);
    }
    public static void callEmployeframe(){
        Employee = new JFrame();
        Employee.setVisible(true);
        Employee.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Employee.setSize(1000,800);
        Employee.setLocation(400,10);

        Employee.setTitle("RESTURANT MANAGEMENT APP");
        Employee.add(new Employee().getMainPanel());
        Employee.setResizable(false);
    }
    public static void calldelempframe(){
        delemp = new JFrame();
        delemp.setVisible(true);
        delemp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        delemp.setSize(1000,800);
        delemp.setLocation(400,10);

        delemp.setTitle("RESTURANT MANAGEMENT APP");
        delemp.add(new del_employe().getMainPanel());
        delemp.setResizable(false);
    }
}
