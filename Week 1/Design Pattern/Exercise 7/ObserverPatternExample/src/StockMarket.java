import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock{
    List<Observer> observers = new ArrayList<>();
    private double Price;

    public void Register(Observer observer){
        observers.add(observer);
    }

    public void Deregister(Observer observer){
        observers.remove(observer);
    }

    public void Notify(){
        for(Observer observer : this.observers){
            observer.update(Price);
        }
    }

    public void setPrice(double price){
        this.Price = price;
        this.Notify();
    }

}
