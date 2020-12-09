package Card.futbolcular;
import Card.Sporcu;

public class Futbolcu extends Sporcu{
    private int penalti=0;
    private int serbestVurus=0;
    private int kaleciyleKarsiKarsiya=0;

    public Futbolcu() {

        super();
    }


    public Futbolcu(String sporcuIsim, String sporcuTakim, int penalti, int serbestVurus, int kaleciyleKarsiKarsiya) {
        super(sporcuIsim, sporcuTakim);
        this.penalti=penalti;
        this.serbestVurus=serbestVurus;
        this.kaleciyleKarsiKarsiya=kaleciyleKarsiKarsiya;
    }


    // String.format ile formatlanmış bir string olusturarak bilgilerimizi bu stringle birlikte return ederiz.
    @Override
    public String sporcuPuaniGoster1() {
        String puan = new String();
        puan=String.format("\nFutbolcu: %s\n\t\n Penaltı : %d \n Serbest Vuruş : %d \n Kaleciyle Karşı Karşıya :" +
                " %d\n----------------------------" +
                "\n",getSporcuIsim(),penalti,serbestVurus,kaleciyleKarsiKarsiya);
        return puan;
    }
    //Getter Setter'lar
    public int getPenalti() {
        return penalti;
    }

    public int getSerbestAtis() {
        return serbestVurus;
    }

    public int getKaleciyleKarsiKarsiya() {
        return kaleciyleKarsiKarsiya;
    }

    public void setPenalti(int penalti) {
        this.penalti = penalti;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestVurus = serbestAtis;
    }

    public void setKaleciyleKarsiKarsiya(int kaleciyleKarsiKarsiya) {
        this.kaleciyleKarsiKarsiya = kaleciyleKarsiKarsiya;
    }
}
