package view;

import core.Helper;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    private JPanel container;

   public void guiInitilaze(int witdth, int height){

       this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       this.setTitle("Rent A Car");
       this.setSize(witdth, height);
       this.setLocation(Helper.getLocationPoint("x",this.getSize()),Helper.getLocationPoint("y",this.getSize()));
       this.setVisible(true);
   }
}
