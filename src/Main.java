import javax.swing.*;

public class Main {
    public static void baslat(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });

        Adam f=new Adam();
        f.setVisible(true);
    }


    public static void main(String[] args) {
        baslat();
    }
}
