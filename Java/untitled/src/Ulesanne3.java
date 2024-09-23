public class Ulesanne3 {
    public static void main(String[] args) {
        int x = 100;
        int y = 1500;
        int z = 20;
        int i = 0;
        while (i < 5 && y <= 50000) {
            if (y <= 50000) {
                y = x + y + z;
                x = x * 2 + y;
            }
            System.out.println(y);
            i++;


        }
        if (i == 5) {
            System.out.println("\nArvutamine lõpetati viienda korra peal, väärtusteks saadi:"+"\nX:" + x + "\nY:" + y);
        }
        else{

            System.out.println("\nArvutamine lõpetati, kuna jõuti arvuni, kus Y on suurem kui 50000: " + "\nX:" +x+ "\nY:" +y);
            }
        }
    }

