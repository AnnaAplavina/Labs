import java.sql.SQLOutput;

public class MumiTroll extends Troll{
    public MumiTroll(String name){
        super(name);
        System.out.println("Новый мумми-тролль с именем " + name + " появился в мире");
    }

    @Override
    public void expressEmotion(Emotion emotion){
        switch (emotion){
            case AFRAID:
                System.out.println("У "+ super.getName() + " от страха побелела мордочка");
                break;
            case HAPPY:
                System.out.println("У " + super.getName() + " на лице счастливая улыбка");
                break;
            case ANGRY:
                System.out.println("У " + super.getName() + " от злости сжались кулаки");
                break;
            case CALM:
                System.out.println(super.getName() + "спокоен");
                break;
        }
    }
    public void nod(){
        System.out.println(super.getName() + " кивает");
    }
    public void walkInCircles(int initialTime, int timeStep, int circles){
        System.out.println(super.getName()+" начинает бормоча притоптывая ногами выписывать круги");
        for(int i = 1; i <= circles; i++){
            System.out.println(super.getName()+ " проходит круг номер " + i + " за " + initialTime + " секунд");
            initialTime = initialTime + timeStep;
        }
    }
}