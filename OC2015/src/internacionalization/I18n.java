package internacionalization;

import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class I18n {

    public static void main(String[] args) {

        Locale locale = Locale.getDefault();
        //Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("resources/MyResources", locale);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("I18N Test");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(3, 2));
        frame.add(new JLabel(rb.getString("userName")));
        frame.add(new JTextField());
        frame.add(new JLabel(rb.getString("password")));
        frame.add(new JPasswordField());
        frame.add(new JButton(rb.getString("login")));
        frame.pack();

        frame.setVisible(true);
    }
}
