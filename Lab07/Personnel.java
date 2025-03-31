import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Personnel {
    protected String name;
    protected LocalDate bithday;
    protected LocalDate employmentDate;
    protected LocalDate dismissalDate;
    protected float salary;

    Personnel(String name, LocalDate bithday){
        this.name = name;
        this.bithday = bithday;
    }

    Personnel(String name, LocalDate bithday, float salary){
        this(name, bithday);
        this.employmentDate = LocalDate.now();
        this.salary = salary;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String bithdayString = this.bithday.format(formatter);
        return String.format("%s %s, зарплата: %.02f руб", name, bithdayString, salary);
    }

    public void paySalary(){
        System.out.printf("Выплачено %.2f руб\n", this.salary);
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getBithday(){
        return this.bithday;
    }

    public LocalDate getEmploymentDate(){
        return this.employmentDate;
    }

    public LocalDate getDismissalDate(){
        return this.dismissalDate;
    }

    public float getSalary(){
        return this.salary;
    }

    public void setName(String value){
        this.name = value;
    }

    public void setBithday(LocalDate value){
        this.bithday = value;
    }

    public void setEmploymentDate(LocalDate value){
        this.employmentDate = value;
    }

    public void setDismissalDate(LocalDate value){
        this.dismissalDate = value;
    }

    public void setSalary(float value){
        this.salary = value;
    }
}
