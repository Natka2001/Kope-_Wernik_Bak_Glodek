import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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


        btnZatwierdz.addActionListener(this::actionPerformed);
        btnAnuluj.addActionListener(this::actionPerformed);

        if (r.getDuration()==0) {
            for (Pracownik p : budynek.getListaPracownikow()) {
                cmbOsoba.addItem(p);
            }
        } else {
            for (Pracownik p : budynek.getListaPracownikow()) {
                cmbOsoba.addItem(p);
            }
            txtData.setText(r.getDate().toString());
            txtCzas.setText(String.valueOf(r.getDuration()));
            cmbOsoba.getSelectedItem();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnZatwierdz){
            r.setDuration(Integer.parseInt(txtCzas.getText()));
            SimpleDateFormat form = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            try {
                r.setDate(form.parse(txtData.getText()));
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            r.setP((Pracownik)cmbOsoba.getSelectedItem());
            this.dispose();
        }
        else if(e.getSource() == btnAnuluj){
            this.dispose();
        }
    }
}
