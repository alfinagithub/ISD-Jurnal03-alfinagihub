public class LinkedList {
    Node head;

    // Menambahkan buku pada awal atau akhir list
    public void addNode(Buku buku, boolean tambahDiAwal) {
        Node newNode = new Node(buku);
        if (tambahDiAwal) {
            newNode.next = head;
            head = newNode;
        } else {
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        System.out.println("Data buku ditambahkan!");
    }

    // Menambahkan buku pada indeks tertentu
    public void addNodeAtIndex(Buku buku, int indeks) {
        if (indeks < 0) {
            System.out.println("Indeks tidak valid. Indeks harus non-negatif.");
            return;
        }

        Node newNode = new Node(buku);
        if (indeks == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < indeks - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Indeks melebihi panjang list. Data buku tidak ditambahkan.");
                return;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        System.out.println("Data buku ditambahkan pada indeks " + indeks + "!");
    }

    // Menghapus buku dari awal atau akhir list
    public void deleteNode(boolean hapusDariAwal) {
        if (head == null) {
            System.out.println("List kosong, tidak ada data buku untuk dihapus.");
            return;
        }
        if (hapusDariAwal) {
            head = head.next;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        System.out.println("Data buku dihapus!");
    }

    // Menghapus buku berdasarkan judul
    public void deleteNodeByTitle(String judul) {
        if (head == null) {
            System.out.println("List kosong, tidak ada data buku untuk dihapus.");
            return;
        }

        if (head.data.judul.equals(judul)) {
            head = head.next;
            System.out.println("Data buku dengan judul '" + judul + "' dihapus!");
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.data.judul.equals(judul)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Data buku dengan judul '" + judul + "' tidak ditemukan.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Data buku dengan judul '" + judul + "' dihapus!");
        }
    }

    // Mencetak semua data buku dalam list
    public void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List kosong, tidak ada data buku.");
            return;
        }
        System.out.println("Daftar Data Buku:");
        while (temp != null) {
            System.out.println("Judul: " + temp.data.judul + ", Penulis: " + temp.data.penulis + ", Tahun Terbit: " + temp.data.tahunTerbit);
            temp = temp.next;
        }
    }
}