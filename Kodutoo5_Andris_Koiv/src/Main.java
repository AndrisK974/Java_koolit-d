import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }
}

public class Main {
    public static void main(String[] args) {
        // Loome inimeste konteineri ja lisame sinna vähemalt 8 objekti
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Teet", "Margna", 1985));
        people.add(new Person("Kristjan", "Jõekalda", 1990));
        people.add(new Person("Robert", "Rool", 1978));
        people.add(new Person("Andris", "Kõiv", 1999));
        people.add(new Person("Tiina", "Rool", 1995));
        people.add(new Person("Mait", "Margna", 1989));
        people.add(new Person("Peeter", "Daniels", 1980));
        people.add(new Person("Jack", "Daniels", 1975));

        // Küsime kasutajalt perekonnanime
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sisesta perekonnanimi: ");
        String lastName = scanner.nextLine();

        // Kontrollime sisendit, kas see sisaldab ainult tähti
        if (!lastName.matches("[a-zA-ZõäöüÕÄÖÜ]+")) {
            System.out.println("Vigane sisend! Perekonnanimi võib sisaldada ainult tähti.");
            return;
        }

        // Otsime inimesi vastavalt sisestatud perekonnanimele
        boolean found = false;
        for (Person person : people) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Isik: " + person.getFirstName() + ", Sünniaasta: " + person.getBirthYear());
                found = true;
            }
        }

        // Kui vastava perekonnanimega isikut ei leitud, väljastame vastava teate
        if (!found) {
            System.out.println("Sellise perekonnanimega isikut ei leitud.");
        }
    }
}
