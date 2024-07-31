public interface Stock {
    public void Register(Observer observer);
    public void Deregister(Observer observer);
    public void Notify();

}
