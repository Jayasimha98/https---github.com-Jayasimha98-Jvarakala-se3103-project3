package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.GammingPannel;
import view.DrawingCanvas;
import javax.swing.JTextField;

import model.BaseBallGame;
import javax.swing.JButton;

public class Play_ExitListiner implements ActionListener {

  GammingPannel quizPanal;

  public Play_ExitListiner(GammingPannel quizPanal) {
    this.quizPanal = quizPanal;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (((JButton) e.getSource()).getText().equals("exit")) {
System.exit(0);
    } else {

      //BaseBallGame baseBallGame = quizPanal.getBaseBallGame();
      BaseBallGame baseBallGame = new BaseBallGame();
      quizPanal.setBaseBallGame(baseBallGame);
      quizPanal.setGameState(GammingPannel.GameState.PLAYING);

int[] keys =  baseBallGame.getKeys();

String textKeys  = ""+keys[0]+ keys[1]+keys[2];

      JTextField textKeyField = quizPanal.getGameKeyField();
      JTextField textFieldGess = quizPanal.getGameGessField();

    //  String st = new WordList().getRamdomWord();
      // resetting to defalts
     // HelthCanvas.gameOwm = false;
      textKeyField.setText(textKeys);
      textFieldGess.setText("");
      DrawingCanvas.helth = 5;
      quizPanal.ableAllButtons();
      quizPanal.getCanvas().setBall_Stricks(0, 0);
      // calling repaint
      quizPanal.getCanvas().repaint();
    }
  }

}
