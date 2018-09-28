/*
 * Classe que defineix una visita amb entrada lliure. Una visita amb entrada lliure 
 * es defineix pel seu codi, nom, adreça, coordenades i durada en minuts
 */
package components;

import java.util.Scanner;

/**
 *
 * @author FTA
 */
public class VisitaLliure {

    private String codi;
    private String nom;
    private String adreca;
    private String coordenades;
    private int durada; //Durada en minuts
    public static final Scanner DADES = new Scanner(System.in);

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     */
    public VisitaLliure(String codi, String nom, String adreca, String coordenades, int durada) {
        this.codi = codi;
        this.nom = nom;
        this.adreca = adreca;
        this.coordenades = coordenades;
        this.durada = durada;
    }


    /*
     TODO Mètodes accessors    
     */
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getCoordenades() {
        return coordenades;
    }

    public void setCoordenades(String coordenades) {
        this.coordenades = coordenades;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova visita amb eentrada 
     lliure. Les dades a demanar són les que necessita el constructor.
     - També heu de tenir en compte que tant el nom com l'adreça, poden ser frases,
     per exemple, Francesc Xavier, o bé, C/ del dofí, 13.
     Retorn: La nova visita lliure de pagament creada.
     */
    public static VisitaLliure addVisitaLliure() {

        String codi, nom, adreca, coordenada;
        int durada;

        System.out.print("Introdueixi el codi de la visita: ");
        codi = DADES.next();
        DADES.nextLine();//neteja buffer
        System.out.print("Introdueixi el nom de la visita: ");
        nom = DADES.nextLine();
        System.out.print("Introdueixi l'adreça de la visita: ");
        adreca = DADES.nextLine();
        System.out.print("Introdueixi les coordenades de la visita: ");
        coordenada = DADES.nextLine();
        System.out.print("Introdueixi la durada en minuts de la visita: ");
        durada = DADES.nextInt();
        //DADES.close();

        //crear el constructor amb les dades introduïdes
        VisitaLliure visitaLliure = new VisitaLliure(codi, nom, adreca, coordenada, durada);

        return visitaLliure;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void updateVisitaLliure() {
        String codiVis, nomVis, adrecaVis, coordenadaVis;
        int duradaVis;
        
        showVisitaLliure();//mostrar a l'usuari el valor actual dels atributs de l'objecte
        
        System.out.print("Introdueixi el nou el codi de la visita: ");
        codiVis = DADES.next();
        DADES.nextLine();//netejar buffer
        setCodi(codiVis);
        System.out.print("Introdueixi el nou nom de la visita: ");
        nomVis = DADES.nextLine();
        setNom(nomVis);
        System.out.print("Introdueixi la nova adreça de la visita: ");
        adrecaVis = DADES.nextLine();
        setAdreca(adrecaVis);
        System.out.print("Introdueixi les noves coordenades de la visita: ");
        coordenadaVis = DADES.nextLine();
        setCoordenades(coordenadaVis);
        System.out.print("Introdueixi la nova durada en minuts de la visita: ");
        duradaVis = DADES.nextInt();
        setDurada(duradaVis);
        //DADES.close();

    }

    public void showVisitaLliure() {
        System.out.println("\nLes dades del guia amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nAdreça:" + adreca);
        System.out.println("\nCoordenades:" + coordenades);
        System.out.println("\nDurada:" + durada);
    }

}
