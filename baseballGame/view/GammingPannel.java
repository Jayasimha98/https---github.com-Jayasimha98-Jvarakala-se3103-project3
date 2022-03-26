package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;

import controller.Play_ExitListiner;
import controller.NumberKeysListiner;
import model.BaseBallGame;
import model.observerPattern.Ball_SkrickObserver;

import java.awt.Font;
import java.awt.Color;

//import controller.BUttonClickListener;
public class GammingPannel {

public enum GameState{
PLAYING,READY,GAMEOVER
}

  private JFrame window;
  private DrawingCanvas quizCanvas;
  JTextField gameKeyField  = new JTextField() ;
  JTextField gameGessField = new JTextField();
JButton play = new JButton("Play ball");
JButton exit = new JButton("exit");
private BaseBallGame baseBallGame = new BaseBallGame();
  ArrayList<JButton> alphaButtons = new ArrayList<JButton>();
private GameState gameState = GameState.READY;


  // JTextField textField = new JTextField();
  // JTextField textFieldHide = new JTextField();

  public GammingPannel(JFrame window) {
    this.window = window;
    window.setTitle("Base Ball Game");

  }

  public void init() {
    Container container = window.getContentPane();
    container.setPreferredSize(new Dimension(500, 500));
    quizCanvas = new DrawingCanvas(this);
    container.add(quizCanvas, BorderLayout.CENTER);


    JPanel southPanal = new JPanel();

    container.add(southPanal, BorderLayout.SOUTH);
    southPanal.setLayout(new GridLayout(4, 7, 10, 8));
    southPanal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    southPanal.setBackground(Color.white);

  
    NumberKeysListiner nummberPad = new NumberKeysListiner(this);
    for (int i = 0; i < 10; i++) {
      
      alphaButtons.add(new JButton(""+i));
      southPanal.add(alphaButtons.get(i));
      alphaButtons.get(i).addActionListener(nummberPad);

    }
   
    play.setBackground(Color.BLUE);
    exit.setBackground(Color.red);
    play.setForeground(Color.white);
    exit.setForeground(Color.white);


    southPanal.add(play);
    southPanal.add(exit);

    play.addActionListener(new Play_ExitListiner(this));
    exit.addActionListener(new Play_ExitListiner(this));

    //// north pannel /////
    JPanel northPanel = new JPanel();

    container.add(northPanel, BorderLayout.NORTH);
    northPanel.setLayout(new GridLayout(2, 2));
    northPanel.setBackground(Color.white);
    gameKeyField.setEditable(false);
    gameGessField.setEditable(false);
    Font font = new Font("Courier", Font.BOLD, 12);
    gameKeyField.setForeground(Color.RED);
    gameKeyField.setFont(font);
    gameGessField.setFont(font);

    northPanel.add(new JLabel("Secret Game Key"));
    northPanel.add(gameKeyField);
    northPanel.add(new JLabel("Game Gess Key"));
    northPanel.add(gameGessField);
    disableAllButtons();

    Ball_SkrickObserver Observer = new Ball_SkrickObserver(this);
    baseBallGame.addLisiner(Observer);
  }

  public void disableAllButtons() {
    for (JButton jButton : alphaButtons) {
      jButton.setEnabled(false);
    }
  }

  public void ableAllButtons() {
    for (JButton jButton : alphaButtons) {
      jButton.setEnabled(true);
    }
  }

  public JFrame getWindow() {
    return this.window;
  }

  public JTextField getGameKeyField() {
    return gameKeyField;
  }

  public JTextField getGameGessField() {
    return gameGessField;
  }

  public DrawingCanvas getCanvas() {
    return this.quizCanvas;
  }

  public ArrayList<JButton> getAlphaButtons() {
      return alphaButtons;
  }

  public JButton getExit() {
      return exit;
  }

  public JButton getPlay() {
      return play;
  }

  public GameState getGameState() {
      return gameState;
  }

  public void setGameState(GameState gameState) {
      this.gameState = gameState;
  }

  public void setBaseBallGame(BaseBallGame baseBallGame) {
      this.baseBallGame = baseBallGame;
      Ball_SkrickObserver Observer = new Ball_SkrickObserver(this);
    baseBallGame.addLisiner(Observer);
  }

  public BaseBallGame getBaseBallGame() {
      return baseBallGame;
  }

}
