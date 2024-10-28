import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas Layanan menyimpan informasi tentang jenis layanan yang tersedia.
 */
class Layanan {
    private String nama;
    private int harga;

    /**
     * Konstruktor untuk membuat objek Layanan.
     *
     * @param nama  Nama layanan
     * @param harga Harga layanan
     */
    public Layanan(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    /**
     * Mendapatkan nama layanan.
     *
     * @return Nama layanan
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mendapatkan harga layanan.
     *
     * @return Harga layanan
     */
    public int getHarga() {
        return harga;
    }
}

/**
 * Kelas Pesanan mengelola detail pemesanan yang dibuat oleh pengguna.
 */
class Pesanan {
    private Layanan layanan;
    private String lokasiAwal;
    private String lokasiTujuan;

    /**
     * Konstruktor untuk membuat objek Pesanan.
     *
     * @param layanan     Jenis layanan yang dipilih
     * @param lokasiAwal  Lokasi awal pemesanan
     * @param lokasiTujuan Lokasi tujuan pemesanan
     */
    public Pesanan(Layanan layanan, String lokasiAwal, String lokasiTujuan) {
        this.layanan = layanan;
        this.lokasiAwal = lokasiAwal;
        this.lokasiTujuan = lokasiTujuan;
    }

    /**
     * Menampilkan detail dari pesanan.
     */
    public void tampilkanDetail() {
        System.out.printf("Layanan: %s%n", layanan.getNama());
        System.out.printf("Harga: %d%n", layanan.getHarga());
        System.out.printf("Dari: %s%n", lokasiAwal);
        System.out.printf("Ke: %s%n", lokasiTujuan);
    }

    /**
     * Mendapatkan total harga dari pesanan.
     *
     * @return Total harga pemesanan
     */
    public int getHargaTotal() {
        return layanan.getHarga();
    }
}

/**
 * Kelas GrabApp merupakan kelas utama untuk menjalankan aplikasi pemesanan Grab online.
 */
public class GrabApp {
    /**
     * Metode utama untuk menjalankan aplikasi.
     *
     * @param args Argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        List<Layanan> daftarLayanan = new ArrayList<>();
        daftarLayanan.add(new Layanan("GrabCar", 50000));
        daftarLayanan.add(new Layanan("GrabBike", 20000));
        daftarLayanan.add(new Layanan("GrabFood", 30000));

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Aplikasi Grab Online ===");
        System.out.println("Pilih layanan:");
        for (int i = 0; i < daftarLayanan.size(); i++) {
            System.out.printf("%d. %s - %d%n", i + 1, daftarLayanan.get(i).getNama(), daftarLayanan.get(i).getHarga());
        }

        System.out.print("Masukkan nomor layanan yang dipilih: ");
        int pilihan = scanner.nextInt() - 1;

        scanner.nextLine(); // Clear the buffer

        System.out.print("Masukkan lokasi awal: ");
        String lokasiAwal = scanner.nextLine();

        System.out.print("Masukkan lokasi tujuan: ");
        String lokasiTujuan = scanner.nextLine();

        Pesanan pesanan = new Pesanan(daftarLayanan.get(pilihan), lokasiAwal, lokasiTujuan);

        System.out.println("\n=== Detail Pesanan ===");
        pesanan.tampilkanDetail();
        System.out.printf("Total Biaya: %d%n", pesanan.getHargaTotal());

        scanner.close();
    }
}
