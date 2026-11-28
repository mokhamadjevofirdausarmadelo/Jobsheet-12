import java.util.Scanner;

public class KubusLimasNoAbsen {

    static int luasPersegi(int s) {
        return s * s;
    }

    static int volumeKubus(int s) {
        return s * s * s;
    }

    static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    static double volumeLimasPersegi(int s, int t) {
        return luasPersegi(s) * t / 3.0;
    }

    static void tampilMenu() {
        System.out.println("\n===== MENU BANGUN RUANG =====");
        System.out.println("1. Luas Persegi");
        System.out.println("2. Volume Kubus");
        System.out.println("3. Luas Permukaan Kubus");
        System.out.println("4. Volume Limas Persegi");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            tampilMenu();
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1: {
                    System.out.print("Masukkan sisi: ");
                    int s = sc.nextInt();
                    System.out.println("Luas persegi = " + luasPersegi(s));
                    break;
                }
                case 2: {
                    System.out.print("Masukkan sisi: ");
                    int s = sc.nextInt();
                    System.out.println("Volume kubus = " + volumeKubus(s));
                    break;
                }
                case 3: {
                    System.out.print("Masukkan sisi: ");
                    int s = sc.nextInt();
                    System.out.println("Luas permukaan kubus = " + luasPermukaanKubus(s));
                    break;
                }
                case 4: {
                    System.out.print("Masukkan sisi alas: ");
                    int s = sc.nextInt();
                    System.out.print("Masukkan tinggi: ");
                    int t = sc.nextInt();
                    System.out.printf("Volume limas persegi = %.2f%n", volumeLimasPersegi(s, t));
                    break;
                }
                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}