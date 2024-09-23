import java.util.*;

public class Ülesanne1 {
    public static void main(String[] args){
        String sisend = "Luua hulk words. Leida kõik tekstis esinenud sõnad, salvestada need hulka\n" +         // Sisendtekst, kasutasin ülesande teksti
                "words nende ilmumise järjekorras. Väljastada words konsoolile! Kas (see programm) töötab?";    // Saaks ka kasutada scannerit, et kasutaja saaks ise teksti sisestada

        Set<String> sõnad = new LinkedHashSet<>(); // LinkedHashSet säilitab sõnade järjekorra
        String[] sõnaMassiiv = sisend.split("\\s+"); // Tekstist sõnade eraldamine, kõik sõnad uuel real

        for (String sõna : sõnaMassiiv) {   // For tsükkel lisame sõnad massiiiv
            sõna = sõna.replaceAll("[.,!?()]", ""); // Eemaldame kirjavahemärgid
            sõnad.add(sõna);
        }

        System.out.println("Tekstis esinevad sõnad on: ");
        for (String sõna : sõnad) { // For tsükkel. Prindi seni, kuni sõnu on
            System.out.println(sõna); // Prindime välja sõna
        }
    }
}
