
package kartyatrukk;

import java.util.Scanner;

public class KartyaTrukk {

     static Scanner myObj = new Scanner(System.in);
    static String[] pakli = new String[22];

    public static void main(String[] args) {
        Feltolt();
        for (int i = 0; i < 3; i++) {
            Kirak();
            int oszlop = Melyik();
            Kever(oszlop);
        }

        EzVolt();
    }

    private static void Feltolt() {
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", ",X", "IX", "VIII"};

        int i = 1;
        for (String szin : szinek) {
            for (int j = 0; i < 22 && j < ertekek.length; j++) {
                pakli[i++] = szin + "_" + ertekek[j] + " ";
            }
        }
    }

    private static void Kirak() {
        for (int i = 0; i < pakli.length; i++) {

            System.out.printf("%-8s", pakli[i]);
            if (i % 3 == 0) {
                System.out.println("");
            }
        }
    }

    private static int Melyik() {
        boolean jo;
        int oszlop;
        do {
            System.out.println("Oszlop 1-3: ");
            oszlop = myObj.nextInt();
            jo = oszlop >= 1 && oszlop <= 3;
        } while (!jo);
        return oszlop;
    }

    private static void Kever(int oszlop) {
        String[] ujPakli = new String[22];
        switch (oszlop) {
            case 1:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
            case 2:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }

            case 3:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[21 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[20 - (i - 1) * 3];
                }
                break;
            default:
        }
        pakli = ujPakli;
    }

    private static void EzVolt() {
        System.out.println("Kiválaszott lap: " + pakli[11]);
    }
    
}
