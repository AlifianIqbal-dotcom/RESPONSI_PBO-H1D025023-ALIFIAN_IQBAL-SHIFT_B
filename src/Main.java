/**
 * Main class untuk testing semua requirement
 * Requirement 4: Main class terpisah dari hierarchy inheritance
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("           SISTEM MANAJEMEN SPBU - STUDI KASUS OOP");
        System.out.println("=".repeat(70));
        System.out.println();
        
        // ===== TEST 1: Pertalite (Subsidi) =====
        System.out.println("[TEST 1] PERTALITE - Pembelian Kecil dengan Subsidi");
        System.out.println("-".repeat(70));
        Pertalite pertalite1 = new Pertalite(8.0);
        pertalite1.tampilkanInfo();
        System.out.println("\nRincian Pembayaran:");
        pertalite1.tampilkanRincian();
        System.out.println();
        
        // ===== TEST 2: Pertalite (Pembelian Besar, Subsidi Dihapus) =====
        System.out.println("\n[TEST 2] PERTALITE - Pembelian Besar (State Logic Branching)");
        System.out.println("-".repeat(70));
        Pertalite pertalite2 = new Pertalite(35.0, true);
        System.out.println("Status subsidi sebelum: " + pertalite2.isSubsidi());
        pertalite2.tampilkanInfo();
        System.out.println("Status subsidi sesudah tentukanKategori(): " + pertalite2.isSubsidi());
        System.out.println("\nRincian Pembayaran:");
        pertalite2.tampilkanRincian();
        System.out.println();
        
        // ===== TEST 3: Pertamax (Transaksi Sedang) =====
        System.out.println("\n[TEST 3] PERTAMAX - Transaksi Sedang dengan Bonus Poin");
        System.out.println("-".repeat(70));
        Pertamax pertamax1 = new Pertamax(15.0);
        pertamax1.tampilkanInfo();
        System.out.println("\nRincian Pembayaran:");
        pertamax1.tampilkanRincian();
        System.out.println();
        
        // ===== TEST 4: Pertamax (Transaksi Besar dengan Diskon) =====
        System.out.println("\n[TEST 4] PERTAMAX - Transaksi Besar (>= 20L dapat diskon 5%)");
        System.out.println("-".repeat(70));
        Pertamax pertamax2 = new Pertamax(25.0);
        pertamax2.tampilkanInfo();
        System.out.println("\nRincian Pembayaran:");
        pertamax2.tampilkanRincian();
        System.out.println();
        
        // ===== TEST 5: Pertamax Turbo (Multiple Interface + Serviceable) =====
        System.out.println("\n[TEST 5] PERTAMAX TURBO - Layanan Premium untuk Mobil");
        System.out.println("-".repeat(70));
        PertamaxTurbo turbo1 = new PertamaxTurbo(40.0, "Mobil");
        turbo1.tampilkanInfo();
        System.out.println("\nRincian Pembayaran:");
        turbo1.tampilkanRincian();
        System.out.println();
        
        // Requirement 9: Interface Polymorphism - memanggil method via interface reference
        System.out.println(">>> Demonstrasi Interface Polymorphism (Serviceable):");
        Serviceable layanan = turbo1;  // Interface reference variable
        layanan.lakukanLayanan();
        System.out.println(">>> Status: " + layanan.getJenisLayanan());
        System.out.println();
        
        // ===== TEST 6: Pertamax Turbo (Kendaraan Khusus) =====
        System.out.println("\n[TEST 6] PERTAMAX TURBO - Kendaraan Khusus (Truk)");
        System.out.println("-".repeat(70));
        PertamaxTurbo turbo2 = new PertamaxTurbo(20.0, "Truk");
        turbo2.tampilkanInfo();
        System.out.println("\nRincian Pembayaran:");
        turbo2.tampilkanRincian();
        System.out.println();
        
        // ===== TEST 7: Polymorphism dengan Payable Interface =====
        System.out.println("\n[TEST 7] DEMONSTRASI POLYMORPHISM - Array Interface Payable");
        System.out.println("-".repeat(70));
        
        // Requirement 9: Interface Polymorphism - array of interface
        Payable[] daftarTransaksi = {
            new Pertalite(12.0),
            new Pertamax(18.0),
            new PertamaxTurbo(30.0, "Mobil", true)
        };
        
        double totalPendapatan = 0.0;
        for (int i = 0; i < daftarTransaksi.length; i++) {
            System.out.println("Transaksi #" + (i + 1) + ":");
            daftarTransaksi[i].tampilkanRincian();
            totalPendapatan += daftarTransaksi[i].hitungTotal();
            System.out.println();
        }
        
        System.out.println("=".repeat(70));
        System.out.println("TOTAL PENDAPATAN SPBU: Rp " + totalPendapatan);
        System.out.println("=".repeat(70));
        
        // ===== RINGKASAN REQUIREMENT YANG DIPENUHI =====
        System.out.println("\n\n");
        System.out.println("=".repeat(70));
        System.out.println("              RINGKASAN REQUIREMENT YANG DIPENUHI");
        System.out.println("=".repeat(70));
        System.out.println(" 1. State dan Behavior         : ✓ (variabel, void method, return method)");
        System.out.println(" 2. Immutability                : ✓ (SATUAN_BAHAN_BAKAR, kodeBBM)");
        System.out.println(" 3. Enkapsulasi & Overloading   : ✓ (private + getter/setter, 2+ constructor)");
        System.out.println(" 4. Inheritance                 : ✓ (BahanBakar extends 3 subclass)");
        System.out.println(" 5. Super Chaining              : ✓ (super(...) dan super.method())");
        System.out.println(" 6. Method Overriding           : ✓ (@Override tampilkanInfo)");
        System.out.println(" 7. Abstract Class              : ✓ (BahanBakar dengan abstract method)");
        System.out.println(" 8. State Logic Branching       : ✓ (tentukanKategori() ubah state)");
        System.out.println(" 9. Interface Polymorphism      : ✓ (Serviceable, Payable reference)");
        System.out.println("10. Multiple Interface          : ✓ (PertamaxTurbo implements Payable+Serviceable)");
        System.out.println("=".repeat(70));
        System.out.println("\nCatatan: PertamaxTurbo implements Serviceable secara eksplisit,");
        System.out.println("         dan mewarisi implements Payable dari BahanBakar.");
        System.out.println("         Total: 2 interface (memenuhi requirement 10)");
        System.out.println("=".repeat(70));
    }
}
