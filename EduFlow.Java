import java.util.ArrayList;
import java.util.Scanner;

/**
 * EDUFLOW - Learning Management System
 * Implementasi: Abstraction, Inheritance, Encapsulation, Polymorphism
 */

// 1. ABSTRACTION: Base class yang tidak bisa di-instansiasi langsung
abstract class Account {
    // 2. ENCAPSULATION: Data disembunyikan (private) dan diakses via getter
    private String name;
    private String username;

    public Account(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getName() { return name; }
    public String getUsername() { return username; }

    // Abstract method untuk diimplementasikan oleh subclass (Polymorphism)
    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("| %-15s | %-20s | %-12s |", getUsername(), getName(), getRole());
    }
}

// 3. INHERITANCE: Turunan spesifik dari Account
class Instructor extends Account {
    public Instructor(String name, String username) { super(name, username); }
    @Override
    public String getRole() { return "INSTRUCTOR"; }
}

class Student extends Account {
    public Student(String name, String username) { super(name, username); }
    @Override
    public String getRole() { return "STUDENT"; }
}

// Model untuk Materi Kursus
class CourseMaterial {
    private String id;
    private String title;
    private String type;

    public CourseMaterial(String id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type.toUpperCase();
    }

    public void printRow() {
        System.out.printf("| %-6s | %-25s | %-10s |\n", id, title, type);
    }
}

public class EduFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<CourseMaterial> materials = new ArrayList<>();

        // Membaca input hingga tanda pemutus "---"
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.equals("---")) break;

            String[] data = line.split(";");
            if (data.length < 4) continue;

            String category = data[0].toLowerCase();

            if (category.equals("user")) {
                // 4. POLYMORPHISM: Objek berbeda disimpan dalam list yang sama (Account)
                if (data[3].equalsIgnoreCase("instructor")) {
                    accounts.add(new Instructor(data[1], data[2]));
                } else {
                    accounts.add(new Student(data[1], data[2]));
                }
            } else if (category.equals("content")) {
                materials.add(new CourseMaterial(data[1], data[2], data[3]));
            }
        }

        printReport(accounts, materials);
        sc.close();
    }

    private static void printReport(ArrayList<Account> accounts, ArrayList<CourseMaterial> materials) {
        System.out.println("\n" + "=".repeat(62));
        System.out.println("                EDUFLOW LMS - SYSTEM REPORT");
        System.out.println("=".repeat(62));

        // Tabel User
        System.out.println("\n[ DATABASE PENGGUNA ]");
        System.out.println("+-----------------+----------------------+--------------+");
        System.out.printf("| %-15s | %-20s | %-12s |\n", "USERNAME", "NAMA LENGKAP", "ROLE");
        System.out.println("+-----------------+----------------------+--------------+");
        for (Account acc : accounts) {
            System.out.println(acc.toString());
        }
        System.out.println("+-----------------+----------------------+--------------+");

        // Tabel Materi
        System.out.println("\n[ KATALOG MATERI KURSUS ]");
        System.out.println("+--------+---------------------------+------------+");
        System.out.printf("| %-6s | %-25s | %-10s |\n", "ID", "JUDUL MATERI", "TIPE");
        System.out.println("+--------+---------------------------+------------+");
        for (CourseMaterial mat : materials) {
            mat.printRow();
        }
        System.out.println("+--------+---------------------------+------------+");
        System.out.println("\nStatus: Pemrosesan Data Selesai.");
    }
}