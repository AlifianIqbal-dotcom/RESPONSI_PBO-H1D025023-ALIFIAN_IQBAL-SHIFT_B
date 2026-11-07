/**
 * Subclass Pertamax Turbo
 * Requirement 4: Inheritance dengan extends
 * Requirement 5: Super Chaining
 * Requirement 6: Method Overriding
 * Requirement 8: State Logic Branching
 * Requirement 10: Multiple Interface - implements 2 interface (Payable & Serviceable)
 */
public class PertamaxTurbo extends BahanBakar implements Serviceable {
    private boolean layananPremium;
    private String jenisKendaraan;
    
    // Requirement 5: Super Chaining - Constructor dengan super(...)
    public PertamaxTurbo(double jumlahLiter, String jenisKendaraan) {
        super("Pertamax Turbo", 15000.0, "PTT", jumlahLiter);
        this.jenisKendaraan = jenisKendaraan;
        this.layananPremium = false;
    }
    
    public PertamaxTurbo(double jumlahLiter, String jenisKendaraan, boolean layananPremium) {
        super("Pertamax Turbo", 15000.0, "PTT", jumlahLiter);
        this.jenisKendaraan = jenisKendaraan;
        this.layananPremium = layananPremium;
    }
    
    public boolean isLayananPremium() {
        return this.layananPremium;
    }
    
    public void setLayananPremium(boolean layananPremium) {
        this.layananPremium = layananPremium;
    }
    
    public String getJenisKendaraan() {
        return this.jenisKendaraan;
    }
    
    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
    
    // Requirement 8: State Logic Branching - implementasi abstract method dengan if/else
    // yang membaca dan mengubah state objek
    @Override
    public String tentukanKategori() {
        if (this.jenisKendaraan.equalsIgnoreCase("Motor")) {
            // Membaca state: jenisKendaraan
            return "Kendaraan Ringan";
        } else if (this.jenisKendaraan.equalsIgnoreCase("Mobil")) {
            if (this.getJumlahLiter() >= 30.0) {
                // Mengubah state: aktifkan layanan premium
                this.layananPremium = true;
                return "Kendaraan Standar (Layanan Premium Aktif)";
            }
            return "Kendaraan Standar";
        } else {
            this.layananPremium = true;
            return "Kendaraan Khusus (Layanan Premium Aktif)";
        }
    }
    
    @Override
    public double hitungDiskon() {
        // Pertamax Turbo dengan layanan premium dapat diskon 10%
        if (this.layananPremium) {
            return hitungSubtotal() * 0.10;
        }
        // Diskon 7% untuk pembelian >= 25 liter
        if (this.getJumlahLiter() >= 25.0) {
            return hitungSubtotal() * 0.07;
        }
        return 0.0;
    }
    
    // Requirement 10: Implementasi interface Serviceable
    @Override
    public void lakukanLayanan() {
        System.out.println(">>> Melakukan layanan premium untuk " + this.jenisKendaraan);
        System.out.println(">>> Layanan: Pembersihan tangki, cek tekanan ban, lap kaca");
    }
    
    @Override
    public String getJenisLayanan() {
        return this.layananPremium ? "Layanan Premium Aktif" : "Layanan Standar";
    }
    
    // Requirement 6: Method Overriding dengan @Override
    @Override
    public void tampilkanInfo() {
        // Requirement 5: Super Chaining - memanggil super.namaMethod()
        super.tampilkanInfo();
        System.out.println("Jenis Kendaraan: " + this.jenisKendaraan);
        System.out.println("Layanan: " + getJenisLayanan());
        System.out.println("Kategori: " + tentukanKategori());
    }
}
