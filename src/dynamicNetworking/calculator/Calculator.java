/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicNetworking.calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author steffen
 */
public class Calculator extends JFrame {
    public Calculator() {
        initUI();
    }

    public final void initUI() {

       JPanel panel = new JPanel();
       JPanel left = new JPanel();
       JPanel middle = new JPanel();
       JPanel right = new JPanel();
       JPanel solution = new JPanel();
       JButton quitButton = new JButton("Quit");
       JButton eq = new JButton("=");
       
       panel.add(left);
       panel.add(middle);
       panel.add(right);
       panel.add(eq);
       panel.add(solution);
       panel.add(quitButton);
       getContentPane().add(panel);
       
       JTextField op1 = new JTextField("0");
       JTextField op2 = new JTextField("0");
       JTextField oper = new JTextField("+");
       JLabel answer = new JLabel("0");
       
       left.add(op1);
       middle.add(oper);
       right.add(op2);
       solution.add(answer);
       
       
       quitButton.setBounds(50, 60, 80, 30);
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
       });
       
       eq.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               //what to do when equals button is pressed
          }
       });
       setTitle("Java Calculator");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculator ex = new Calculator();
                ex.setVisible(true);
            }
        });
    }
}