/*
 Andris Kõiv, Tikumängu programm, 21.02.2024
 Tehtud:
      newGame()
      makeComputerMove()
      makeHumanMove()
      Mängu lõppedes uue mängu algus
      Alustama peab inimene
      Arvuti käik on random (v.a juhul, kui on võimalik võita)

*/

import java.util.InputMismatchException;    // Impordin selle, et saaksin kontrollida, kas sisend on täisarv
import java.util.Scanner;                   // Impordin scanneri, et saaksin sisendeid lugeda
import java.util.Random;                    // Impordin randomi, et saaksin suvalise numbri genereerida
public class Kodutoo2_Andris_Koiv {
    private static int M;                   // Kui palju tikke tohib võtta, globaalne muutuja, et kõik klassid sellele ligi saaks
    private static int N;                   // Tikkude arv laual, globaalne muutuja, et kõik klassid sellele ligi saaks
    public static void main(String[] args) {// Main funktsioon, kus on muutujad ning kust käivitatakse kõik programmi osad
    newGame();


    }
    public static void newGame(){           // Klass newGame. Käivitatakse kohe programmi alguses. Kasutajalt küsitakse sisendeid
        while(true) {                       // While loop, kus kontrollitakse tikkude arvu ja sisendi õigsust
            System.out.println("Palun sisesta laual olevate tikkude arv (miinimum 10): ");
            Scanner tArvN = new Scanner(System.in);  // Sisendi lugemine

            try{                            // Proovime, kas sisend on täisarv
                N = tArvN.nextInt();        // N = täisarv, tArvN ehk Täisarv N
                if (N < 10) {               // Kui N on väiksem kui 10
                    System.out.println("Sisestatud arv ei sobi!");
                } else {                    // Kui N >= 10, mine While loopist välja
                    break;
                }
            } catch(InputMismatchException e) { // Kui sisend pole täisarv, siis palu sisestada täisarv, mine try{} algusesse.
                System.out.println("Sisestatud väärtus pole täisarv! Palun proovi uuesti!");
            }
        }
        while(true){                            // While loop, palju tikke tohib võtta. Kui tingimused okei, siis loopist välja
            System.out.println("Palun sisesta, kui palju tikke tohib korraga võtta: ");
            Scanner tArvM = new Scanner(System.in); // Võtame sisendi Täisarv M
            try {
                M = tArvM.nextInt();            // Täisarv M peab olema täisarv
                if (M > N / 2) {                // Kui M on suurem kui N/2, ehk võetavate tikkude arv peab olema vähemalt poole väiksem kui laual olevate tikkude arv
                    System.out.println("Kuna laual olevate tikkude arv on: " + N + " siis ei saa võetavate tikkude arv olla suurem kui: " + N / 2);
                } else if (M <= 1) {            // Kui M on 1 või 1st väiksem
                    System.out.println("Võetavate tikkude arv peab olema suurem kui 1!");
                } else {
                    break;                      // Kui tingimused on õiged, "lõhu" ennast loopist välja
                }
            } catch(InputMismatchException e){  // "Püüa kinni", kui sisestatakse midagi muud, kui täisarv
                System.out.println("Sisestatud väärtus pole täisarv! Palun proovi uuesti!");
            }

        }
        makeHumanMove();
        System.out.println("Tikke laual: " + N + "\nTikke saab võtta: " + M);   // Lihtsalt katsetamiseks, kas newgame(); funktsioonid töötavad
    }
    public static void makeComputerMove(){
        if(N == 0){                         // Kui laual pole rohkem tikke siis küsi, kas soovid edasi mängida
            System.out.println("Oled mängu võitnud! Kas soovid uuesti mängida? Jah/Ei");    // Mängija on võitnud kuna kui tuli arvuti kord, ei olnud ühtegi tikku alles
            while(true) {
                Scanner alusta = new Scanner(System.in);    // Loetakse sisendit
                String jh = alusta.nextLine().toLowerCase();// Sisend tehakse väikesteks tähtedeks ja salvestatakse sõnesse "jh"
                if (jh.equals("jah")) {                     // Kui sõne jh on Jah
                    newGame();                              // Käivita mäng uuesti
                } else if (jh.equals("ei")) {               // Kui sõne jh on Ei
                    System.exit(0);                  // Välju programmist koodiga 0
                } else {                                    // Kõigil muudel juhtudel pole vastus õige
                    System.out.println("Sisestatud vastus ei ole korrektne!");
                }
            }
        }
        if(N <= M){                                         // Kui tikke on laual sama palju või vähem kui võtta võib
            int voiduKaik = N;                              // Võitmiseks tuleb võtta sama palju tikke kui on laual
            N = N - voiduKaik;                              // Tikkude arv laual on tikkude arv laual - tikkude arv laual, seega 0
            System.out.println("AI: Võtsin laualt "+ voiduKaik + " tikku.\nLauale jäi "+ N + " tikku.");    // Prindi välja seis (0 tikku)
        }else {                                             // Kui võidukäiku ei saa teha
            Random suvaline = new Random();                 // Genereeri suvaline number
            int suvalineInt = suvaline.nextInt(M);          // Suvaline number peab olema vahemikus 0 ja nii palju, kui laualt võtta tohib
            if (suvalineInt == 0) {                         // Kui suvaline number on 0
                suvalineInt = suvalineInt + 1;              // Tee tehe 0 + 1
            }
            N = N - suvalineInt;                            // Laua seisu saamine. Tikkude arv laual = tikkude arv laual - võetud tikud
            System.out.println("AI: Võtsin laualt " + suvalineInt + " tikku.\nLauale jäi " + N + " tikku.");    // Väljastab mängulaua seisu
        }
        makeHumanMove();                                    // Mine järgmisesse klassi, nüüd on mängija kord
    }
    public static void makeHumanMove(){                     // Mängija klass
        int humanMoveM;                                     // Teen muutuja humanMoveM
        if(N <= 0){                                         // Kui arvuti on oma käigu käinud ning laual on alles 0 tikku
            while(true) {
                System.out.println("Oled mängu kaotanud! Kas soovid uuesti mängida? Jah/Ei");   // Järelikult on mängija mängu kaotanud
                Scanner alusta = new Scanner(System.in);                                        // Ootan mängija sisendit
                String jh = alusta.nextLine().toLowerCase();                                    // Sisend salvestatakse sõnesse jh ning tehakse väikesteks tähtedeks
                if (jh.equals("jah")) {                                                         // Kui sisend on võrdne Jah
                    newGame();                                                                  // Algab uus mäng
                } else if(jh.equals("ei")) {                                                    // Kui sisend on Ei
                    System.exit(0);                                                      // Programm väljub koodiga 0
                }
                else{
                    System.out.println("Sisestatud vastus ei ole korrektne!");                  // Muudel juhtudel pole sisend korrektne
                }
            }
        }
        while(true){
            System.out.println("Palun sisesta, mitu tikku soovid võtta: ");
            Scanner kaik = new Scanner(System.in);                                              // Skännime kasutaja sisendi
            try{                                                                                // Try catch, proovime, kas sisend on õige
                humanMoveM = kaik.nextInt();                                                    // muutuja humanMoveM on täisarv
                if(humanMoveM > M){                                                             // Kui humanMoveM on suurem kui "laualt tohib võtta" tikkude arv
                    System.out.println("Sa ei saa võtta rohkem tikke kui " + M);
                }
                else if(humanMoveM <= 0){                                                       // Kui mängija sisestab 0-i või väiksema arvu
                    System.out.println("Pead võtma vähemalt ühe tiku!");
                }
                else{
                    break;                                                                      // Järelikult sobib, välju loopist
                }
            }catch(InputMismatchException e){                                                   // Viga, ehk sisend ei ole täisarv
                System.out.println("Sisestatud väärtus pole täisarv! Palun proovi uuesti!");
            }
        }
        N = N - humanMoveM;                                                                     // Arvutatakse välja palju lauale tikke jääb. Laual olevad tikud = laual olevad tikud - mängija võetud tikud
        System.out.println("Võtsid laualt "+ humanMoveM + " tikku.\nLaual on alles "+ N + " tikku.");
        makeComputerMove();                                                                     // Mine makeComputerMove() klassi, on arvuti kord
    }
}