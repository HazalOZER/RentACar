package view;

import core.Helper;
import entity.User;

import javax.swing.*;

public class AdminView extends Layout{
    private JPanel container;
    private User user ;

    public AdminView (User user){
        this.add(container);
        this.guiInitilaze(1000,500);
        this.user = user;

        if (user == null){
            dispose();
        }
    }
}
