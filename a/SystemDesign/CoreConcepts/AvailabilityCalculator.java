package dsa.striver.a.SystemDesign.CoreConcepts;

class AvailabilityCalculator {

    public AvailabilityCalculator() {}

    public double calculate(double[] uptimes, String mode) {

        double finalUptime = 1.0;
        if ("series".equals(mode)) {
            for (double uptime : uptimes) {
                finalUptime *= uptime;
            }
        }
        else if ("parallel".equals(mode)) {
            for (double uptime : uptimes) {
                finalUptime *= (1 - uptime);
            }
            finalUptime = 1 - finalUptime;
        }
        return finalUptime;
    }
}
