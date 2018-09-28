/*
 * Una classe Application per interactuar amb l'usuari, que contengui els destins 
 * i cridar a la resta de classes i mètodes mitjançant uns menús.
 */
package principal;
import java.util.Scanner;

/**
 *
 * @author FTA
 */
public class Application {

    static private Desti[] destins = new Desti[5];//Destins de l'agència d'excursions
    static private int posicioDestins = 0; //La propera posició buida del vector destins
    static private Desti destiActual = null; //Destí seleccionat
    public static final Scanner DADES = new Scanner(System.in);
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de destins");
            System.out.println("\n2. Gestió d'excursions");
            System.out.println("\n3. Gestió de guies");
            System.out.println("\n4. Gestió de visites amb entrada lliure");
            System.out.println("\n5. Gestió de visites de pagament");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuDestins();
                    break;
                case 2:
                    if (destiActual != null) {
                        menuExcursions();
                    } else {
                        System.out.println(RED+"\nPrimer s'ha de seleccionar el destí en el menú de destins"+RESET);
                    }
                    break;
                case 3:
                    if (destiActual != null) {
                        menuGuies();
                    } else {
                        System.out.println(RED+"\nPrimer s'ha de seleccionar el destí en el menú de destins"+RESET);
                    }
                    break;
                case 4:
                    if (destiActual != null) {
                        menuVisitesLliures();
                    } else {
                        System.out.println(RED+"\nPrimer s'ha de seleccionar el destí en el menú de destins"+RESET);
                    }
                    break;
                case 5:
                    if (destiActual != null) {
                        menuVisitesPagament();
                    } else {
                        System.out.println(RED+"\nPrimer s'ha de seleccionar el destí en el menú de destins"+RESET);
                    }
                    break;
                default:
                    System.out.println(RED+"\nS'ha de seleccionar una opció correcta del menú."+RESET);
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuDestins() {
        int opcio = 0;

        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. LListar destins");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    destins[posicioDestins] = Desti.addDesti();
                    posicioDestins++;
                    break;
                case 2:
                    if (posicioDestins > 0) {
                        pos = selectDesti();
                        if (pos >= 0) {
                            destiActual = destins[pos];
                        } else {
                            System.out.println(RED + "\nNo existeix aquest destí" + RESET);
                        }
                    } else {
                        System.out.println(RED + "\nNo hi han destins a seleccionar" + RESET);
                    }
                    break;
                case 3:
                    if (posicioDestins > 0) {
                        pos = selectDesti();

                        if (pos >= 0) {
                            destins[pos].updateDesti();
                        } else {
                            System.out.println(RED + "\nNo existeix aquest destí" + RESET);
                        }
                    } else {
                        System.out.println(RED + "\nNo hi han destins a modificar" + RESET);
                    }
                    break;
                case 4:
                    if (posicioDestins > 0) {
                        for (int i = 0; i < posicioDestins; i++) {
                            destins[i].showDesti();
                        }
                    } else {
                        System.out.println(RED + "No s'ha creat cap destí encara" + RESET);
                    }
                    break;
                default:
                    System.out.println(RED+"S'ha de seleccionar una opció correcta del menú."+RESET);
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO 
     Paràmetres: cap
     Accions:
     Heu de desenvolupar el menú guies amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat destiActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea un guia en el destí actual. Penseu que Desti sap crear guies       
     Opció 2. Modificar -->      Permet modificar un guia que ha d'existir al destí actual
     (per comprovar l'existència a la classe Desti tenim un mètode que ens ajuda)
     Opció 3. Llistar guies-->Imprimeix les dades dels guies del destí actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     Retorn: cap.
     */
    public static void menuGuies() {
        int opcio = 0;

        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. LListar guies");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    destiActual.addGuia();
                    break;
                case 2:
                    if (destiActual.getPosicioGuies() > 0) {
                        pos = destiActual.selectGuia(null);
                        if (pos >= 0) {
                            destiActual.getGuies()[pos].updateGuia();
                        } else {
                            System.out.println(RED + "\nNo existeix aquest guia" + RESET);
                        }
                    } else {
                        System.out.println(RED + "\nNo existeix guies" + RESET);
                    }
                    break;
                case 3:
                    if (destiActual.getPosicioGuies() == 0) {
                        System.out.println(RED+"No hi ha cap guia a modificar"+RESET);
                    } else {
                        for (int i = 0; i < destiActual.getPosicioGuies(); i++) {
                            destiActual.getGuies()[i].showGuia();
                        }
                    }
                    break;
                default:
                    System.out.println(RED+"S'ha de seleccionar una opció correcta del menú."+RESET);
                    break;
            }
        } while (opcio != 0);

    }

    /*
     TODO 
     Paràmetres: cap
     Accions:
     Heu de desenvolupar el menú de les visites amb entrada lliure amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat destiActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una visita amb entrada lliure en el destí actual. Penseu que Desti sap crear visites 
     amb entrada lliure       
     Opció 2. Modificar -->      Permet modificar una visita amb entrada lliure que ha d'existir al destí actual
     (per comprovar l'existència a la classe Desti tenim un mètode que ens ajuda)
     Opció 3. Llistar visites amb entrada lliure-->Imprimeix les dades de les visites amb entrada lliure del destí actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     Retorn: cap.
     */
    public static void menuVisitesLliures() {
        int opcio = 0;
        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. LListar visites amb entrada lliure");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    destiActual.addVisitesLliures();
                    break;
                case 2:
                    if (destiActual.getPosicioVisitesLliures() > 0) {
                        pos = destiActual.selectVisitaLliure(null);
                        if (pos >= 0) {
                            destiActual.getVisitesLliures()[pos].updateVisitaLliure();
                        } else {
                            System.out.println(RED + "\nNo existeix aquesta visites amb entrada lliure" + RESET);
                        }
                    } else {
                        System.out.println(RED + "\nNo existeixen visites amb entrada lliure" + RESET);
                    }
                    break;
                case 3:
                    for (int i = 0; i < destiActual.getPosicioVisitesLliures(); i++) {
                        destiActual.getVisitesLliures()[i].showVisitaLliure();
                    }
                    if (destiActual.getPosicioVisitesLliures() == 0) {
                        System.out.println(RED+"No hi han visites lliures"+RESET);
                    }
                    break;
                default:
                    System.out.println(RED+"S'ha de seleccionar una opció correcta del menú."+RESET);
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO 
     Paràmetres: cap
     Accions:
     Heu de desenvolupar el menú de les visites de pagament amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat destiActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una visita de pagament en el destí actual. Penseu que Desti sap crear visites 
     de pagament      
     Opció 2. Modificar -->      Permet modificar una visita de pagament que ha d'existir al destí actual
     (per comprovar l'existència a la classe Desti tenim un mètode que ens ajuda)
     Opció 3. Llistar visites de pagament-->Imprimeix les dades de les visites de pagament del destí actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     Retorn: cap.
     */
    public static void menuVisitesPagament() {
        int opcio = 0;
        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Llistar visites de pagament");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    destiActual.addVisitesPagament();
                    break;
                case 2:
                    if (destiActual.getPosicioVisitesPagament() > 0) {
                        pos = destiActual.selectVisitaPagament(null);
                        if (pos >= 0) {
                            destiActual.getVisitesPagament()[pos].updateVisitaPagament();
                        } else {
                            System.out.println(RED + "\nNo existeix aquesta visites amb entrada de pagament" + RESET);
                        }
                    } else {
                        System.out.println(RED + "\nNo existeixen visites amb entrada de pagament" + RESET);
                    }
                    break;
                case 3:
                    for (int i = 0; i < destiActual.getPosicioVisitesPagament(); i++) {
                        destiActual.getVisitesPagament()[i].showVisitaPagament();
                    }
                    if (destiActual.getPosicioVisitesPagament() == 0) {
                        System.out.println(RED+"No hi han visites de pagament"+RESET);
                    }
                    break;
                default:
                    System.out.println(RED+"\nS'ha de seleccionar una opció correcta del menú."+RESET);
                    break;
            }
        } while (opcio != 0);
    }

    /*
     TODO 
     Paràmetres: cap
     Accions:
     Heu de desenvolupar el menú excursions amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, la propietat destiActual no és null
     
     Opció 0. Sortir -->         Sortim del menú. 
     Opció 1. Alta -->           Crea una visita de pagament en el destí actual. Penseu que Desti sap crear visites 
     excursions       
     Opció 2. Afegir guia --> Afegeix un guia al vector de guies de l'excursió, però
     penseu que Desti sap fer-ho
     Opció 3. Afegir visita amb entrada lliure --> Afegeix una visita d'entrada lliure
     al vector de visites d'entrada lliure de l'excursió, però penseu que Desti sap fer-ho
     Opció 4. Afegir visita de pagament --> Afegeix una visita de pagament al vector 
     de visites de pagament de l'excursió, però penseu que Desti sap fer-ho
     Opció 5. Llistar excursions-->Imprimeix les dades de les taules del restaurant actual
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi l'opció 0 de sortida
     Recomanacions:
     - estructura de control switch case per bifurcar les opcions
     - si no s'ha introduït cap opció de les de la llista, s'ha de mostrar el missatge
     "S'ha de seleccionar una opció correcta del menú."
     - per a l'entrada de dades, millor fer servir la classe Scanner
     - definiu una variable int opcio;
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, doncs això ho farem amb la
     tècnica de les excepcions que veurem més endavant
     Retorn: cap.
     */
    public static void menuExcursions() {
        int opcio = 0;
        Excursio[] exc = new Excursio[100];

        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Afegir guia a una excursió");
            System.out.println("\n3. Afegir visita amb entrada lliure");
            System.out.println("\n4. Afegir visita de pagament");
            System.out.println("\n5. Llistar excursions");

            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    destiActual.addExcursio();
                    break;
                case 2:
                    destiActual.addGuiaExcursio();
                    break;
                case 3:
                    destiActual.addVisitaLliureExcursio();
                    break;
                case 4:
                    destiActual.addVisitaPagamentExcursio();
                    break;
                case 5:
                    for (int i = 0; i < destiActual.getPosicioExcursions(); i++) {
                        destiActual.getExcursions()[i].showExcursio();
                    }
                    if (destiActual.getPosicioExcursions()== 0) {
                        System.out.println(RED+"No hi han excursions per llistar"+RESET);
                    }
                    break;
                default:
                    System.out.println(RED+"\nS'ha de seleccionar una opció correcta del menú."+RESET);
                    break;
            }
        } while (opcio != 0);
    }

    public static Integer selectDesti() {

        System.out.println("\nCodi del destí?:");
        int codi = DADES.nextInt();

        boolean trobat = false;
        int pos = -1;

        for (int i = 0; i < posicioDestins && !trobat; i++) {
            if (destins[i].getCodi() == codi) {
                pos = i;
                trobat = true;
            }
        }

        return pos;
    }
}
