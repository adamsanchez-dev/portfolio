/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeroesOfVannaria.javaclass.personatgeclasses;

import HeroesOfVannaria.javaclass.armaclasses.Arma;

public class Cavaller extends Personatge {

    public Cavaller(String nom, String classe, int forca, int cons, int vel, int inte, int sort) {
        super(nom, classe, forca, cons, vel, inte, sort);
        calculaDerivades();
    }

    public Cavaller(String nom, String classe, int forca, int cons, int vel, int inte, int sort, Arma arma) {
        super(nom, classe, forca, cons, vel, inte, sort, arma);
        calculaDerivades();
    }
    public Cavaller(String nom, String classe, int forca, int cons, int vel, int inte, int sort, Arma arma, int pex, int lvl) {
        super(nom, classe, forca, cons, vel, inte, sort, arma, pex, lvl);
        calculaDerivades();
    }

    public void calculaDerivades() {
        this.ps = constitucio + forca + intelligencia;
        this.pd = (forca + arma.getWpow()) / 4;
        this.pe = velocitat + sort + intelligencia;
        this.pa = (this.intelligencia + this.sort + arma.getWvel());

    }





}
