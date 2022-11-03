
package HeroesOfVannaria.javaclass.personatgeclasses;

import HeroesOfVannaria.javaclass.armaclasses.Arma;

public abstract class Personatge {

    protected String nom;
    protected int forca, constitucio, velocitat, intelligencia, sort;
    protected int ps, pd, pa, pe, pex, lvl;
    protected Arma arma;
    protected String classe;

    public Personatge(String nom, String classe, int forca, int cons, int vel, int inte, int sort) {
        this.nom = nom;
        this.classe = classe;
        this.forca = forca;
        this.constitucio = cons;
        this.velocitat = vel;
        this.intelligencia = inte;
        this.sort = sort;
        this.arma = null;
        this.pex = 0;
        this.lvl = 0;
     

        



    }

    public Personatge(String nom, String classe, int forca, int cons, int vel, int inte, int sort, Arma arma) {
        this.nom = nom;
        this.classe = classe;
        this.forca = forca;
        this.constitucio = cons;
        this.velocitat = vel;
        this.intelligencia = inte;
        this.sort = sort;

        this.arma = arma;

    }

    //create a new constructor to save classe of personatge
    public Personatge(String nom, String classe, int forca, int cons, int vel, int inte, int sort, Arma arma, int pex, int lvl) {
        this.nom = nom;
        this.classe = classe;
        this.forca = forca;
        this.constitucio = cons;
        this.velocitat = vel;
        this.intelligencia = inte;
        this.sort = sort;
        this.arma = arma;
        this.pex = pex;
        this.lvl = lvl;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getForca() {
        return forca;
    }

    public int getConstitucio() {
        return constitucio;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public int getIntelligencia() {
        return intelligencia;
    }

    public int getSort() {
        return sort;
    }

    public int getPs() {
        return ps;
    }

    public int getPd() {
        return pd;
    }

    public int getPa() {
        return pa;
    }

    public int getPe() {
        return pe;
    }

    public int getPex() {
        return pex;
    }

    public Arma getArma() {
        return arma;
    }

    public int getLvl() {
        return lvl;
    }

    public String getClasse(){
        return classe;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setPex(int pex) {
        this.pex = pex;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setConstitucio(int constitucio) {
        this.constitucio = constitucio;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public void setIntelligencia(int intelligencia) {
        this.intelligencia = intelligencia;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
        calculaDerivades();
    }

 

    public void setClasse(String classe) {
        this.classe = classe;
    }


    public abstract void calculaDerivades();

    public void subidalvl() {

        this.forca++;
        this.constitucio++;
        this.velocitat++;
        this.intelligencia++;
        this.sort++;
        this.lvl++;
        calculaDerivades();
    }
}
