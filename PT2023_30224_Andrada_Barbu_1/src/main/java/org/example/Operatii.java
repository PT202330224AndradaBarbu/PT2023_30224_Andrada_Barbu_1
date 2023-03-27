package org.example;

import java.util.Map;

public class Operatii {

    public Polinom adunarePolinom(Polinom sursaPolinom1, Polinom sursaPolinom2){
        Polinom polinomRezultat = new Polinom();
        for(Map.Entry<Integer, Float> i: sursaPolinom1.getPolinomMap().entrySet()) {
            Monom monom = new Monom(i.getKey(), i.getValue());
            polinomRezultat.addaugareMonom(monom);
        }
        for(Map.Entry<Integer, Float> i: sursaPolinom2.getPolinomMap().entrySet()) {
            Monom monom = new Monom(i.getKey(), i.getValue());
            polinomRezultat.addaugareMonom(monom);
        }
        return polinomRezultat;
    }

    public Polinom scaderePolinom(Polinom sursaPolinom1, Polinom sursaPolinom2){
        Polinom polinomRezultat = new Polinom();
        polinomRezultat = adunarePolinom(polinomRezultat, sursaPolinom1);
        for(Map.Entry<Integer,Float> i: sursaPolinom2.getPolinomMap().entrySet()){
            Monom monom=new Monom(i.getKey(),-i.getValue());
            polinomRezultat.addaugareMonom(monom);
        }
        return polinomRezultat;
    }

    public Polinom derivarePolinom(Polinom sursaPolinom){
        Polinom polinomRezultat = new Polinom();
        for(Map.Entry<Integer,Float> i: sursaPolinom.getPolinomMap().entrySet()){
            Monom monom=new Monom(i.getKey()-1,i.getKey()*i.getValue());
            if(monom.getPutere()!=-1) {
                polinomRezultat.addaugareMonom(monom);
            }
        }
        return  polinomRezultat;
    }

    public Polinom integrarePolinom(Polinom sursaPolinom){
        Polinom polinomRezultat = new Polinom();
        for(Map.Entry<Integer,Float> i: sursaPolinom.getPolinomMap().entrySet()){
            Monom monom=new Monom(i.getKey()+1,i.getValue()/(i.getKey()+1));
            polinomRezultat.addaugareMonom(monom);
        }
        return polinomRezultat;
    }

    public Polinom inmultirePolinom(Polinom sursaPolinom1, Polinom sursaPolinom2) {
        Polinom polinomRezultat = new Polinom();
        for (Map.Entry<Integer, Float> i : sursaPolinom1.getPolinomMap().entrySet()) {
            for (Map.Entry<Integer, Float> j : sursaPolinom2.getPolinomMap().entrySet()) {
                Monom monom = new Monom(i.getKey() + j.getKey(), i.getValue() * j.getValue());
                polinomRezultat.addaugareMonom(monom);
            }
        }
        return polinomRezultat;
    }

    public void impartirePolinom(Polinom sursaPolinom1, Polinom sursaPolinom2, Polinom polinomRezultat, Polinom polinomRest) {
        Polinom rez = new Polinom();
        Polinom rst = new Polinom();
        rst = adunarePolinom(rst, sursaPolinom1);
        Monom monom1=new Monom(sursaPolinom1.putereaCeaMaiMare(), sursaPolinom1.getPolinomMap().get(sursaPolinom1.putereaCeaMaiMare()));
        Monom monom2=new Monom(sursaPolinom2.putereaCeaMaiMare(), sursaPolinom2.getPolinomMap().get(sursaPolinom2.putereaCeaMaiMare()));
        int compararePuteri=monom1.compareTo(monom2);
        while((compararePuteri==1 || compararePuteri==0) && !rst.getPolinomMap().isEmpty()){
            if(monom2.getCoeficient()==0){
                break;
            }
            else{
                Polinom rezImpartire=new Polinom();
                Monom monomImpartire=new Monom(monom1.getPutere()-monom2.getPutere(),monom1.getCoeficient()/monom2.getCoeficient());
                rezImpartire.addaugareMonom(monomImpartire);
                rez = adunarePolinom(rez, rezImpartire);
                Polinom aux = inmultirePolinom(rezImpartire, sursaPolinom2);
                Polinom rest= scaderePolinom(rst, aux);
                rst.setPolinomMap(rest.getPolinomMap());
                if(rst.getPolinomMap().isEmpty()){
                    break;
                }
                monom1.setPutere(rst.putereaCeaMaiMare());
                monom1.setCoeficient(rst.getPolinomMap().get(rst.putereaCeaMaiMare()));
                compararePuteri=monom1.compareTo(monom2);
            }
        }
        polinomRezultat.setPolinomMap(rez.getPolinomMap());
        polinomRest.setPolinomMap(rst.getPolinomMap());
    }

}
