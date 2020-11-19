import thread.Airplane;
import thread.Car;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {

        {
            Semaphore places = new Semaphore(5);
            Random rand = new Random();
            for (int i = 1; i < 11; i++) {
                new Car(i, places, Math.abs(rand.nextInt() % 10), Math.abs(rand.nextInt() % 10)).start();
            }
        }

        {
        //Опциональное
        System.out.println("\nOptional");
        Semaphore runways = new Semaphore(5);
        Random rand = new Random();
        for(int i = 1; i < 11; i++){
            new Airplane(i, runways).start();
        }
        }
    }
}
