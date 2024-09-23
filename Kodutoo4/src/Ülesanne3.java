import java.util.*;
public class Ülesanne3 {
    public static void main(String[] args) {
        String tekst = "Luua list, mis koosneb kõigist tähega r ja tähega s algavatest sõnadest\n" +
                "tekstis. Tulemuslistis on sõnad ilma kordusteta ja sorteeritud tähestikulises\n" +
                "järjekorras. Väljastada list konsoolile. Raha, ragiseb, raginal riskides rosinatega \n";
        List<String> rsList = new ArrayList<>(); // Loome listi tulemusi hoidmiseks
        tekst = tekst.toLowerCase(); // Teeme väiketähtedeks
        String[] sõnad = tekst.split("\\s+"); // Võtame teksti sõnadeks

        for (String sõna : sõnad) { // For tsükkel. Võtame ühe sõna kaupa
            char algusTäht = sõna.charAt(0);    // Esimene täht (ehk täht indeksil 0)
            sõna = sõna.replaceAll("[.,!?()]", "");
            if ((algusTäht == 'r' || algusTäht == 's') && !rsList.contains(sõna)) {
                rsList.add(sõna); // Kui esimene täht on r või s ja seda sõna ei ole juba loendis, lisame selle loendisse
            }
        }
        Collections.sort(rsList); // Sordime tähestikujärjekorras

        System.out.println("Kõik sõnad mis algavad 'r' ja 's' tähega tähestiku järjekorras: ");
        for (String word : rsList) {
            System.out.println(word); // Prindi sõnu seni kuni neid on
        }
    }
}



