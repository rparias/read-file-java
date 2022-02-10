import java.util.List;

public class PersonWithDays {
    private String name;
    private List<String> daysOfWorking;

    public PersonWithDays(String name, List<String> daysOfWorking) {
        this.name = name;
        this.daysOfWorking = daysOfWorking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDaysOfWorking() {
        return daysOfWorking;
    }

    public void setDaysOfWorking(List<String> daysOfWorking) {
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
