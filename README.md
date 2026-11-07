# Sistem Manajemen SPBU - Tugas Praktikum PBO

## Identitas Mahasiswa
- **Nama**: [Isi dengan nama lengkap Anda]
- **NIM**: [Isi dengan NIM Anda]
- **Tema**: SPBU (Stasiun Pengisian Bahan Bakar Umum)
- **Kelas**: [Isi dengan kelas Anda]

## Deskripsi Proyek
Sistem manajemen SPBU berbasis Java yang menerapkan konsep Object-Oriented Programming (OOP). Sistem ini mengelola berbagai jenis bahan bakar (Pertalite, Pertamax, Pertamax Turbo) dengan fitur perhitungan harga, diskon, bonus poin, dan layanan premium.

## Struktur Class

### 1. Interface
- **Payable**: Interface untuk objek yang dapat dikenakan pembayaran
- **Serviceable**: Interface untuk objek yang dapat memberikan layanan

### 2. Abstract Class
- **BahanBakar**: Abstract class yang menjadi superclass untuk semua jenis bahan bakar
  - Atribut: jenisBBM, hargaPerLiter, jumlahLiter, kodeBBM (final)
  - Constant: SATUAN_BAHAN_BAKAR (public static final)
  - Abstract methods: tentukanKategori(), hitungDiskon()

### 3. Concrete Classes
- **Pertalite**: Bahan bakar subsidi dengan logika pembatasan pembelian besar
- **Pertamax**: Bahan bakar dengan sistem bonus poin
- **PertamaxTurbo**: Bahan bakar premium dengan layanan tambahan (implements multiple interface)

### 4. Main Class
- **Main**: Class untuk testing dan demonstrasi semua fitur

## Requirement OOP yang Dipenuhi

| No | Requirement | Status | Lokasi Implementasi |
|----|-------------|--------|---------------------|
| 1 | State dan Behavior | ✅ | Semua class memiliki variabel, void method, dan return method |
| 2 | Immutability | ✅ | `SATUAN_BAHAN_BAKAR` (public static final), `kodeBBM` (private final) |
| 3 | Enkapsulasi & Overloading | ✅ | Private attributes + getter/setter, minimal 2 constructor per class |
| 4 | Inheritance | ✅ | BahanBakar → Pertalite, Pertamax, PertamaxTurbo |
| 5 | Super Chaining | ✅ | `super(...)` di constructor, `super.tampilkanInfo()` di method |
| 6 | Method Overriding | ✅ | `@Override tampilkanInfo()` di semua subclass |
| 7 | Abstract Class | ✅ | BahanBakar dengan 2 abstract method |
| 8 | State Logic Branching | ✅ | `tentukanKategori()` menggunakan if/else dan mengubah state objek |
| 9 | Interface Polymorphism | ✅ | `Payable obj = new Pertalite()`, `Serviceable layanan = turbo1` |
| 10 | Multiple Interface | ✅ | PertamaxTurbo implements Serviceable + mewarisi Payable dari parent |

## Instruksi Compile dan Run

### Prerequisite
- Java Development Kit (JDK) 8 atau lebih baru
- Terminal/Command Prompt

### Langkah-langkah

#### 1. Clone atau Download Repository
```bash
git clone [URL_REPOSITORY_ANDA]
cd spbu_project
```

#### 2. Compile Program
Masuk ke direktori `src` dan compile semua file Java:

```bash
cd src
javac *.java
```

Jika berhasil, tidak akan ada output error dan akan terbentuk file `.class` untuk setiap file Java.

#### 3. Jalankan Program
Jalankan Main class:

```bash
java Main
```

### Alternatif: Compile dan Run dalam Satu Command

**Windows (Git Bash/MSYS):**
```bash
cd src && javac *.java && java Main
```

**Windows (Command Prompt):**
```cmd
cd src
javac *.java
java Main
```

**Linux/Mac:**
```bash
cd src && javac *.java && java Main
```

## Fitur Program

### 1. Pertalite (Bahan Bakar Subsidi)
- Harga: Rp 10.000/liter
- Diskon 2% untuk pembelian dengan subsidi
- Logika: Subsidi otomatis dihapus jika pembelian > 30 liter

### 2. Pertamax (Bahan Bakar Reguler)
- Harga: Rp 13.000/liter
- Diskon 5% untuk pembelian ≥ 20 liter
- Sistem bonus poin berdasarkan total transaksi:
  - < Rp 100.000: 10 poin
  - Rp 100.000 - Rp 300.000: 50 poin
  - > Rp 300.000: 150 poin

### 3. Pertamax Turbo (Bahan Bakar Premium)
- Harga: Rp 15.000/liter
- Diskon 10% dengan layanan premium aktif
- Diskon 7% untuk pembelian ≥ 25 liter (tanpa layanan premium)
- Layanan premium: pembersihan tangki, cek tekanan ban, lap kaca

## Screenshot Output Program

### Output Terminal
```
======================================================================
           SISTEM MANAJEMEN SPBU - STUDI KASUS OOP
======================================================================

[TEST 1] PERTALITE - Pembelian Kecil dengan Subsidi
----------------------------------------------------------------------
Jenis BBM: Pertalite
Kode BBM: PTL
Harga per Liter: Rp 10000.0
Jumlah: 8.0 Liter
Status Subsidi: Ya
Kategori: Pembelian Kecil

Rincian Pembayaran:
Subtotal: Rp 80000.0
Diskon: Rp 1600.0
Total: Rp 78400.0

[TEST 2] PERTALITE - Pembelian Besar (State Logic Branching)
----------------------------------------------------------------------
Status subsidi sebelum: true
Status subsidi sesudah tentukanKategori(): false
Kategori: Pembelian Besar (Subsidi Dihapus)
Total: Rp 350000.0

[TEST 5] PERTAMAX TURBO - Layanan Premium untuk Mobil
----------------------------------------------------------------------
>>> Demonstrasi Interface Polymorphism (Serviceable):
>>> Melakukan layanan premium untuk Mobil
>>> Layanan: Pembersihan tangki, cek tekanan ban, lap kaca
>>> Status: Layanan Premium Aktif

[TEST 7] DEMONSTRASI POLYMORPHISM - Array Interface Payable
----------------------------------------------------------------------
TOTAL PENDAPATAN SPBU: Rp 756600.0

======================================================================
              RINGKASAN REQUIREMENT YANG DIPENUHI
======================================================================
 1. State dan Behavior         : ✓
 2. Immutability                : ✓
 3. Enkapsulasi & Overloading   : ✓
 4. Inheritance                 : ✓
 5. Super Chaining              : ✓
 6. Method Overriding           : ✓
 7. Abstract Class              : ✓
 8. State Logic Branching       : ✓
 9. Interface Polymorphism      : ✓
10. Multiple Interface          : ✓
======================================================================
```

## Struktur Direktori
```
spbu_project/
├── README.md
└── src/
    ├── Payable.java          (Interface)
    ├── Serviceable.java      (Interface)
    ├── BahanBakar.java       (Abstract Class)
    ├── Pertalite.java        (Concrete Class)
    ├── Pertamax.java         (Concrete Class)
    ├── PertamaxTurbo.java    (Concrete Class)
    └── Main.java             (Main Class)
```

## Penjelasan Konsep OOP

### State Logic Branching (Requirement 8)
Method `tentukanKategori()` di setiap subclass mengimplementasikan logika if/else yang:
- **Membaca state objek** (misal: jumlahLiter, jenisKendaraan)
- **Mengubah state objek** (misal: mengubah isSubsidi, layananPremium, poinBonus)

Contoh di Pertalite:
```java
if (this.getJumlahLiter() > 30.0) {
    this.isSubsidi = false;  // Mengubah state
    return "Pembelian Besar (Subsidi Dihapus)";
}
```

### Interface Polymorphism (Requirement 9)
Program menggunakan interface reference variable untuk memanggil method:
```java
Serviceable layanan = turbo1;  // Interface reference
layanan.lakukanLayanan();      // Polymorphic call
```

### Multiple Interface (Requirement 10)
PertamaxTurbo implements 2 interface:
1. `Serviceable` - secara eksplisit
2. `Payable` - diwarisi dari BahanBakar

## Catatan Pengembangan
- Semua class dirancang dengan prinsip encapsulation (private attributes, public methods)
- Abstract class digunakan untuk mendefinisikan kontrak yang harus diimplementasi subclass
- Interface digunakan untuk polymorphism dan loose coupling
- State logic branching memberikan business logic yang dinamis berdasarkan kondisi objek

## Lisensi
Proyek ini dibuat untuk keperluan tugas praktikum Pemrograman Berorientasi Objek.

---
**Dibuat oleh**: [Nama Anda] - [NIM Anda]  
**Tanggal**: November 2026  
**Mata Kuliah**: Pemrograman Berorientasi Objek
