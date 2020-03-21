public interface ITimeCirclesCalculator {
    int calculateTimeStep(int fearFactor);
    int calculateInitialTime(int fearFactor);
    int calculateCircles(int fearFactor);
}
