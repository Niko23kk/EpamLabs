package music;

public class Rock extends Music {
    public Rock(float duraction, String name, String band) {
        super(duraction, name, band);
    }

    public void play(){
        super.play("Rock");
    }
}
