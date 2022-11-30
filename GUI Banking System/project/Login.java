import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
   
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;

    public Login(){

      //USERNAME LABEL
      user_label = new JLabel();
      user_label.setText("Username (Full Name):");
      userName_text = new JTextField();
     

      //PASSWORD LABEL
      password_label = new JLabel();
      password_label.setText("Password :");
      password_text = new JPasswordField();

      //ENTER LABEL
      submit = new JButton("Enter");
      panel = new JPanel(new GridLayout(3, 1));
      panel.add(user_label);
      panel.add(userName_text);
      panel.add(password_label);
      panel.add(password_text);
      message = new JLabel();
      panel.add(message);
      panel.add(submit);
      
   
      submit.addActionListener(this);
      add(panel, BorderLayout.CENTER);
      setTitle("Please Login ");
      setSize(300,100);
      setVisible(true);
      this.setLocationRelativeTo(null);

      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
               dispose();
               System.exit(0);
         }
      });

   }

   public void actionPerformed(ActionEvent e) {
        setVisible(false);
   }

}