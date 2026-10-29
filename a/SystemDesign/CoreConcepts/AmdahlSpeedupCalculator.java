package dsa.striver.a.SystemDesign.CoreConcepts;

class AmdahlSpeedupCalculator {
    public AmdahlSpeedupCalculator() {}

    public double speedup(double parallelFraction, int processors) {

        double serialFractionTime = 1 - parallelFraction;
        double parallelFractionTime = parallelFraction / processors;
        double runTime = serialFractionTime + parallelFraction;
        return 1 / runTime;
    }
}
