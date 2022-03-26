 package model;
import model.observerPattern.Observer;
import model.observerPattern.Subject;

import java.util.ArrayList;
import java.util.Random;

public class BaseBallGame implements Subject{

ArrayList<Observer> eventListner = new ArrayList<Observer>();

public int keys[] = new int[3];
public int gess[] = new int[3];



public BaseBallGame(){
    generateKey();
}

private void generateKey() {
    Random r = new Random();

    keys[0]=r.nextInt(10);

    do{
        keys[1]=r.nextInt(10);
    }while(keys[1] == keys[0]);
    do{
        keys[2]=r.nextInt(10);
    }while(keys[1] == keys[2] || keys[1] == keys[0] || keys[0] == keys[2]);
}

public int[] getKeys() {
    return keys;
}

public int[] getGess() {
    return gess;
}

public void setGess(int pos, int value){
gess[pos] = value;
}






@Override
public void addLisiner(Observer ob) {
    eventListner.add(ob);
}

@Override
public void removeLisiner(Observer ob) {
    eventListner.remove(ob); 
}

@Override
public void notifyListiners(String number) {
for (Observer ob : eventListner) {
    ob.validate(number);
}    
}

 }