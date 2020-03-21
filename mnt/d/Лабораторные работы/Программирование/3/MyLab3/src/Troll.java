public abstract class Troll implements ITroll{
    private String name;
    abstract void expressEmotion(Emotion emotion);
    @Override
    public String getName(){
        return name;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    public Troll(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
    public boolean equals(Object o){
        return super.equals(o);
    }
}