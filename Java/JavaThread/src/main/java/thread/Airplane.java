package thread;

import java.util.concurrent.Semaphore;

public class Airplane extends Thread{
    public int airplaneId;
    public Semaphore runways;

    public Airplane(int airplaneId, Semaphore runways){
        this.airplaneId = airplaneId;
        this.runways = runways;
    }

    @Override
    public void run() {

        try {
            System.out.printf("Самолет %d ждет взлетную полосу\n", airplaneId);
            runways.acquire();
            sleep(1000);
            System.out.printf("Самолет %d встал на взлетную полосу\n", airplaneId);
            sleep(1000);
            System.out.printf("Самолет %d набирает скорость\n", airplaneId);
            sleep(1000);
            System.out.printf("Самолет %d взлетел\n", airplaneId);
            runways.release();
            System.out.printf("Runway is free\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
