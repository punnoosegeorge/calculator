import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class calculatordemo implements ActionListener {
    String oldValue;
    boolean operatorClicked = false;
    String operator = ""; // To keep track of the operator used
    JFrame jf;
    JLabel displayLabel;
    JButton SEVENBUTTON, EIGHTBUTTON, NINEBUTTON, FOURBUTTON, fiveBUTTON, sixBUTTON, ONEBUTTON, twobutton, threebutton, dotBUTTON, zerobutton, equalbutton, divBUTTON, multBUTTON, subbutton, addbutton, clearbutton;

    public calculatordemo() {
        jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(600, 600);

        displayLabel = new JLabel("");
        displayLabel.setBounds(30, 50, 540, 40);
        displayLabel.setBackground(Color.gray);
        displayLabel.setOpaque(true);
        displayLabel.setForeground(Color.WHITE);

        // Initialize buttons
        SEVENBUTTON = new JButton("7");
        SEVENBUTTON.setBounds(30, 120, 80, 80);
        SEVENBUTTON.addActionListener(this);

        EIGHTBUTTON = new JButton("8");
        EIGHTBUTTON.setBounds(130, 120, 80, 80);
        EIGHTBUTTON.addActionListener(this);

        NINEBUTTON = new JButton("9");
        NINEBUTTON.setBounds(240, 120, 80, 80);
        NINEBUTTON.addActionListener(this);

        FOURBUTTON = new JButton("4");
        FOURBUTTON.setBounds(30, 230, 80, 80);
        FOURBUTTON.addActionListener(this);

        fiveBUTTON = new JButton("5");
        fiveBUTTON.setBounds(130, 230, 80, 80);
        fiveBUTTON.addActionListener(this);

        sixBUTTON = new JButton("6");
        sixBUTTON.setBounds(240, 230, 80, 80);
        sixBUTTON.addActionListener(this);

        ONEBUTTON = new JButton("1");
        ONEBUTTON.setBounds(30, 340, 80, 80);
        ONEBUTTON.addActionListener(this);

        twobutton = new JButton("2");
        twobutton.setBounds(130, 340, 80, 80);
        twobutton.addActionListener(this);

        threebutton = new JButton("3");
        threebutton.setBounds(240, 340, 80, 80);
        threebutton.addActionListener(this);

        dotBUTTON = new JButton(".");
        dotBUTTON.setBounds(30, 450, 80, 80);
        dotBUTTON.addActionListener(this);

        zerobutton = new JButton("0");
        zerobutton.setBounds(130, 450, 80, 80);
        zerobutton.addActionListener(this);

        equalbutton = new JButton("=");
        equalbutton.setBounds(240, 450, 80, 80);
        equalbutton.addActionListener(this);

        divBUTTON = new JButton("/");
        divBUTTON.setBounds(340, 120, 80, 80);
        divBUTTON.addActionListener(this);

        multBUTTON = new JButton("*");
        multBUTTON.setBounds(340, 230, 80, 80);
        multBUTTON.addActionListener(this);

        subbutton = new JButton("-");
        subbutton.setBounds(340, 340, 80, 80);
        subbutton.addActionListener(this);

        addbutton = new JButton("+");
        addbutton.setBounds(340, 450, 80, 80);
        addbutton.addActionListener(this);

        clearbutton = new JButton("clear");
        clearbutton.setBounds(440, 450, 80, 80);
        clearbutton.addActionListener(this);

        jf.add(displayLabel);
        jf.add(SEVENBUTTON);
        jf.add(EIGHTBUTTON);
        jf.add(NINEBUTTON);
        jf.add(FOURBUTTON);
        jf.add(fiveBUTTON);
        jf.add(sixBUTTON);
        jf.add(ONEBUTTON);
        jf.add(twobutton);
        jf.add(threebutton);
        jf.add(zerobutton);
        jf.add(dotBUTTON);
        jf.add(equalbutton);
        jf.add(divBUTTON);
        jf.add(multBUTTON);
        jf.add(subbutton);
        jf.add(addbutton);
        jf.add(clearbutton);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new calculatordemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SEVENBUTTON) {
            handleNumberInput("7");
        } else if (e.getSource() == EIGHTBUTTON) {
            handleNumberInput("8");
        } else if (e.getSource() == NINEBUTTON) {
            handleNumberInput("9");
        } else if (e.getSource() == FOURBUTTON) {
            handleNumberInput("4");
        } else if (e.getSource() == fiveBUTTON) {
            handleNumberInput("5");
        } else if (e.getSource() == sixBUTTON) {
            handleNumberInput("6");
        } else if (e.getSource() == ONEBUTTON) {
            handleNumberInput("1");
        } else if (e.getSource() == twobutton) {
            handleNumberInput("2");
        } else if (e.getSource() == threebutton) {
            handleNumberInput("3");
        } else if (e.getSource() == dotBUTTON) {
            handleNumberInput(".");
        } else if (e.getSource() == zerobutton) {
            handleNumberInput("0");
        } else if (e.getSource() == equalbutton) {
            handleEqualButton();
        } else if (e.getSource() == divBUTTON) {
            handleOperator("/");
        } else if (e.getSource() == multBUTTON) {
            handleOperator("*");
        } else if (e.getSource() == subbutton) {
            handleOperator("-");
        } else if (e.getSource() == addbutton) {
            handleOperator("+");
        } else if (e.getSource() == clearbutton) {
            displayLabel.setText("");
        }
    }

    private void handleNumberInput(String number) {
        if (operatorClicked) {
            displayLabel.setText(number);
            operatorClicked = false;
        } else {
            displayLabel.setText(displayLabel.getText() + number);
        }
    }

    private void handleOperator(String op) {
        operatorClicked = true;
        oldValue = displayLabel.getText();
        operator = op;
    }

    private void handleEqualButton() {
        String newValue = displayLabel.getText();
        float oldValueF = Float.parseFloat(oldValue);
        float newValueF = Float.parseFloat(newValue);
        float result = 0;

        switch (operator) {
            case "+":
                result = oldValueF + newValueF;
                break;
            case "-":
                result = oldValueF - newValueF;
                break;
            case "*":
                result = oldValueF * newValueF;
                break;
            case "/":
                result = oldValueF / newValueF;
                break;
        }
        displayLabel.setText(result + "");
    }
}
