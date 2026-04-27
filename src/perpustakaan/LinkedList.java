package perpustakaan;

class LinkedListBuku {
    Node head;
    int jumlah = 0;

    // tambah buku di akhir linked list (push)
    void insertBuku(String kode, String judul, String penulis) {
        Node newNode = new Node(kode, judul, penulis);

        if (head == null) {
            head = newNode;	// jika linked list kosong, node baru menjadi head
        } else {
            Node current = head;
            while (current.next != null) {	// menelusuri hingga node terakhir
                current = current.next;
            }
            current.next = newNode;	// node terakhir menunjuk ke node baru
        }
        
        jumlah++;
        System.out.println("Data berhasil ditambahkan");
    }

    // hapus buku terakhir (pop)
    void deleteBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            head = null; // jika cuma 1 data, langsung kosongkan 
        } else {
            Node current = head;
            while (current.next.next != null) { // berhenti ke node sebelum terakhir
                current = current.next;
            }
            current.next = null; // hapus node terakhir
        }
        
        jumlah--;
        System.out.println("Data terakhir berhasil dihapus");
    }

    // cari buku berdasarkan node
    void searchBuku(String kode) {
        Node current = head;

        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kode)) {
                System.out.println("Buku ditemukan:");
                System.out.println("Kode: " + current.kodeBuku +
                        " | Judul: " + current.judul +
                        " | Penulis: " + current.penulis);
                return;
            }
            current = current.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    // menampilkan semua buku
    void display() {
        if (head == null) {
            System.out.println("Data kosong.");
            return;
        }

        Node current = head;
        int count = 0;

        System.out.println("Daftar Buku:");
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku +
                    " | Judul: " + current.judul +
                    " | Penulis: " + current.penulis);
            current = current.next;
            count++;
        }

        System.out.println("Total Buku: " + count);
        
        // validasi minimal 5 data buku
        if (count < 5) {
            System.out.println("Jumlah buku belum mencapai batas minimal 5 buku.");
        }
    }
}
