
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

    @Override
    public String toString() {
        return "Nama: " + this.nama + ", NIM: " + this.nim + ", Jurusan: " + this.jurusan + ", IPK: " + this.IPK;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mahasiswa mahasiswa = (Mahasiswa) obj;
        return Double.compare(mahasiswa.IPK, IPK) == 0 && nama.equals(mahasiswa.nama) && nim.equals(mahasiswa.nim) && jurusan.equals(mahasiswa.jurusan);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nama != null ? nama.hashCode() : 0;
        result = 31 * result + (nim != null ? nim.hashCode() : 0);
        result = 31 * result + (jurusan != null ? jurusan.hashCode() : 0);
        temp = Double.doubleToLongBits(IPK);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
