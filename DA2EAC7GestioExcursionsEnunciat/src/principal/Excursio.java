/*
 * Classe que defineix una excursió. Una excursió es defineix per un codi, nom i 
 * un preu. A més, contindrà un vector de guies, un vector de visites
 * amb entrada lliure i un vector de visites de pagament.
 */
package principal;

import components.Guia;
import components.VisitaLliure;
import components.VisitaPagament;
import java.util.Scanner;

/**
 *
 * @author FTA
 */
public class Excursio {

    private String codi;
    private String nom;
    private double preu;
    private Guia[] guies = new Guia[4];
    private Integer posicioGuies = 0; //Priemra posició buida del vector guies
    private VisitaLliure[] visitesLliures = new VisitaLliure[10];
    private Integer posicioVisitesLliures = 0; //Priemra posició buida del vector visitesLliures    
    private VisitaPagament[] visitesPagament = new VisitaPagament[10];
    private Integer posicioVisitesPagament = 0; //Priemra posició buida del vector visitesPagament
    public static final Scanner DADES = new Scanner(System.in);
    
    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys els vectors.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     */

    public Excursio(String codi, String nom, double preu) {
        this.codi = codi;
        this.nom = nom;
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

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public Guia[] getGuies() {
        return guies;
    }

    public void setGuies(Guia[] guies) {
        this.guies = guies;
    }

    public Integer getPosicioGuies() {
        return posicioGuies;
    }

    public void setPosicioGuies(Integer posicioGuies) {
        this.posicioGuies = posicioGuies;
    }

    public VisitaLliure[] getVisitesLliures() {
        return visitesLliures;
    }

    public void setVisitesLliures(VisitaLliure[] visitesLliures) {
        this.visitesLliures = visitesLliures;
    }

    public Integer getPosicioVisitesLliures() {
        return posicioVisitesLliures;
    }

    public void setPosicioVisitesLliures(Integer posicioVisitesLliures) {
        this.posicioVisitesLliures = posicioVisitesLliures;
    }

    public VisitaPagament[] getVisitesPagament() {
        return visitesPagament;
    }

    public void setVisitesPagament(VisitaPagament[] visitesPagament) {
        this.visitesPagament = visitesPagament;
    }

    public Integer getPosicioVisitesPagament() {
        return posicioVisitesPagament;
    }

    public void setPosicioVisitesPagament(Integer posicioVisitesPagament) {
        this.posicioVisitesPagament = posicioVisitesPagament;
    }
    
    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova excursió. Les dades
     a demanar són les que necessita el constructor.
     - També heu de tenir en compte que el nom pot ser una frases, per exemple, 
     Museu de la ciència.
     Retorn: La nova excursió creada-.
     */
    public static Excursio addExcursio() {
        String codi,nom;
        double preu;
        
        System.out.print("Introduieixi el codi de l'excursió: ");
        codi = DADES.next();
        DADES.nextLine();//netejar buffer
        System.out.print("Introduieixi el nom de l'excursió: ");
        nom = DADES.nextLine();
        System.out.print("Introduieixi el preu de l'excursió amb decimals: ");
        preu = DADES.nextDouble();
        //DADES.close();
        
        Excursio excursio = new Excursio(codi, nom, preu);
        
        return excursio;

    }
    
    /*
     TODO
     Paràmetres: guia a afegir
     Accions:
     - afegeix al vector de guies de l'excursió actual la guia passada per paràmetre .
     - actualitza la posició del vector de guies.
     Retorn: cap
     */
    public void addGuiaExcursio(Guia guia) {
        guies[posicioGuies] = guia;
        posicioGuies++;
    }

    /*
     TODO
     Paràmetres: visita amb entrada lliure a afegir
     Accions:
     - afegeix al vector visitesLliures de l'excursió actual la visita amb entrada lliure passada per paràmetre.
     - actualitza la posició del vector visiteslliures.
     Retorn: cap
     */
    public void addVisitaLliureExcursio(VisitaLliure visitaLl) {
        visitesLliures[posicioVisitesLliures] = visitaLl;
        posicioVisitesLliures++;
    }
    
    /*
     TODO
     Paràmetres: visita de pagament a afegir
     Accions:
     - afegeix al vector visitesPagament de l'excursió actual la visita de pagament 
     passada per paràmetre i afegeix al preu de l'excursió el preu de la visita.
     - actualitza la posició del vector visitesPagament.
     Retorn: cap
     */
    public void addVisitaPagamentExcursio(VisitaPagament visitaPag) {
        visitesPagament[posicioVisitesPagament] = visitaPag;
        posicioVisitesPagament++;
    }

    public void showExcursio() {
        System.out.println("\nLes dades de l'excursió amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nPreu:" + preu);

        int i;

        for (i = 0; i < posicioGuies; i++) {
            guies[i].showGuia();
        }

        for (i = 0; i < posicioVisitesLliures; i++) {
            visitesLliures[i].showVisitaLliure();
        }

        for (i = 0; i < posicioVisitesPagament; i++) {
            visitesPagament[i].showVisitaPagament();
        }
    }

}
