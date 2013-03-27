/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicNetworking.calculator;
import dynamicNetworking.calculator.operationsServer.OperationsServer;
import dynamicNetworking.calculator.operationsServer.UnknownOperationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author steffen
 */
public class Calculator extends JFrame {
    OperationsServer server = new OperationsServer();
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
       
       final JTextField op1 = new JTextField("0");
       final JTextField op2 = new JTextField("0");
       final JTextField oper = new JTextField("+");
       final JLabel answer = new JLabel("0");
       
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
                
                try {
                    Float servAnswer = server.getOperation(oper.getText()).compute(Float.parseFloat(op1.getText()),Float.parseFloat(op2.getText()) );
                    answer.setText(servAnswer.toString());
                } catch (UnknownOperationException ex) {
                    Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
                }
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