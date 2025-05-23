
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        MahasiswaManager mahasiswaManager = new MahasiswaManager();
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        String fileName = "DataMahasiswa.txt";

        mahasiswaManager.bacaDariFile(fileName);

        do {
            System.out.println("\n=== Menu Program Data Mahasiswa ===");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Semua Data");
            System.out.println("3. Ubah Data Mahasiswa");
            System.out.println("4. Hapus Data Mahasiswa");
            System.out.println("5. Simpan Data Mahasiswa");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();

                    System.out.print("Masukkan NIM Mahasiswa: ");
                    String nim = scanner.nextLine();

                    System.out.print("Masukkan Jurusan Mahasiswa: ");
                    String jurusan = scanner.nextLine();

                    System.out.print("Masukkan IPK Mahasiswa: ");
                    double ipk = scanner.nextDouble();

                    mahasiswaManager.tambahMahasiswa(new Mahasiswa(nama, nim, jurusan, ipk));
                    System.out.println("Data berhasil ditambahkan.");
                }

                case 2 ->
                    mahasiswaManager.tampilkanSemua();

                case 3 -> {
                    System.out.print("Masukkan NIM Mahasiswa yang ingin diubah: ");
                    String nimUbah = scanner.nextLine();

                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();

                    System.out.print("Masukkan Jurusan Mahasiswa: ");
                    String jurusan = scanner.nextLine();

                    System.out.print("Masukkan IPK Mahasiswa: ");
                    double ipk = scanner.nextDouble();

                    mahasiswaManager.ubahMahasiswa(nama, nimUbah, jurusan, ipk);
                }

                case 4 -> {
                    System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                    String nimHapus = scanner.nextLine();

                    boolean sukses = mahasiswaManager.hapusMahasiswa(nimHapus);
                    if (sukses) {
                        System.out.println("Mahasiswa berhasil dihapus.");
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                }

                case 5 -> {
                    mahasiswaManager.simpanKeFile("DataMahasiswa.txt");

                    System.out.println("Data berhasil disimpan ke file.");
                    System.out.println();

                    mahasiswaManager.bacaDariFile(fileName);
                }
                case 6 ->
                    System.out.println("Terima kasih telah menggunakan program.");

                default ->
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-3.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
