package piimatooted;


import java.text.DecimalFormat;

public class Arve {
    private static int counter = 1;
    private int arveNr;
    private String klient;
    private double summa;
    private StringBuilder ostud = new StringBuilder();

    public Arve(String klient) {
        this.arveNr = leiaJargmine();
        this.klient = klient;
    }

    public void lisa(Piimatoode toode, int kogus) {
        double hind = toode.getPrice(kogus);
        summa += hind;
        ostud.append(toode.getNimi()).append(": ").append(kogus).append("tk, Hind: ").append(hind).append("€\n");
    }

    public String klient() {
        return klient;
    }

    public double leiaKoguSumma() {
        return summa;
    }

    public int leiaArveNr() {
        return arveNr;
    }

    private static int leiaJargmine() {
        return counter++;
    }

    public void maksa() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Arve number: " + arveNr);
        System.out.println("Klient: " + klient);
        System.out.println("Tellitud kaubad:\n" + ostud);
        System.out.println("Kogusumma: " + df.format(summa) + "€");
    }
}
