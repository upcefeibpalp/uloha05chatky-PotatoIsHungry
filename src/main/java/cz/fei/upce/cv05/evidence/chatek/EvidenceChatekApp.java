package cz.fei.upce.cv05.evidence.chatek;

import java.util.Scanner;

public class EvidenceChatekApp {

    public static void main(String[] args) {
        final int KONEC_PROGRAMU = 0;
        final int VYPIS_CHATEK = 1;
        final int VYPIS_KONKRETNI_CHATKU = 2;
        final int PRIDANI_NAVSTEVNIKU = 3;
        final int ODEBRANI_NAVSTEVNIKU = 4;
        final int CELKOVA_OBSAZENOST = 5;
        final int VYPIS_PRAZDNE_CHATKY = 6;

        final int VELIKOST_KEMPU = 5;
        final int MAX_VELIKOST_CHATKY = 10;

        Scanner scanner = new Scanner(System.in);

        int[] chatky = new int[VELIKOST_KEMPU];
        int operace;

        do {
            System.out.println("""
                    MENU:
                                        
                    1 - vypsani vsech chatek
                    2 - vypsani konkretni chatky
                    3 - Pridani navstevniku
                    4 - Odebrani navstevniku
                    5 - Celkova obsazenost kempu
                    6 - Vypis prazdne chatky
                    0 - Konec programu
                    """);

            System.out.print("Zadej volbu: ");
            operace = scanner.nextInt();

            switch (operace) {
                case VYPIS_CHATEK -> vypisChatek(chatky);
                case VYPIS_KONKRETNI_CHATKU -> vypisKonkretniChatky(chatky, scanner);
                case PRIDANI_NAVSTEVNIKU -> pridaniNavstevniku(chatky, scanner, MAX_VELIKOST_CHATKY);
                case ODEBRANI_NAVSTEVNIKU -> odebraniNavstevniku(chatky, scanner);
                case CELKOVA_OBSAZENOST ->  obsazenost(chatky);
                case VYPIS_PRAZDNE_CHATKY ->  prazdneChatky(chatky);
                case KONEC_PROGRAMU -> System.out.println("Konec programu");
                default -> System.err.println("Neplatna volba");
                
            }
        } while (operace != 0);
    }

    public static void vypisChatek(int[] chatky) {
        for (int i = 0; i < chatky.length; i++) {
            System.out.println("Chatka [" + cisloChatky(i) + "] = " + chatky[i]);
        }
    }

    public static void vypisKonkretniChatky(int[] chatky, Scanner scanner) {
        System.out.print("Zadej cislo chatky: ");
        int cisloChatky = scanner.nextInt() - 1;

        if (cisloChatky < 0 || cisloChatky >= chatky.length) {
            System.err.println("Tato chatka neexistuje");
        } else {
            System.out.println("Chatka [" + cisloChatky(cisloChatky) + "] = " + chatky[cisloChatky]);
        }
    }

    public static void prazdneChatky(int[] chatky) {
        for (int i = 0; i < chatky.length; i++) {
            if (chatky[i] == 0) {
                System.out.println("Chatka[" + cisloChatky(i) + "]");
            }
        }
    }

    public static void obsazenost(int[] chatky) {
        
        int obsazene = 0;
        
        for (int i = 0; i < chatky.length; i++) {
            System.out.println("Chatka[" + cisloChatky(i) + "] = " + chatky[i]);
            obsazene += chatky[i];
        }
        System.out.println("Obsazenost: " + obsazene);
    }

    public static void odebraniNavstevniku(int[] chatky, Scanner scanner) {
        System.out.print("Zadej cislo chatky: ");
        int cisloChatky = scanner.nextInt() - 1;

        if (cisloChatky < 0 || cisloChatky >= chatky.length) {
            System.err.println("Tato chatka neexistuje");
        } else {
            System.out.print("Zadej pocet navstevniku pro odebrani: ");
            int pocetNavstevniku = scanner.nextInt();

            if (pocetNavstevniku <= 0) {
                System.err.println("Neplatna hodnota pro pocet navstevniku");

            } else if (chatky[cisloChatky] - pocetNavstevniku < 0) {
                System.err.println("Prekrocen limit");

            } else {
                chatky[cisloChatky] = chatky[cisloChatky] - pocetNavstevniku;
            }
        }
    }

    public static void pridaniNavstevniku(int[] chatky, Scanner scanner, int MAX_VELIKOST_CHATKY) {
        System.out.print("Zadej cislo chatky: ");
        int cisloChatky = scanner.nextInt() - 1;

        if (cisloChatky < 0 || cisloChatky >= chatky.length) {
            System.err.println("Tato chatka neexistuje");

        } else {
            System.out.print("Zadej pocet navstevniku: ");
            int pocetNavstevniku = scanner.nextInt();

            if (pocetNavstevniku <= 0 || pocetNavstevniku > MAX_VELIKOST_CHATKY) {
                System.err.println("Neplatna hodnota pro pocet navstevniku");

            } else if ((chatky[cisloChatky] + pocetNavstevniku) > MAX_VELIKOST_CHATKY) {
                System.err.println("Prekrocen maximalni pocet navstevniku chatky");

            } else {
                chatky[cisloChatky] = pocetNavstevniku + chatky[cisloChatky];
            }
        }
    }
    
    public static int cisloChatky(int cislo){
        return cislo +1;
    }
}
