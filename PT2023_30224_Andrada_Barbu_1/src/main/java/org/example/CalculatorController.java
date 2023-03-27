package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CalculatorController {

    private CalculatorModel model;

    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        view.addAdunareListener(new AdunareListener());
        view.addScadereListener(new ScadereListener());
        view.addDerivareListener(new DerivareListener());
        view.addIntegrareListener(new IntegrareListener());
        view.addInmultireListener(new InmultireListener());
        view.addImpartireListener(new ImpartireListener());
    }

    class AdunareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String p1 = view.getTextFieldPolinom1().getText();
                String p2 = view.getTextFieldPolinom2().getText();
                model.setPolinom1(model.crearePolinom(p1));
                model.setPolinom2(model.crearePolinom(p2));
                model.adunare();
                view.setTextFieldRezultat(model.getPolinomRezultat().toString());
                view.setTextFieldRest("");
            } catch (IOException ex) {
                view.aruncaEroare(ex.getMessage());
            }
        }
    }

    class ScadereListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String p1 = view.getTextFieldPolinom1().getText();
                String p2 = view.getTextFieldPolinom2().getText();
                model.setPolinom1(model.crearePolinom(p1));
                model.setPolinom2(model.crearePolinom(p2));
                model.scadere();
                view.setTextFieldRezultat(model.getPolinomRezultat().toString());
                view.setTextFieldRest("");
            } catch (IOException ex) {
                view.aruncaEroare(ex.getMessage());
            }
        }
    }

    class DerivareListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String p1=view.getTextFieldPolinom1().getText();
                model.setPolinom1(model.crearePolinom(p1));
                model.derivare();
                view.setTextFieldRezultat(model.getPolinomRezultat().toString());
                view.setTextFieldRest("");
            } catch (IOException ex) {
                view.aruncaEroare(ex.getMessage());
            }
        }
    }

    class IntegrareListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String p1=view.getTextFieldPolinom1().getText();
                model.setPolinom1(model.crearePolinom(p1));
                model.integrare();
                view.setTextFieldRezultat(model.getPolinomRezultat().toString());
                view.setTextFieldRest("");
            } catch (IOException ex) {
                view.aruncaEroare(ex.getMessage());
            }
        }
    }
    class InmultireListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String p1=view.getTextFieldPolinom1().getText();
                String p2=view.getTextFieldPolinom2().getText();
                model.setPolinom1(model.crearePolinom(p1));
                model.setPolinom2(model.crearePolinom(p2));
                model.inmultire();
                view.setTextFieldRezultat(model.getPolinomRezultat().toString());
                view.setTextFieldRest("");
            } catch (IOException ex) {
                view.aruncaEroare(ex.getMessage());
            }
        }
    }

    class ImpartireListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String p1=view.getTextFieldPolinom1().getText();
                String p2=view.getTextFieldPolinom2().getText();
                model.setPolinom1(model.crearePolinom(p1));
                model.setPolinom2(model.crearePolinom(p2));
                model.impartire();
                view.setTextFieldRezultat(model.getPolinomRezultat().toString());
                view.setTextFieldRest(model.getPolinomRest().toString());
            } catch (IOException ex) {
                view.aruncaEroare(ex.getMessage());
            }
        }
    }

}
