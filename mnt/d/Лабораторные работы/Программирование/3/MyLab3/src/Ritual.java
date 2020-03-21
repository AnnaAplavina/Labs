import java.util.*;

public class Ritual {
    private Occasion occasion;
    private int circles;
    private int initialTime;
    private int timeStep;
    List<MumiTroll> trolls;
    public Ritual(Occasion occasion, int fearFactor, MumiTroll ... trolls){
        this.occasion = occasion;
        TimeCirclesCalculator calculator = new TimeCirclesCalculator();
        initialTime = calculator.calculateInitialTime(fearFactor);
        timeStep = calculator.calculateTimeStep(fearFactor);
        circles = calculator.calculateCircles(fearFactor);
        this.trolls = Arrays.asList(trolls);
        for(MumiTroll troll : trolls){
            System.out.print(troll.toString() + " ");
        }        System.out.println("готовы ворожить");
    }
    public void start(){
        for(MumiTroll troll : trolls){
            System.out.print(troll.toString() + " ");
        }
        System.out.println("начали ворожить");
        for(MumiTroll troll : trolls){
            troll.walkInCircles(initialTime,timeStep,circles);
        }
    }
    @Override
    public String toString(){
        return "ritual with occasion" + occasion.toString();
    }
    @Override
    public int hashCode(){
        return occasion.getName().hashCode()+circles+initialTime+timeStep;
    }
    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
}