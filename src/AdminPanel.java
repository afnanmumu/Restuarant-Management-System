import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel {
    private JButton placeOrderButton;
    private JButton availableItemsButton;
    private JButton dashboardButton;
    private JButton employeListButton;
    private JButton orderDetailsButton;
    private JPanel main;
    private JLabel pic;
    private JButton signOutButton;

    public AdminPanel() {
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    drive.callmenuframe();
                } catch (textnotfoundexp textnotfoundexp) {
                    textnotfoundexp.printStackTrace();
                }
                drive.AdminPanel.dispose();
            }
        });
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.signout();
                drive.AdminPanel.dispose();
            }
        });
        orderDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.callOrderdetailsframe();
            }
        });
        employeListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.callEmployeframe();
                drive.AdminPanel.dispose();
            }
        });
        availableItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Available_items();
                drive.AdminPanel.dispose();
            }
        });
        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drive.calldashboard();
            }
        });
    }

    JPanel getMainPanel(){return main;}
}
