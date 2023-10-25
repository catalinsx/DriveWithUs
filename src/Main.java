import rentacar.logging.FileLogger;
import rentacar.logging.Logger;

import rentacar.cars;
import rentacar.customers;
import rentacar.bookings;
public class Main {
    public static void main(String[] args) {
        Logger logger = FileLogger.getInstance();
        logger.logEvent("Logging was successfully.");
    }
}