package piimatooted;

public class Põhiprogramm {
    public static void main(String[] args) {
        // Loome tooted
        Piimatoode eestiJuust = new Juust("Eesti juust", 6.5);
        Piimatoode hollandiJuust = new Juust("Hollandi juust", 8.0);
        Piimatoode piim1 = new Piim("Täispiim", 1.0);
        Piimatoode piim2 = new Piim("Kodune piim", 1.2);
        Piimatoode kohupiim1 = new Kohupiim("Tavaline kohupiim", 2.0);
        Piimatoode kohupiim2 = new Kohupiim("Mahe kohupiim", 2.5);

        // Moodustame arved
        Arve arve1 = new Arve("Peep Pudel");
        arve1.lisa(eestiJuust, 3);
        arve1.lisa(piim1, 2);
        arve1.lisa(kohupiim1, 2);

        Arve arve2 = new Arve("Tiit Tihane");
        arve2.lisa(hollandiJuust, 2);
        arve2.lisa(piim2, 5);
        arve2.lisa(kohupiim2, 1);

        Arve arve3 = new Arve("Marju Meemäe");
        arve3.lisa(eestiJuust, 1);
        arve3.lisa(hollandiJuust, 1);
        arve3.lisa(piim1, 3);
        arve3.lisa(piim2, 2);
        arve3.lisa(kohupiim1, 1);
        arve3.lisa(kohupiim2, 1);

        // Trükime arved
        arve1.maksa();
        System.out.println();
        arve2.maksa();
        System.out.println();
        arve3.maksa();
    }
}
