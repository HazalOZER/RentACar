package view;

import core.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JPanel w_bottom;
    private JTextField fld_username;
    private JPasswordField fld_pass;
    private JButton btn_login;
    private JLabel lnl_username;
    private JLabel lbl_pass;

    public LoginView() {
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Rent A Car");
        this.setSize(400, 400);
        int x = ((Toolkit.getDefaultToolkit().getScreenSize().width) - (this.getSize().width)) / 2;
        int y = ((Toolkit.getDefaultToolkit().getScreenSize().height) - (this.getSize().height)) / 2;
        this.setLocation(x, y);
        this.setVisible(true);
        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmty(this.fld_username) || Helper.isFieldEmty(this.fld_pass)) {
                Helper.showMsg("fill");
            }

        });
    }
}
