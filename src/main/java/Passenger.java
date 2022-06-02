import javax.management.StringValueExp;
import java.io.File;
import java.lang.invoke.StringConcatException;
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
    private String cabin;
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
            this.cabin = data[11];
            this.embarked = data[12];
        } catch (Exception e) {
            this.cabin = "";
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

    public int getPassengerId() {
        return passengerId;
    }

    public int getSurvived() {
        return survived;
    }

    public int getpClass() {
        return pClass;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public int getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public double getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public String getEmbarked() {
        return embarked;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public void setpClass(int pClass) {
        this.pClass = pClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSibSp(int sibSp) {
        this.sibSp = sibSp;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                passengerId +
                "," + survived +
                "," + pClass +
                "," + name + '\'' +
                "," + sex + '\'' +
                ",=" + age +
                "," + sibSp +
                "," + parch +
                "," + ticket + '\'' +
                "," + fare +
                "," + cabin +
                "," + embarked + '\'' +
                '}'+ "\n";
    }
}
