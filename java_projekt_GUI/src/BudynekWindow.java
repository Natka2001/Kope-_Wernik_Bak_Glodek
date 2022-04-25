import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class BudynekWindow extends JFrame implements ActionListener{

    private Budynek budynek = MainWindow.budynek;
    private JPanel mainPanel;
    private JButton btnDodaj;
    private JButton btnUsun;
    private JButton btnSortujPoNumerze;
    private JButton btnSortujPoIlości;
    private JButton btnZmien;
    private JButton btnPowrot;
    private JTextField txtNazwaBudynku;
    private JTextField txtWydzial;

    private JList<Sala> lstSale;
    DefaultListModel<Sala> model = new DefaultListModel<Sala>();



    public BudynekWindow(){
        prepareGui();

        btnDodaj.addActionListener(this::actionPerformed);
        btnSortujPoIlości.addActionListener(this::actionPerformed);
        btnSortujPoNumerze.addActionListener(this::actionPerformed);
        btnUsun.addActionListener(this::actionPerformed);
        btnZmien.addActionListener(this::actionPerformed);
        btnPowrot.addActionListener(this::actionPerformed);
    }


    public void prepareGui(){
        this.setTitle("Rezerwacja sal w budynkach");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(500,300,800,400);


        txtNazwaBudynku.setText(budynek.getNazwa());
        txtWydzial.setText(budynek.getWydzial().toString());
        lstSale.setModel(model);
        for (Sala s:budynek.getListaSal()) {
            model.addElement(s);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDodaj) {
            Sala s = new Sala();
            JFrame frame = new SalaWindow(s);
            frame.setVisible(true);
            budynek.DodajSale(s);
            model.clear();
            for (Sala s1 : budynek.getListaSal()) {
                model.addElement(s1);
            }
        }
        else if(e.getSource() == btnSortujPoIlości){
            budynek.SortujPoIlosci();
            model.clear();
            for (Sala s1 : budynek.getListaSal()) {
                model.addElement(s1);
            }
        }
        else if(e.getSource() == btnSortujPoNumerze){
            budynek.SortujPoNumerze();
            model.clear();
            for (Sala s1 : budynek.getListaSal()) {
                model.addElement(s1);
            }
        }
        else if(e.getSource() == btnUsun){
            Sala sala = lstSale.getSelectedValue();
            try {
                budynek.UsunSale(sala);
            } catch (WlasnyWyjatek wlasnyWyjatek) {
                wlasnyWyjatek.printStackTrace();
            }
            model.clear();
            for (Sala s1 : budynek.getListaSal()) {
                model.addElement(s1);
            }
        }
        else if(e.getSource() == btnZmien){
            Sala s2 = lstSale.getSelectedValue();
            JFrame frame = new SalaWindow(s2);
            frame.setVisible(true);
            model.clear();
            for (Sala s1 : budynek.getListaSal()) {
                model.addElement(s1);
            }
        }

        else if(e.getSource() == btnPowrot){
            this.dispose();
        }
    }


}
