import java.util.Scanner;

public class RekapLaundry17 {

    static String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
    static int[] harga = {6000, 8000, 5000, 12000};
    static String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    static void inputData(int[][] data, Scanner sc) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("Berat cucian " + layanan[i] + " hari " + hari[j] + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilData(int[][] data) {
        System.out.println("\n=== REKAP BERAT CUCIAN (kg) ===");
        System.out.printf("%-14s%-10s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%-8s", h);
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-14sRp%-8d", layanan[i], harga[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-8d", data[i][j]);
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

    static void tampilLayananTertinggi(int[][] data) {
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

    static void tampilPendapatan(int[][] data) {
        System.out.println("\n=== PENDAPATAN ===");
        long totalPendapatan = 0;
        for (int i = 0; i < data.length; i++) {
            long pendapatan = (long) totalPerLayanan(data, i) * harga[i];
            totalPendapatan += pendapatan;
            System.out.printf("%-14s: Rp%,d%n", layanan[i], pendapatan);
        }
        System.out.printf("Total pendapatan selama %d hari: Rp%,d%n", data[0].length, totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] data = new int[layanan.length][hari.length];

        inputData(data, sc);
        tampilData(data);

        System.out.println("\n=== TOTAL PER LAYANAN ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println(layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        tampilLayananTertinggi(data);

        int idxHari = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + hari[idxHari]);

        tampilPendapatan(data);
        sc.close();
    }
}