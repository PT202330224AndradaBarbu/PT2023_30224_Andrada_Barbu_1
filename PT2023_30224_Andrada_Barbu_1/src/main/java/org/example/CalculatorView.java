package org.example;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JLabel polinom1Label;
    private JTextField textFieldPolinom1;
    private JLabel polinom2Label;
    private JButton adunareButton;
    private JButton scadereButton;
    private JButton inmultireButton;
    private JButton impartireButton;
    private JButton derivareButton;
    private JButton integrareButton;
    private JTextField textFieldPolinom2;
    private JTextField textFieldRest;
    private JLabel restLabel;
    private JTextField textFieldRezultat;
    private JLabel rezultatLabel;
    private JPanel contentPanel;

    private CalculatorModel calculatorModel;

    public CalculatorView(CalculatorModel model) {
        calculatorModel = model;
        setContentPane(contentPanel);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addAdunareListener(ActionListener adunareAL) {
        adunareButton.addActionListener(adunareAL);
    }
    public void addScadereListener(ActionListener scadereAL){
        scadereButton.addActionListener(scadereAL);
    }
    public void addDerivareListener(ActionListener derivareAL){
        derivareButton.addActionListener(derivareAL);
    }
    public void addIntegrareListener(ActionListener integrareAL){
        integrareButton.addActionListener(integrareAL);
    }
    public void addInmultireListener(ActionListener inmultireALL){
        inmultireButton.addActionListener(inmultireALL);
    }

    public void addImpartireListener(ActionListener impartireALL){
        impartireButton.addActionListener(impartireALL);
    }
    public JTextField getTextFieldPolinom1() {
        return textFieldPolinom1;
    }

    public void setTextFieldPolinom1(JTextField textFieldPolinom1) {
        this.textFieldPolinom1 = textFieldPolinom1;
    }

    public JTextField getTextFieldPolinom2() {
        return textFieldPolinom2;
    }

    public void setTextFieldPolinom2(JTextField textFieldPolinom2) {
        this.textFieldPolinom2 = textFieldPolinom2;
    }

    public JTextField getTextFieldRezultat() {
        return textFieldRezultat;
    }

    public void setTextFieldRezultat(String textRezultat) {
        this.textFieldRezultat.setText(textRezultat);
    }

    public JTextField getTextFieldRest() {
        return textFieldRest;
    }

    public void setTextFieldRest(String textRest) {
        this.textFieldRest.setText(textRest);
    }

    public void aruncaEroare(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}
