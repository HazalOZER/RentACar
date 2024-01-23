package core;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setThere() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getClassName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    public static void showMsg(String str) {
        String msg;
        String title;
        switch (str) {
            case "fill":
                msg = "Lütfen tüm alanları doldurunuz";
                title = "Hata!";
                break;
            case "done":
                msg = "İşlem Başarılı";
                title = "Sonuç";
                break;
            case "notFound" :
                msg = "Kayıt Bulunamadı";
                title = "Bulunamadı";
                break;
            default:
                msg = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);

    }

    public static boolean isFieldEmty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (Helper.isFieldEmty(field)) return true;
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> ((Toolkit.getDefaultToolkit().getScreenSize().width) - (size.width)) / 2;
            case "y" -> ((Toolkit.getDefaultToolkit().getScreenSize().height) - (size.height)) / 2;
            default -> 0;
        };
    }
}
