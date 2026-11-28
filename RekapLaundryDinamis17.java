import java.util.Scanner;

public class RekapLaundryDinamis17 {

    static void inputLayanan(String[] layanan, int[] harga, Scanner sc) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga per kg " + layanan[i] + ": ");
            harga[i] = Integer.parseInt(sc.nextLine().trim());
        }
    }

    static void inputData(int[][] data, String[] layanan, Scanner sc) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Berat cucian " + layanan[i] + " Hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = Integer.parseInt(sc.nextLine().trim());
            }
        }
    }

    static void tampilData(int[][] data, String[] layanan, int[] harga) {
        System.out.println("\n=== REKAP BERAT CUCIAN (kg) ===");
        System.out.printf("%-16s%-10s", "Layanan", "Harga/kg");
        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%-10s", "Hari ke-" + (j + 1));
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-16sRp%-8d", layanan[i], harga[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-10d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("\nLayanan dengan total cucian tertinggi: " + layanan[idxMax]
                + " (" + totalPerLayanan(data, idxMax) + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        int totalMax = -1;
        for (int j = 0; j < data[0].length; j++) {
            int total = 0;
            for (int i = 0; i < data.length; i++) {
                total += data[i][j];
            }
            if (total > totalMax) {
                totalMax = total;
                idxMax = j;
            }
        }
        return idxMax;
    }

    static void tampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        System.out.println("\n=== PENDAPATAN ===");
        long totalPendapatan = 0;
        for (int i = 0; i < data.length; i++) {
            long pendapatan = (long) totalPerLayanan(data, i) * harga[i];
            totalPendapatan += pendapatan;
            System.out.printf("%-16s: Rp%,d%n", layanan[i], pendapatan);
        }
        System.out.printf("Total pendapatan selama %d hari: Rp%,d%n", data[0].length, totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Jumlah layanan: ");
        int jumlahLayanan = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Jumlah hari: ");
        int jumlahHari = Integer.parseInt(sc.nextLine().trim());

        String[] layanan = new String[jumlahLayanan];
        int[] harga = new int[jumlahLayanan];
        int[][] data = new int[jumlahLayanan][jumlahHari];

        inputLayanan(layanan, harga, sc);
        inputData(data, layanan, sc);
        tampilData(data, layanan, harga);

        System.out.println("\n=== TOTAL PER LAYANAN ===");
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        tampilLayananTertinggi(data, layanan);
        System.out.println("Hari tersibuk: Hari ke-" + (hariTersibuk(data) + 1));

        tampilPendapatan(data, layanan, harga);
        sc.close();
    }
}