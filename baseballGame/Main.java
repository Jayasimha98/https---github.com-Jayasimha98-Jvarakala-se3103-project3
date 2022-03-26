import javax.swing.JFrame;
import view.GammingPannel;

public class Main{
    public static void main(String args[]) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 40);
        
        window.setTitle("Base Ball");
       GammingPannel mainMenu = new GammingPannel(window);
       mainMenu.init();
        window.pack();
        window.setVisible(true);
       
   }
}