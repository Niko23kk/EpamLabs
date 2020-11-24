package disk;
import music.Music;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class AudioDisk {

    ArrayList<Music> audios;

    public AudioDisk(){
        audios = new ArrayList<Music>();
    }

    public AudioDisk(ArrayList<Music> audios){
        this.audios = audios;
    }

    public void add(Music audio){
        audios.add(audio);
    }

    public void remove(Music audio){
        audios.remove(audio);
    }

    public void clear(){
        audios.clear();
    }

    public Music getAudioByDuration(int from, final int to){
        return audios.stream().filter(music->music.getDuration()>=from && music.getDuration()<=to).findFirst().get();
    }

    public void shuffle(){
        Random random = new Random();
        Music buf;
        int randomNumber;
        for(int i = 0; i < audios.size(); i++){
            randomNumber = Math.abs(random.nextInt()) % audios.size();
            buf = audios.get(i);
            audios.set(i, audios.get(randomNumber));
            audios.set(randomNumber, buf);
        }
    }

    public void musicOfGenreToStart(Class cl){
        int j = 0;
        Music buf;
        for(int i = 0; i < audios.size(); i++){
            if(audios.get(i).getClass().equals(cl)){
                buf = audios.get(i);
                audios.set(i, audios.get(j));
                audios.set(j, buf);
                j++;
            }
        }
    }

    public int totalDuration(){
        int total = 0;
        for (Music audio:audios) {
            total += audio.getDuration();
        }
        return total;
    }

    public void play(){
        for( int i = 0; i < audios.size(); i++){
            audios.get(i).play();
        }
    }

    public Music getAudio(String name){
        for( int i = 0; i < audios.size(); i++){
            if(audios.get(i).getName() == name)
                return audios.get(i);
        }
        return null;
    }

    public ArrayList<Music> getAudios(){
        return new ArrayList<Music>(audios);
    }

    public int numberOfAudios(){
        return audios.size();
    }
}
