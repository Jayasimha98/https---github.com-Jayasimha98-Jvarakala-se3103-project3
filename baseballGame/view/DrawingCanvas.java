package view;

import javax.swing.JPanel;

import view.GammingPannel.GameState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class DrawingCanvas extends JPanel {

    GammingPannel quizPanal;
    public static int width = 500;
    public static int height = 500;
    public static int helth = 5;
   // public static boolean gameOwm = false;

private int balls;
private int stricks;

    public DrawingCanvas(GammingPannel quizPanal) {
        this.quizPanal = quizPanal;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics gs) {
        super.paintComponent(gs);
        Graphics2D graphics2D = (Graphics2D) gs;
        
GameState gameState =  quizPanal.getGameState();

if(gameState.equals(GameState.READY)){

    graphics2D.setFont(new Font("Courier New", Font.BOLD, 30));
    graphics2D.setColor(Color.BLUE);
    graphics2D.drawString("Click on < Play > to Start", 30, 110);
}else{
   
    if(gameState.equals(GameState.GAMEOVER)){
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 30));
        graphics2D.setColor(Color.RED);
        graphics2D.drawString("GAME OVER", 150, 150);
    }
    graphics2D.setFont(new Font("Courier New", Font.BOLD, 15));
    graphics2D.setColor(Color.yellow);
    graphics2D.drawString("Balls "+balls, 20, 100);

    for (int i = 0; i < 3; i++) {
        if(i<balls){
            graphics2D.fillOval(i*150+115, 70, 50, 50);
        }else{
            graphics2D.drawOval(i*150+115, 70, 50, 50);

        }
    }

    graphics2D.drawString("Stricks "+stricks, 20, 200);


    for (int i = 0; i < 3; i++) {
        if(i<stricks){
            graphics2D.fillOval(i*150+115, 170, 50, 50);
        }else{
            graphics2D.drawOval(i*150+115, 170, 50, 50);

        }
    }
}
   /* if(gameOwm){
        graphics2D.setColor(Color.GREEN);
        graphics2D.drawString("You WON ! ! !", 170, 100);
        graphics2D.setColor(Color.BLUE);
        graphics2D.drawString("Click < New > to RE-Start", 30, 140);
        quizPanal.disableAllButtons();
        return;
    }

if(helth>0){
    graphics2D.setColor(Color.green);
    graphics2D.drawString("Helth Level", 80, 100);

        for (int i = 0; i < helth; i++) {
                graphics2D.setColor(Color.GREEN);
            graphics2D.fill3DRect(i * 80 + 80, 130, 50, 50,true);
        }

    }else{
        graphics2D.setColor(Color.red);
        graphics2D.drawString("You Lost ! ! !", 170, 100);
        graphics2D.setColor(Color.BLUE);
        graphics2D.drawString("Click < New > to RE-Start", 30, 140);
        quizPanal.disableAllButtons();
    }
}else{
    graphics2D.setFont(new Font("Courier New", Font.BOLD, 30));
    graphics2D.setColor(Color.BLUE);
    graphics2D.drawString("Click on < NEW > to Start", 30, 110);
   
}*/

}

public void setBall_Stricks(int balls,int stricks){
this.balls = balls;
this.stricks = stricks;
}
}
