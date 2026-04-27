package SistemKasirToko;

class StackTransaksi {
    NodePelanggan top;
    
    // menambahkan data transaksi ke stack (push)
    void push(NodePelanggan data) {
        data.next = top;	// node baru menunjuk ke data sebelumnya
        top = data;	// top berpindah ke node baru
    }
    
    // menampikan seluruh riwayat transaksi dari baru ke lama
    void tampilkan() {
        NodePelanggan current = top;

        if (current == null) {
            System.out.println("Riwayat kosong.");
            return;
        }

        System.out.println("Riwayat Transaksi:");
        while (current != null) { // menelusuri dari top ke bawah (LIFO)
            System.out.println(current.kode + " | " + current.nama + " | " + current.total);
            current = current.next;
        }
    }
}