package SistemKasirToko;

import java.util.Scanner;

public class MainKasir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        QueuePelanggan queue = new QueuePelanggan();
        StackTransaksi stack = new StackTransaksi();

        int pilihan;
        int jumlah = 0; // menghitung jumlah pelanggan
        
        // menampilkan menu utama
        do { 
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // untuk menghindari bug input

            switch (pilihan) {
                case 1:
                	// input data untuk antrian pelanggan 
                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = input.nextLine();

                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan Total Belanja: ");
                    double total = input.nextDouble();
                    input.nextLine();

                    queue.enqueue(kode, nama, total); // tambah ke queue
                    jumlah++;
                    break;
                	

                case 2:
                	// melayani pelanggan (dequeue & push ke stack)
                	if (jumlah < 5) {
                        System.out.println("Antrian minimal 5 pelanggan");
                        break;
                    }
                	
                    NodePelanggan p = queue.dequeue();
                    if (p != null) {
                        System.out.println("Melayani pelanggan: " + p.kode + " (" + p.nama + ")");
                        stack.push(p);
                        jumlah--;
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3:
                	// untuk menampilkan seluruh antrian
                    queue.tampilkan();
                    break;

                case 4:
                	// untuk melihat riwayat transaksi (stack)
                    stack.tampilkan();
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;
            }
        } while (pilihan != 5);
        input.close(); // tutup scanner
    }
}