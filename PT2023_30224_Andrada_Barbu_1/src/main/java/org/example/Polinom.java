package org.example;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private Map <Integer,Float> polinomMap;

    public Polinom()
    {
        this.polinomMap=new HashMap<Integer, Float>();
    }

    public void reinitializarePolinom(){
        polinomMap.clear();
    }

    public int putereaCeaMaiMare(){
        int maxx = -1;
        for(Integer cheie: polinomMap.keySet()){
            if(cheie>maxx){
                maxx=cheie;
            }
        }
        return maxx;
    }

    public void addaugareMonom(Monom m)
    {
        if(polinomMap.isEmpty()){
                polinomMap.put(m.getPutere(), m.getCoeficient());
        }
        else{
            if (polinomMap.containsKey(m.getPutere())) {
                this.polinomMap.put(m.getPutere(), m.getCoeficient() + polinomMap.get(m.getPutere()));
            } else {
                this.polinomMap.put(m.getPutere(), m.getCoeficient());
            }
        }
        List<Integer> cheiIrelevante = new ArrayList<>();
        for(Map.Entry<Integer,Float> i:polinomMap.entrySet()){
            if(i.getValue()==0){
                cheiIrelevante.add(i.getKey());
            }
        }
        for (Integer cheie : cheiIrelevante) {
            polinomMap.remove(cheie);
        }
    }

    @Override
    public String toString() {
        String s="";
//       sortare dupa cheie https://www.geeksforgeeks.org/sorting-hashmap-according-key-value-java/
        TreeMap<Integer, Float> polinomMapSortat = new TreeMap<>(polinomMap);
        for(Map.Entry<Integer,Float> set: polinomMapSortat.descendingMap().entrySet()){
            if(set.getValue()!=0) {
                if (set.getValue() > 0) {
                    s += "+";
                }
                if(set.getValue() != 1 && set.getValue() != -1) {
                    if (set.getKey() == 0) {
                        s += set.getValue().toString();
                    } else {
                        if (set.getKey() == 1) {
                            s += set.getValue().toString() + 'x';
                        } else {
                            s += set.getValue().toString() + "x^" + set.getKey().toString();
                        }
                    }
                }
                else
                if(set.getValue()==1)
                {
                    if (set.getKey() != 0) {
                        if (set.getKey() == 1) {
                            s += 'x';
                        } else {
                            s += "x^" + set.getKey().toString();
                        }
                    }
                    else{
                        s += set.getValue().toString();
                    }
                }
                else{
                    if (set.getKey() != 0) {
                        if (set.getKey() == 1) {
                            s += "-x";
                        } else {
                            s += "-x^" + set.getKey().toString();
                        }
                    }
                    else{
                        s += set.getValue().toString();
                    }
                }
            }
        }
        if(s.indexOf('+')==0)
            s=s.substring(1);
        if(s==""){
            s="0";
        }
        return s;
    }

    public Map<Integer, Float> getPolinomMap() {
        return polinomMap;
    }

    public void setPolinomMap(Map<Integer, Float> polinomMap) {
        this.polinomMap = polinomMap;
    }

    @Override
    public boolean equals(Object o) {
        Polinom p = (Polinom) o;
        boolean suntEgale = this.polinomMap.equals(p.getPolinomMap());
        return suntEgale;
    }
}

