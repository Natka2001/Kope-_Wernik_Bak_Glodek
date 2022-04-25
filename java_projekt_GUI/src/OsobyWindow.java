import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OsobyWindow extends JFrame implements ActionListener {

    private Budynek budynek = MainWindow.budynek;
    private JButton btnDodaj;
    private JButton btnZmien;
    private JButton btnUsun;
    private JButton btnAnuluj;
    private JLabel Osoby;
    private JPanel mainPanel;

    private JList<Pracownik> lstPracownicy;
    DefaultListModel<Pracownik> model1 = new DefaultListModel<Pracownik>();


    public OsobyWindow(){

        prepareGui();
        System.out.println(budynek.getListaPracownikow());
        btnAnuluj.addActionListener(this::actionPerformed);
        btnDodaj.addActionListener(this::actionPerformed);
        btnUsun.addActionListener(this::actionPerformed);
        btnZmien.addActionListener(this::actionPerformed);
    }

    public void prepareGui(){
        this.setTitle("Rezerwacja sal w budynkach");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(500,300,800,400);

        lstPracownicy.setModel(model1);
        for (Pracownik p:budynek.getListaPracownikow()) {
            model1.addElement(p);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAnuluj){
            this.dispose();
        }
        else if (e.getSource() == btnDodaj) {
            Pracownik p = new Pracownik();
            JFrame frame = new OsobaWindow(p);
            frame.setVisible(true);
            budynek.DodajOsobe(p);
            model1.clear();
            for (Pracownik p1 : budynek.getListaPracownikow()) {
                model1.addElement(p1);
            }
        }
        else if(e.getSource() == btnUsun){
            Pracownik p = lstPracownicy.getSelectedValue();
            budynek.UsunOsobe(p);
            model1.clear();
            for (Pracownik p1 : budynek.getListaPracownikow()) {
                model1.addElement(p1);
            }
        }
        else if(e.getSource() == btnZmien){
            Pracownik p = lstPracownicy.getSelectedValue();
            JFrame frame = new OsobaWindow(p);
            frame.setVisible(true);
            model1.clear();
            for (Pracownik p1 : budynek.getListaPracownikow()) {
                model1.addElement(p1);
            }
        }
    }
}
