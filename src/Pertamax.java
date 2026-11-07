/**
 * Subclass Pertamax
 * Requirement 4: Inheritance dengan extends
 * Requirement 5: Super Chaining
 * Requirement 6: Method Overriding
 * Requirement 8: State Logic Branching
 */
public class Pertamax extends BahanBakar {
    private int poinBonus;
    
    // Requirement 5: Super Chaining - Constructor dengan super(...)
    public Pertamax(double jumlahLiter) {
        super("Pertamax", 13000.0, "PTX", jumlahLiter);
        this.poinBonus = 0;
    }
    
    public Pertamax(double jumlahLiter, int poinBonus) {
        super("Pertamax", 13000.0, "PTX", jumlahLiter);
        this.poinBonus = poinBonus;
    }
    
    public int getPoinBonus() {
        return this.poinBonus;
    }
    
    public void setPoinBonus(int poinBonus) {
        this.poinBonus = poinBonus;
    }
    
    // Requirement 8: State Logic Branching - implementasi abstract method dengan if/else
    // yang membaca dan mengubah state objek
    @Override
    public String tentukanKategori() {
        double total = hitungSubtotal();
        
        if (total < 100000) {
            // Membaca state: subtotal
            this.poinBonus = 10;
            return "Transaksi Kecil (Bonus 10 poin)";
        } else if (total < 300000) {
            // Mengubah state: poinBonus berdasarkan total
            this.poinBonus = 50;
            return "Transaksi Sedang (Bonus 50 poin)";
        } else {
            this.poinBonus = 150;
            return "Transaksi Besar (Bonus 150 poin)";
        }
    }
    
    @Override
    public double hitungDiskon() {
        // Pertamax dapat diskon 5% jika pembelian >= 20 liter
        if (this.getJumlahLiter() >= 20.0) {
            return hitungSubtotal() * 0.05;
        }
        return 0.0;
    }
    
    // Requirement 6: Method Overriding dengan @Override
    @Override
    public void tampilkanInfo() {
        // Requirement 5: Super Chaining - memanggil super.namaMethod()
        super.tampilkanInfo();
        System.out.println("Poin Bonus: " + this.poinBonus);
        System.out.println("Kategori: " + tentukanKategori());
    }
}
