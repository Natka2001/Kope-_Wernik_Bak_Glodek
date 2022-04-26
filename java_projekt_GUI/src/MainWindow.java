import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow extends JFrame implements ActionListener {

    public static Budynek budynek;
    private JPanel mainPanel;
    private JButton btnSale;
    private JButton btnOsoby;
    private JButton btnZarezerwuj;

    MainWindow(){
        this.setTitle("Rezerwacja sal w budynkach");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(500,300,800,400);
        btnSale.addActionListener(this::actionPerformed);
        btnOsoby.addActionListener(this::actionPerformed);
        btnZarezerwuj.addActionListener(this::actionPerformed);

        try {
            budynek = Budynek.odczytaj("budynek.bin");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(budynek.getListaPracownikow());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSale) {
            JFrame frame = new BudynekWindow();
            frame.setVisible(true);
        }

        else if (e.getSource() == btnOsoby) {
            JFrame frame = new OsobyWindow();
            frame.setVisible(true);
        }
        else if (e.getSource() == btnZarezerwuj) {
            JFrame frame = new RezerwacjeWindow();
            frame.setVisible(true);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new MainWindow();
        frame.setVisible(true);
    }
}
