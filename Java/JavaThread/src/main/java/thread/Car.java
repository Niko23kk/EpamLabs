package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread{
    private int carId;
    private int timeToStaying;
    private int timeToWait;
    private Semaphore semaphore;

    public Car(int carId, Semaphore semaphore, int timeToStaying, int timeToWait) {
        this.carId = carId;
        this.semaphore = semaphore;
        this.timeToStaying = timeToStaying;
        this.timeToWait = timeToWait;
    }

    public int getCarId() {
        return carId;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Машина %d ждем места\n", carId);
            if (semaphore.tryAcquire(this.timeToStaying, TimeUnit.SECONDS)) {

                System.out.printf("Машина %d встала на место\n", carId);

                sleep(timeToWait * 1000);

                System.out.printf("Машина %d освободила место\n", carId);

                semaphore.release();
            } else {
                System.out.printf("Машина %d раастроилась и поехала на другую стоянку\n", carId);

            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
