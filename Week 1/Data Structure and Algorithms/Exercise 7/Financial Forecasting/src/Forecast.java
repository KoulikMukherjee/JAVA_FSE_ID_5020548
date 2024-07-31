public class Forecast {
    public static double calculateFutureValue(double initialValue, double growthRate, int years)
    {
        if (years == 0)
        {
            double roundedInitialValue = Math.round(initialValue * 100.0) / 100.0;
            return roundedInitialValue;
        }
        return calculateFutureValue(initialValue * (1 + growthRate), growthRate, years - 1);
    }
}
