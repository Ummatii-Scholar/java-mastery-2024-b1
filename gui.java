// 
import java.awt.*;
import java.awt.event.*;
public class gui{
    public static void main(String[] args){
        // Frame
        Frame fr  = new Frame("Gui");
        fr.setSize(400, 400);
        fr.setVisible(true);
        fr.setLayout(null);
        // label 
        // panel
        // Panel pa = new Panel(null);
        Label la = new Label("Name");
        la.setBounds(10, 25, 80, 25);
        fr.add(la); 
        // fr.add(pa);
        // textbox
        TextField tf = new TextField(20);
        tf.setBounds(100, 25, 150, 25);
        fr.add(tf);
        // Button
        Button bt  =new Button("Submit");
        bt.setBounds(50, 50, 100, 30);
        fr.add(bt);
        Label name = new Label();
        bt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                name.setText(tf.getText());
                name.setBounds(100, 100, 100, 20);
                fr.add(name);
            }
        });
        TextArea ta =new TextArea();
        ta.setBounds(150, 150, 100, 100);
        fr.add(ta);
        // radiobutton checkbox combobox list menu scroll panel tabel textarea 
    }
}
/*
 * |   |    |
 * |   |    |
 * |   |    |
 */