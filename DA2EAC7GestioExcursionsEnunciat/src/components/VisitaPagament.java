/*
 * Classe que defineix una visita de pagament. Una visita de pagament es defineix 
 * pel seu codi, nom, adreça, coordenades, durada en minuts i preu.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author FTA
 */
public class VisitaPagament {

    private String codi;
    private String nom;
    private String adreca;
    private String coordenades;
    private int durada; //Durada en minuts
    private double preu;
    public static final Scanner DADES = new Scanner(System.in);

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     */

    public VisitaPagament(String codi, String nom, String adreca, String coordenades, int durada, double preu) {
        this.codi = codi;
        this.nom = nom;
        this.adreca = adreca;
        this.coordenades = coordenades;
        this.durada = durada;
        this.preu = preu;
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

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova visita de pagament.
     Les dades a demanar són les que necessita el constructor.
     - També heu de tenir en compte que tant el nom com l'adreça, poden ser frases,
     per exemple, Francesc Xavier, o bé, C/ del dofí, 13.
     Retorn: La nova visita lliure de pagament creada.
     */
    public static VisitaPagament addVisitaPagament() {
        
        String codi,nom,adreca,coordenades;
        int durada;
        double preu;
        
        System.out.print("Introdueixi el codi de la visita: ");
        codi = DADES.next();
        DADES.nextLine();
        System.out.print("Introdueixi el nom de la visita: ");
        nom = DADES.nextLine();
        System.out.print("Introdueixi l'adreça de la visita: ");
        adreca = DADES.nextLine();
        System.out.print("Introdueixi les coordenades de la visita: ");
        coordenades = DADES.nextLine();
        System.out.print("Introdueixi la durada de la visita: ");
        durada = DADES.nextInt();
        System.out.print("Introdueixi el preu de la visita: ");
        preu = DADES.nextDouble();
        
        VisitaPagament visitaPagament = new VisitaPagament(codi, nom, adreca, coordenades, durada, preu);
        return visitaPagament;
        
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
    public void updateVisitaPagament() {
        
        
        showVisitaPagament();
        
        System.out.print("Introdueixi el nou codi de la visita: ");
        codi = DADES.next();
        DADES.nextLine();//netejar buffer
        setCodi(codi);
        
        System.out.print("Introdueixi el nou nom de la visita: ");
        nom = DADES.nextLine();
        setNom(nom);
        
        System.out.print("Introdueixi la nova adreça de la visita: ");
        adreca = DADES.nextLine();
        setAdreca(adreca);
        
        System.out.print("Introdueixi les noves coordenades de la visita: ");
        coordenades = DADES.nextLine();
        setCoordenades(coordenades);
        
        System.out.print("Introdueixi la nova durada de la visita: ");
        durada = DADES.nextInt();
        DADES.nextLine();//netejar buffer
        setDurada(durada);
        
        System.out.print("Introdueixi el nou preu de la visita: ");
        preu = DADES.nextDouble();
        setPreu(preu);
        
        //DADES.close();

    }

    public void showVisitaPagament() {
        System.out.println("\nLes dades de la visita de pagament amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nAdreça:" + adreca);
        System.out.println("\nCoordenades:" + coordenades);
        System.out.println("\nDurada:" + durada);
        System.out.println("\nPreu:" + preu);
    }
}
