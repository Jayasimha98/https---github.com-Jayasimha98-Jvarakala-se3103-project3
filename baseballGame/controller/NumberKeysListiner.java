package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.BaseBallGame;
import view.GammingPannel;

public class NumberKeysListiner implements ActionListener {

    GammingPannel quizPanal;
    private int clickCount = 0;

    public NumberKeysListiner(GammingPannel quizPanal) {

        this.quizPanal = quizPanal;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String buttonString = ((JButton) e.getSource()).getText();

        ((JButton) e.getSource()).setEnabled(false);
        JTextField gessField = quizPanal.getGameGessField();

        if (clickCount == 0) {
            gessField.setText("");
        }

        BaseBallGame baseBallGame = quizPanal.getBaseBallGame();
        gessField.setText(gessField.getText().concat(buttonString));
        baseBallGame.setGess(clickCount, buttonString.charAt(0)-'0');
        clickCount++;
if(clickCount==3){
    baseBallGame.notifyListiners(gessField.getText());
    clickCount = 0;
}
        quizPanal.getCanvas().repaint();
    }

}
