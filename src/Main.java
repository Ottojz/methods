import java.time.LocalDate;

public class Main {

    public static boolean checkLeap (short year) {
        boolean leapYear = false;

        if (year >= 1584 && (year - 1584) % 4 == 0) {
            if ((year - 1584) % 100 == 0) {
                if ((year - 1584) % 400 == 0) {
                    leapYear = true;
                } else {
                    leapYear = false;
                }
            } else {
                leapYear = true;
            }
        }
        return leapYear;
    }

    public static void checkOS (byte clientOS, short clientDeviceYear) {

        boolean oldDevice;
        if (clientDeviceYear < LocalDate.now().getYear()) {
            oldDevice = true;
        } else if (clientDeviceYear == LocalDate.now().getYear()) {
            oldDevice = false;
        } else {
            throw new RuntimeException ("Дата выпуска устройства еще не наступила");
        }

        boolean iOS;
        if (clientOS == 0) {
            iOS = true;
        } else if (clientOS == 1) {
            iOS = false;
        } else {
            throw new RuntimeException ("Неизвестная ОС");
        }

        if (oldDevice == false && iOS == true) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (oldDevice == false && iOS == false) {
            System.out.println("Установите версию для Android по ссылке");
        } else if (oldDevice == true && iOS == true) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else if (oldDevice == true && iOS == false) {
            System.out.println("Установите облегченную версию для Android по ссылке");
        }
    }

    public static byte countPeriod (byte deliveryDistance) {

        byte deliveryTerm = 1;

        if (deliveryDistance <= 20) {
            deliveryTerm = deliveryTerm;
        } else if (deliveryDistance <= 60) {
            deliveryTerm = (byte) (deliveryTerm + 1);
        } else if (deliveryDistance <= 100) {
            deliveryTerm = (byte) (deliveryTerm + 2);
        } else {
            deliveryTerm = (byte) (deliveryTerm - 1);
        }
        return deliveryTerm;
    }

    public static void main(String[] args) {

        System.out.println();
        //task 1
        System.out.println("task 1");
        System.out.println();

        short year = 2084;

        if (checkLeap(year)) {
            System.out.println(year + " год - високосный");
        } else {
            System.out.println(year + " год - не високосный");
        }

        System.out.println();
        //task 2
        System.out.println("task 2");
        System.out.println();

        byte OS = 1;
        short deviceYear = 2020;

        checkOS(OS, deviceYear);

        System.out.println();
        //task 3
        System.out.println("task 3");
        System.out.println();

        byte distance = 95;

        if (distance <= 100) {
            System.out.println("Потребуется дней: " + countPeriod(distance));
        } else {
            System.out.println("Доставка не осуществляется");
        }
    }
}