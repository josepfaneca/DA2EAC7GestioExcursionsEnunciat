/*
 * Classe que defineix un desti. Un destí es defineix per un codi, un nom i continent 
 * al qual pertany el destí. A més, contindrà vectors amb excursions, guies, visites 
 * amb entrada lliure  i visites de pagament.
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
public class Desti {

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nom;
    private String continent;
    private Guia[] guies = new Guia[40];
    private Integer posicioGuies = 0; //Primera posició buida del vector guies
    private VisitaLliure[] visitesLliures = new VisitaLliure[40];
    private Integer posicioVisitesLliures = 0; //Priemra posició buida del vector visitesLliures    
    private VisitaPagament[] visitesPagament = new VisitaPagament[40];
    private Integer posicioVisitesPagament = 0; //Priemra posició buida del vector visitesPagament
    private Excursio[] excursions = new Excursio[100];
    private int posicioExcursions = 0; //Possició actual buida del vector excursions
    public static final Scanner DADES = new Scanner(System.in);
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    /*
     TODO
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys els vectors i el
     codi.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     */
    public Desti(String nom, String continent) {
        this.codi = properCodi;
        this.nom = nom;
        this.continent = continent;
        properCodi++;//properCodi amb el següent codi a assignar.??
    }

    /*
     TODO Mètodes accessors    
     */
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi(int properCodi) {
        Desti.properCodi = properCodi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
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

    public Excursio[] getExcursions() {
        return excursions;
    }

    public void setExcursions(Excursio[] excursions) {
        this.excursions = excursions;
    }

    public int getPosicioExcursions() {
        return posicioExcursions;
    }

    public void setPosicioExcursions(int posicioExcursions) {
        this.posicioExcursions = posicioExcursions;
    }

    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou destí. Les dades
     a demanar són les que necessita el constructor.
     - Heu de tenir en compte que el nom pot ser una frase, per exemple, New York.
     Retorn: El nou destí creat.
     */
    public static Desti addDesti() {

        String nom, continent;
        System.out.print("Introdueixi el nom del destí: ");
        nom = DADES.nextLine();
        System.out.print("Introdueixi el continent del destí: ");
        continent = DADES.nextLine();

        Desti desti = new Desti(nom, continent);

        return desti;
    }

    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     no es pot modificar el contingut dels vectors, només els dels atributs 
     nom i continent. Evidentment, tampoc podeu modificar el codi.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los.
     Retorn: cap
     */
    public void updateDesti() {

        showDesti();

        System.out.print("Introduixi el nou destí: ");
        nom = DADES.nextLine();
        setNom(nom);

        System.out.print("Introduixi el nou continent: ");
        continent = DADES.nextLine();
        setContinent(continent);

        //DADES.close();
    }

    public void showDesti() {
        System.out.println("\nLes dades del destí amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nContinent:" + continent);
    }

    /*
     GUIA
     */
 /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nou guia al vector de guies d'aquest destí (l'objecte actual) si
     aquest no existeix. Per afegir-lo heu de fer  servir el mètode de la classe 
     Guia pertinent i per comprovar la seva existència el mètode de la classe Destí
     que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de guies si s'afegeix el guia.
     - mostra el missatge "El guia ja existeix" si no s'ha afegit el guia.
     Retorn: cap
     */
    public void addGuia() {

        int codiGuia = selectGuia(null);

        if (codiGuia != -1) {
            System.out.println(RED+"El guia ja existeix."+RESET);
        } else {
            guies[posicioGuies] = Guia.addGuia();
            posicioGuies++;
        }
    }

    public int selectGuia(String codi) {

        if (codi == null) {
            System.out.println(RED+"\nCodi del guia per comprobar si ja existeix?:"+RESET);
            codi = DADES.next();
        }
        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioGuies && !trobat; i++) {
            if (guies[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     VISITA AMB ENTRADA LLIURE
     */
 /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nova visita amb entrada lliure al vector de visites amb entrada 
     lliure d'aquest destí (l'objecte actual) si aquesta no existeix. Per afegir-la
     heu de fer  servir el mètode de la classe VisitaLliure pertinent i per comprovar 
     la seva existència el mètode de la classe Destí que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de vistes amb entrada lliure si s'afegeix la visita.
     - mostra el missatge "La visita amb entrada lliure ja existeix" si no s'ha afegit la visita.
     Retorn: cap
     */
    public void addVisitesLliures() {

        int codiVisitLl = selectVisitaLliure(null);

        if (codiVisitLl != -1) {
            System.out.println(RED+"La visita amb entrada lliure ja existeix"+RESET);
        } else {
            visitesLliures[posicioVisitesLliures] = VisitaLliure.addVisitaLliure();
            posicioVisitesLliures++;
        }
    }

    public int selectVisitaLliure(String codi) {

        if (codi == null) {
            System.out.println(RED+"\nCodi de la visita amb entrada lliure per comprobar existència:"+RESET);
            codi = DADES.next();
        }

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioVisitesLliures && !trobat; i++) {
            if (visitesLliures[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     VISITA DE PAGAMENT
     */
 /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nova visita de pagament al vector de visites de pagament d'aquest 
     destí (l'objecte actual) si aquesta no existeix. Per afegir-la heu de fer  
     servir el mètode de la classe VisitaPagament pertinent i per comprovar la seva 
     existència el mètode de la classe Destí que ens ajuda en aquesta tasca.
     - actualitza la posició del vector de vistes de pagament si s'afegeix la visita.
     - mostra el missatge "La visita de pagament ja existeix" si no s'ha afegit la visita.
     Retorn: cap
     */
    public void addVisitesPagament() {

        int codiVisitPag = selectVisitaPagament(null);
        if (codiVisitPag != -1) {
            System.out.println(RED+"La visita de pagament ja existeix"+RESET);
        } else {
            visitesPagament[posicioVisitesPagament] = VisitaPagament.addVisitaPagament();
            posicioVisitesPagament++;
        }

    }

    public int selectVisitaPagament(String codi) {

        if (codi == null) {
            System.out.println("\nCodi de la visita de pagament?:");
            codi = DADES.next();
        }

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioVisitesPagament && !trobat; i++) {
            if (visitesPagament[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }

    /*
     EXCURSIO
     */
 /*
     TODO
     Paràmetres: cap
     Accions:
     - afegeix un nova excursió al vector d'excursions lliure d'aquest destí 
     (l'objecte actual) si aquesta no existeix. Per afegir-la heu de fer  servir 
     el mètode de la classe Excursió pertinent i per comprovar la seva existència 
     el mètode de la classe Destí que ens ajuda en aquesta tasca.
     - actualitza la posició del vector d'excursions si s'afegeix l'excursió.
     - mostra el missatge "L'excursió ja existeix" si no s'ha afegit l'excursió.
     Retorn: cap
     */
    public void addExcursio() {

        int codiExcurs = selectExcursio(null);

        if (codiExcurs != -1) {
            System.out.println(RED+"L'excursió ja existeix"+RESET);
        } else {
            excursions[posicioExcursions] = Excursio.addExcursio();
            posicioExcursions++;
        }

    }

    public int selectExcursio(String codi) {

        if (codi == null) {
            System.out.println(RED+"\nCodi de l'excursió per comprobar si existeix?:"+RESET);
            codi = DADES.next();
        }

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioExcursions && !trobat; i++) {
            if (excursions[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }
    /////////////----------------------------------------------////////

    public void addGuiaExcursio() {
        Excursio excursioSel = null;
        int pos = selectExcursio(null);

        if (pos >= 0) {

            excursioSel = this.getExcursions()[pos];

            pos = selectGuia(null);

            if (pos >= 0) {
                excursioSel.addGuiaExcursio(getGuies()[pos]);
            } else {
                System.out.println(RED+"\nNo existeix aquest guia"+RESET);
            }

        } else {
            System.out.println(RED+"\nNo existeix aquesta excursió"+RESET);
        }

    }

    public void addVisitaLliureExcursio() {
        Excursio excursioSel = null;
        int pos = selectExcursio(null);

        if (pos >= 0) {

            excursioSel = this.getExcursions()[pos];

            pos = selectVisitaLliure(null);

            if (pos >= 0) {
                excursioSel.addVisitaLliureExcursio(getVisitesLliures()[pos]);
            } else {
                System.out.println(RED+"\nNo existeix aquesta visita amb entrada lliure"+RESET);
            }

        } else {
            System.out.println(RED+"\nNo existeix aquesta excursió"+RESET);
        }
    }

    public void addVisitaPagamentExcursio() {
        Excursio excursioSel = null;
        int pos = selectExcursio(null);

        if (pos >= 0) {

            excursioSel = this.getExcursions()[pos];

            pos = selectVisitaPagament(null);

            if (pos >= 0) {
                excursioSel.addVisitaPagamentExcursio(getVisitesPagament()[pos]);
            } else {
                System.out.println(RED+"\nNo existeix aquesta visita de pagament"+RESET);
            }

        } else {
            System.out.println(RED+"\nNo existeix aquesta excursió"+RESET);
        }
    }
}
