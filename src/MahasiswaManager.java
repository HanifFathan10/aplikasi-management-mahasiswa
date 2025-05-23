
import java.io.*;
import java.util.ArrayList;

public class MahasiswaManager extends Mahasiswa {

    private final ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public Mahasiswa cariMahasiswa(String nim) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equals(nim)) {
                return mhs;
            }
        }
        return null;
    }

    // CRUD Data Mahasiswa
    public void tambahMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.add(mhs);
    }

    public boolean ubahMahasiswa(String nama, String nim, String jurusan, double ipk) {
        Mahasiswa mhs = cariMahasiswa(nim);

        if (mhs != null) {
            mhs.setNama(nama);
            mhs.setJurusan(jurusan);
            mhs.setIPK(ipk);
            return true;
        }
        return false;
    }

    public boolean hapusMahasiswa(String nim) {
        Mahasiswa mhs = cariMahasiswa(nim);
        if (mhs != null) {
            daftarMahasiswa.remove(mhs);
            return true;
        }
        return false;
    }

    public void tampilkanSemua() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            System.out.println("================ Data Mahasiswa ================");
            for (Mahasiswa mhs : daftarMahasiswa) {
                System.out.println("Nama: " + mhs.getNama());
                System.out.println("NIM: " + mhs.getNim());
                System.out.println("Jurusan: " + mhs.getJurusan());
                System.out.println("IPK: " + mhs.getIPK());
                System.out.println("------------------------------");
            }
        }
    }

    // Simpan dan Baca Data dari File
    public void simpanKeFile(String namaFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile, true))) {
            for (Mahasiswa mhs : daftarMahasiswa) {
                bw.write("Nama: " + mhs.getNama() + " | NIM: " + mhs.getNim() + " | Jurusan: " + mhs.getJurusan() + " | IPK: " + mhs.getIPK());
                bw.newLine();
            }
            System.out.println("Data berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    public void bacaDariFile(String namaFile) {
        try (FileReader fr = new FileReader(namaFile)) {
            int karakter;
            while ((karakter = fr.read()) != -1) {
                System.out.print((char) karakter);
            }

            System.out.println("Data berhasil dibaca dari file.");
        } catch (IOException e) {
            System.out.println("Gagal membaca data: " + e.getMessage());
        }
    }
}
