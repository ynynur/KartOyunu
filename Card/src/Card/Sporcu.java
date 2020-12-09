package Card;


// Sporcu abstract class'ı , basketbol ve futbolcu extend edecek bu classı

public abstract class Sporcu {

    private String sporcuIsim;
    private String sporcuTakim;
    private boolean kartKullanildiMi=false; //kullanmadım galiba

    //Constructor methods
    public Sporcu() {
        this.sporcuIsim = "Isimsiz Sporcu";
        this.sporcuTakim="Takimsiz Sporcu";
    }

    public Sporcu(String sporcuIsim, String sporcuTakim) {
        this.sporcuIsim = sporcuIsim;
        this.sporcuTakim = sporcuTakim;
    }

    //Sporcu id,isim ve puan dondurmek için abstract method
    public abstract String sporcuPuaniGoster1();

    //getter setter'lar
    public String getSporcuIsim() {
        return sporcuIsim;
    }
    public void setSporcuIsim(String sporcuIsim) {
        this.sporcuIsim = sporcuIsim;
    }

    public String getSporcuTakim() {
        return sporcuTakim;
    }

    public void setSporcuTakim(String sporcuTakim) {
        this.sporcuTakim = sporcuTakim;
    }

    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

}
