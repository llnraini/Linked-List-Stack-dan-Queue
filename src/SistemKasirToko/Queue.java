package SistemKasirToko;

class QueuePelanggan {
    NodePelanggan front, rear;
    int count = 0;
    
    // menambah pelanggan ke antrian (enqueue)
    void enqueue(String kode, String nama, double total) {
        NodePelanggan newNode = new NodePelanggan(kode, nama, total);

        if (rear == null) {
            front = rear = newNode;	// jika antrian kosong, front dan rear menunjuk ke node baru
            
        } else {
            rear.next = newNode;	//	 node terakhir menunjuk ke node baru
            rear = newNode;	// update rear ke node baru
        }
        count++;
        System.out.println("Data pelanggan ditambahkan ke antrian");
    }
    
    // menghapus pelanggan dari antrian depan (dequeue)
    NodePelanggan dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong");
            return null;
        }

        NodePelanggan temp = front;	// 	menyimpan data yang akan di hapus
        front = front.next;	// memindahkan front ke node selantunya

        if (front == null) {
        	rear = null;	// rear di null kan jika setelah dihapus antrian kosong
        }
        count--;
        return temp;
    }
    
    // untuk menampilkan seluruh data antrian
    void tampilkan() {
        NodePelanggan current = front;

        if (current == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Antrian:");
        while (current != null) {	// menelusuri dari front sampai akhir
            System.out.println(current.kode + " | " + current.nama + " | " + current.total);
            current = current.next;
        }
    }
}