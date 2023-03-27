package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {

    private final Operatii operatii = new Operatii();

    @ParameterizedTest
    @MethodSource("polinoameDeTestAdunare")
    public void adunareParametrizata(Polinom polinom1, Polinom polinom2, Polinom polinomRezultatAsteptat) {
        Polinom polinomRezultatCalculat=operatii.adunarePolinom(polinom1,polinom2);
        AssertJUnit.assertEquals(polinomRezultatAsteptat, polinomRezultatCalculat);
    }

    @ParameterizedTest
    @MethodSource("polinoameDeTestScadere")
    public void scadereParametrizata(Polinom polinom1, Polinom polinom2, Polinom polinomRezultatAsteptat) {
        Polinom polinomRezultatCalculat=operatii.scaderePolinom(polinom1,polinom2);
        AssertJUnit.assertEquals(polinomRezultatAsteptat, polinomRezultatCalculat);
    }

    @ParameterizedTest
    @MethodSource("polinoameDeTestDerivare")
    public void derivareParametrizata(Polinom polinom1,Polinom polinomRezultatAsteptat) {
        Polinom polinomRezultatCalculat=operatii.derivarePolinom(polinom1);
        AssertJUnit.assertEquals(polinomRezultatAsteptat, polinomRezultatCalculat);
    }

    @ParameterizedTest
    @MethodSource("polinoameDeTestIntegrare")
    public void integrareParametrizata(Polinom polinom1,Polinom polinomRezultatAsteptat) {
        Polinom polinomRezultatCalculat=operatii.integrarePolinom(polinom1);
        AssertJUnit.assertEquals(polinomRezultatAsteptat, polinomRezultatCalculat);
    }

    @ParameterizedTest
    @MethodSource("polinoameDeTestInmultire")
    public void inmultireParametrizata(Polinom polinom1, Polinom polinom2, Polinom polinomRezultatAsteptat) {
        Polinom polinomRezultatCalculat=operatii.inmultirePolinom(polinom1,polinom2);
        AssertJUnit.assertEquals(polinomRezultatAsteptat, polinomRezultatCalculat);
    }

    @ParameterizedTest
    @MethodSource("polinoameDeTestImpartire")
    public void impartireParametrizata(Polinom polinom1, Polinom polinom2, Polinom polinomRezultatAsteptat, Polinom polinomRestAsteptat) {
        Polinom polinomRezultatCalculat=new Polinom();
        Polinom polinomRestCalculat=new Polinom();
        operatii.impartirePolinom(polinom1,polinom2,polinomRezultatCalculat,polinomRestCalculat);
        Polinom[] polinoameCalculate= new Polinom[2];
        polinoameCalculate[0]=polinomRezultatCalculat;
        polinoameCalculate[1]=polinomRestCalculat;
        Polinom[] polinoameAsteptate=new Polinom[2];
        polinoameAsteptate[0]=polinomRezultatAsteptat;
        polinoameAsteptate[1]=polinomRestAsteptat;
        AssertJUnit.assertArrayEquals(polinoameAsteptate,polinoameCalculate);
    }

    private static List<Arguments> polinoameDeTestAdunare() {
        List<Arguments> polinoameTest = new ArrayList<>();

        //x^3-2x^2+6x-5
        Polinom polinom1=new Polinom();
        Monom monom1=new Monom(3,1);
        Monom monom2=new Monom(2,-2);
        Monom monom3=new Monom(1,6);
        Monom monom4=new Monom(0,-5);

        polinom1.addaugareMonom(monom1);
        polinom1.addaugareMonom(monom2);
        polinom1.addaugareMonom(monom3);
        polinom1.addaugareMonom(monom4);

        //x^2-1
        Polinom polinom2=new Polinom();
        Monom monom5=new Monom(2,1);
        Monom monom6=new Monom(0,-1);

        polinom2.addaugareMonom(monom5);
        polinom2.addaugareMonom(monom6);

        //x^3-x^2+6x-6
        Polinom polinomRezultatBunAsteptat=new Polinom();
        Monom monom7=new Monom(3,1);
        Monom monom8=new Monom(2,-1);
        Monom monom9=new Monom(1,6);
        Monom monom10=new Monom(0,-6);

        polinomRezultatBunAsteptat.addaugareMonom(monom7);
        polinomRezultatBunAsteptat.addaugareMonom(monom8);
        polinomRezultatBunAsteptat.addaugareMonom(monom9);
        polinomRezultatBunAsteptat.addaugareMonom(monom10);

        //x^5-x^2+6x-6
        Polinom polinomRezultatRauAsteptat=new Polinom();
        Monom monom11=new Monom(5,1);
        Monom monom12=new Monom(2,-1);
        Monom monom13=new Monom(1,6);
        Monom monom14=new Monom(0,-6);

        polinomRezultatRauAsteptat.addaugareMonom(monom11);
        polinomRezultatRauAsteptat.addaugareMonom(monom12);
        polinomRezultatRauAsteptat.addaugareMonom(monom13);
        polinomRezultatRauAsteptat.addaugareMonom(monom14);


        polinoameTest.add(Arguments.of(polinom1, polinom2, polinomRezultatBunAsteptat));
        polinoameTest.add(Arguments.of(polinom1, polinom2, polinomRezultatRauAsteptat));
        return polinoameTest;
    }


    private static List<Arguments> polinoameDeTestScadere() {
        List<Arguments> polinoameTest = new ArrayList<>();

        //x^3-2x^2+6x-5
        Polinom polinom1=new Polinom();
        Monom monom1=new Monom(3,1);
        Monom monom2=new Monom(2,-2);
        Monom monom3=new Monom(1,6);
        Monom monom4=new Monom(0,-5);

        polinom1.addaugareMonom(monom1);
        polinom1.addaugareMonom(monom2);
        polinom1.addaugareMonom(monom3);
        polinom1.addaugareMonom(monom4);

        //x^2-1
        Polinom polinom2=new Polinom();
        Monom monom5=new Monom(2,1);
        Monom monom6=new Monom(0,-1);

        polinom2.addaugareMonom(monom5);
        polinom2.addaugareMonom(monom6);

        //x^3-3x^2+6x-4
        Polinom polinomRezultatBunAsteptat=new Polinom();
        Monom monom7=new Monom(3,1);
        Monom monom8=new Monom(2,-3);
        Monom monom9=new Monom(1,6);
        Monom monom10=new Monom(0,-4);

        polinomRezultatBunAsteptat.addaugareMonom(monom7);
        polinomRezultatBunAsteptat.addaugareMonom(monom8);
        polinomRezultatBunAsteptat.addaugareMonom(monom9);
        polinomRezultatBunAsteptat.addaugareMonom(monom10);

        //x^5-x^2+6x-6
        Polinom polinomRezultatRauAsteptat=new Polinom();
        Monom monom11=new Monom(5,1);
        Monom monom12=new Monom(2,-1);
        Monom monom13=new Monom(1,6);
        Monom monom14=new Monom(0,-6);

        polinomRezultatRauAsteptat.addaugareMonom(monom11);
        polinomRezultatRauAsteptat.addaugareMonom(monom12);
        polinomRezultatRauAsteptat.addaugareMonom(monom13);
        polinomRezultatRauAsteptat.addaugareMonom(monom14);


        polinoameTest.add(Arguments.of(polinom1, polinom2, polinomRezultatBunAsteptat));
        polinoameTest.add(Arguments.of(polinom1, polinom2, polinomRezultatRauAsteptat));
        return polinoameTest;
    }

    private static List<Arguments> polinoameDeTestInmultire() {
        List<Arguments> polinoameTest = new ArrayList<>();

        //x^3-2x^2+6x-5
        Polinom polinom1=new Polinom();
        Monom monom1=new Monom(3,1);
        Monom monom2=new Monom(2,-2);
        Monom monom3=new Monom(1,6);
        Monom monom4=new Monom(0,-5);

        polinom1.addaugareMonom(monom1);
        polinom1.addaugareMonom(monom2);
        polinom1.addaugareMonom(monom3);
        polinom1.addaugareMonom(monom4);

        //x^2-1
        Polinom polinom2=new Polinom();
        Monom monom5=new Monom(2,1);
        Monom monom6=new Monom(0,-1);

        polinom2.addaugareMonom(monom5);
        polinom2.addaugareMonom(monom6);

        //x-2
        Polinom polinomRezultatBunAsteptat=new Polinom();
        Monom monom7=new Monom(5,1);
        Monom monom8=new Monom(4,-2);
        Monom monom9=new Monom(3,5);
        Monom monom10=new Monom(2,-3);
        Monom monom11=new Monom(1,-6);
        Monom monom12=new Monom(0,5);

        polinomRezultatBunAsteptat.addaugareMonom(monom7);
        polinomRezultatBunAsteptat.addaugareMonom(monom8);
        polinomRezultatBunAsteptat.addaugareMonom(monom9);
        polinomRezultatBunAsteptat.addaugareMonom(monom10);
        polinomRezultatBunAsteptat.addaugareMonom(monom11);
        polinomRezultatBunAsteptat.addaugareMonom(monom12);

        //x^5-x^2+6x-6
        Polinom polinomRezultatRauAsteptat=new Polinom();
        Monom monom13=new Monom(5,1);
        Monom monom14=new Monom(2,-1);
        Monom monom15=new Monom(1,6);
        Monom monom16=new Monom(0,-6);

        polinomRezultatRauAsteptat.addaugareMonom(monom13);
        polinomRezultatRauAsteptat.addaugareMonom(monom14);
        polinomRezultatRauAsteptat.addaugareMonom(monom15);
        polinomRezultatRauAsteptat.addaugareMonom(monom16);


        polinoameTest.add(Arguments.of(polinom1, polinom2, polinomRezultatBunAsteptat));
        polinoameTest.add(Arguments.of(polinom1, polinom2, polinomRezultatRauAsteptat));
        return polinoameTest;
    }

    private static List<Arguments> polinoameDeTestDerivare() {
        List<Arguments> polinoameTest = new ArrayList<>();

        //x^3-2x^2+6x-5
        Polinom polinom1=new Polinom();
        Monom monom1=new Monom(3,1);
        Monom monom2=new Monom(2,-2);
        Monom monom3=new Monom(1,6);
        Monom monom4=new Monom(0,-5);

        polinom1.addaugareMonom(monom1);
        polinom1.addaugareMonom(monom2);
        polinom1.addaugareMonom(monom3);
        polinom1.addaugareMonom(monom4);

        //3x^2-4x+6
        Polinom polinomRezultatBunAsteptat=new Polinom();
        Monom monom7=new Monom(2,3);
        Monom monom8=new Monom(1,-4);
        Monom monom9=new Monom(0,6);

        polinomRezultatBunAsteptat.addaugareMonom(monom7);
        polinomRezultatBunAsteptat.addaugareMonom(monom8);
        polinomRezultatBunAsteptat.addaugareMonom(monom9);

        //x^2+6x-6
        Polinom polinomRezultatRauAsteptat=new Polinom();
        Monom monom12=new Monom(2,1);
        Monom monom13=new Monom(1,6);
        Monom monom14=new Monom(0,-6);

        polinomRezultatRauAsteptat.addaugareMonom(monom12);
        polinomRezultatRauAsteptat.addaugareMonom(monom13);
        polinomRezultatRauAsteptat.addaugareMonom(monom14);


        polinoameTest.add(Arguments.of(polinom1, polinomRezultatBunAsteptat));
        polinoameTest.add(Arguments.of(polinom1, polinomRezultatRauAsteptat));
        return polinoameTest;
    }

    private static List<Arguments> polinoameDeTestIntegrare() {
        List<Arguments> polinoameTest = new ArrayList<>();

        //x^3-2x^2+6x-5
        Polinom polinom1=new Polinom();
        Monom monom1=new Monom(3,1);
        Monom monom2=new Monom(2,-2);
        Monom monom3=new Monom(1,6);
        Monom monom4=new Monom(0,-5);

        polinom1.addaugareMonom(monom1);
        polinom1.addaugareMonom(monom2);
        polinom1.addaugareMonom(monom3);
        polinom1.addaugareMonom(monom4);

        //0.25x^4-0.666x^3+3x^2-5x
        Polinom polinomRezultatBunAsteptat=new Polinom();
        Monom monom7=new Monom(4, 0.25F);
        Monom monom8=new Monom(3,-0.6666667F);
        Monom monom9=new Monom(2,3);
        Monom monom10=new Monom(1,-5);

        polinomRezultatBunAsteptat.addaugareMonom(monom7);
        polinomRezultatBunAsteptat.addaugareMonom(monom8);
        polinomRezultatBunAsteptat.addaugareMonom(monom9);
        polinomRezultatBunAsteptat.addaugareMonom(monom10);

        //x^2+6x-6
        Polinom polinomRezultatRauAsteptat=new Polinom();
        Monom monom12=new Monom(2,1);
        Monom monom13=new Monom(1,6);
        Monom monom14=new Monom(0,-6);

        polinomRezultatRauAsteptat.addaugareMonom(monom12);
        polinomRezultatRauAsteptat.addaugareMonom(monom13);
        polinomRezultatRauAsteptat.addaugareMonom(monom14);


        polinoameTest.add(Arguments.of(polinom1, polinomRezultatBunAsteptat));
        polinoameTest.add(Arguments.of(polinom1, polinomRezultatRauAsteptat));
        return polinoameTest;
    }

    private static List<Arguments> polinoameDeTestImpartire() {
        List<Arguments> polinoameTest = new ArrayList<>();

        //x^3-2x^2+6x-5
        Polinom polinom1=new Polinom();
        Monom monom1=new Monom(3,1);
        Monom monom2=new Monom(2,-2);
        Monom monom3=new Monom(1,6);
        Monom monom4=new Monom(0,-5);

        polinom1.addaugareMonom(monom1);
        polinom1.addaugareMonom(monom2);
        polinom1.addaugareMonom(monom3);
        polinom1.addaugareMonom(monom4);

        //x^2-1
        Polinom polinom2=new Polinom();
        Monom monom5=new Monom(2,1);
        Monom monom6=new Monom(0,-1);

        polinom2.addaugareMonom(monom5);
        polinom2.addaugareMonom(monom6);

        //x-2
        Polinom polinomRezultatBunAsteptat=new Polinom();
        Monom monom7=new Monom(1,1);
        Monom monom8=new Monom(0,-2);


        polinomRezultatBunAsteptat.addaugareMonom(monom7);
        polinomRezultatBunAsteptat.addaugareMonom(monom8);

        //7x-7
        Polinom polinomRestBunAsteptat=new Polinom();
        Monom monom9=new Monom(1,7);
        Monom monom10=new Monom(0,-7);

        polinomRestBunAsteptat.addaugareMonom(monom9);
        polinomRestBunAsteptat.addaugareMonom(monom10);

        //x^5-x^2+6x-6
        Polinom polinomRezultatRauAsteptat=new Polinom();
        Monom monom13=new Monom(5,1);
        Monom monom14=new Monom(2,-1);
        Monom monom15=new Monom(1,6);
        Monom monom16=new Monom(0,-6);

        polinomRezultatRauAsteptat.addaugareMonom(monom13);
        polinomRezultatRauAsteptat.addaugareMonom(monom14);
        polinomRezultatRauAsteptat.addaugareMonom(monom15);
        polinomRezultatRauAsteptat.addaugareMonom(monom16);

        //7x-5
        Polinom polinomRestRauAsteptat=new Polinom();
        Monom monom11=new Monom(1,7);
        Monom monom12=new Monom(0,-5);

        polinomRestRauAsteptat.addaugareMonom(monom11);
        polinomRestRauAsteptat.addaugareMonom(monom12);

        polinoameTest.add(Arguments.of(polinom1, polinom2, polinomRezultatBunAsteptat,polinomRestBunAsteptat));
        polinoameTest.add(Arguments.of(polinom1, polinom2, polinomRezultatRauAsteptat,polinomRestRauAsteptat));
        return polinoameTest;
    }
    //    @Test
//    public void adunare() {
//        //x^3-2x^2+6x-5
//
//        Polinom polinom1=new Polinom();
//        Monom monom1=new Monom(3,1);
//        Monom monom2=new Monom(2,-2);
//        Monom monom3=new Monom(1,6);
//        Monom monom4=new Monom(0,-5);
//
//        polinom1.addaugareMonom(monom1);
//        polinom1.addaugareMonom(monom2);
//        polinom1.addaugareMonom(monom3);
//        polinom1.addaugareMonom(monom4);
//
//        //x^2-1
//        Polinom polinom2=new Polinom();
//        Monom monom5=new Monom(2,1);
//        Monom monom6=new Monom(0,-1);
//
//        polinom2.addaugareMonom(monom5);
//        polinom2.addaugareMonom(monom6);
//
//        Polinom polinomRezultatCalculat=operatii.adunarePolinom(polinom1,polinom2);
//
//        //x^3-x^2+6x-6
//        Polinom polinomRezultatAsteptat=new Polinom();
//        Monom monom7=new Monom(3,1);
//        Monom monom8=new Monom(2,-1);
//        Monom monom9=new Monom(1,6);
//        Monom monom10=new Monom(0,-6);
//
//        polinomRezultatAsteptat.addaugareMonom(monom7);
//        polinomRezultatAsteptat.addaugareMonom(monom8);
//        polinomRezultatAsteptat.addaugareMonom(monom9);
//        polinomRezultatAsteptat.addaugareMonom(monom10);
//
//        System.out.println(polinomRezultatCalculat.toString());
//        System.out.println(polinomRezultatAsteptat.toString());
//
////        AssertJUnit.assertEquals(polinomRezultatCalculat.toString(),polinomRezultatAsteptat.toString());
//        AssertJUnit.assertEquals(polinomRezultatAsteptat, polinomRezultatCalculat);
//    }
}
