package music;

public class LoFi extends Music{
    public LoFi(float duraction, String name, String band) {
        super(duraction, name, band);
    }

    public void play(){
        super.play("LoFi");
    }
}
