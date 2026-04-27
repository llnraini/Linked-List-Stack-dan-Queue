package perpustakaan;

import java.util.Scanner;

public class MainPerpustakaan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedListBuku list = new LinkedListBuku();

        int pilihan;

        do {
        	// menampilkan menu utama 
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // menghindari bug input

            switch (pilihan) {
                case 1:
                	// input data buku
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = input.nextLine();
                    
                    // validasi panjang kode 
                    if (kode.length() > 5) {
                        System.out.println("Kode maksimal 5 karakter");
                        break;
                    }

                    System.out.print("Masukkan Judul: ");
                    String judul = input.nextLine();

                    System.out.print("Masukkan Penulis: ");
                    String penulis = input.nextLine();
                    
                    // menambahkan linked list
                    list.insertBuku(kode, judul, penulis);
                    
                    if (list.jumlah < 5) {
                        int sisa = 5 - list.jumlah;
                        System.out.println("Catatan: perlu menambahkan " + sisa + " buku lagi.");
                    }
                    
                    break;

                case 2:
                	// menghapus data buku terakhir dari daftar
                    list.deleteBuku();
                    break;

                case 3:
                	// mencari kode buku
                    System.out.print("Masukkan kode buku: ");
                    String cari = input.nextLine();
                    list.searchBuku(cari);
                    break;

                case 4:
                	// menampilkan semua data buku
                    list.display();
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 5);
        
        input.close(); // menutup scanner secara manual
    }
}