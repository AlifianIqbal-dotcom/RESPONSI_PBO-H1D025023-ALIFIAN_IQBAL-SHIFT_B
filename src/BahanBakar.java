/**
 * Abstract class untuk Bahan Bakar
 * Requirement 4: Inheritance
 * Requirement 7: Abstract Class dengan minimal 1 abstract method
 */
public abstract class BahanBakar implements Payable {
    // Requirement 2: Immutability - public static final constant
    public static final String SATUAN_BAHAN_BAKAR = "Liter";
    
    // Requirement 1: State - private attributes
    private String jenisBBM;
    private double hargaPerLiter;
    private double jumlahLiter;
    
    // Requirement 2: Immutability - private final instance attribute
    private final String kodeBBM;
    
    // Requirement 3: Overloading - Constructor 1
    public BahanBakar(String jenisBBM, double hargaPerLiter, String kodeBBM) {
        this.jenisBBM = jenisBBM;
        this.hargaPerLiter = hargaPerLiter;
        this.kodeBBM = kodeBBM;
        this.jumlahLiter = 0.0;
    }
    
    // Requirement 3: Overloading - Constructor 2
    public BahanBakar(String jenisBBM, double hargaPerLiter, String kodeBBM, double jumlahLiter) {
        this.jenisBBM = jenisBBM;
        this.hargaPerLiter = hargaPerLiter;
        this.kodeBBM = kodeBBM;
        this.jumlahLiter = jumlahLiter;
    }
    
    // Requirement 3: Enkapsulasi - Getters and Setters dengan this keyword
    public String getJenisBBM() {
        return this.jenisBBM;
    }
    
    public void setJenisBBM(String jenisBBM) {
        this.jenisBBM = jenisBBM;
    }
    
    public double getHargaPerLiter() {
        return this.hargaPerLiter;
    }
    
    public void setHargaPerLiter(double hargaPerLiter) {
        this.hargaPerLiter = hargaPerLiter;
    }
    
    public double getJumlahLiter() {
        return this.jumlahLiter;
    }
    
    public void setJumlahLiter(double jumlahLiter) {
        this.jumlahLiter = jumlahLiter;
    }
    
    public String getKodeBBM() {
        return this.kodeBBM;
    }
    
    // Requirement 1: Behavior - method dengan return value
    public double hitungSubtotal() {
        return this.hargaPerLiter * this.jumlahLiter;
    }
    
    // Requirement 1: Behavior - void method
    public void tampilkanInfo() {
        System.out.println("Jenis BBM: " + this.jenisBBM);
        System.out.println("Kode BBM: " + this.kodeBBM);
        System.out.println("Harga per " + SATUAN_BAHAN_BAKAR + ": Rp " + this.hargaPerLiter);
        System.out.println("Jumlah: " + this.jumlahLiter + " " + SATUAN_BAHAN_BAKAR);
    }
    
    // Requirement 7: Abstract method
    // Requirement 8: State Logic Branching - akan diimplementasi di subclass
    public abstract String tentukanKategori();
    
    // Requirement 7: Abstract method untuk diskon
    public abstract double hitungDiskon();
    
    // Implementation dari Payable interface
    @Override
    public double hitungTotal() {
        return hitungSubtotal() - hitungDiskon();
    }
    
    @Override
    public void tampilkanRincian() {
        tampilkanInfo();
        System.out.println("Subtotal: Rp " + hitungSubtotal());
        System.out.println("Diskon: Rp " + hitungDiskon());
        System.out.println("Total: Rp " + hitungTotal());
    }
}
