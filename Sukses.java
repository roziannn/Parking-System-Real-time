import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.*;

public class Sukses implements ActionListener{

    private JButton kembali;
    private JLabel tanggal;
    
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Berhasil bayar! Parkir Selesai.");

    Sukses(){
        welcomeLabel.setBounds(95,150,300,35);
        welcomeLabel.setFont(new Font(null,Font.BOLD,15));
        welcomeLabel.setForeground(Color.BLUE);

        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,480);
        frame.setLayout(null);
        frame.setVisible(true);

        kembali = new JButton("KEMBALI");
        kembali.setBounds(150,220,100,25);
        frame.add(kembali);

        kembali.setFocusable(false);
        kembali.addActionListener((java.awt.event.ActionListener) this);

        //tambahan ket tgl,waktu di header paling atas
        tanggal = new JLabel();
        tanggal.setBounds(30,10,300,25);
        tanggal.setText(DateFormat.getDateTimeInstance().format(new Date()));
        tanggal.setFont(new Font(null, Font.PLAIN,12));
        frame.add(tanggal);

        Timer d = new Timer(0, new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
              tanggal.setText(
                 DateFormat.getDateTimeInstance().format(new Date())
              );
            }
         });
       d.setRepeats(true);
       d.setCoalesce(true);
       d.setInitialDelay(0);
       d.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==kembali){
            frame.dispose();
            Parkir back = new Parkir();
      }
    }
}
