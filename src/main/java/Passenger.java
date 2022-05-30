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

    public Passenger(String[] passengerDetails) {

    }
    public void build(String[] passengerDetails){
    this.passengerId=Integer.valueOf(passengerDetails[0]);
    this.survived=Integer.valueOf(passengerDetails[1]);
    this.pClass=Integer.valueOf(passengerDetails[2]);
    this.name=passengerDetails[3];
    this.sex=passengerDetails[4];
    this.age=Integer.valueOf(passengerDetails[5]);
    this.sibSp=Integer.valueOf(passengerDetails[6]);
    this.parch=Integer.valueOf(passengerDetails[7]);
    this.ticket=passengerDetails[8];
    this.fare=Double.valueOf(passengerDetails[9]);
    this.cabin=Integer.valueOf(passengerDetails[10]);
    this.embarked=passengerDetails[11];
    }


    public String getFormattedName(){
        String nameNew="";






        return nameNew;
    }

}
