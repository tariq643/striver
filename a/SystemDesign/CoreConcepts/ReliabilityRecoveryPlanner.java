package dsa.striver.a.SystemDesign.CoreConcepts;

class ReliabilityRecoveryPlanner {
    public ReliabilityRecoveryPlanner() {}

    public double availability(double mtbfHours, double mttrHours) {
        return mtbfHours / (mtbfHours + mttrHours);
    }

    public double maximumMttr(double mtbfHours, double targetAvailability) {
        return mtbfHours * (1 - targetAvailability) / targetAvailability;
    }

    public boolean meetsTarget(double mtbfHours, double mttrHours, double targetAvailability) {

        double availability = this.availability(mtbfHours, mttrHours);
        return availability >= targetAvailability;
    }
}