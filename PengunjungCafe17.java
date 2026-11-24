public class PengunjungCafe17 {

    static void daftarPengunjung(String... namaPengunjung) {
        System.out.println("Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja nomor " + nomorMeja + " - Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        // Langkah 3 - 6
        daftarPengunjung("Ali", "Budi", "Citra");
        daftarPengunjung("Andi");
        daftarPengunjung("Doni", "Eti", "Fahmi", "Galih");

        // Pertanyaan 1: tanpa argumen
        System.out.println("\n--- Tanpa argumen ---");
        daftarPengunjung();

        // Pertanyaan 2b: dikirim sebagai array
        System.out.println("\n--- Dikirim sebagai array ---");
        String[] tamu = {"Ali", "Budi", "Citra"};
        daftarPengunjung(tamu);

        // Pertanyaan 3
        System.out.println("\n--- Dengan nomor meja ---");
        daftarPengunjung(5, "Ali", "Budi", "Citra");

        // Pertanyaan 4
        System.out.println("\n--- hitungTotalBelanja ---");
        System.out.println("1 argumen : " + hitungTotalBelanja(15000));
        System.out.println("3 argumen : " + hitungTotalBelanja(15000, 20000, 22000));
        System.out.println("5 argumen : " + hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));
    }
}