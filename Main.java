import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cetak Daftar Buku");
            System.out.println("4. Input data sesuai indeks");
            System.out.println("5. Hapus Data sesuai judul buku");
            System.out.println("6. Keluar");
            System.out.print("Pilih operasi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Judul Buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis Buku: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan Tahun Terbit Buku: ");
                    int tahunTerbit = scanner.nextInt();
                    Buku buku = new Buku(judul, penulis, tahunTerbit);
                    linkedList.addNode(buku, true);
                    break;

                case 2:
                    linkedList.deleteNode(true);
                    break;

                case 3:
                    linkedList.printList();
                    break;

                case 4:
                    System.out.print("Masukkan Judul Buku: ");
                    String judulAtIndex = scanner.nextLine();
                    System.out.print("Masukkan Penulis Buku: ");
                    String penulisAtIndex = scanner.nextLine();
                    System.out.print("Masukkan Tahun Terbit Buku: ");
                    int tahunTerbitAtIndex = scanner.nextInt();
                    Buku bukuAtIndex = new Buku(judulAtIndex, penulisAtIndex, tahunTerbitAtIndex);

                    System.out.print("Masukkan Indeks: ");
                    int indeks = scanner.nextInt();
                    linkedList.addNodeAtIndex(bukuAtIndex, indeks);
                    break;

                case 5:
                    System.out.print("Masukkan Judul Buku yang akan dihapus: ");
                    String judulHapus = scanner.nextLine();
                    linkedList.deleteNodeByTitle(judulHapus);
                    break;

                case 6:
                    System.out.println("Keluar dari program. Sampai jumpa!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-6.");
            }
        }
    }
}