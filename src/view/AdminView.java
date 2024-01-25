package view;

import business.BrandManager;
import business.ModelManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane pnl_model;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scl_brand;
    private JTable tbl_brand;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private User user;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private BrandManager brandManager;
    private ModelManager modelManager;
    private JPopupMenu brandMenu;
    private JPopupMenu modelMenu;

    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.add(container);
        this.guiInitilaze(1000, 500);
        this.user = user;

        if (this.user == null) {
            dispose();
        }

        this.lbl_welcome.setText("Hoşgeldin " + this.user.getUsername());

        loadBrandTable();
        loadBrandComponent();

        loadModelTable();
        tableRowSelect(this.tbl_model);


    }

    private void loadModelTable() {
        Object[] col_model = {"Model ID", "Marka", "Model Adı", "Tip", "Yıl", "Yakıt Türü", "Vites"};
        ArrayList<Object[]> modelList = this.modelManager.getForTable(col_model.length, this.modelManager.findAll());
        createTable(this.tmdl_model, this.tbl_model, col_model, modelList);

    }

    public void loadBrandTable() {

        Object[] col_brand = {"Marka ID", "Marka Adı"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brand, col_brand, brandList);

    }

    private void loadBrandComponent() {

        tableRowSelect(this.tbl_brand);

        this.brandMenu = new JPopupMenu();
        this.brandMenu.add("Yeni").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });
        });
        this.brandMenu.add("Güncelle").addActionListener(e -> {
            int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });

        });
        this.brandMenu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
                if (this.brandManager.delete(selectBrandId)) {
                    Helper.showMsg("done");
                    loadBrandTable();
                } else {
                    Helper.showMsg("error");
                }
            }

        });
        this.tbl_brand.setComponentPopupMenu(this.brandMenu);
    }


}
