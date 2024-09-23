import java.util.*;
import java.util.stream.Collectors;

public class Ülesanne4 {
    public static void main(String[] args){
        String tekst = "Siin on kordused siin siin siin raks ja raks ja väljastab seda seda selle rootor rootor rootor top 5";
        List<String> rVõis = new ArrayList<>(Arrays.asList(tekst.split("\\s+"))); // Loome uue muudetava listi
        rVõis.removeIf(word -> !(word.startsWith("r") || word.startsWith("s"))); // Filtrime sõnad, mis ei alga "r" või "s" tähega
        Map<String, Long> wordFrequency = rVõis.stream() // Loome sõnade voolu
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting())); // Gruppeerime ja loendame sõnade sagedused

        wordFrequency.entrySet().stream() // Voolame sagedused
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // Sorteerime sageduse järgi kahanevalt
                .limit(5) // Piirame voolu viiega
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " korda")); // Väljastame viis kõige sagedamini esinevat sõna
    }
}
