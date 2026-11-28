import java.util.Scanner;

public class TabungKerucut17 {
    // Fungsi untuk menghitung luas lingkaran
    public static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    // Fungsi untuk menghitung volume tabung
    public static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    // Fungsi untuk menghitung luas permukaan tabung
    public static double luasPermukaanTabung(double r, double t) {
        double diameter = 2 * r;
        return 2 * Math.PI * r * t + diameter * luasLingkaran(r);
    }

    // Fungsi untuk menghitung volume kerucut
    public static double volumeKerucut(double r, double t) {
        double volumeTabung = volumeTabung(r, t);
        return volumeTabung / 3;
    }

    // Fungsi main untuk menguji fungsi-fungsi
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu Pilihan Perhitungan:");
            System.out.println("1. Luas Lingkaran");
            System.out.println("2. Volume Tabung");
            System.out.println("3. Luas Permukaan Tabung");
            System.out.println("4. Volume Kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-4): ");
            pilihan = scanner.nextInt();

            if (pilihan == 0) {
                System.out.println("Terima kasih!.");
                break;
            }

            System.out.print("Masukkan jari-jari (r): ");
            double r = scanner.nextDouble();
            System.out.print("Masukkan tinggi (t): ");
            double t = scanner.nextDouble();

            switch (pilihan) {
                case 1:
                    double luasLingkaran = luasLingkaran(r);
                    System.out.println("Luas Lingkaran: " + luasLingkaran);
                    break;
                case 2:
                    double volumeTabung = volumeTabung(r, t);
                    System.out.println("Volume Tabung: " + volumeTabung);
                    break;
                case 3:
                    double luasPermukaanTabung = luasPermukaanTabung(r, t);
                    System.out.println("Luas Permukaan Tabung: " + luasPermukaanTabung);
                    break;
                case 4:
                    double volumeKerucut = volumeKerucut(r, t);
                    System.out.println("Volume Kerucut: " + volumeKerucut);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                    break;
            }

            System.out.println();
        } while (true);

        scanner.close();
    }
}