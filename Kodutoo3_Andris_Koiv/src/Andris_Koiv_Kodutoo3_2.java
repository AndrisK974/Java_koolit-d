import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

    public class Andris_Koiv_Kodutoo3_2 {

        public static void main(String[] args) {
            String sisendfail = "src\\inimesed.txt"; // Sisendfail, kust loetakse kirjed
            String valjund1 = "src\\valjund1.txt";  // Ilusti sorditud väljund
            String valjund2 = "src\\valjund2.txt";  // Väljund, kuhu lähevad mittesobivad kirjed muutmata kujul
            String otsitav = "Pireta";              // Sõne, mida soovime eemaldada sisendfailist
            convert(sisendfail, valjund1, valjund2);    // Kutsume välja converti
            eemaldaRida(sisendfail, otsitav);           // Kutsume välja eemaldaRida
        }

        public static void convert(String sisendfail, String valjund1, String valjund2) {
            try (BufferedReader br = new BufferedReader(new FileReader(sisendfail));    // Loeme sisse sisendfaili
                 BufferedWriter bw1 = new BufferedWriter(new FileWriter(valjund1));     // Kirjutame valjund1 faili
                 BufferedWriter bw2 = new BufferedWriter(new FileWriter(valjund2))) {   // Kirjutame valjund2 faili

                String line;
                while ((line = br.readLine()) != null) {        // Kuniks on ridu mida lugeda
                    String[] parts = line.split("\\|");   // Eemaldame | märgi kirjete vahelt
                    if (parts.length == 4) {                    // Kui on 4 erinevat osa
                        String isikukood = parts[0];            // 1. on isikukood
                        String perekonnanimi = parts[1];        // 2. on perekonnanimi
                        String eesnimi = parts[2];              // 3. on eesnimi
                        String palk = parts[3];                 // 4. on palk
/* Otsime, kas isikukood sisaldab tähti. Kui sisaldab, siis lõhume ennast loopist välja väärtusega true*/
                        boolean isikukoodisTaht = false;
                        for (char c : isikukood.toCharArray()) {
                            if (Character.isLetter(c)) {
                                isikukoodisTaht = true;
                                break;
                            }
                        }
/* Otsime, kas perenimes on number. Kui on, lõhume loopist välja väärtusega true */
                        boolean kasOnNumbritPerenimes = false;
                        for (char c : perekonnanimi.toCharArray()) {
                            if (Character.isDigit(c)) {
                                kasOnNumbritPerenimes = true;
                                break;
                            }
                        }
                        // Otsime, kas eesnimes on number
                        boolean kasOnNumbritEesnimes = false;
                        for (char c : eesnimi.toCharArray()) {
                            if (Character.isDigit(c)) {
                                kasOnNumbritEesnimes = true;
                                break;
                            }


                        }
                        boolean kasPalkOnNumber = false; // Alguses on see muutuja false
                        try {                           // Try, kuna palk ei pruugi olla number. Sellisel juhul saaksime veateate, kuid try catch võimaldab selle kinni püüda
                            double palkDouble = Double.parseDouble(palk);
                            if (palkDouble > 0) {
                                kasPalkOnNumber = true; // Kui väärtus on üle 0 siis väljastame väärtuse true
                            }
                        } catch (NumberFormatException e) {
                            kasPalkOnNumber = false;    // Kui tuleb NumberFormatException siis järelikult pole sellel real kõik numbrid ning väljastame väärtuse false
                        }
                        // Pikk IF-ide rida. Kõik kontrollivad sobivust. Kommentaarid väga lühidad
                        bw1.newLine();
                        if (perekonnanimi.length() > 2 && !kasOnNumbritPerenimes) { // Kui perenimi on pikem kui 2 tähte ja ei sisalda numbreid
                            bw1.write("Perekonnanimi: " + perekonnanimi);       // kirjuta õiges formaadis ja liigu uuele reale
                            bw1.newLine();
                        } else {
                            bw2.write(line);        // Kirjuta valjund2 faili
                            bw2.newLine();          // Mine uuele reale
                        }
                        if (eesnimi.length() > 2 && !kasOnNumbritEesnimes) {    // Kui eesnimi on pikem kui 2 ja ei sisalda numbrit
                            bw1.write("Eesnimi: " + eesnimi);               // Õiges formaadis faili kirjutamine
                            bw1.newLine();                                      // Uuele reale
                        } else {
                            bw2.write(line);    // Kirjuta valjund2 faili
                            bw2.newLine();      // Uuele reale
                        }
/* Kui isikukood on 11 numbrit pikk, ei sisalda tähti, algab numbriga 3 - 6, siis kirjuta see valjund1, vastasel juhul valjund2 */
                        if (isikukood.length() == 11 && !isikukoodisTaht && isikukood.startsWith("3") || isikukood.startsWith("4") || isikukood.startsWith("5") || isikukood.startsWith("6")) {
                            bw1.write("Isikukood: " + isikukood);
                            bw1.newLine();
                        } else {
                            bw2.write(line);
                            bw2.newLine();
                        }
                        if (kasPalkOnNumber) {  // Kui palk on number siis valjund1, muidu valjund2
                            bw1.write("Palk: " + palk);
                            bw1.newLine();
                        } else {
                            bw2.write(line);
                            bw2.newLine();
                        }


                    }
                }

                System.out.println("Andmete teisendamine faili " + sisendfail +" õnnestus!"); // Ütleme, et andmete teisendamine õnnestus

            } catch (IOException e) { // Kui sisendfail on puudu siis järelikult viga ja prindime välja ka veakoodi
                System.err.println("Viga!\n" + e.getMessage());
            }

        }

        public static void eemaldaRida(String sisendfail,  String otsitav) {    // Eemaldame rea
            try (BufferedReader br = new BufferedReader(new FileReader(sisendfail));    // Loeme sisse sisendfaili
                 BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"))) {  // Teeme temp.txt faili

                String line;
                while ((line = br.readLine()) != null) {        // Kuniks rida pole tühi
                    if (!line.contains(otsitav)) {              // Kui rida ei sisalda otsitavat
                        bw.write(line);                         // Kirjuta see faili
                        bw.newLine();                           // Uuele reale minek
                    }
                }
            } catch (IOException e) {       // Veateate saamine
                System.err.println("Viga!\n" + e.getMessage());
            }
            File vanaFail = new File(sisendfail);   // vanaFail on meie sisendfail
            vanaFail.delete();                      // Kustutame vana faili ära
            File uusFail = new File("temp.txt");    // Meie uus fail on meie äsja loodud temp fail
            uusFail.renameTo(vanaFail);             // Muudame temp.txt nime inimesed.txt-ks
        }
    }




