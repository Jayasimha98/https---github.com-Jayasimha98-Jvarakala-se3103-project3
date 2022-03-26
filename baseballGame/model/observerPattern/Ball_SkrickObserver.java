package model.observerPattern;

import view.GammingPannel;


public class Ball_SkrickObserver implements Observer {

    GammingPannel quizPanal;
    private int ballCount =0;
    private int struckCount = 0;
private int[] gess = new int [3]; 
    public Ball_SkrickObserver(GammingPannel quizPanal) {
        this.quizPanal = quizPanal;
    }

    @Override
    public void validate(String number) {
        
        System.out.println("number" + number);
try{



        gess[0] =   Integer.parseInt(""+number.charAt(0));
        gess[1] =   Integer.parseInt(""+number.charAt(1)); 
        gess[2] =   Integer.parseInt(""+number.charAt(2));


       computeBallStricks(gess);
     
        System.out.println(" ball count count" + ballCount);
        quizPanal.disableAllButtons();
        quizPanal.getCanvas().setBall_Stricks(ballCount, struckCount);
    
    if(struckCount == 3 ){
        quizPanal.setGameState(GammingPannel.GameState.GAMEOVER);
        quizPanal.disableAllButtons();
    }else{
        quizPanal.ableAllButtons();
    }
}catch(Exception e){
    System.out.println(e.getMessage());
    }
    }



    public void computeBallStricks(int[] gess){

        struckCount =0;
        ballCount = 0;

         int keys[] = quizPanal.getBaseBallGame().getKeys();
        //  int gess[] = quizPanal.getBaseBallGame().getGess();

        for (int i = 0; i < 3; i++) {
            if(keys[i]==gess[i])
            struckCount++;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==j) continue;
                if(keys[i]==gess[j])ballCount++;
            }
        }
        }



    
}
