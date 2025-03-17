import java.util.concurrent.ThreadLocalRandom;


class Task1 {
    final double ABS_ZERO = -1000000;
    
    class Month{
        public String name;
        public int length;
        public double temperatureSum = 0;
        public int numberNegativeTemperature = 0;
        public double minTemperature = -ABS_ZERO;
        public double maxTemperatureThirdDecade = ABS_ZERO;
        public Month(String name, int length){
            this.name = name;
            this.length = length;
        }
        public double averageTemperature(){
            return this.temperatureSum / this.length;
        }
    }
    final Month[] months = {
        new Month("Январь", 31),
        new Month("Февраль", 28),
        new Month("Март", 31),
        new Month("Апрель", 30),
        new Month("Май", 31),
        new Month("Июнь", 30),
        new Month("Июль", 31),
        new Month("Август", 31),
        new Month("Сентябрь", 30),
        new Month("Октябрь", 31),
        new Month("Ноябрь", 30),
        new Month("Декабрь", 31),
    };
    public void main(String[] args) {
        final int N = 365;
        double [] t = new double[N];
        int currentMonthID = 0;
        int currentDay = 0;
        Month currentMonth = months[currentMonthID];

        // Определите название месяца с максимальной среднемесячной температурой
        double maxAverageTemperature = ABS_ZERO;
        Month maxAverageTemperatureMonth = currentMonth;

        // Определите название месяца с наибольшим количеством отрицательных температур
        int maxNumberNegativeTemperature = 0;
        Month maxNumberNegativeTemperatureMonth = currentMonth;

        // Определите название месяца с минимальной годовой температурой
        double minTemperature = -ABS_ZERO;
        Month minTemperatureMonth = currentMonth;

        // Определите название месяца с максимальной температурой в третьей декаде
        double maxTemperatureThirdDecade = ABS_ZERO;
        Month maxTemperatureThirdDecadeMonth = currentMonth;

        for (int i = 0; i < N; i++){
            t[i] = ThreadLocalRandom.current().nextDouble(-30, 30);
            //t[i] += 40 - abs(i-200)/4;
            currentDay++;
            currentMonth.temperatureSum += t[i];
            if (t[i] < 0){
                currentMonth.numberNegativeTemperature++;
            }
            if(t[i] < currentMonth.minTemperature){
                currentMonth.minTemperature = t[i];
            }
            if(currentDay > 20 && t[i] > currentMonth.maxTemperatureThirdDecade){
                currentMonth.maxTemperatureThirdDecade = t[i];
            }
            if(currentDay == currentMonth.length){
                if (currentMonth.averageTemperature() > maxAverageTemperature){
                    maxAverageTemperature = currentMonth.averageTemperature();
                    maxAverageTemperatureMonth = currentMonth;
                }
                if (currentMonth.numberNegativeTemperature > maxNumberNegativeTemperature){
                    maxNumberNegativeTemperature = currentMonth.numberNegativeTemperature;
                    maxNumberNegativeTemperatureMonth = currentMonth;
                }
                if (currentMonth.minTemperature < minTemperature){
                    minTemperature = currentMonth.minTemperature;
                    minTemperatureMonth = currentMonth;
                }
                if (currentMonth.maxTemperatureThirdDecade > maxTemperatureThirdDecade){
                    maxTemperatureThirdDecade = currentMonth.maxTemperatureThirdDecade;
                    maxTemperatureThirdDecadeMonth = currentMonth;
                }
                currentMonthID++;
                if (currentMonthID < 12){
                    currentMonth = months[currentMonthID];
                    currentDay = 0;
                }
            }
        }
        System.out.printf(
            "Максимальная среднемесячная температура %.02f в %s \n", 
            maxAverageTemperature,
            maxAverageTemperatureMonth.name);
        System.out.printf(
            "Наибольшее количество отрицательных температур %d в %s \n", 
            maxNumberNegativeTemperature,
            maxNumberNegativeTemperatureMonth.name);
        System.out.printf(
            "Минимальная годовая температура %.02f в %s \n", 
            minTemperature,
            minTemperatureMonth.name);
        System.out.printf(
            "Максимальная температура третей декады %.02f в %s \n", 
            maxTemperatureThirdDecade,
            maxTemperatureThirdDecadeMonth.name);
    }
}