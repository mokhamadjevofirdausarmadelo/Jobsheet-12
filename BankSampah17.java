import java.util.Scanner;

public class BankSampah17 {
    public static double[] inputSetoran(int n) {
        Scanner scanner = new Scanner(System.in);
        double[] setoran = new double[n];
        System.out.println("Masukkan berat setoran untuk setiap nasabah:");
        for (int i = 0; i < n; i++) {
            System.out.print("Nasabah ke-" + (i + 1) + ": ");
            setoran[i] = scanner.nextDouble();
        }
        scanner.close();
        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("Berat setoran setiap nasabah:");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double s : setoran) {
            total += s;
        }
        return total;
    }

    public static void hitungSaldo(double[] setoran) {
        double hargaPerKg = 3000;
        System.out.println("Saldo setiap nasabah:");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = setoran[i] * hargaPerKg;
            System.out.println("Nasabah ke-" + (i + 1) + ": " + saldo + " rupiah");
        }
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int maxIndex = 0;
        double maxSetoran = setoran[0];
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > maxSetoran) {
                maxSetoran = setoran[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah nasabah: ");
        int n = scanner.nextInt();
        double[] setoran = inputSetoran(n);
        tampilSetoran(setoran);
        double total = totalSetoran(setoran);
        System.out.println("Total berat setoran seluruh nasabah: " + total + " kg");
        hitungSaldo(setoran);
        int nasabahTerbesarIndex = nasabahTerbanyak(setoran);
        System.out.println("Nasabah dengan setoran terbesar adalah Nasabah ke-" + (nasabahTerbesarIndex + 1));
        scanner.close();
    }
}