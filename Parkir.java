import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class Parkir implements ActionListener{

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat minuteFormat;
    SimpleDateFormat dateFormat;

    private JButton cek,clear,ok;
    private JLabel label, label1, label2, label3, lama, bayar,tanggal, td1,td2,line,gagal;
    private JTextField noPolisi,outTime,outMinute, timeLabel, minuteLabel, durasi, totalBayar;
    String time;
    String minute;

    JFrame frame = new JFrame("Aplikasi Parkir Simple");
    Parkir(){

        label = new JLabel("PARKING SYSTEM UPI KAMPUS PURWAKARTA");
        label.setFont(new Font(null, Font.BOLD,14));
        label.setBounds(30,30,350,60);
        frame.add(label);

        label1 = new JLabel("No Polisi");
        label1.setBounds(30, 100, 60,20);
        frame.add(label1);

        noPolisi = new JTextField();
        noPolisi.setBounds(120,100,225,25);
        frame.add(noPolisi);

        label2 = new JLabel("Jam Keluar");
        label2.setBounds(30,140,150,20);
        frame.add(label2);

        label3 = new JLabel("Jam Masuk");
        label3.setBounds(30,180,150,20);
        frame.add(label3);

        lama = new JLabel("Lama Parkir ");
        lama.setBounds(30,220,100,20);
        frame.add(lama);
        
        durasi= new JTextField(""); //field durasi parkir
        durasi.setBounds(120,220,225,25);
        durasi.setFont(new Font(null, Font.PLAIN,12));
        frame.add(durasi);

        //boxWaktu in (real tieme)
        timeFormat = new SimpleDateFormat("H");
        timeLabel = new JTextField();
        time = timeFormat.format(Calendar.getInstance().getTime());

        timeLabel.setText(time);
        timeLabel.setBounds(120,140,25,25);
        timeLabel.setFont(new Font(null, Font.BOLD,12));
        frame.add(timeLabel);

        td1 = new JLabel(":");
        td1.setBounds(145,140,25,25);
        td1.setFont(new Font(null, Font.PLAIN,18));
        frame.add(td1);

        //Box menit in (real time)
        minuteFormat = new SimpleDateFormat("mm");
        minuteLabel = new JTextField();
        minute = minuteFormat.format(Calendar.getInstance().getTime());

        minuteLabel.setText(minute);
        minuteLabel.setBounds(152,140,25,25);
        minuteLabel.setFont(new Font(null, Font.BOLD,12));
        frame.add(minuteLabel);

        totalBayar = new JTextField(" ");
        totalBayar.setBounds(120,300,225,25);
        totalBayar.setFont(new Font(null, Font.BOLD,12));
        frame.add(totalBayar);

        //Jam, menit Out (input sendiri)
        outTime = new JTextField(); //INI
        outTime.setBounds(120,180,25,25);
        frame.add(outTime);

        outMinute = new JTextField(); //INI
        outMinute.setBounds(152,180,25,25);
        frame.add(outMinute);

        td2 = new JLabel(":");
        td2.setBounds(145,180,25,25);
        td2.setFont(new Font(null, Font.PLAIN,18));
        frame.add(td2);

        bayar = new JLabel("Bayar Parkir ");
        bayar.setBounds(30,300,100,20);
        frame.add(bayar);

        line = new JLabel("=================================");
        line.setBounds(30,265,400,20);
        line.setFont(new Font(null, Font.PLAIN,16));
        frame.add(line);

        gagal = new JLabel();
        gagal.setBounds(30,340,300,20);
        frame.add(gagal);

        //CEK
        cek = new JButton("CEK");
        cek.setBounds(30,420,60,25);
        frame.add(cek);

        clear = new JButton("CLEAR");
        clear.setBounds(200,420,80,25);
        frame.add(clear);

        ok = new JButton("OK");
        ok.setBounds(290,420,60,25);
        frame.add(ok);

        cek.setFocusable(false);
        clear.setFocusable(false);
        ok.setFocusable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        /**frame.getContentPane().setBackground(new Color(16,144,144)); //ubah warna bg frame.*/

        cek.addActionListener((java.awt.event.ActionListener) this);
        clear.addActionListener((java.awt.event.ActionListener) this);
        ok.addActionListener((java.awt.event.ActionListener) this);
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
        if(e.getSource()==cek){
            int a = Integer.parseInt(timeLabel.getText());
            int b = Integer.parseInt(outTime.getText());
            int lamanya = a-b; 
            durasi.setText(lamanya+ " "+"JAM");
            totalBayar.setText(" "+lamanya*1000 + ",-");
        }
        if(e.getSource()==clear){
            durasi.setText(""); 
            totalBayar.setText("");
            outTime.setText("");
            outMinute.setText("");
        }
        if(e.getSource()==ok){
            if (durasi.getText().trim().isEmpty()){
                gagal.setText("Lengkapi kolom dengan benar!");
                gagal.setForeground(Color.RED);
                gagal.setFont(new Font(null,Font.BOLD, 12));
            }else{
                frame.dispose();
                Sukses baru = new Sukses();
            }
        }
    } 
    public static void main(String[] args) {
       Parkir p = new Parkir();
    }				
}
