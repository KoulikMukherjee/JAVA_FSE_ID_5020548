public class Main {
    public static void main(String[] args)
    {
        double initialValue = 25000.0;
        double growthRate = 0.02;
        int years = 10;
        double futureValue = Forecast.calculateFutureValue(initialValue, growthRate, years);
        System.out.println("Future Value: " + futureValue + " rupees");
    }
}