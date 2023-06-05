//import java.util.Random;
//public class PaperTechnician extends Thread {
//
//
//    private ServicePrinter printer;
//
//    public PaperTechnician(ThreadGroup threadGroup, ServicePrinter printer, String name) {
//        super(threadGroup, name);
//        this.printer = printer;
//    }
//
//    @Override
//    public void run() {
//        Random random = new Random();
//        int numberOfRefills = 3;
//
//        for (int i = 1; i <= numberOfRefills; i++) {
//
//            printer.refillPaper();
//            int MINIMUM_SLEEPING_TIME = 1000;
//            int MAXIMUM_SLEEPING_TIME = 5000;
//            int sleepingTime = MINIMUM_SLEEPING_TIME + random.nextInt(MAXIMUM_SLEEPING_TIME - MINIMUM_SLEEPING_TIME);
//
//            try {
//                Thread.sleep(sleepingTime);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.printf("Paper Technician %s was interrupted during sleeping time after refilling paper pack no. %d.\n",
//                        sleepingTime, i);
//            }
//        }
//
//        System.out.printf("Paper Technician %s finished attempts to refill printer with paper packs.\n", getName());
//    }
//}

import java.util.Random;

public class PaperTechnician extends Thread {

    private static final int NUMBER_OF_REFILLS = 3;
    private static final int MIN_SLEEPING_TIME = 1000;
    private static final int MAX_SLEEPING_TIME = 5000;
    private final ServicePrinter printer;
    private final Random random = new Random();
    private int refillsCounter = 0;

    public PaperTechnician(ThreadGroup threadGroup, ServicePrinter printer, String name) {
        super(threadGroup, name);
        this.printer = printer;
    }

    @Override
    public void run() {
        while (refillsCounter < NUMBER_OF_REFILLS) {

            printer.refillPaper();
            int sleepingTime = MIN_SLEEPING_TIME + random.nextInt(MAX_SLEEPING_TIME - MIN_SLEEPING_TIME);

            try {
                Thread.sleep(sleepingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.printf("Paper Technician %s was interrupted during sleeping time after refilling paper pack no. %d.\n",
                        sleepingTime, refillsCounter+1);
            }
            refillsCounter++;
        }

        System.out.printf("Paper Technician %s finished attempts to refill printer with paper packs.\n", getName());
    }
}



