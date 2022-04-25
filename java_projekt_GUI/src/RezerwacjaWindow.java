import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RezerwacjaWindow extends JFrame implements ActionListener {


    private Budynek budynek = MainWindow.budynek;
    private JPanel mainPanel;
    private JTextField txtData;
    private JTextField txtCzas;
    private JComboBox cmbOsoba;
    private JButton btnAnuluj;
    private JButton btnZatwierdz;

    Rezerwacja r;

    public RezerwacjaWindow(Rezerwacja r) {
        this.r = r;
        this.setTitle("Rezerwacja sal w budynkach");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(500, 300, 800, 400);

        if (r.getDat() == null) {
            for (Pracownik p : budynek.getListaPracownikow()) {
                cmbOsoba.addItem(p);
            }
        } else {
            for (Pracownik p : budynek.getListaPracownikow()) {
                cmbOsoba.addItem(p);
            }
            txtData.setText(r.getDat().toString());
            txtCzas.setText(String.valueOf(r.getDuration()));
            cmbOsoba.getSelectedItem();
        }

        btnZatwierdz.addActionListener(this::actionPerformed);
        btnAnuluj.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnZatwierdz){
            r.setDuration(Integer.parseInt(txtCzas.getText()));
            r.setDate(txtData.getText());
            r.setP((Pracownik)cmbOsoba.getSelectedItem());
            this.dispose();
        }
        else if(e.getSource() == btnAnuluj){
            this.dispose();
        }
    }
}
