import java.util.*;

public class Ülesanne2 {
    public static void main(String[] args) {
        String sisend = "Luua kujutis letters. Leida tähtede k, p, t, r, s esinemissagedus tekstis,\n" +
                "reastatult esinemissageduse järjekorras – kõige sagedasem esimesena ja kõige vähem\n" +
                "sage viimasena. Väljastada letters konsoolile.";  // Ülesande tekst näidiseks
        Map<Character, Integer> täheEsinemine = new HashMap<>();    // Tähe esinemine on uus map
        sisend = sisend.toLowerCase(); // Teeme kõik väikesteks tähtedeks

        for (char c : sisend.toCharArray()) {   // For tsükkel mis otsib tähed välja
            if ("kptrs".indexOf(c) != -1) {     // Kui k, p, t, r, s ei esine, siis tagastatakse -1. Kui esineb, siis
                täheEsinemine.put(c, täheEsinemine.getOrDefault(c, 0) + 1); // Salvestame loendurisse. Loendur alustab 0-ist
            }
        }
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(täheEsinemine.entrySet()); // Sorditud tähtede list
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Võrdleme kahte väärtust, et leida, milline on suurem

        System.out.println("Tähtede esinemissagedus tekstis:");
        for (Map.Entry<Character, Integer> entry : sortedList) { // Prindime esinemissageduse järjekorras tähed välja. Käib läbi kõik tähed
            System.out.println(entry.getKey() + ": " + entry.getValue()); // Võtmeks on täht, value on mitu korda esines
        }
    }
}
