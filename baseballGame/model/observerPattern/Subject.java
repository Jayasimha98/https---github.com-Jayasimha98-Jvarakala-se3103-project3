package model.observerPattern;

public interface Subject {
    public void addLisiner(Observer ob);

    public void removeLisiner(Observer ob);

    public void notifyListiners(String number);
}
