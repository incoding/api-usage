package com.javaapi.test.buisness.pattern.ext.strategy;

import java.util.HashMap;
import java.util.Map;

public class CarStrategyTest {


    public static void main(String[] args) {
        CarStragy carStragy = new CarStragy();
        carStragy.getCar("truck").run();
        carStragy.getCar("waggon").run();
    }

    public static class CarStragy {

        public static final Map<String, Car> carMap = new HashMap<>(16);

        static {
            carMap.put("truck", new Truck());
            carMap.put("waggon", new Waggon());
        }

        public static Car getCar(String car) {
            Car carImpl = carMap.get(car);
            if (carImpl == null) {
                throw new IllegalStateException("参数错误");
            }
            return carImpl;
        }

        public interface Car {
            void run();
        }

        public static class Truck implements Car {
            public void run() {
                System.out.println("Truck running");
            }
        }

        public static class Waggon implements Car {
            public void run() {
                System.out.println("Waggon running");
            }
        }

    }

}
