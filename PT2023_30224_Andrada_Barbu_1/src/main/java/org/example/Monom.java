package org.example;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class Monom {
    private int putere;
    private float coeficient;

    public Monom()
    {
    }

    public Monom(int putere,float coeficient)
    {
        this.putere=putere;
        this.coeficient=coeficient;

    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public float getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    public int compareTo(Monom m)
    {
        if(this.putere>m.putere)
            return 1;
        else
        {
            if(this.putere==m.putere)
                return 0;
            else
                return -1;
        }
    }



}
