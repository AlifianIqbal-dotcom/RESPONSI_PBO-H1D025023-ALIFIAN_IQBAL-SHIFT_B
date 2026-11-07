/**
 * Subclass Pertalite
 * Requirement 4: Inheritance dengan extends
 * Requirement 5: Super Chaining
 * Requirement 6: Method Overriding
 * Requirement 8: State Logic Branching
 */
public class Pertalite extends BahanBakar {
    private boolean isSubsidi;
    
    // Requirement 5: Super Chaining - Constructor dengan super(...)
    public Pertalite(double jumlahLiter) {
        super("Pertalite", 10000.0, "PTL", jumlahLiter);
        this.isSubsidi = true;
    }
    
    public Pertalite(double jumlahLiter, boolean isSubsidi) {
        super("Pertalite", 10000.0, "PTL", jumlahLiter);
        this.isSubsidi = isSubsidi;
    }
    
    public boolean isSubsidi() {
        return this.isSubsidi;
    }
    
    public void setSubsidi(boolean subsidi) {
        this.isSubsidi = subsidi;
    }
    
    // Requirement 8: State Logic Branching - implementasi abstract method dengan if/else
    // yang membaca dan mengubah state objek
    @Override
    public String tentukanKategori() {
        if (this.getJumlahLiter() <= 10.0) {
            // Membaca state: jumlahLiter
            return "Pembelian Kecil";
        } else if (this.getJumlahLiter() <= 30.0) {
            return "Pembelian Sedang";
        } else {
            // Mengubah state: jika pembelian besar, subsidi dihapus
            this.isSubsidi = false;
            return "Pembelian Besar (Subsidi Dihapus)";
        }
    }
    
    @Override
    public double hitungDiskon() {
        // Pertalite subsidi dapat diskon 2%
        if (this.isSubsidi) {
            return hitungSubtotal() * 0.02;
        }
        return 0.0;
    }
    
    // Requirement 6: Method Overriding dengan @Override
    @Override
    public void tampilkanInfo() {
        // Requirement 5: Super Chaining - memanggil super.namaMethod()
        super.tampilkanInfo();
        System.out.println("Status Subsidi: " + (this.isSubsidi ? "Ya" : "Tidak"));
        System.out.println("Kategori: " + tentukanKategori());
    }
}
