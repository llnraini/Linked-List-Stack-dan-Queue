package SistemKasirToko;

class NodePelanggan {
    String kode, nama;
    double total;
    NodePelanggan next;
    
    // konstruktor untuk menginisialisasi data pelanggan 
    NodePelanggan(String kode, String nama, double total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null; // menunjuk ke node berikutnya
    }
}
