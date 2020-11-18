package music;

public class Rap extends Music {
    public Rap(float duraction, String name, String band) {
        super(duraction, name, band);
    }

    public void play(){
        super.play("Rap");
    }
}
