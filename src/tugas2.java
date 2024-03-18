import java.util.Scanner;

class Kontak {
    private String name;
    private String phoneNumber;
    private Kontak next;

    public Kontak(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Kontak getNext() {
        return next;
    }

    public void setNext(Kontak next) {
        this.next = next;
    }
}

class managerKontak {
    private Kontak head;

    public managerKontak() {
        head = null;
    }

    public void addContact(String name, String phoneNumber) {
        Kontak newContact = new Kontak(name, phoneNumber);
        if (head == null) {
            head = newContact;
        } else {
            Kontak current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newContact);
        }
        System.out.println("Kontak berhasil ditambahkan");
    }

    public void displayContacts() {
        System.out.println("Daftar kontak:");
        Kontak current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.getName() + " - " + current.getPhoneNumber());
            current = current.getNext();
            count++;
        }
    }

    public void searchContact(String name) {
        Kontak current = head;
        boolean found = false;
        while (current != null) {
            if (current.getName().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan:");
                System.out.println(current.getName() + " - " + current.getPhoneNumber());
                found = true;
                break;
            }
            current = current.getNext();
        }
        if (!found) {
            System.out.println("Kontak tidak ditemukan");
        }
    }
}

public class tugas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        managerKontak contactManager = new managerKontak();

        System.out.println("Selamat datang di manajemen kontak!");
        int choice;
        do {
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama kontak: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon: ");
                    String phoneNumber = scanner.nextLine();
                    contactManager.addContact(name, phoneNumber);
                    break;
                case 2:
                    contactManager.displayContacts();
                    break;
                case 3:
                    System.out.print("Masukkan nama kontak yang ingin dicari: ");
                    String searchName = scanner.nextLine();
                    contactManager.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan manajemen kontak!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}
