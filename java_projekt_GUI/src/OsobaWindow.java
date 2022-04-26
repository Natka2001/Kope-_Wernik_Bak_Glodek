import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OsobaWindow extends JFrame implements ActionListener {
    private JTextField txtImie;
    private JTextField txtNazwisko;
    private JComboBox cmbWydzial;
    private JComboBox cmbTytul;
    private JButton btnZatwierdz;
    private JButton btnAnuluj;
    private JLabel label;
    private JPanel mainPanel;

    private Pracownik p;

    public OsobaWindow(Pracownik p){
        this.p = p;
        this.setTitle("Rezerwacja sal w budynkach");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(500,300,800,400);

        btnZatwierdz.addActionListener(this::actionPerformed);
        btnAnuluj.addActionListener(this::actionPerformed);

        if(p==null){
            for (EnumWydzial wydzial:EnumWydzial.values()) {
                cmbWydzial.addItem(wydzial);
            }
            for (EnumTytul typ:EnumTytul.values()) {
                cmbTytul.addItem(typ);
            }
        }
        else {
            for (EnumWydzial wydzial:EnumWydzial.values()) {
                cmbWydzial.addItem(wydzial);
            }
            for (EnumTytul typ:EnumTytul.values()) {
                cmbTytul.addItem(typ);
            }
            txtImie.setText(p.getImie());
            txtNazwisko.setText(p.getNazwisko());
            cmbWydzial.setSelectedItem(p.getWydzial());
            cmbTytul.setSelectedItem(p.getTytul());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnZatwierdz){
            p.setNazwisko(txtNazwisko.getText());
           p.setImie(txtImie.getText());
            if(cmbWydzial.getSelectedItem().toString()=="WZ") {
                p.setWydzial(EnumWydzial.WZ);}
            else if(cmbWydzial.getSelectedItem().toString()=="WIMIR") {
                p.setWydzial(EnumWydzial.WIMIR);}
            else if(cmbWydzial.getSelectedItem().toString()=="WINIP") {
                p.setWydzial(EnumWydzial.WINIP);}
            else if(cmbWydzial.getSelectedItem().toString()=="WIP") {
                p.setWydzial(EnumWydzial.WIP);}
            else if(cmbWydzial.getSelectedItem().toString()=="WILiGZ") {
                p.setWydzial(EnumWydzial.WILiGZ);}
            else if(cmbWydzial.getSelectedItem().toString()=="WH") {
                p.setWydzial(EnumWydzial.WH);}

            if(cmbTytul.getSelectedItem().toString()=="magister") {
                p.setTytul(EnumTytul.magister);}
            else if(cmbTytul.getSelectedItem().toString()=="doktor") {
                p.setTytul(EnumTytul.doktor);}
            else  if(cmbTytul.getSelectedItem().toString()=="dogtorHabilitowany") {
                p.setTytul(EnumTytul.dogtorHabilitowany);}
            this.dispose();
        }
        else if(e.getSource() == btnAnuluj){
            this.dispose();
        }
    }
}
