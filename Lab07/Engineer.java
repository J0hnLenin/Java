import java.time.LocalDate;

public class Engineer extends Worker {
    protected String qualification;
    
    Engineer(String name, LocalDate bithday, float salary, Boolean harmfulness, String qualification){
        super(name, bithday, salary, harmfulness);
        this.qualification = qualification;
    }
    
    public String toString(){
        String str = super.toString();
        if (this.qualification != null){
            str = String.format("%s, квалификация: %s", str, this.qualification);
        } 
        return str;
    }

    public void paySalary(){
        super.paySalary();
        if (this.qualification != null){
            System.out.printf("Надбавка за квалификацию %.2f,", this.salary*0.5);
        }
    }
    
    public String getQualification(){
        return this.qualification;
    }

    public void setQualification(String value){
        this.qualification = value;
    }
}
