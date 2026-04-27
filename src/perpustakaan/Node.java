package perpustakaan;

public class Node {
    String kodeBuku, judul, penulis;	// menyimpan data
    Node next;	// menunjuk ke node berikutnya

    // konstruktor untuk membuat node baru
    Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}