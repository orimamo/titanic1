import java.io.File;
import java.lang.reflect.Array;

public class Passenger {
    private int passengerId;
    private int survived;
    private int pClass;
    private String name;
    private String sex;
    private int age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private int cabin;
    private String embarked;

    public Passenger(String passengerDetails) {
    build(passengerDetails);
    }
    public void build(String passengerDetails) {
        String[] data = passengerDetails.split(",");
        try {
            this.passengerId = Integer.valueOf(data[0]);
            this.survived = Integer.valueOf(data[1]);
            this.pClass = Integer.valueOf(data[2]);
            this.name = data[3] + "," + data[4];
            this.sex = data[5];
            this.age = Integer.valueOf(data[6]);
            this.sibSp = Integer.valueOf(data[7]);
            this.parch = Integer.valueOf(data[8]);
            this.ticket = data[9];
            this.fare = Double.valueOf(data[10]);
            this.cabin = Integer.valueOf(data[11]);
            this.embarked = data[12];
        } catch (NumberFormatException e) {
            this.cabin = 0;
        }
        this.name=getFormattedName(this.name);
    }


    public String getFormattedName(String name){
        String nameNew="";
        name=name.substring(1,name.length()-1);
        String[] firstName=name.split(",");
        String[] lastName=firstName[1].split("\\.");
        nameNew= lastName[1]+ " " + firstName[0];
        return nameNew;
    }
}
