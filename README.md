# 📘 EduFlow: Digital Learning Management System

EduFlow adalah sistem manajemen pembelajaran (LMS) sederhana yang dirancang untuk mengotomatisasi pendataan pengguna dan materi edukasi. Proyek ini merupakan implementasi nyata dari konsep **Object-Oriented Programming (OOP)** dalam bahasa Java.

## 🌟 Latar Belakang
Pengelolaan data akademik seringkali menemui kendala jika dilakukan secara manual. EduFlow hadir sebagai solusi otomatisasi untuk mengelola database pengguna (Instruktur & Siswa) serta katalog materi kursus dalam format yang terstruktur dan mudah dibaca.

## 🎯 Tujuan Proyek
* Menerapkan pilar OOP: **Abstraction, Inheritance, Encapsulation, dan Polymorphism**.
* Menggunakan **Collection Framework (ArrayList)** untuk penyimpanan data dinamis.
* Menyajikan laporan data dalam bentuk **Tabel Terminal** yang rapi.

## 🧪 Panduan Penggunaan
Program menggunakan pemisah titik koma (`;`) untuk input data.

### Format Input:
1. **User:** `user;Nama Lengkap;Username;Role`
2. **Konten:** `content;ID;Judul Materi;Tipe`
3. **Selesai:** Ketik `---` untuk melihat laporan.

### Contoh Demo:
```text
user;Immanuel Tambunan;nuel123;instructor
user;Jesika Hasugian;jesika_ocean;student
content;V01;Fundamental OOP Java;Video
content;Q01;Kuis Polimorfisme;Quiz
---