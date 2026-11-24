import java.util.Scanner;
public class Kafe17 {

    public static int jumlahMenu() {
        return 6;
    }

    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }


    public static int hitungTotalHarga17(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int persen = 0;

        if (kodePromo.equals("DISKON50")) {
            persen = 50;
        } else if (kodePromo.equals("DISKON30")) {
            persen = 30;
        } else if (!kodePromo.isEmpty()) {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            persen += 10;
        }

        return total * persen / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama pelanggan: ");
        String namaPelanggan = sc.nextLine();
        System.out.print("Member? (y/n): ");
        boolean isMember = sc.nextLine().trim().equalsIgnoreCase("y");
        System.out.print("Jam kunjung (0-23): ");
        int jamKunjung = sc.nextInt();

        System.out.println();
        Menu(namaPelanggan, isMember, jamKunjung);

        System.out.print("\nBerapa jenis menu yang ingin dipesan? ");
        int jenisMenu = sc.nextInt();

        int totalHarga = 0;
        for (int i = 1; i <= jenisMenu; i++) {
            int pilihanMenu;
            while (true) {
                System.out.print("Masukkan nomor menu ke-" + i + " (1-" + jumlahMenu() + "): ");
                pilihanMenu = sc.nextInt();
                if (pilihanMenu >= 1 && pilihanMenu <= jumlahMenu()) {
                    break;
                }
                System.out.println("Menu tidak tersedia");
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            int totalBayar = hitungTotalHarga17(pilihanMenu, banyakItem);
            System.out.println("Subtotal menu " + pilihanMenu + ": Rp" + totalBayar);
            totalHarga += totalBayar;
        }

        sc.nextLine(); // buang sisa newline
        System.out.print("\nKode promo (kosongkan jika tidak ada): ");
        String kodePromo = sc.nextLine().trim();

        int diskon = hitungDiskon(totalHarga, kodePromo, isMember);

        System.out.println("\n===== RINCIAN PEMBAYARAN =====");
        System.out.println("Total harga       : Rp" + totalHarga);
        System.out.println("Besar diskon      : Rp" + diskon);
        System.out.println("Total yang dibayar: Rp" + (totalHarga - diskon));

        sc.close();
    }
}