import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

public class RezerwacjeWindow extends JFrame implements ActionListener {
    private Budynek budynek = MainWindow.budynek;
    private JButton btnDodaj;
    private JButton btnZmien;
    private JButton btnUsun;
    private JButton btnPowrot;
    private JPanel mainPanel;

    private JList<Rezerwacja> lstRezerwacje;
    private JComboBox cmbSale;
    DefaultListModel<Rezerwacja> model = new DefaultListModel<Rezerwacja>();


    public RezerwacjeWindow() {
        this.setTitle("Rezerwacja sal w budynkach");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(500, 300, 800, 400);

        for (Sala s : budynek.getListaSal()) {
            cmbSale.addItem(s);
        }

        lstRezerwacje.setModel(model);
        odswiezenie();
        cmbSale.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                odswiezenie();
            }
        });

        btnPowrot.addActionListener(this::actionPerformed);
        btnDodaj.addActionListener(this::actionPerformed);
        btnUsun.addActionListener(this::actionPerformed);
        btnZmien.addActionListener(this::actionPerformed);
    }

    public void odswiezenie() {
        model.clear();
        Sala s1 = (Sala)cmbSale.getSelectedItem();
        for (Rezerwacja r : s1.getListaRezerwacji()) {
            model.addElement(r);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPowrot) {
            this.dispose();
        } else if (e.getSource() == btnDodaj) {
            Rezerwacja r = null;
            try {
                r = new Rezerwacja(null, "12.01.2001",1);
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            JFrame frame = new RezerwacjaWindow(r);
            frame.setVisible(true);
            try {
                ((Sala)cmbSale.getSelectedItem()).DodajRezerwacje(r);
            } catch (WlasnyWyjatek wlasnyWyjatek) {
                wlasnyWyjatek.printStackTrace();
            }
            model.clear();
            odswiezenie();
        } else if (e.getSource() == btnUsun) {
            Rezerwacja r = lstRezerwacje.getSelectedValue();
            for (Sala s : budynek.getListaSal()) {
                s.UsunRezerwacje(r);
            }
            model.clear();
            odswiezenie();
        } else if (e.getSource() == btnZmien) {
            Rezerwacja r = lstRezerwacje.getSelectedValue();
            JFrame frame = new RezerwacjaWindow(r);
            frame.setVisible(true);
            model.clear();
            odswiezenie();
        }
    }

}
