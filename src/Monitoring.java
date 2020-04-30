import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Monitoring extends JFrame implements ListSelectionListener {
    JList liste = new JList();
    JLabel etiquette = new JLabel("                   ");

  public Monitoring() {
    String choix[] = {" Alarme GAZ -> idAlarme : 1"};
   
    liste = new JList(choix);
    liste.addListSelectionListener(this);

    add(etiquette, BorderLayout.CENTER);
    add(liste, BorderLayout.WEST);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    pack();
    int frameWidth = 500;
    int frameHeight = 800;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
    setVisible(true);
  }

  public void valueChanged(ListSelectionEvent evt)  { 
      etiquette.setText((String)liste.getSelectedValue());    
  }
} 