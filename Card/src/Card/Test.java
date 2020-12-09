package Card;
import Card.basketbolcular.Basketbolcu;
import Card.futbolcular.Futbolcu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Test {


    public static int kullaniciSelected=0;
    public static int z=0; //
    public static void main(String[] args) {

     /*   ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);


        for (Integer c : arrayList) {

            System.out.println(c);

        }
        Random random = new Random();
        int randomsayii = random.nextInt(arrayList.size());
        System.out.println(randomsayii);



        int sayac = 12;
        do {
            System.out.println("Sayaç: " + sayac);
            sayac++;
        } while (sayac < 11); */

        Futbolcu futbolcu1 = new Futbolcu("Ronaldo","A",25,50,45);
        Futbolcu futbolcu2 = new Futbolcu("Lionel Messi","A",55,65,45);
        Futbolcu futbolcu3 = new Futbolcu("Diego Armando Maradona","A",50,85,55);
        Futbolcu futbolcu4 = new Futbolcu("Pele","A",35,75,95);
        Futbolcu futbolcu5 = new Futbolcu("Johan Cruyff","A",55,100,75);
        Futbolcu futbolcu6 = new Futbolcu("Cristiano Ronaldo","A",80,45,100);
        Futbolcu futbolcu7 = new Futbolcu("Zinedine Zidane","A",25,95,70);
        Futbolcu futbolcu8 = new Futbolcu("Alfredo Di Stéfano","A",45,90,35);

        ArrayList<Futbolcu> futbolcular=new ArrayList<>();
        futbolcular.addAll(Arrays.asList(futbolcu1,futbolcu2,futbolcu3,futbolcu4,futbolcu5,futbolcu6,futbolcu7,futbolcu8));

      /*  for (int i = 0 ; i<futbolcular.size(); i++){
            System.out.println(futbolcular.get(i).getSporcuIsim());
        }*/

        Basketbolcu basketbolcu1 = new Basketbolcu("Kareem Abdul Jabbar","NBA",90,80,70);
        Basketbolcu basketbolcu2 = new Basketbolcu("Bill Russel","NBA",50,85,100);
        Basketbolcu basketbolcu3 = new Basketbolcu("Magic Johnson","NBA",60,70,35);
        Basketbolcu basketbolcu4 = new Basketbolcu("Wilt Chamberlain","NBA",80,45,100);
        Basketbolcu basketbolcu5 = new Basketbolcu("Larry Bird","NBA",90,25,65);
        Basketbolcu basketbolcu6 = new Basketbolcu("Tim Duncan","NBA",110,85,55);
        Basketbolcu basketbolcu7 = new Basketbolcu("Kobe Bryant","NBA",65,75,95);
        Basketbolcu basketbolcu8 = new Basketbolcu("Shaquille O`Neal","NBA",50,55,95);

        ArrayList<Basketbolcu> basketbolcular = new ArrayList<>();
        basketbolcular.addAll(Arrays.asList(basketbolcu1,basketbolcu2,basketbolcu3,basketbolcu4,basketbolcu5,basketbolcu6,basketbolcu7,basketbolcu8));

        // Basketbol ve Futbolcu nesnelerini olusturup liste olarak basketbolcular/futbolcular listelerine attik.
        //liste olarak birleştirip ondan sonra array lise eklememiz lazım


        Bilgisayar bilgisayar = new Bilgisayar(0,"Bilgisayar",0);
        Kullanici kullanici = new Kullanici(1,"Kullanici",0);
        // Kullanici ve bilgisayar oyunculari nesnelerini olusturduk.

        int kartSayisi=8; //futbolcu
        int kartSayisi1=8;
        // ilk 8 seferde futbolculari rastgele sekilde 4-4 bilgisayar ve kullaniciya dağittık.
        for(int i=0 ;i<16;i++){

            Random rand= new Random();
            if(i<8){
                int randomSayi=rand.nextInt(kartSayisi);

                if(i%2==0){
                    kullanici.addKartListesi(futbolcular.get(randomSayi));
                }
                else{
                    bilgisayar.addKartListesi(futbolcular.get(randomSayi));
                }
                futbolcular.remove(randomSayi);
                kartSayisi--;

            }
            // Sonraki seferde ise ayni islemi basketolcular icin yaptık.
            else{
                int randomSayi1=rand.nextInt(kartSayisi1);

                if(i%2==0){
                    kullanici.addKartListesi(basketbolcular.get(randomSayi1));
                }
                else{
                    bilgisayar.addKartListesi(basketbolcular.get(randomSayi1));
                }
                basketbolcular.remove(randomSayi1);
                kartSayisi1--;

            }


        }
        // Formumuzu olusturduk ve görünür kıldık.
        Form test=new Form(kullanici.getKartListesi());
        test.setVisible(true);

        // Oyuncu kart ekranları ustune bilgilerini yazdirdik.
        test.setOyuncu1(kullanici.skorGoster()); //oyuncu id , oyuncu adı , skor
        test.setOyuncu2(bilgisayar.skorGoster());


        // public olarak tanımladıgımız button1 isimle değişkenimizin actionListener'ını burada tanımladık ve kodun kalan kısmını
        //burada gerçekleştirdik.
        test.button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kullaniciSelected=test.getComboBox1(); // butona basıldığında comboBox'tan seçilen değeri aliyorum.

                if(z%2==0){// z değişkeni kontrolü ile sırayla basketbol ve futbol classlarından tureme nesneleri seçiyorum.
                    if(kullanici.getKartListesi().get(kullaniciSelected-1) instanceof Futbolcu){

                        kullanici.setSecilenKart(kullanici.kartSec(kullaniciSelected));// Indexteki kartı seç ve secilenKart değişkenine ata.
                        test.setKullaniciOrtaBilgi(kullanici.getSecilenKart().sporcuPuaniGoster1());// Sectiğin karti göster

                        bilgisayar.setSecilenKart(bilgisayar.kartSec(z));//Sirasi gelen class'tan kartı seç ve secilenKart değişkenine ata
                        test.setBilgisayarOrtaBilgi(bilgisayar.getSecilenKart().sporcuPuaniGoster1());// Sectiğin karti göster

                        test.removeItemCombo();// Combo Box değerlerini sil ve boşalt.

                        test.kartYazdir(kullanici.getKartListesi());//Tekrardan güncel kart listesini yazdır(Combox burada doluyor tekrar)
                        test.button1.setEnabled(false);// buttonu disable et.

                        Random rand=new Random();

                        Futbolcu secilenKartTut= (Futbolcu)kullanici.getSecilenKart();//Secilen kartları ata.
                        Futbolcu secilenKartTutBil=(Futbolcu)bilgisayar.getSecilenKart();

                        int karsilasOzellik=rand.nextInt(3);//Karsilastirilacak ozellik icin rastgele sayi al.


                        switch(karsilasOzellik){// 3 case icin aynı kod bloklarini gerçekleştir ve karşılaştırmaları yap.
                            case 0:
                                if(secilenKartTut.getPenalti() != secilenKartTutBil.getPenalti()) {// penalti puanları eşit değilse
                                    String kazananSonuc = ((secilenKartTut.getPenalti() > secilenKartTutBil.getPenalti()) ? "Oyuncu" : "Bilgisayar");
                                    if (secilenKartTut.getPenalti() > secilenKartTutBil.getPenalti()) {
                                        kullanici.skorArttir();
                                    } else {
                                        bilgisayar.skorArttir();
                                    }
                                    //kimin yuksek oldugunu bul ,skorunu arttır ve onu çıktı olarak ver .
                                    JOptionPane.showMessageDialog(test, "\n | Penaltı Karşılaştırması |\n" +
                                            " Oyuncu: " + secilenKartTut.getPenalti() + "\n" +
                                            " Bilgisayar: " + secilenKartTutBil.getPenalti() + "\n" +
                                            "\t Kazanan : " + kazananSonuc);
                                }
                                else{// eşitse eger berabere yazdir.
                                    JOptionPane.showMessageDialog(test,"\n | Penalti Karşılaştırması |\n" +
                                            " Oyuncu: "+secilenKartTut.getPenalti()+"\n" +
                                            " Bilgisayar: "+secilenKartTutBil.getPenalti()+"\n \tBerabere kartlar geri dağıtıldı.");
                                    test.removeItemCombo();// combo Box boşalt.
                                    //kart listelerine ortaya koyulan kartlari geri koy.
                                    kullanici.addKartListesi(secilenKartTut);
                                    bilgisayar.addKartListesi(secilenKartTutBil);
                                    //guncel kart listesini tekrar yazdır.
                                    test.kartYazdir(kullanici.getKartListesi());

                                }
                                z++;// z değişkenini arttırarak sonraki class karşılaştırmassına geçiş sağla.
                                break;

                            case 1:// Aynı işlemleri devam et.
                                if(secilenKartTut.getSerbestAtis() != secilenKartTutBil.getSerbestAtis()) {
                                    String kazananSonuc = ((secilenKartTut.getSerbestAtis() > secilenKartTutBil.getSerbestAtis()) ? "Oyuncu" : "Bilgisayar");
                                    if (secilenKartTut.getSerbestAtis() > secilenKartTutBil.getSerbestAtis()) {
                                        kullanici.skorArttir();
                                    } else {
                                        bilgisayar.skorArttir();
                                    }
                                    JOptionPane.showMessageDialog(test, "\n | Serbest Vuruş Karşılaştırması |\n" +
                                            " Oyuncu: " + secilenKartTut.getSerbestAtis() + "\n" +
                                            " Bilgisayar: " + secilenKartTutBil.getSerbestAtis() + "\n" +
                                            "\t Kazanan : " + kazananSonuc);
                                }
                                else{
                                    JOptionPane.showMessageDialog(test,"\n | Serbest Vuruş Karşılaştırması |\n" +
                                            " Oyuncu: "+secilenKartTut.getSerbestAtis()+"\n" +
                                            " Bilgisayar: "+secilenKartTutBil.getSerbestAtis()+"\n \tBerabere kartlar geri dagitildi.");
                                    test.removeItemCombo();
                                    kullanici.addKartListesi(secilenKartTut);
                                    bilgisayar.addKartListesi(secilenKartTutBil);
                                    test.kartYazdir(kullanici.getKartListesi());
                                }
                                z++;
                                break;

                            case 2:
                                if(secilenKartTut.getKaleciyleKarsiKarsiya() != secilenKartTutBil.getKaleciyleKarsiKarsiya()) {
                                    String kazananSonuc = ((secilenKartTut.getKaleciyleKarsiKarsiya() > secilenKartTutBil.getKaleciyleKarsiKarsiya()) ? "Oyuncu" : "Bilgisayar");
                                    if (secilenKartTut.getKaleciyleKarsiKarsiya() > secilenKartTutBil.getKaleciyleKarsiKarsiya()) {
                                        kullanici.skorArttir();
                                    } else {
                                        bilgisayar.skorArttir();
                                    }
                                    JOptionPane.showMessageDialog(test, "\n | Kaleciyle Karşı Karşıya Karşılaştırması |\n" +
                                            " Oyuncu: " + secilenKartTut.getKaleciyleKarsiKarsiya() + "\n" +
                                            " Bilgisayar: " + secilenKartTutBil.getKaleciyleKarsiKarsiya() + "\n" +
                                            "\t Kazanan : " + kazananSonuc);
                                }
                                else{
                                    JOptionPane.showMessageDialog(test,"\n | Kaleciyle Karşı Karşıya Karşılaştırması |\n" +
                                            " Oyuncu: "+secilenKartTut.getKaleciyleKarsiKarsiya()+"\n" +
                                            " Bilgisayar: "+secilenKartTutBil.getKaleciyleKarsiKarsiya()+"\n \tBerabere kartlar geri dagitildi.");
                                    test.removeItemCombo();
                                    kullanici.addKartListesi(secilenKartTut);
                                    bilgisayar.addKartListesi(secilenKartTutBil);
                                    test.kartYazdir(kullanici.getKartListesi());
                                }
                                z++;
                                break;

                            default:
                                JOptionPane.showMessageDialog(test,"Teknik bir sorunla karşılaşıldı.");
                        }

                        if(kullanici.kartSayisiBulma(0)==0){
                            // Eğer basketbol yada futbol class'ından nesne kalmamıssa
                            //z'yi artık sırayla gitmesi için değil,diğer bloğa girmesi için gerekli değerlere ata.
                            z=1;
                        }
                        if(kullanici.kartSayisiBulma(1)==0){
                            z=0;
                        }
                        test.button1.setEnabled(true);// Buton aktive et.

                    }
                    else{
                        JOptionPane.showMessageDialog(test,"Lütfen futbolcu seçiniz.");
                        test.button1.setEnabled(true);
                   }

                }



                else{
                    if(kullanici.getKartListesi().get(kullaniciSelected-1) instanceof Basketbolcu){//Secilen kart basketbolcu class' mı
                        //kontrol et.
                        //Aynı işlemleri basketol class'ı için gerçekleştir.

                        kullanici.setSecilenKart(kullanici.kartSec(kullaniciSelected));
                        test.setKullaniciOrtaBilgi(kullanici.getSecilenKart().sporcuPuaniGoster1());

                        bilgisayar.setSecilenKart(bilgisayar.kartSec(z));
                        test.setBilgisayarOrtaBilgi(bilgisayar.getSecilenKart().sporcuPuaniGoster1());

                        test.setKullaniciOrtaBilgi(kullanici.getSecilenKart().sporcuPuaniGoster1());

                        test.removeItemCombo();

                        test.kartYazdir(kullanici.getKartListesi());
                        test.button1.setEnabled(false);

                        Random rand=new Random();
                        Basketbolcu secilenKartTut= (Basketbolcu)kullanici.getSecilenKart();
                        Basketbolcu secilenKartTutBil=(Basketbolcu)bilgisayar.getSecilenKart();
                        int karsilasOzellik=rand.nextInt(3);


                        switch(karsilasOzellik){
                            case 0:
                                if(secilenKartTut.getIkilikAtis() != secilenKartTutBil.getIkilikAtis()) {
                                    String kazananSonuc = ((secilenKartTut.getIkilikAtis() > secilenKartTutBil.getIkilikAtis()) ? "Oyuncu" : "Bilgisayar");
                                    if (secilenKartTut.getIkilikAtis() > secilenKartTutBil.getIkilikAtis()) {
                                        kullanici.skorArttir();
                                    } else {
                                        bilgisayar.skorArttir();
                                    }
                                    JOptionPane.showMessageDialog(test, "\n | İkilik Atış Karşılaştırması |\n" +
                                            " Oyuncu: " + secilenKartTut.getIkilikAtis() + "\n" +
                                            " Bilgisayar: " + secilenKartTutBil.getIkilikAtis() + "\n" +
                                            "\t Kazanan : " + kazananSonuc);
                                }
                                else{
                                    JOptionPane.showMessageDialog(test,"\n |İkilik Atış Karşılaştırması  |\n" +
                                            " Oyuncu: "+secilenKartTut.getIkilikAtis()+"\n" +
                                            " Bilgisayar: "+secilenKartTutBil.getIkilikAtis()+"\n \tBerabere kartlar geri dagitildi.");
                                    test.removeItemCombo();
                                    kullanici.addKartListesi(secilenKartTut);
                                    bilgisayar.addKartListesi(secilenKartTutBil);
                                    test.kartYazdir(kullanici.getKartListesi());

                                }
                                z++;
                                break;

                            case 1:
                                if(secilenKartTut.getSerbestAtis() != secilenKartTutBil.getSerbestAtis()) {
                                    String kazananSonuc = ((secilenKartTut.getSerbestAtis() > secilenKartTutBil.getSerbestAtis()) ? "Oyuncu" : "Bilgisayar");
                                    if (secilenKartTut.getSerbestAtis() > secilenKartTutBil.getSerbestAtis()) {
                                        kullanici.skorArttir();
                                    } else {
                                        bilgisayar.skorArttir();
                                    }
                                    JOptionPane.showMessageDialog(test, "\n | Serbest  Atış Karşılaştırması |\n" +
                                            " Oyuncu: " + secilenKartTut.getSerbestAtis() + "\n" +
                                            " Bilgisayar: " + secilenKartTutBil.getSerbestAtis() + "\n" +
                                            "\t Kazanan : " + kazananSonuc);
                                }
                                else{
                                    JOptionPane.showMessageDialog(test,"\n | Serbest Atış Karşılaştırması |\n" +
                                            " Oyuncu: "+secilenKartTut.getSerbestAtis()+"\n" +
                                            " Bilgisayar: "+secilenKartTutBil.getSerbestAtis()+"\n \tBerabere kartlar geri dagitildi.");
                                    test.removeItemCombo();
                                    kullanici.addKartListesi(secilenKartTut);
                                    bilgisayar.addKartListesi(secilenKartTutBil);
                                    test.kartYazdir(kullanici.getKartListesi());

                                }
                                z++;
                                break;

                            case 2:
                                if(secilenKartTut.getUclukAtis() != secilenKartTutBil.getUclukAtis()) {
                                    String kazananSonuc = ((secilenKartTut.getUclukAtis() > secilenKartTutBil.getUclukAtis()) ? "Oyuncu" : "Bilgisayar");
                                    if (secilenKartTut.getUclukAtis() > secilenKartTutBil.getUclukAtis()) {
                                        kullanici.skorArttir();
                                    } else {
                                        bilgisayar.skorArttir();
                                    }
                                    JOptionPane.showMessageDialog(test, "\n | Üçlük Atış Karşılştırması |\n" +
                                            " Oyuncu: " + secilenKartTut.getUclukAtis() + "\n" +
                                            " Bilgisayar: " + secilenKartTutBil.getUclukAtis() + "\n" +
                                            "\t Kazanan : " + kazananSonuc);

                                }
                                else{
                                    JOptionPane.showMessageDialog(test,"\n | Üçlük Atış Karşılştırması |\n" +
                                            " Oyuncu: "+secilenKartTut.getUclukAtis()+"\n" +
                                            " Bilgisayar: "+secilenKartTutBil.getUclukAtis()+"\n \tBerabere kartlar geri dagitildi.");
                                    test.removeItemCombo();
                                    kullanici.addKartListesi(secilenKartTut);
                                    bilgisayar.addKartListesi(secilenKartTutBil);
                                    test.kartYazdir(kullanici.getKartListesi());

                                }
                                z++;
                                break;

                            default:
                                JOptionPane.showMessageDialog(test,"Teknik bir sorunla karşılaşıldı.");
                                break;
                        }
                        if(kullanici.kartSayisiBulma(0)==0){
                            z=1;
                        }
                        if(kullanici.kartSayisiBulma(1)==0){
                            z=0;
                        }
                        test.button1.setEnabled(true);

                    }
                    else{
                        JOptionPane.showMessageDialog(test,"Lütfen basketbolcu seçiniz.");
                        test.button1.setEnabled(true);
                    }

                }


                // Skor tabelasini güncel haliyle yazdır
                test.setOyuncu1(kullanici.skorGoster());
                test.setOyuncu2(bilgisayar.skorGoster());


                // Eger kullanici karti kalmadıysa(ki bilgisayarında kalmamış olur bu durumda) oyunu bıtırmek için
                //bu bloğa gir ve puan karşılaştırması yaparak kazananı yazdir ve pencereyi kapa.
                if(kullanici.getKartListesi().size()==0){
                    if(kullanici.getSkor() == bilgisayar.getSkor()){
                        JOptionPane.showMessageDialog(test,"| Oyun Bitti | \n Berabere");
                    }
                    else{
                        String kazananSon= ((kullanici.getSkor() > bilgisayar.getSkor()) ? "Oyuncu" : "Bilgisayar");
                        JOptionPane.showMessageDialog(test,"| Oyun Bitti | \n\t | Puan Durumu | \n" +
                                "Oyuncu: "+kullanici.getSkor()+"\nBilgisayar:"+bilgisayar.getSkor()+"\n\tKazanan: "+kazananSon);
                    }
                    test.setVisible(false);
                    test.dispose(); //Destroy the JFrame object

                }


            }


        });


    }

}
