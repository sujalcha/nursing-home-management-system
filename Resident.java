
package nursinghome;

/**
 *
 * @author Sujal Shrestha
 */
public class Resident {

    String name;
    String age;
    String condition;

    public Resident(){}

    public Resident(String name, String age, String condition){
        this.name = name;
        this.age = age;
        this.condition = condition;
        
    }

    public String getname() {
        return name;
    }

    public String getage() {
        return age;
    }

    public String getcondition() {
        return condition;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setage(String age) {
        this.age = age;
    }
    
    public String toString(){
    return "\t"+this.name + "\t\t\t" + this.age + "\t\t\t" + this.condition;
}
    
    public String toStringdoc(){
    return this.name + "," + this.age + "," + this.condition;
}

     
}
    
