package org.example;

import java.awt.datatransfer.FlavorEvent;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;

public class CalculatorModel {

    private Polinom polinom1;

    private Polinom polinom2;

    private Polinom polinomRezultat;

    private Polinom polinomRest;

    private Operatii operatii;

    CalculatorModel() {
        polinom1=new Polinom();
        polinom2=new Polinom();
        polinomRezultat=new Polinom();
        polinomRest=new Polinom();
        operatii = new Operatii();
    }

    public void adunare(){
        polinomRezultat.reinitializarePolinom();
        polinomRezultat = operatii.adunarePolinom(polinom1, polinom2);
    }
    public void scadere(){
        polinomRezultat.reinitializarePolinom();
        polinomRezultat = operatii.scaderePolinom(polinom1, polinom2);
    }
    public void derivare(){
        polinomRezultat.reinitializarePolinom();
        polinomRezultat = operatii.derivarePolinom(polinom1);
    }

    public void integrare(){
        polinomRezultat.reinitializarePolinom();
        polinomRezultat = operatii.integrarePolinom(polinom1);
    }

    public void inmultire(){
        polinomRezultat.reinitializarePolinom();
        polinomRezultat = operatii.inmultirePolinom(polinom1, polinom2);
    }
    public void impartire(){
        polinomRezultat.reinitializarePolinom();
        polinomRest.reinitializarePolinom();
        operatii.impartirePolinom(polinom1, polinom2, polinomRezultat, polinomRest);
    }

    public Polinom crearePolinom(String stringPolinom) throws IOException {
        List<String> subsir = new ArrayList<>();
        Polinom polinom = new Polinom();
        subsir = spargeInMonoameDeStringuri(stringPolinom);
        List<Monom> listaMonoame=creareListaMonoame(subsir);
        for(Monom m:listaMonoame) {
            polinom.addaugareMonom(m);
        }
        return polinom;
    }

    // parsare polinoame - expresie regex: https://stackoverflow.com/questions/36490757/regex-for-polynomial-expression
    public List<String> spargeInMonoameDeStringuri(String sir) throws IOException {
        if(!estePolinomulValid(sir)){
            throw new IOException("Polinom invalid");
        }
        List<String> listaSubsiruri=new ArrayList<>();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(sir);
        while (matcher.find()) {
            listaSubsiruri.add(matcher.group(1));
        }
        return listaSubsiruri;
    }


    public List<Monom> creareListaMonoame(List<String> listaSubsiruri){
        List<Monom> listaMonoame = new ArrayList<Monom>();
        for(String s: listaSubsiruri){
            int putere=0;
            float coef=0;
           if(s.contains("x")){
               if(s.indexOf("x") != 0){
                   String coefString = s.substring(0,s.indexOf("x"));
                   if(coefString.equals("-")){
                       coef=-1;
                   }
                   else
                   if(coefString.equals("+")){
                       coef=1;
                   }
                   else{
                       coef= Float.parseFloat(coefString);
                   }
               }
               else{
                   coef=1;
               }
               if(s.contains("^")){
                   putere=Integer.parseInt(s.substring(s.indexOf("^")+1, s.length()));
               }
               else{
                   putere=1;
               }
           }
           else{
               coef=Float.parseFloat(s);
           }
 //          System.out.println(coef+" "+ putere);
            Monom m1=new Monom(putere,coef);
            listaMonoame.add(m1);
        }
        return listaMonoame;
    }

    public boolean estePolinomulValid(String sir){
        boolean esteValid=true;
        if(sir==null || sir.length() <= 0) {
            esteValid=false;
        }
        else{
            if(sir.length()==1 && (sir.contains("^") || sir.contains(".") || sir.contains("+") || sir.contains("-"))) {
                esteValid=false;
            }
            else {
                if(sir.charAt(sir.length()-1)=='+' || sir.charAt(sir.length()-1)=='-' || sir.charAt(sir.length()-1)=='^' || sir.charAt(sir.length()-1)=='.' ){
                    esteValid=false;
                }
                else {
                    if(sir.contains("^+") || sir.contains("^-") || sir.contains("^^") || sir.contains("-+") || sir.contains("+-") || sir.contains("--") ||
                            sir.contains("++") || sir.contains("^x") || sir.contains("xx") || sir.contains(".x") || sir.contains("x.") || sir.contains(".^") || sir.contains("^.")) {
                        esteValid = false;
                    }
                    else {
                        for(char c: sir.toCharArray()) {
                            if ((c<'0' || c>'9') && c!='x' && c!='X' && c!='+' && c!='-' && c!='.' && c!='^'){
                                esteValid = false;
                            }
                        }
                    }
                }
            }
        }
        return esteValid;
    }

    public Polinom getPolinom1() {
        return polinom1;
    }

    public void setPolinom1(Polinom polinom1) {
        this.polinom1 = polinom1;
    }

    public Polinom getPolinom2() {
        return polinom2;
    }

    public void setPolinom2(Polinom polinom2) {
        this.polinom2 = polinom2;
    }

    public Polinom getPolinomRezultat() {
        return polinomRezultat;
    }

    public void setPolinomRezultat(Polinom polinomRezultat) {
        this.polinomRezultat = polinomRezultat;
    }

    public Polinom getPolinomRest() {
        return polinomRest;
    }

    public void setPolinomRest(Polinom polinomRest) {
        this.polinomRest = polinomRest;
    }
}
