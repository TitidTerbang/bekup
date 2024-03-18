import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class ContactManager {
    private ArrayList<Kontak> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        Kontak contact = new Kontak(name, phoneNumber);
        contacts.add(contact);
        System.out.println("Kontak berhasil ditambahkan");
    }

    public void displayContacts() {
        System.out.println("Daftar kontak:");
        for (int i = 0; i < contacts.size(); i++) {
            Kontak contact = contacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " - " + contact.getPhoneNumber());
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Kontak contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan:");
                System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kontak tidak ditemukan");
        }
    }
}

public class tugas1 {
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
