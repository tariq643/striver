package dsa.striver.a.SystemDesign.CoreConcepts;

class LittlesLawCalculator {
    public LittlesLawCalculator() {}

    public double solve(double throughput, double concurrency, double latencySeconds) {

        if (throughput == -1.0) {
            return concurrency / latencySeconds;
        }
        else if (concurrency == -1.0) {
            return throughput * latencySeconds;
        }
        else if (latencySeconds == -1.0) {
            return concurrency / throughput;
        }
        return -1;
    }
}
