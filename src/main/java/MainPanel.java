import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {

    private JComboBox<String> survivedComboBox,genderComboBox,embakedrComboBox;
    private List<Passenger> passengerList;

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
        JLabel minPriceLabel = new JLabel("min passenger id: ");
        minPriceLabel.setBounds(135,250,120,50);
        this.add(minPriceLabel);
        //
        JLabel maxPriceLabel = new JLabel("max passenger id:");
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
        filter.setBounds(50,400,100,100);
        this.add(filter);
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
            List<Passenger> afterFilter=new ArrayList<>();
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
                System.out.println(afterFilter);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });

    }
    public List<Passenger> filterByClass(String level,List<Passenger> passengerList){
        List<Passenger> afterFilter=new ArrayList<>();
        if (!passengerList.isEmpty()) {
            if (level == "1st") {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getpClass() == 1).collect(Collectors.toList());
            } else if (level == "2st") {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getpClass() == 2).collect(Collectors.toList());
            } else if (level == "3st") {
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
            if (min != " " && max != " ") {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getPassengerId() > Integer.valueOf(min) && passenger.getPassengerId() < Integer.valueOf(max)).collect(Collectors.toList());
            } else if (min != " " && max == " ") {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getPassengerId() > Integer.valueOf(min)).collect(Collectors.toList());
            } else if (min == " " && max != " ") {
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
            if (gender == "male") {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getSex().equals("male")).collect(Collectors.toList());
            } else if (gender == "female") {
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
            if (name != "") {
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
            if (numSibSp != "") {
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

            if (numParch != "") {
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
            if (numTicket != "") {
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
            if (numCabin != "") {
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
            if (embarked != "") {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getCabin().contains(embarked)).collect(Collectors.toList());
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
            if (maxFare == "" && minFare != "" ) {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getFare() > Double.valueOf(minFare)).collect(Collectors.toList());
            } else if (minFare == "" && maxFare != "") {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getFare() < Double.valueOf(maxFare)).collect(Collectors.toList());
            } else if (minFare != "" && maxFare != "") {
                afterFilter = passengerList.stream().filter(passenger -> passenger.getFare() > Double.valueOf(minFare) && passenger.getFare() < Double.valueOf(maxFare)).collect(Collectors.toList());
            } else {
                afterFilter = passengerList;
            }
        }
        return afterFilter;
    }


}
