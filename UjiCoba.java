// Fungsi Tanpa NilaiKembalian
public class UjiCoba {
    // Fungsi Tanpa parameter
    public static void menu() {
        System.out.println("==== Menu JTI Lantai 7=====");
        System.out.println("1.Harga Kopi : 15.000");
        System.out.println("2.Harga Teh : 10.000");
    }
    // Fungsi Dengan Parameter
    public static void sapaPelanggan(String nama) {
        System.out.println("Selamat datang di kantin JTI lantai 7, " + nama + "!");
    }
    //Fungsi dengan nilai kembalian
    public static int hitungHarga(int harga, int jumlah) {
        int hitungHarga = harga * jumlah;
        return hitungHarga;
    }
    //Fungsi yang memanggil fungsi lain
    public static int hitungDiskon(int harga, int jumlah) {
        int totalDiskon = hitungHarga(harga,jumlah) * 10/100;
        return totalDiskon;
    }
    // Fungsi Varargs
    public static int totalBayar(int... harga) {
        int total = 0;
        for (int h : harga ) {
            total += h;
        }
        return total;
    }
    public static void main(String[] args) {
        sapaPelanggan("Cak danis");
        menu();
        int kopi = hitungHarga(15000, 3);
        int teh = hitungHarga(10000, 2);
        int total = totalBayar(kopi, teh);
        int diskon = hitungDiskon(15000, 3);

        int totalBayar = total - diskon;
        
        System.out.println("total sebelum diskon: " + total);
        System.out.println("Diskon yang di dapat: " + diskon);
        System.out.println("Total yang harus di bayar: " + totalBayar);
    }
}
    