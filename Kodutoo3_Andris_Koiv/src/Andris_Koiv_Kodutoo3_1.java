import java.util.HashMap;
import java.util.Map;

public class Andris_Koiv_Kodutoo3_1 {

    public static void main(String[] args) {
    prindiVastus();

    }
    // Ülesanne 1 algus
    public static void prindiVastus(){
        String sisend = "Pets maiku ja ubaÕÄÖÜ";
        System.out.println("Sisendtekst: " + sisend);
        char koigeSagedasem = leiakoigeSagedasem(sisend);
        if(koigeSagedasem == '0'){
            System.out.println("Numbrid puuduvad!");
        } else{
            System.out.println("Kõige sagedasem number on: " + koigeSagedasem);
            System.out.println("Uus tekst: " + eemaldaTahtJaNumber(sisend, koigeSagedasem));
        }
    }
    public static char leiakoigeSagedasem(String sisend) {      // Otsime kõige sagedasemat numbrit
        Map<Character, Integer> numbridSagedusega = new HashMap<>();        // Uus HashMap
        for(char symbol : sisend.toCharArray()){        // For tsükli sisendiks Üks tähemärk ja sisendist tehtud sümbolite massiiv
            if(Character.isDigit(symbol)){              // Kui tähemärk on number
                numbridSagedusega.put(symbol, numbridSagedusega.getOrDefault(symbol, 0) + 1);   // Teeme loenduri. Vaikeväärtus on 0. Kui number esineb, lisame loendurisse +1
            }
        }
        char koigeSagedasem = '0'; // Kui tekstis pole numbreid, tagastame selle väärtuse.
        int maxSagedus = 0;         // Uus muutuja maxSagedus. Siia salvestame kõige suurema sagedusega numbri väärtuse
        for(Map.Entry<Character, Integer> entry : numbridSagedusega.entrySet()){ // Teeme tabeli kõikidest numbritest ja nende sagedustest
            if(entry.getValue() > maxSagedus) { // Kontrollime kas arv mida kontrollime on suurima sagedusega. Kui on, siis tagastame selle
                koigeSagedasem = entry.getKey();
                maxSagedus = entry.getValue();
            }
        }

        return koigeSagedasem;
    }

    public static String eemaldaTahtJaNumber(String sisend, char symbol) {
        sisend = sisend.replace(symbol, '.');   // Asenda kõige sagedasemini esinev number punktiga.
        return sisend.replaceAll("[^a-zA-Z0-9]", "."); // Kõik sümbolid mis ei kuulu inglise tähestikku asendame punktiga
    }
    // Ülesanne 1 lõpp
}
