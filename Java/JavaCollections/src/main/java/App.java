import disk.AudioDisk;
import music.LoFi;
import music.Music;
import music.Rap;
import music.Rock;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        OptionalTask.firstTask();

        Rap panicAttack = new Rap(2.5f, "Panic attack", "Rocket");
        LoFi bit = new LoFi(5f, "Kakoy-to nit", "Bitmaker");
        Rock russianFreestyle = new Rock(2.23f, "Фристайл по русски", "Kurt92");
        Rock lonelyDay = new Rock(2.1f, "Lonely day", "Hto-to");
        Rap benger = new Rap(3.1f, "Benger", "Feduk");

        AudioDisk top5SongChart = new AudioDisk() {
            {
                add(panicAttack);
                add(bit);
                add(russianFreestyle);
                add(lonelyDay);
                add(benger);
            }
        };

        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("0 - Exit");
            System.out.println("1 - Play");
            System.out.println("2 - Shuffle");
            System.out.println("3 - Total duration");
            System.out.println("4 - Audio by duration");
            System.out.println("5 - Add audio");
            System.out.println("6 - Add lo-fi");
            System.out.println("7 - Add rap");
            System.out.println("8 - Add rock");
            System.out.println("9 - Selected genre to start");
            System.out.println("10 - Clear playlist");

            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting");
                    break;
                case 1:
                    top5SongChart.play();
                    break;
                case 2:
                    top5SongChart.shuffle();
                    break;
                case 3:
                    System.out.println(top5SongChart.totalDuration()+'m');
                    break;
                case 4:
                    System.out.println("Enter the duration through enter");
                    try {
                        top5SongChart.getAudioByDuration(scanner.nextInt(), scanner.nextInt()).play();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter the duration and after the name of audio with the name of band through enter");
                    try {
                        top5SongChart.add(new Music(scanner.nextInt(), scanner.next(),scanner.next()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Enter the duration and after the name of audio with the name of band through enter");
                    try {
                        top5SongChart.add(new LoFi(scanner.nextInt(), scanner.next(),scanner.next()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Enter the duration and after the name of audio with the name of band through enter");
                    try {
                        top5SongChart.add(new Rap(scanner.nextInt(), scanner.next(), scanner.next()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Enter the duration and after the name of audio with the name of band through enter");
                    try {
                        top5SongChart.add(new Rock(scanner.nextInt(), scanner.next(), scanner.next()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Enter a genre");
                    switch (scanner.next()) {
                        case "Lo-Fi":
                            top5SongChart.musicOfGenreToStart(LoFi.class);
                            break;
                        case "Rap":
                            top5SongChart.musicOfGenreToStart(Rap.class);
                            break;
                        case "Rock":
                            top5SongChart.musicOfGenreToStart(Rock.class);
                            break;
                        default:
                            System.out.println("Incorrect genre");
                    }
                    break;
                case 10:
                    top5SongChart.clear();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }


        } while (choice != 0);
    }
}

