import java.time.LocalDate;
import java.util.List;

public class Administrator extends Personnel implements Manageable{
    List<String> projects;
    List<Personnel> teamMembers;

    Administrator(String name, LocalDate bithday, float salary, List<String> projects, List<Personnel> teamMembers){
        super(name, bithday, salary);
        this.projects = projects;
        this.teamMembers = teamMembers;
    }

    public String toString(){
        String str = super.toString();
        str = String.format("%s, подчинённых: %d", str, this.teamMembers.size());
        
        if (this.projects.size() > 0){
            str = String.format("%s, проекты: %s", str, String.join(", ", this.projects));
        }
        return str;
    }

    public void paySalary(){
        super.paySalary();
        if(this.projects.size() > 1){
            System.out.printf("Надбавка %.02f\n", this.salary*0.25*(this.projects.size()-1));
        }
    }

    public void manage(){
        System.out.printf("%s начал управлять\n", this.name);
    }

    public List<String> getProjects(){
        return this.projects;
    }

    public List<Personnel> getTeamMembers(){
        return this.teamMembers;
    }

    public void setProjects(List<String> value){
        this.projects = value;
    }

    public void setTeamMembers(List<Personnel> value){
        this.teamMembers = value;
    }
}
