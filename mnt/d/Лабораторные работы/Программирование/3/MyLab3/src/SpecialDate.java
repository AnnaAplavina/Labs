public class SpecialDate extends Occasion {
    public SpecialDate(String name, TimeOfDay time) {
        super(name, time);
        inform(name, time);
    }
    private void inform(String name, TimeOfDay time){
        String timestring = "default";
        switch (time){
            case NIGHT:
                timestring = "ночь";
                break;
            case DAY:
                timestring = "день";
                break;
            case EVENING:
                timestring = "вечер";
                break;
            case MORNING:
                timestring = "утро";
                break;
        }
        System.out.println("Установлено специальное событие "+ name + ". Время " + timestring + ".");
    }
    @Override
    public String toString(){
        return "специальное событие " + super.getName();
    }
}