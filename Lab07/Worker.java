import java.time.LocalDate;

public class Worker extends Personnel implements Workable {
    protected Boolean harmfulness;
    
    Worker(String name, LocalDate bithday, float salary, Boolean harmfulness){
        super(name, bithday, salary);
        this.harmfulness = harmfulness;
    }

    public String toString(){
        String str = super.toString();
        if (this.harmfulness){
            str = String.format("%s, вредность", str);
        } 
        return str;
    }

    public void paySalary(){
        super.paySalary();
        if(this.harmfulness){
            System.out.println("Выдано молоко за вредность");
        }
    }

    public void work(){
        System.out.printf("%s начал работать\n", this.name);
    }

    public Boolean getHarmfulness(){
        return this.harmfulness;
    }

    public void setHarmfullness(Boolean value){
        this.harmfulness = value;
    }
}
