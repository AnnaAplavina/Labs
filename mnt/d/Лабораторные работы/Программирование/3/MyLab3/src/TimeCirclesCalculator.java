public class TimeCirclesCalculator implements ITimeCirclesCalculator {
    @Override
    public int calculateInitialTime(int fearFactor){ return fearFactor*10; }
    @Override
    public int calculateTimeStep(int fearFactor){ return fearFactor*2; }
    @Override
    public int calculateCircles(int fearFactor){ return fearFactor; }
}