import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class DigitalClock extends JFrame {
private JLabel timeLabel;
private JLabel dateLabel;

public DigitalClock(){
    setTitle("Digital Clock");
    setSize(500,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    panel.setLayout(new BorderLayout());

    timeLabel = new JLabel();
    timeLabel.setFont(new Font("Arial", Font.PLAIN,60));
    timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    timeLabel.setVerticalAlignment(SwingConstants.CENTER);
    timeLabel.setForeground(Color.RED);

    dateLabel =new JLabel();
    dateLabel.setFont(new Font("Arial",Font.PLAIN,20));
    dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
    dateLabel.setVerticalAlignment(SwingConstants.CENTER);
    dateLabel.setForeground(Color.WHITE);

    panel.add(timeLabel , BorderLayout.CENTER);
    panel.add(dateLabel, BorderLayout.SOUTH);
    //panel.add(dateLabel, BorderLayout.EAST);
    //panel.add(dateLabel, BorderLayout.WEST);

    panel.setBackground(Color.BLACK);

    add(panel);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            updateTimeAndDate();
        }
    });
    timer.start();
}

private void updateTimeAndDate(){
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
String time = timeFormatter.format(calendar.getTime());

SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE,MMM dd, yyyy");
String date = dateFormatter.format(calendar.getTime());

timeLabel.setText(time);
dateLabel.setText(date);

}
    public static void main(String args[]){
DigitalClock clock = new DigitalClock();
clock.setVisible(true);    }
}
