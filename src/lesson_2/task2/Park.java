package lesson_2.task2;

public class Park {

    private String name;
    private Attraction attraction;

    public Park(String name, String attractionName, String workingHours, double cost) {
        this.name = name;
        this.attraction = new Attraction(attractionName, workingHours, cost);
    }

    public void displayAttractionInfo() {
        System.out.println("Парк: " + name);
        System.out.println("Информация об аттракционе:");
        System.out.println("Название: " + attraction.getName());
        System.out.println("Время работы: " + attraction.getWorkingHours());
        System.out.println("Стоимость: " + attraction.getCost());
    }

    private class Attraction {
        private String name;
        private String workingHours;
        private double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public double getCost() {
            return cost;
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Развлекательный парк", "Колесо обозрения", "с 10:00 до 22:00", 500.0);
        park.displayAttractionInfo();
    }
}
