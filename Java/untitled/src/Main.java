//Andris Kõiv, Tunnitöö 1
// Ülesanne 1, prindi välja 2 väikseimat numbrit

import java.util.Arrays;  // Impordin massiivid
public class Main {
    public static void main(String[] args) {
        int[] massiiv = {18, 120, 16, 20, 72, 551};  // Ette antud massiiv, mida sorditakse
        Arrays.sort(massiiv);           // Sordi massiiv väiksemast suuremani
        int esimene = massiiv[0];       // Kõige väiksem massiivist
        int teine = massiiv[1];         // Teine väiksem massiivist
            System.out.println("\n 2 kõige väiksemat numbrit on:");
            System.out.println(esimene+ "," +teine);
        }


    }



