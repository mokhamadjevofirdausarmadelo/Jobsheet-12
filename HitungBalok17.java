import java.util.Scanner;

public class HitungBalok17 {

    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    // Pertanyaan 4: memanfaatkan hitungLuas
    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int p, l, t, L, vol;

        System.out.println("Masukkan panjang");
        p = input.nextInt();

        System.out.println("Masukkan lebar");
        l = input.nextInt();

        System.out.println("Masukkan tinggi");
        t = input.nextInt();

        L = hitungLuas(p, l);
        System.out.println("Luas Persegi Panjang adalah " + L);

        vol = hitungVolume(t, p, l);
        System.out.println("Volume Balok adalah " + vol);
        input.close();

        // Pertanyaan 4: luas permukaan dan volume 3 balok dengan ukuran berbeda
        System.out.println("\n--- 3 balok dengan ukuran berbeda ---");
        int[][] balok = {{4, 3, 5}, {6, 2, 7}, {10, 5, 2}};
        for (int i = 0; i < balok.length; i++) {
            int bp = balok[i][0], bl = balok[i][1], bt = balok[i][2];
            System.out.println("Balok " + (i + 1) + " (" + bp + " x " + bl + " x " + bt + ")"
                    + " -> luas permukaan = " + hitungLuasPermukaanBalok(bp, bl, bt)
                    + ", volume = " + hitungVolume(bt, bp, bl));
        }
    }
}