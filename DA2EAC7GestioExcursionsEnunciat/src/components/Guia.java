/*
 * Classe que defineix un guia. Un guia es defineix pel seu codi, nom, adreça i 
 * telèfon
 */
package components;

import java.util.Scanner;

/**
 *
 * @author FTA
 */
public class Guia {

    private String codi;
    private String nom;
    private String adreca;
    private String telefon;
    public static final Scanner DADES = new Scanner(System.in);

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     */
    public Guia(String codi, String nom, String adreca, String telefon) {
        this.codi = codi;
        this.nom = nom;
        this.adreca = adreca;
        this.telefon = telefon;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou guia. Les dades
     a demanar són les que necessita el constructor.
     - També heu de tenir en compte que tant el nom com l'adreça, poden ser frases,
     per exemple, Francesc Xavier, o bé, C/ del dofí, 13.
     Retorn: El nou guia creat.
     */
    public static Guia addGuia() {

        String codi;
        String nom;
        String adreca;
        String telefon;

        System.out.print("Introdueixi el codi del guia: ");
        codi = DADES.next();//sols considero fins l'espai en blanc
        DADES.nextLine();//netejar el buffer
        System.out.print("Introdueixi el nom del guia: ");
        nom = DADES.nextLine();
        System.out.print("Introdueixi l'adreça del guia: ");
        adreca = DADES.nextLine();
        System.out.print("Introdueixi el telèfon del guia: ");
        telefon = DADES.nextLine();
        //DADES.close();

        //crear el constructor amb les dades introduïdes
        Guia guia = new Guia(codi, nom, adreca, telefon);
        System.out.println("\nLes dades del guia amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nAdreça:" + adreca);
        System.out.println("\nTelefon:" + telefon);
        return guia;

    }

    public void visualitzar() {
        System.out.println("Codi...........:" + getCodi());
        System.out.println("Nom...........:" + getNom());
        System.out.println("Adreça...........:" + getAdreca());
        System.out.println("Telefon...........:" + getTelefon());
    }


    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void updateGuia() {
        //declaracióVariablesLocals
        String codiGuia;
        String nomGuia;
        String adrecaGuia;
        String telefonGuia;

        System.out.print("Modifiqui el codi del guia: ");
        codiGuia = DADES.next();
        DADES.nextLine();//netejar el buffer
        setCodi(codiGuia);
        System.out.print("Modifiqui el nom del guia: ");
        nomGuia = DADES.nextLine();
        setNom(nomGuia);
        System.out.print("Modifiqui l'adreça del guia: ");
        adrecaGuia = DADES.nextLine();
        setAdreca(adrecaGuia);
        System.out.print("Modifiqui el tf del guia: ");
        telefonGuia = DADES.next();
        //DADES.close();
        setTelefon(telefonGuia);

        showGuia();

    }

    public void showGuia() {
        System.out.println("\nLes dades del guia amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nAdreça:" + adreca);
        System.out.println("\nTelefon:" + telefon);
    }

}
