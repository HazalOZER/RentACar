package core;

import javax.swing.*;

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
            default:
                msg = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, str, title, JOptionPane.INFORMATION_MESSAGE);

    }

    public static boolean isFieldEmty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmty(JTextField[] fiekdList) {
        for (JTextField field : fiekdList) {
            if (Helper.isFieldEmty(field)) return true;
        }
        return false;
    }
}
