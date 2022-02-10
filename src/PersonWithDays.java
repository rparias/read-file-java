import java.util.Map;

public class PersonWithDays {
    private String name;
    private Map<String, TimeWorked> daysOfWorking;

    public PersonWithDays(String name, Map<String, TimeWorked> daysOfWorking) {
        this.name = name;
        this.daysOfWorking = daysOfWorking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, TimeWorked> getDaysOfWorking() {
        return daysOfWorking;
    }

    public void setDaysOfWorking(Map<String, TimeWorked> daysOfWorking) {
        this.daysOfWorking = daysOfWorking;
    }

    @Override
    public String toString() {
        return "PersonWithDays{" +
                "name='" + name + '\'' +
                ", daysOfWorking=" + daysOfWorking +
                '}';
    }
}
