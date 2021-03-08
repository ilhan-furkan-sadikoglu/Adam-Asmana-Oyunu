import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Adam extends JFrame{
    private JPanel Panel1;
    private JTextField textField2;
    private JButton onaylaButton;
    private JButton onaylaButton1;
    private JLabel resim;
    private JLabel bosluk;
    private JButton button1;
    private JLabel banner;
    private JLabel kullanilanText;

    static int sayac=0;
    String kelime;
    String bosluktext="";
    String kullanilanlar="";

    public int kontrol(String s){
        int tahmin=1;

        if(s.length()==0) return 3;

        if(s.length()>1){
            String cevap=kelime;
            System.out.println(s);
            if(cevap.equals(s)) {
                bosluktext=kelime;
                bosluk.setText(kelime);
                banner.setText("Doğru bildin");
                return 0;
            }
            else return 1;
        }
        else {

            char c=s.charAt(0);
            String temp="";


            for(int i=0;i<kelime.length();i++){
                if(kelime.charAt(i)==c){
                    tahmin=2;
                    temp+=c;
                                    }
                else temp+=bosluktext.charAt(i);

            }
            bosluktext=temp;
            bosluk.setText(bosluktext);

        }

        return tahmin;
    }

    public String kelimesec(){
        Random rand = new Random();
        int i = rand.nextInt(5);
        switch (i){
            case 1:
               return "aziz bektas";
            case 2:
                return "ilhan sadikoglu";
            case 3:
                return "medeniyet universitesi";
            case 4:
                return "kadikoy";
            case 5:
                return "turkiye";
            default:
                return "aziz bektas";

        }
    }

    public void bosluklar(){

    }


    Adam(){
        add(Panel1);
        setSize(800,800);
        setTitle("Adam Asmaca");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        kelime=kelimesec();


        for(int i=0;i<kelime.length();i++){
            bosluktext+="?";
        }
        bosluk.setText(bosluktext);


        onaylaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(kontrol(textField2.getText())==1){
                    banner.setText("Hatalı tahmin");
                    kullanilanlar+=(textField2.getText())+" ";
                    kullanilanText.setText(kullanilanlar);
                    if(sayac<8) {


                        ImageIcon img = new ImageIcon(this.getClass().getResource("Resimler/"+(sayac+2)+".PNG"));
                        resim.setIcon(img);
                        sayac++;
                    }
                    else{
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        System.exit(0);
                    }
                }
                else if(kontrol(textField2.getText())==0){
                    ImageIcon img = new ImageIcon(this.getClass().getResource("Resimler/Doğru.png"));
                    resim.setIcon(img);
                }
                else if(kontrol(textField2.getText())==2){
                    banner.setText("Harf mevcut");
                }
                else banner.setText("Boş girmeyiniz");
                textField2.setText("");
            }
        });


    }
}
