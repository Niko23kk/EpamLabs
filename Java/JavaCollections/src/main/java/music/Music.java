package music;

public class Music {
    private float duration;
    private String name;
    private String band;

    public Music(float duration, String name, String band){
        this.duration = duration;
        this.name = name;
        this.band = band;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void play(){
        System.out.println("Audio: " + name+"; band: " + band + "; duration of track is: " + duration);
    }

    public void play(String ganre) {
        System.out.println("Audio: " + name + "; band: " + band + "; duration of track is: " + duration +
                " Ganre: " + ganre);
    }
}
