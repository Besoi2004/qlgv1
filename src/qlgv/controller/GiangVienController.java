
package qlgv.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;
import qlgv.model.GiangVien;
import qlgv.service.GiangVienServiceImpl;
import qlgv.service.GiangVienService;
import qlgv.utility.CLassTableModel;

/**
 *
 * @author ASUS
 */
public class GiangVienController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private GiangVienService giangVienService = null;
    
    private String[] listColumn = {"Mã Giảng Viên", "STT", "Họ và Tên","Địa Chỉ", "Trình Độ"};
    
    private TableRowSorter<TableModel> rowSorter = null;
            
    public GiangVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.giangVienService = new GiangVienServiceImpl();
    }
    
public void setDataToTable() {
    List<GiangVien> listItem = giangVienService.getList();
    DefaultTableModel model = new CLassTableModel().setTableGiangVien(listItem, listColumn);
    JTable table = new JTable(model);

    rowSorter = new TableRowSorter<>(table.getModel());
    table.setRowSorter(rowSorter);

    jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            String text = jtfSearch.getText();
            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0, 1, 2, 3,4));
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String text = jtfSearch.getText();
            if (text.trim().length() == 0) {
                rowSorter.setRowFilter(null);
            } else {
                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0, 1, 2, 3,4));
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    });

    table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
    table.getTableHeader().setPreferredSize(new Dimension(100, 50));
    table.setRowHeight(50);
    table.validate();
    table.repaint();

    JScrollPane scroll = new JScrollPane();
    scroll.getViewport().add(table);
    scroll.setPreferredSize(new Dimension(1150, 400));

    jpnView.removeAll();
    jpnView.setLayout(new CardLayout());
    jpnView.add(scroll);
    jpnView.validate();
    jpnView.repaint();
}

}
