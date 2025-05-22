
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Mahasiswa {

    private String nama;
    private String nim;
    private String jurusan;
    private double IPK;

    public Mahasiswa() {

    }

    public Mahasiswa(String nama, String nim, String jurusan, double IPK) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.IPK = IPK;
    }

    public void displayInfo() {
        System.out.println("Nama: " + this.nama);
        System.out.println("NIM: " + this.nim);
        System.out.println("Jurusan: " + this.jurusan);
        System.out.println("IPK: " + this.IPK);
        System.out.println("-----------------------------");
    }

    public void updateDataMhs(String nama, String nim, String jurusan, double IPK) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.IPK = IPK;
    }

    public void saveToFile(ArrayList<Mahasiswa> daftarMahasiswa) {
        try (FileWriter fw = new FileWriter("DataMahasiswa.txt", true)) {
            for (Mahasiswa mhsSave : daftarMahasiswa) {
                fw.write("Nama: " + mhsSave.getNama() + "," + "NPM: " + mhsSave.getNim() + "," + "Jurusan: " + mhsSave.getJurusan() + "," + "IPK: " + mhsSave.getIPK() + "\n");
            }
            System.out.println("Data berhasil disimpan ke dataMahasiswa.txt.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        }
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String value) {
        this.nama = value;
    }

    public String getNim() {
        return this.nim;
    }

    public void setNim(String value) {
        this.nim = value;
    }

    public String getJurusan() {
        return this.jurusan;
    }

    public void setJurusan(String value) {
        this.jurusan = value;
    }

    public double getIPK() {
        return this.IPK;
    }

    public void setIPK(double value) {
        this.IPK = value;
    }
}
