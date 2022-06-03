import com.opencsv.CSVWriter;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {

    private JComboBox<String> survivedComboBox,genderComboBox,embakedrComboBox;
    private List<Passenger> passengerList,afterFilter;
    private int counter=0;

    public MainPanel (int x, int y, int width, int height) {
      File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
      this.passengerList=new ArrayList<Passenger>();
        try {
            Scanner scanner=new Scanner(file);
            int i=0;
            while (scanner.hasNextLine()){
                String passengerData = scanner.nextLine();
                if(i==0){
                    i++;
                }else {
//                    String passengerData = scanner.nextLine();
                    Passenger passenger1 = new Passenger(passengerData);
                    passengerList.add(passenger1);

                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


        this.setLayout(null);
        this.setBounds(x, y + Constants.MARGIN_FROM_TOP, width, height);
        //
        JLabel survivedLabel = new JLabel("Passenger Class: ");
        survivedLabel.setBounds(x + Constants.MARGIN_FROM_LEFT, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(survivedLabel);
        //
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        //
        JLabel numberOfPassengerLabel = new JLabel("Passenger number: ");
        numberOfPassengerLabel.setBounds(0,30,120,50);
        this.add(numberOfPassengerLabel);
        //
        JLabel minLabel = new JLabel("min passenger id: ");
        minLabel.setBounds(150,30,120,50);
        this.add(minLabel);
        //
        JLabel maxLabel = new JLabel("max passenger id:");
        maxLabel.setBounds(340,30,120,50);
        this.add(maxLabel);
        //
        JTextField min=new JTextField();
        min.setBounds(265,35,70,30);
        this.add(min);
        //
        JTextField max=new JTextField();
        max.setBounds(455,35,70,30);
        this.add(max);
        //
        JLabel nameLabel = new JLabel("name passenger :");
        nameLabel.setBounds(0,80,120,50);
        this.add(nameLabel);
        //
        JTextField name=new JTextField();
        name.setBounds(120,85,70,30);
        this.add(name);
        //
        JLabel genderLabel = new JLabel("gender passenger :");
        genderLabel.setBounds(0,120,130,50);
        this.add(genderLabel);
        //
        this.genderComboBox = new JComboBox<>(Constants.PASSENGER_GENDER_OPTIONS);
        this.genderComboBox.setBounds(130,125, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.genderComboBox);
        //
        JLabel sibSpLabel = new JLabel("amount passenger brother:");
        sibSpLabel.setBounds(0,150,160,50);
        this.add(sibSpLabel);

        JTextField sibSp=new JTextField();
        sibSp.setBounds(165,160,70,30);
        this.add(sibSp);
        //
        JLabel parchLabel = new JLabel("amount passenger brother:");
        parchLabel.setBounds(0,150,160,50);
        this.add(parchLabel);

        JTextField parch=new JTextField();
        parch.setBounds(165,160,70,30);
        this.add(parch);
        //
        JLabel ticketLabel = new JLabel("passenger ticket:");
        ticketLabel.setBounds(0,200,160,50);
        this.add(ticketLabel);

        JTextField ticket=new JTextField();
        ticket.setBounds(165,200,70,30);
        this.add(ticket);
        //
        JLabel fareLabel = new JLabel("Passenger ticket price: ");
        fareLabel.setBounds(0,250,150,50);
        this.add(fareLabel);
        //
        JLabel minPriceLabel = new JLabel("min ticket pirce: ");
        minPriceLabel.setBounds(135,250,120,50);
        this.add(minPriceLabel);
        //
        JLabel maxPriceLabel = new JLabel("max ticket pirce:");
        maxPriceLabel.setBounds(340,250,120,50);
        this.add(maxPriceLabel);
        //
        JTextField minPrice=new JTextField();
        minPrice.setBounds(265,255,70,30);
        this.add(minPrice);
        //
        JTextField maxPrice=new JTextField();
        maxPrice.setBounds(455,255,70,30);
        this.add(maxPrice);
        //
        JLabel cabinLabel = new JLabel("passenger cabin:");
        cabinLabel.setBounds(0,290,120,50);
        this.add(cabinLabel);
        //
        JTextField cabin=new JTextField();
        cabin.setBounds(150,295,70,30);
        this.add(cabin);
        //
        JLabel embakedrLabel = new JLabel("passenger embarked:");
        embakedrLabel.setBounds(0,330,130,50);
        this.add(embakedrLabel);
        //
        this.embakedrComboBox = new JComboBox<>(Constants.PASSENGER_EMBARKED_OPTIONS);
        this.embakedrComboBox.setBounds(135,340, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.embakedrComboBox);
        //
        JButton filter=new JButton("filter");
        filter.setBounds(50,400,100,40);
        this.add(filter);
        //
        JLabel totalRowLabel = new JLabel("");
        totalRowLabel.setBounds(160,400,250,50);
        this.add(totalRowLabel);
        //
        JButton statistic=new JButton("create statistic file");
        statistic.setBounds(50,450,200,40);
        this.add(statistic);
        //
        this.survivedComboBox.addActionListener((e) -> {
            String s=(String) survivedComboBox.getSelectedItem();
            List<Passenger> afterFilter1=new ArrayList<>();
            switch (s){
                case "All":
                {
                    afterFilter1=this.passengerList;


                }
                case "1st":{
                    afterFilter1=filterByClass("1st",this.passengerList);

                }
                case "2st":{
                    afterFilter1=filterByClass("2st",this.passengerList);

                }
                case "3st":{
                    afterFilter1=filterByClass("3st",this.passengerList);
                }
            }

        });
        //

            this.genderComboBox.addActionListener((e) -> {
                String s = (String) genderComboBox.getSelectedItem();
                List<Passenger> afterFilter1 = new ArrayList<>();
                switch (s) {
                    case "All": {
                        afterFilter1=this.passengerList;
                        break;

                    }
                    case "male": {
                        afterFilter1 = filterByGender("male",this.passengerList);
                        break;
                    }
                    case "female": {
                        afterFilter1 = filterByGender("female",this.passengerList);
                        break;
                    }

                }

            });
        this.embakedrComboBox.addActionListener((e) -> {
            String s = (String) embakedrComboBox.getSelectedItem();
            List<Passenger> afterFilter1 = new ArrayList<>();
            switch (s) {
                case "All": {
                    afterFilter1=this.passengerList;
                    break;

                }
                case "C": {
                    afterFilter1 = filterByEmbarked("C",this.passengerList);
                    break;
                }
                case "S": {
                    afterFilter1 = filterByEmbarked("S",this.passengerList);
                    break;
                }
                case "Q": {
                    afterFilter1 = filterByEmbarked("Q",this.passengerList);
                    break;
                }

            }

        });
        filter.addActionListener((event)->{
            try {
                afterFilter = filterByClass((String) this.survivedComboBox.getSelectedItem(), this.passengerList);
                afterFilter = filterByPassengerId(min.getText(), max.getText(), afterFilter);
                afterFilter = searchName(name.getText(), afterFilter);
                afterFilter = filterByGender((String) genderComboBox.getSelectedItem(), afterFilter);
                afterFilter = searchSibSp(sibSp.getText(), afterFilter);
                afterFilter = searchParch(parch.getText(), afterFilter);
                afterFilter = searchTicket(ticket.getText(), afterFilter);
                afterFilter = searchFare(minPrice.getText(), maxPrice.getText(), afterFilter);
                afterFilter = searchCabin(cabin.getText(), afterFilter);
                afterFilter = filterByEmbarked((String) embakedrComboBox.getSelectedItem(), afterFilter);
                counter++;
                totalRowLabel.setText(totalRows(afterFilter));
                writeToCsvFile(afterFilter,counter);
                System.out.println(afterFilter);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
        statistic.addActionListener((event)->{
            try {
                String statistics="";
                statistics=statistics+classStatic(afterFilter) + "\n-------------";
                statistics=statistics+genderStatic(afterFilter) + "\n-------------";
                statistics=statistics+ageStatic(afterFilter) + "\n------------";
//                statistics=statistics+staticParchSibSp(afterFilter) + "\n-----------";


                writeToTxtFile(statistics);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });

    }
    public List<Passenger> filterByClass(String level,List<Passenger> passengerList){
        List<Passenger> afterFilter=new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (level.equals("1st")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getpClass() == 1).collect(Collectors.toList());
            } else if (level.equals("2st")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getpClass() == 2).collect(Collectors.toList());
            } else if (level.equals("3st")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getpClass() == 3).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }

        return afterFilter;
    }

    public List<Passenger> filterByPassengerId(String min,String max,List<Passenger> passengerList){
        List<Passenger> afterFilter=new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (!min.equals("") && !max.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getPassengerId() > Integer.valueOf(min) && passenger.getPassengerId() < Integer.valueOf(max)).collect(Collectors.toList());
            } else if (!min.equals("") && max.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getPassengerId() > Integer.valueOf(min)).collect(Collectors.toList());
            } else if (min.equals("") && !max.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getPassengerId() < Integer.valueOf(max)).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }

    public List<Passenger> filterByGender(String gender,List<Passenger> passengerList){
        List<Passenger> afterFilter=new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (gender.equals("male")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getSex().equals("male")).collect(Collectors.toList());
            } else if (gender.equals("female")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getSex().equals("female")).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }
    public List<Passenger> searchName(String name,List<Passenger> passengerList){
        List<Passenger> afterFilter=new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (!name.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getName().contains(name)).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;

            }
        }
        return afterFilter;
    }
    //SibSp
    public List<Passenger> searchSibSp(String numSibSp,List<Passenger> passengerList){
        List<Passenger> afterFilter=new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (!numSibSp.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getSibSp() == Integer.valueOf(numSibSp)).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }
    //Parch
    public List<Passenger> searchParch(String numParch,List<Passenger> passengerList) {
        List<Passenger> afterFilter = new ArrayList<>();
        if (!passengerList.isEmpty()) {

            if (!numParch.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getParch() == Integer.valueOf(numParch)).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }
    //Ticket
    public List<Passenger> searchTicket(String numTicket,List<Passenger> passengerList){
        String strNumTicket = ""+numTicket;
        List<Passenger> afterFilter=new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (!numTicket.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getTicket().contains(strNumTicket)).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }
    //Cabin
    public List<Passenger> searchCabin(String numCabin,List<Passenger> passengerList) {
        String strNumCabin = "" + numCabin;
        List<Passenger> afterFilter = new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (!numCabin.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getCabin().contains(strNumCabin)).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }

    public List<Passenger> filterByEmbarked(String embarked,List<Passenger> passengerList) {
        List<Passenger> afterFilter = new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (embarked.equals("C")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getEmbarked() == "C").collect(Collectors.toList());
            } else if (embarked.equals("S")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getEmbarked() == "S").collect(Collectors.toList());
            } else if (embarked.equals("Q")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getEmbarked() == "Q").collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }
    //priceTicket
    public List<Passenger> searchFare(String minFare , String maxFare,List<Passenger> passengerList){
        List<Passenger> afterFilter=new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (maxFare.equals("") && !minFare.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getFare() > Double.valueOf(minFare)).collect(Collectors.toList());
            } else if (minFare.equals("") && !maxFare.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getFare() < Double.valueOf(maxFare)).collect(Collectors.toList());
            } else if (!minFare.equals("") && !maxFare.equals("")) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getFare() > Double.valueOf(minFare) && passenger.getFare() < Double.valueOf(maxFare)).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }
    public String totalRows(List<Passenger> passengers){
        String totalRows = "Total Rows: " + passengers.size() + " (";
        int survive = survive(passengers);
        int notSurvive = passengers.size()-survive;
        totalRows = totalRows + survive + " survived, "+notSurvive+" did not)";
        return totalRows;
    }

    public int survive (List<Passenger> passengers){
        int counter=0;
        for (Passenger p:passengers) {
            if (p.getSurvived()==1){
                counter++;
            }
        }
        return counter;
    }

    //statistics
    public String statisticsByPclass(List<Passenger> passengers , int pclass ){
        String statis = "";
        int survive = survive(passengers);
        List<Passenger> after = filterByClass(String.valueOf(pclass),passengers);
        double precentSurviveByClass  = survive/after.size()*100;
        statis = statis+ precentSurviveByClass ;
        return statis;
    }
    public String classStatic (List<Passenger> passengers ){
        String firstClass = "First class is: " + statisticsByPclass(passengers,1);
        String secondClass = "Second class is: " + statisticsByPclass(passengers,2);
        String thirdClass = "Third class is: " + statisticsByPclass(passengers,3);
        return ("Survival rates in the : \n" +
                firstClass+"\n" + secondClass + "\n"+thirdClass);
    }

    public double statisticsByGender(List<Passenger> passengers , String gender ){
        int survive = survive(passengers);
        List<Passenger> after = filterByGender(gender,passengers);
        double precentSurviveByGender  = survive/after.size()*100;
        return precentSurviveByGender;
    }
    public String genderStatic (List<Passenger> passengers ){
        double maleStatis = statisticsByGender(passengers,"male");
        String maleStatic = "Males is: " + maleStatis+ "%";
        String femaleStatic = "Female is: " + (100 - maleStatis) + "%";
        return("Survival rates : \n" +
                maleStatic+ "\n"+femaleStatic);
    }
    // filter by age
    public List<Passenger> searchAge(int fromAge , Integer toAge){
        List<Passenger> afterFilter=new ArrayList<>();
        if (toAge!= null) {
            afterFilter = this.passengerList.stream().filter(passenger -> passenger.getAge() > fromAge && passenger.getAge() < toAge).collect(Collectors.toList());
        }else {
            afterFilter = this.passengerList.stream().filter(passenger -> passenger.getAge() > fromAge).collect(Collectors.toList());
        }
        return afterFilter;
    }
    public String ageStat(String numGroup , int from ,Integer to){
        String present = "Group "+numGroup+" age "+from;
        if (to ==null){
            double group = survive(searchAge(from,to))/searchAge(from,to).size()*100;
            present = present+"+: " + group+ "%";
        }else{
            double group = survive(searchAge(from,to))/searchAge(from,to).size()*100;
            present = present+"-"+to+": " + group+ "%";
        }

        return present;
    }

    public String ageStatic (List<Passenger> passengers ){
        return
                ("Percentage of Survivors by Age Groups: \n" +
                ageStat("one", 0 , 10)+ "\n"+
                ageStat("two", 11 , 20)+ "\n"+
                ageStat("three", 21 , 30)+ "\n"+
                ageStat("four", 31 , 40)+ "\n"+
                ageStat("five", 41 , 50)+ "\n"+
                ageStat("six", 51 , null));
    }

    public static void writeToCsvFile(List<Passenger> passengers, int counter) throws IOException {
        String path="C:\\Users\\mori8\\Desktop\\" + counter + ".csv";
        File filteredFile =new File(path);
        FileWriter outputFile = new FileWriter(filteredFile);
        CSVWriter writer=new CSVWriter(outputFile);
        List<String[]> x=new LinkedList<>();
        String menuBar="PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked";
        String[] menuBarArray=menuBar.split(",");
        x.add(menuBarArray);
        for (int i=0;i<passengers.size();i++) {
            String[] s=new String[12];
            Passenger passenger= passengers.get(i);
            s[0]=String.valueOf( passenger.getPassengerId());
            s[1]=String.valueOf( passenger.getSurvived());
            s[2]=String.valueOf( passenger.getpClass());
            s[3]=passenger.getName();
            s[4]=passenger.getSex();
            s[5]=String.valueOf( passenger.getAge());
            s[6]=String.valueOf(passenger.getSibSp());
            s[7]=String.valueOf( passenger.getParch());
            s[8]=String.valueOf( passenger.getTicket());
            s[9]=String.valueOf( passenger.getFare());
            s[10]=String.valueOf( passenger.getCabin());
            s[11]=String.valueOf( passenger.getEmbarked());
            x.add(s);
        }
        writer.writeAll(x);
        writer.close();
    }
    public static void writeToTxtFile(String text) throws IOException {
        try {
            FileWriter fWriter = new FileWriter("C:\\Users\\mori8\\Desktop\\Statistics.txt");
            fWriter.write(text);
            fWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //SibSp && Parch
    public List<Passenger> searchSibSpParch(List<Passenger> passengers){
        List<Passenger> afterFilter=new ArrayList<>();
        for (Passenger p : passengerList) {
            if (p.getSibSp()>0 || p.getParch()>0) {
                afterFilter.add((Passenger) this.passengerList);
            }
        }
        return afterFilter;
    }
    public String staticParchSibSp(List<Passenger> passengers){
        double precentBySibspParch =(survive(searchSibSpParch(passengers))/passengers.size()*100);
        return ("Percentage of survivors among those who had at least one relative on board is: "+precentBySibspParch + "%"
                +"\n"+"Percentage of survivors among those who had no relatives is: " + (100-precentBySibspParch) + "%");
    }

}
