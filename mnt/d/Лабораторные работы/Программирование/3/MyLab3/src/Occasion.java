public class Occasion {
    private String name;
    private TimeOfDay time;
    public Occasion(String name, TimeOfDay time){
        this.name = name;
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return(name);
    }
    @Override
    public int hashCode(){
        return name.hashCode() + time.hashCode();
    }
    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
}
