package observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Observable{
    private List<Observer> observers = new ArrayList<>();
    private String latestNews;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers){
            observer.update(latestNews);
        }
    }

    public void setNews(String news){
        this.latestNews = news;
        notifyObserver();
    }
}
