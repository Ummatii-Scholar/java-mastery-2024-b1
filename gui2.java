import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class gui2{
    public static void main(String[] args) {
        JFrame fr = new JFrame("Swing");
        fr.setSize(400, 400);
        // ImageIcon icon = new ImageIcon("user.jpg");
        // Image img = icon.getImage();
        // img = img.getScaledInstance(100, 100, 0);
        fr.setLayout(null);
        // Jlabel 
        JLabel  jl = new JLabel("name");
        jl.setBounds(20, 40, 40, 20);
        fr.add(jl);
        // Jtextfeid
        JTextField jt = new JTextField(10);
        jt.setBounds(60, 40, 40, 20);
        fr.add(jt);
        // Jbuton
        JButton jb = new JButton("click");
        jb.setBounds(80, 80, 100, 20);
        fr.add(jb);

        JLabel ln = new JLabel();
        jb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ln.setText(jt.getText());
                ln.setBounds(120, 120, 100, 20);
                fr.add(ln);
            }
        });
        // text area
        JTextArea ta = new JTextArea("hai");
        fr.setVisible(true);
    }
}