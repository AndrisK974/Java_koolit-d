package piimatooted;

public class Piimatoode {
    protected String nimi;
    protected double hind;

    public Piimatoode(String nimi, double hind) {
        this.nimi = nimi;
        this.hind = hind;
    }

    public double getHind() {
        return hind;
    }

    public String getNimi() {
        return nimi;
    }

    public double getPrice(int kogus) {
        return hind * kogus;
    }
}

class Juust extends Piimatoode {
    public Juust(String nimi, double hind) {
        super(nimi, hind);
    }

    @Override
    public double getPrice(int kogus) {
        if (kogus >= 3)
            return super.getPrice(kogus) * 0.9;
        else
            return super.getPrice(kogus);
    }
}

class Piim extends Piimatoode {
    public Piim(String nimi, double hind) {
        super(nimi, hind);
    }

    @Override
    public double getPrice(int kogus) {
        if (kogus >= 5)
            return super.getPrice(kogus) * 0.9;
        else
            return super.getPrice(kogus);
    }
}

class Kohupiim extends Piimatoode {
    public Kohupiim(String nimi, double hind) {
        super(nimi, hind);
    }

    @Override
    public double getPrice(int kogus) {
        if (kogus >= 2)
            return super.getPrice(kogus) * 0.9;
        else
            return super.getPrice(kogus);
    }
}
