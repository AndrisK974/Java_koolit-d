import java.util.Arrays;

// Andris Kõiv, 06.02.2024, Kodutöö 1
public class AndrisKõivKodu1 {
    static void ulesanne1() {
        String sisend = "abbcaaa";           // Sisend, millega operatsioone tehakse
        int sõnePikkus = sisend.length();   // Sõne pikkuse funktsioon, võetakse sõne arvuline pikkus
        if (sõnePikkus <= 3) {              // Kui sõne pikkus on väiksem kui 3
            System.out.println("Sõne: " + sisend);  // Prindi välja terve sõne
        } else if (sõnePikkus % 2 != 0) {           // Kui sõne ei jagu kahega ehk on paarituarvuline
            int keskmine = sõnePikkus / 2;          // Leiame keskkoha
            int keskmine1 = keskmine + 1;           // Keskmine +1, et saada keskmisest üks täht edasi olev täht
            int keskmine2 = keskmine - 1;           // Keskmine -1, sama loogika mis ülemise puhul. All prindime välja kõik 3 tähte
            System.out.println("Sõne on paarituarvuline, keskmised 3 tähte on: " + sisend.charAt(keskmine2) + sisend.charAt(keskmine) + sisend.charAt(keskmine1));
        } else if (sõnePikkus % 2 == 0) {   // Kui sõne pikkus on paarisarv, siis see jagub kahega
            int keskmine = sõnePikkus / 2;  // Jagame sõne pikkuse pooleks, et saada keskmine täht
            int keskmine1 = keskmine - 1;   // Võtame keskmine -1, kuna paarisarvulisel sõnel on 2 keskmist tähte. Prindime need 2 tähte välja
            System.out.println("Sõne on paarisarvuline, keskmised 2 tähte on: " + sisend.charAt(keskmine1) + sisend.charAt(keskmine));
        }
    }
    static boolean ulesanne2() {
        String sisend = "xaaaxaaxaxc"; // Sisendsõne, millest hakkame otsinguid tegema
        String otsitav = "aaa";     // Otsitav sõne. Tegin sellest muutuja, kuna nii saab muuta, mis sõne otsime. Otsitava sõne pikkus peab olema 3 tähemärki
        // Pikk if lause. Kui sisendi pikkus on suurem võrdne neljaga JA sisendi alamsõnes 2. positsioonil on aaa (ehk siis 2-1 on a, 2 on a, 2+1 on a VÕI 2 on a, 2+1 on a ja 2+2 on a) VÕI kui
        // sõne pikkus on suurem võrdne kuuega siis otsitakse ka neljandalt positsioonilt, kas on aaa. Otsing käib sama loogika järgi. Vaadatakse 3.; 4.; 5. ja 6. kohta.
        if (sisend.length() >= 4 && (sisend.substring(1, 4).equals(otsitav) || (sisend.length() >= 6 && sisend.substring(3, 6).equals(otsitav)))) {
            return true; // Kui sõne leitakse, tagastatakse true
        } else {
            return false; // Kui sõne ei leita, pikkus pole piisav, tagastatakse false
        }
    }
    static int ulesanne3() {
        int[] Massiiv = {10, 10, 10, 10, 25, 30, 82};   // Annan ette massiivi
        int otsitav = 10;                               // Muutuja. Siia sisestame arvu, mida otsime
        int mituKorda = 0;                              // See on muutuja, kus arvutatakse, mitu korda esineb. Alguses on see 0
        for (int i = 0; i < Massiiv.length; i++){       // For loop. Kui i on väiksem kui massiivi pikkus, siis liidame i-le ühe juurde ja kontrollime uuesti. Loop lõppeb, kui i pole enam väiksem kui massiiv
            if (Massiiv[i] == otsitav) {                // Kui massiivis olev element võrdub meie otsitava väärtusega, siis
                mituKorda++;                            // Liidame muutujale "mituKorda" ühe juurde
            }
        }
        System.out.println("Arvu " +otsitav + " esineb massiivis " + mituKorda+ " korda");  // Prindime välja otsitava arvu ning mitu korda see massiivis esineb.
        return otsitav;
    }
    static void ulesanne4(){
        String[] Massiiv = {"A", "B", "C", "D", "E", "F", "G"};     // Annan ette massiivi
        if(Massiiv.length >3){                                      // Kui massiivi pikkus on üle 3 siis
            String kolmas = Massiiv[2];                             // Kolmas element on Massiivis indeksil 2, annan talle muutuja "kolmas"
            Massiiv[2] = Massiiv[Massiiv.length - 1];               // Tõstan 3. elemendi viimasele kohale.
            Massiiv[Massiiv.length - 1] = kolmas;                   // Tõstan viimase elemendi kolmandale kohale
            System.out.println("Vahetatud elementidega massiiv on järgmine: " + Arrays.toString(Massiiv));  // Prindin välja massiivi, kus on kohad vahetatud. Arrays.toString kasutan, kuna see prindib välja sõne
        }
        else{                                                       // Kui massiiv oli liiga lühike, ning vahetust ei saanud teha
            System.out.println("Massiiv pole elementide vahetamiseks piisavalt pikk!"); // Veateade, et massiiv pole piisavalt pikk
        }
    }
    public static void main(String[] args) {

        ulesanne1(); // Käivita Ülesanne 1
        // Proovisin ülesannet 2 lahendada n.ö moodsamalt, kuid ülejäänud ülesannetesse panin siiski println-i funktsiooni sisse, kuna nii tundus
        // main funktsioon puhtamana. Ei tea, kumb on õigem, seega proovisin mõlemat pidi. Ise eelistan, et main funktsioonis on ainult
        // teiste funktsioonide käivitus.
        boolean tulemus = ulesanne2(); // Muutuja tulemus on kas true või false, vastavalt IF vastusele. Käivitatakse ülesanne 2
        System.out.println(tulemus); // Prinditakse välja, kas IF vastuseks saadi true või false
        ulesanne3();    // Käivita Ülesanne 3
        ulesanne4();    // Käivita Ülesanne 4
    }
}