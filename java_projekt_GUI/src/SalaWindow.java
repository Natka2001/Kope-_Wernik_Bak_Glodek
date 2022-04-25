import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaWindow extends JFrame implements ActionListener {
    private JButton btnZatwierdz;
    private JPanel mainPanel1;
    private JButton btnAnuluj;
    private JComboBox cmbTyp;
    private JTextField txtIlosc;
    private JTextField txtNrSali;

    Sala s;

    public SalaWindow(Sala s){
        this.s = s;
        this.setTitle("Rezerwacja sal w budynkach");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel1);
        this.pack();
        this.setBounds(500,300,800,400);
        if(s==null){
            for (EnumTypSali typ:EnumTypSali.values()) {
                cmbTyp.addItem(typ);
            }
        }else{
            txtNrSali.setText(s.getNumer());
            txtIlosc.setText(String.valueOf(s.getIloscMiejsc()));
            for (EnumTypSali typ:EnumTypSali.values()) {
                cmbTyp.addItem(typ);
            }
            cmbTyp.setSelectedItem(s.getTypSali());
        }

        btnZatwierdz.addActionListener(this::actionPerformed);
        btnAnuluj.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnZatwierdz){
            s.setIloscMiejsc(Integer.parseInt(txtIlosc.getText())) ;
            s.setNumer(txtNrSali.getText());

            if(cmbTyp.getSelectedItem().toString()=="wykladowa") {
            s.setTypSali(EnumTypSali.wykladowa);}
            else if(cmbTyp.getSelectedItem().toString()=="labolatoryjnaChemiczna") {
                s.setTypSali(EnumTypSali.labolatoryjnaChemiczna);}
            else if(cmbTyp.getSelectedItem().toString()=="komputerowa") {
                s.setTypSali(EnumTypSali.komputerowa);}
            else if(cmbTyp.getSelectedItem().toString()=="cwiczeniowa") {
                s.setTypSali(EnumTypSali.cwiczeniowa);}
            else if(cmbTyp.getSelectedItem().toString()=="labolatoryjnaFizyczna") {
                s.setTypSali(EnumTypSali.labolatoryjnaFizyczna);}
            this.dispose();
        }
        else if(e.getSource() == btnAnuluj){
            this.dispose();
        }
    }
}
