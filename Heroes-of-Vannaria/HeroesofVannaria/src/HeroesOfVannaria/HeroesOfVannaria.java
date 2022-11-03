/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HeroesOfVannaria;

//Imports de les clases que utilitzarem.


import HeroesOfVannaria.javaclass.personatgeclasses.*;
import HeroesOfVannaria.javaclass.armaclasses.*;
import HeroesOfVannaria.javaclass.*;



//Imports generics per funcions y métodes al codi.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;





public class HeroesOfVannaria {

    static Scanner sc = new Scanner(System.in);

    private ArrayList<Personatge> personatges;
    private Arma[] armes;
    int atj1=0, atj2=0, vj1=0, vj2=0,dej1=0,dej2, esj1=0, esj2=0; //Stats of the Battle
    String v1=" ", v2=" ", d1=" ", d2=" ";
    public HeroesOfVannaria() {

        armes = new Arma[3];
        armes[0] = new Arma("Daga", 5, 15);
        armes[1] = new Arma("Espasa", 10, 10);
        armes[2] = new Arma("Martell de combat", 15, 5);

        personatges = llegirFitxer("HeroesofVannaria/src/HeroesofVannaria/personatges.csv");

    }

    public static void main(String[] args) {

        /*
         * //Arma a1 = new Arma("Espasa",10,10);
         * Cavaller cavaller = new Cavaller(3,7,10,18,15,new Arma("Espasa",10,10));
         * //cavaller.setArma(a1);
         */

        HeroesOfVannaria joc = new HeroesOfVannaria();
        
        joc.jugar();
    }

    public void jugar() {
        Scanner in = new Scanner(System.in);

        boolean finalJoc = false;
        while (!finalJoc) {
            
            // Mostrar el menú incial.

             System.out.println("");
             System.out.println("");
             System.out.println("");
             System.out.println("");
              

            lectorascii("HeroesofVannaria/src/HeroesofVannaria/ascii/asciiinicial.txt");

             // Seleccionar opció i cridar al mètode corresponent.
            
            String opcio = sc.nextLine().toLowerCase();

           

            switch (opcio) {
                case "1":
                    crearPersonatge(in);

                    break;

                case "2":
                    combat();

                    break;
                    
                case "3":
                    modificarPersonatge();

                    break;

                case "4":

                    eliminarPersonatge();

                    break;

                case "5":

                    mostrarPersonatges();

                    break;

                case "6":
                    readStats();

                    break;


                case "x":

                    finalJoc = true;
                    lectorascii("HeroesofVannaria/src/HeroesofVannaria/ascii/asciidespedida.txt");

                    break;

                default:
                    System.out.println("Opció incorrecta!");
            }
            //Cridem al metode "modificarCSV" per modificar el fitxer CSV.

            modificarCSV();
            //posar a dormir el programa durant 5 segons.
            try {
            Thread.sleep(5*1000);
            } catch (Exception e) {
            System.out.println(e);
            }
        }
    }

    private void crearPersonatge(Scanner in) {

        
        System.out.println("\n\n*** CREAR PERSONATGE ***\n");

        System.out.print("Introdueix el nom d'un personatge: ");
        String nom = sc.nextLine();

        //sout per mostrar les classes disponibles.
        System.out.println("\n\n*** Classes disponibles ***\n");

        System.out.println("1.- Guerrer ");
        System.out.println("2.- Cavaller ");
        System.out.println("3.- Valkiria ");
        System.out.println("4.- Assassi \r\n" );

        System.out.print("Introdueix la classe del personatge (int) : ");
        
    


        int classe = sc.nextInt();
        String clase = "";
        switch (classe) {
            case 1:
                clase = "Guerrer";
                break;
            case 2:
                clase = "Cavaller";
                break;
            case 3:
                clase = "Valkiria";
                break;
            case 4:
                clase = "Assassi";
                break;
        }
        //Imprimeix les armes disponibles y demana que escullis una.
        System.out.println("\n\n*** ARMES DISPONIBLES ***\n");
        for (int i = 0; i < armes.length; i++) {
            System.out.println(i + 1 + ".- " + armes[i].getNom());
        }
        System.out.println();
        sc.nextLine();

        System.out.print("Introdueix l'arma del personatge (int): \r\n");

        int arma = sc.nextInt();
        Arma laMevaArma = null;
        switch (arma) {
            case 1:
                laMevaArma = armes[0];
                break;
            case 2:
                laMevaArma = armes[1];
                break;
            case 3:
                laMevaArma = armes[2];
                break;
        }


        System.out.println("1. Força ");

        System.out.println("2. Constitució ");

        System.out.println("3. Velocitat ");

        System.out.println("4. Inteligencia ");

        System.out.println("5. Sort \r\n");

        boolean nosuma = true;
     
        // Variables Stats
        int i = 1, forca = 0, constitucio = 0, velocitat = 0, intelligencia = 0, sort = 0;
        boolean acabado = false;
        while (nosuma) {
            while (!acabado) {
                switch (i) {
                    case 1:
                        System.out.print("Força == ");
                        
                        forca = sc.nextInt();
                        if ((forca > 3) && (forca < 18)) {
                            i++;
                        } else {
                            System.out.println("El valor introduit no es valid, torna a escriure'l");
                        }
                        break;
                    case 2:
                        System.out.print("Constitució == ");
                        constitucio = sc.nextInt();
                        if ((constitucio > 3) && (constitucio < 18)) {
                            i++;
                        } else {
                            System.out.println("El valor introduit no es valid, torna a escriure'l");
                        }
                        break;

                    case 3:
                        System.out.print("velocitat == ");
                        velocitat = sc.nextInt();
                        if ((velocitat > 3) && (velocitat < 18)) {
                            i++;
                        } else {
                            System.out.println("El valor introduit no es valid, torna a escriure'l");
                        }
                        break;

                    case 4:
                        System.out.print("Inteligencia == ");
                        intelligencia = sc.nextInt();
                        if ((intelligencia > 3) && (intelligencia < 18)) {
                            i++;
                        } else {
                            System.out.println("El valor introduit no es valid, torna a escriure'l");
                        }
                        break;

                    case 5:
                        System.out.print("Sort == ");
                        sort = sc.nextInt();
                        if ((sort > 3) && (sort < 18)) {
                            i++;
                        } else {
                            System.out.println("El valor introduit no es valid, torna a escriure'l");
                        }
                        break;
                    default:
                        acabado = true;
                }
                
            }

            // Els valors dels atributs sumen mes de 60??.

            if ((forca + constitucio + velocitat + intelligencia + sort) < 60) {
                nosuma = false;
            } else {
                System.out.println("Es major a 60, repeteixlo");
                acabado = false;
                i = 0;
            }
        }

        Personatge personatge = null;

        switch (clase) {
            case "Guerrer":
                personatge = new Guerrer(nom, clase, forca, constitucio, velocitat,
                        intelligencia, sort, laMevaArma);
                break;
            case "Cavaller":
                personatge = new Cavaller(nom, clase, forca, constitucio, velocitat,
                        intelligencia, sort, laMevaArma);
                break;
            case "Valkiria":
                personatge = new Valkiria(nom, clase, forca, constitucio, velocitat,
                        intelligencia, sort, laMevaArma);
                break;
            case "Assassi":
                personatge = new Assassi(nom, clase, forca, constitucio, velocitat,
                        intelligencia, sort, laMevaArma);
                break;
        }

        personatges.add(personatge);
        sc.nextLine();
    }

    /**
     * Inicia un combat entre 2 personatges
     */
    private void combat() {
        // Demanar personatges
        
        System.out.println("\n\n*** Personatges disponibles ***\n");
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println(i + ".- " + personatges.get(i).getNom());
        }
        System.out.println();
        System.out.print("Introdueix el primer personatge (int): \r\n");
        int person1 = sc.nextInt();
        System.out.print("Introdueix el segon personatge (int): \r\n");
        int person2 = sc.nextInt();

        //person1 no puede ser el mismo que person2
        while (person1 == person2) {
            System.out.println("Els personatges no poden ser iguals, torna a escriure'l");
            System.out.print("Introdueix el primer personatge (int): \r\n");
            person1 = sc.nextInt();
            System.out.print("Introdueix el segon personatge (int): \r\n");
            person2 = sc.nextInt();
        }

        

        //Si tirada de person1 > tirada de  person2 llavors person1 guanya sino person2 guanya
        int tirada1 = tirada(),  tirada2 = tirada(), jr1 = 0, jr2 = 0;
        
        if (tirada1 > tirada2) {
            System.out.println("El personatge " + personatges.get(person1).getNom() + " comença");
            jr1 = person1;
            jr2 = person2;
        } else {
            System.out.println("El personatge " + personatges.get(person2).getNom() + " comença");
            jr1 = person2;
            jr2 = person1;
        }
        
        int Jr1ps = personatges.get(jr1).getPs();
        int Jr2ps = personatges.get(jr2).getPs();
        // Variables Definides.

        lectorascii("HeroesofVannaria/src/HeroesOfVannaria/ascii/ascidados.txt");
        int turnos = 0;
        

        // Fer combat.
        while ((personatges.get(jr1).getPs() > 0) && (personatges.get(jr2).getPs()) > 0){
            
            if (turnos % 2 == 0) {
                if ((tirada()) <= (personatges.get(jr1).getPa())) {// Aqui poner si la suma dels daus es inferior o
                                                                       // igual a la seva pa encerta l'atac, sino,
                                                                       // l'altre personatge ho pot esquivar si la seva
                                                                       // tirada es major o igual que la seva pe
                    if ((tirada()) > (personatges.get(jr2).getPe())) {
                        personatges.get(jr2).setPs(personatges.get(jr2).getPs() - personatges.get(jr1).getPd());
                        System.out.println("El personatge " + personatges.get(jr1).getNom() + " ha atacat al personatge "  + personatges.get(jr2).getNom() + " amb un dany de " + personatges.get(jr1).getPd() + " i el personatge " + personatges.get(jr2).getNom() + " ha perdut " + personatges.get(person1).getPd() + " punts de vida" + " li queden " + personatges.get(jr2).getPs() + " punts de vida");
                        atj1++;
                    }else {
                        System.out.println("El personatge " + personatges.get(jr2).getNom() + " ha esquivat l'atac");
                        esj2++;
                    }  
                } else {
                    System.out.println("El personatge " + personatges.get(jr1).getNom() + " ha fallat l'atac");
                   esj1++;
                }

            } else {
                if ((tirada()) <= (personatges.get(jr2).getPa())) {// Aqui posar si la suma dels daus es inferior o
                                                                       // igual a la seva pa encerta l'atac, sino,
                                                                       // l'altre personatge ho pot esquivar si la seva
                                                                       // tirada es major o igual que la seva pe

                    if ((tirada()) > (personatges.get(jr1).getPe())) {
                       System.out.println("El personatge " + personatges.get(jr2).getNom() + " ha atacat al personatge " + personatges.get(jr1).getNom() + " amb un dany de " + personatges.get(jr2).getPd() + " i el personatge " + personatges.get(jr1).getNom() + " ha perdut " + personatges.get(jr2).getPd() + " punts de vida" + " li queden " + personatges.get(jr1).getPs() + " punts de vida" ); 
                        personatges.get(jr1).setPs(personatges.get(jr1).getPs() - personatges.get(jr2).getPd());
                        atj2++;
                    } else {
                        System.out.println("El personatge " + personatges.get(jr1).getNom() + " ha esquivat l'atac");
                        esj1++;
                    }
                } else {
                    System.out.println("El personatge " + personatges.get(jr2).getNom() + " ha fallat l'atac");
                    esj2++;
                }

            }
            turnos++;
            System.out.println("");
        } 
        
                
        if (personatges.get(person1).getPs() <= 0) {
            System.out.println();
            System.out.println("El personatge " + personatges.get(person1).getNom() + " ha mort");
            System.out.println("El personatge " + personatges.get(person2).getNom() + " ha guanyat\r\n");
            personatges.get(person2).setPex(personatges.get(person2).getPex() + Jr1ps);
            subidaLVL(person2);
            v2="Victoria";
            d1="Derrota";
        } else {

            personatges.get(person1).setPex(personatges.get(person1).getPex() + Jr2ps);
            subidaLVL(person1);
            System.out.println();
            System.out.println("El personatge " + personatges.get(person2).getNom() + " ha mort");
            System.out.println("El personatge " + personatges.get(person1).getNom() + " ha guanyat \r\n");

            v1="Victoria";
            d2="Derrota";
        }

        // Restaurem la vida dels jugadors.

        personatges.get(person1).setPs(Jr1ps);
        personatges.get(person2).setPs(Jr2ps);

        sc.nextLine();

      
        saveStats(personatges.get(person1).getNom(), personatges.get(person2).getNom(), atj1, atj2, esj1, esj2, v1, v2,d1,d2);
        
    }

    private void subidaLVL(int ganador) {
        //En aquest metode definim com puja cada personatge de nivell.


        if ((personatges.get(ganador).getPex() >= 100) && (personatges.get(ganador).getPex() < 199)) {
            if (personatges.get(ganador).getLvl() < 1) {
                personatges.get(ganador).subidalvl();
            }
        } else if ((personatges.get(ganador).getPex() >= 200) && (personatges.get(ganador).getPex() < 499)) {
            if (personatges.get(ganador).getLvl() < 2) {
                personatges.get(ganador).subidalvl();

            }
        } else if ((personatges.get(ganador).getPex() >= 500) && (personatges.get(ganador).getPex() < 999)) {
            if (personatges.get(ganador).getLvl() < 3) {
                personatges.get(ganador).subidalvl();
            }
        } else if ((personatges.get(ganador).getPex() >= 1000) && (personatges.get(ganador).getPex() < 1999)) {
            if (personatges.get(ganador).getLvl() < 4) {
                personatges.get(ganador).subidalvl();
            }
        }

    }

    private int tirada() {

        Dau dau1 = new Dau(25);
        Dau dau2 = new Dau(25);
        Dau dau3 = new Dau(25);

        int valor = dau1.tirada() + dau2.tirada() + dau3.tirada();
        

        return valor;
    }

        //En aquest metode llegim el fitxer personatges.csv

    private ArrayList<Personatge> llegirFitxer(String nomFitxer) {

        ArrayList<Personatge> personatges = new ArrayList<Personatge>();

        try {
            BufferedReader entrada = new BufferedReader(
                    new FileReader(nomFitxer));

            String personatgeStr;
            while ((personatgeStr = entrada.readLine()) != null) {
                String[] caracteristiques = personatgeStr.split(";");
                String classe = caracteristiques[1];
                Arma laMevaArma = null;
                if (caracteristiques[7].equals("Daga")) // Nom arma
                    laMevaArma = armes[0];
                else if (caracteristiques[7].equals("Espasa"))
                    laMevaArma = armes[1];
                else if (caracteristiques[7].equals("Martell de combat"))
                    laMevaArma = armes[2];

                String nom = caracteristiques[0];
                int forca = Integer.parseInt(caracteristiques[2]);
                int constitucio = Integer.parseInt(caracteristiques[3]);
                int velocitat = Integer.parseInt(caracteristiques[4]);
                int intelligencia = Integer.parseInt(caracteristiques[5]);
                int sort = Integer.parseInt(caracteristiques[6]);
                int pex = Integer.parseInt(caracteristiques[8]);
                int lvl = Integer.parseInt(caracteristiques[9]);

                Personatge personatge = null;
                switch (classe) {
                    case "Guerrer":
                        personatge = new Guerrer(nom, classe, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma, pex, lvl);
                        break;
                    case "Cavaller":
                        personatge = new Cavaller(nom, classe, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma, pex, lvl);
                        break;
                    case "Valkiria":
                        personatge = new Valkiria(nom, classe, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma, pex, lvl);
                        break;
                    case "Assassi":
                        personatge = new Assassi(nom, classe, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma, pex, lvl);
                        break;
                }

                personatges.add(personatge);
            }
            entrada.close();

        } catch (FileNotFoundException fnf) {
            
            System.out.println("Error fitxer no trobat.");
        } catch (IOException ioe) {
            System.out.println("Error I/O: " + ioe.getMessage());
        }

        



        return personatges;

    }

        //En aquest metode modifiquem el personatge que escull el jugador.

    private void modificarPersonatge(){
        System.out.println("Has escollit modificar un personatge...\r\n");
        
        
           for(int i = 0; i < personatges.size(); i++){
              System.out.println(i + "." + personatges.get(i).getNom());
         }
       System.out.println("Quin personatge vols modificar? (int)");
    
      
            
            int personatge = Integer.parseInt(sc.nextLine());

            
            System.out.println("Quin nom vols donar al personatge?");

            String nom = sc.nextLine();
            personatges.get(personatge).setNom(nom);

            System.out.println("Quina força vols donar al personatge?");
            int forca = sc.nextInt();
            personatges.get(personatge).setForca(forca);

            System.out.println("Quina constitucio vols donar al personatge?");
            int constitucio = sc.nextInt();
            personatges.get(personatge).setConstitucio(constitucio);

            System.out.println("Quina velocitat vols donar al personatge?");
            int velocitat = sc.nextInt();
            personatges.get(personatge).setVelocitat(velocitat);

            System.out.println("Quina intelligencia vols donar al personatge?");
            int intelligencia = sc.nextInt();
            personatges.get(personatge).setIntelligencia(intelligencia);

            System.out.println("Quin sort vols donar al personatge?");
            int sort = sc.nextInt();
            personatges.get(personatge).setSort(sort);

             sc.nextLine();

    }

    //En aquest metode es mostra els personatges que tenim disponibles.

    private void mostrarPersonatges() {
        System.out.println("\r\nPersonatges:");

       
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println("Nom : "  + personatges.get(i).getNom());
            System.out.println("Classe: " + personatges.get(i).getClasse());
            System.out.println("Força: " + personatges.get(i).getForca());
            System.out.println("Constitucio: " + personatges.get(i).getConstitucio());
            System.out.println("Velocitat: " + personatges.get(i).getVelocitat());
            System.out.println("Intelligencia: " + personatges.get(i).getIntelligencia());
            System.out.println("Sort: " + personatges.get(i).getSort());
            System.out.println("Pex: " + personatges.get(i).getPex());
            System.out.println("Lvl: " + personatges.get(i).getLvl());
            System.out.println("Arma: " + personatges.get(i).getArma().getNom());
            System.out.println("\r\n");
            System.out.println("--------------------------------------------------------------------------------");
        }

    }

        //En aquest metode s'elimina el personatge que esculli el jugador.

    private void eliminarPersonatge() {
        System.out.println("Has escollit eliminar un personatge...\r\n");

        System.out.println("Introdueix el nom del personatge que vols eliminar");  
        
        for(int i = 0; i < personatges.size(); i++){
            System.out.println(personatges.get(i).getNom());
        }
        String nom = sc.nextLine();
        for (int i = 0; i < personatges.size(); i++) {
            if (personatges.get(i).getNom().equals(nom)) {
                System.out.println("Personatge eliminat");
                personatges.remove(i);
            }
        }



    }
        

    //En aquest metode guardem els canvis despres de cada combat al arxiu .csv.

    private void modificarCSV() {
        try {
                FileWriter file = new FileWriter("HeroesofVannaria/src/HeroesOfVannaria/personatges.csv");
                BufferedWriter output = new BufferedWriter(file);
                //while linea != null do
                
                for (Personatge personatge : personatges) {
                    output.write(personatge.getNom() + ";" + personatge.getClasse() + ";" + personatge.getForca() + ";" + personatge.getConstitucio() + ";" + personatge.getVelocitat() + ";" + personatge.getIntelligencia() + ";" + personatge.getSort() + ";" + personatge.getArma().getNom() +  ";" + personatge.getPex() + ";" +personatge.getLvl()+ "\r\n");
                    
                    
                }
    
                output.close();
    
            } catch (IOException ioe) {
                System.out.println("Error I/O: " + ioe.getMessage());
            }


}

    public static void lectorascii(String filename) {
        try {
         
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }

    }

  public static void saveStats( String jr1, String jr2, int atj1, int atj2,  int esj1, int esj2, String v1, String v2, String d1, String d2){
    

    try {
        FileWriter file = new FileWriter("HeroesofVannaria/src/HeroesOfVannaria/estadisticas.txt");
        BufferedWriter output = new BufferedWriter(file);
        output.write("----------------------------------------------------------------------------------\r\n");
        output.write(" Nombre : "  + jr1 + " | " + " " + "Ataques : " +   atj1 + " | " + " Esquives : "   + esj1  + " | " + v1 + d1 + "\r\n");
        output.write("----------------------------------------------------------------------------------\r\n");
        output.write(" Nombre : "  + jr2 + " | " + " " + "Ataques : " +   atj2 + " | " + " Esquives : "   + esj2  + " | " + v2 + d2 + "\r\n");
        output.write("----------------------------------------------------------------------------------\r\n");

        output.close();
    } catch (IOException ioe) {
        System.out.println("Error I/O: " + ioe.getMessage());
    }
  }
    public static void readStats(){
        System.out.println();
        System.out.println("Estadistiques de la partida anterior : \r\n");

        try {
            FileReader fr = new FileReader("HeroesofVannaria/src/HeroesOfVannaria/estadisticas.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }
    
    }


    


    


    












   





}
