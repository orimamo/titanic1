import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainPanel extends JPanel {

    private JComboBox<String> survivedComboBox,genderComboBox;
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
        min.setBounds(265,30,70,50);
        this.add(min);
        //
        JTextField max=new JTextField();
        max.setBounds(455,30,70,50);
        this.add(max);
        //
        this.survivedComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.survivedComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.survivedComboBox);
        //
        this.genderComboBox = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.genderComboBox.setBounds(survivedLabel.getX() + survivedLabel.getWidth() + 1, survivedLabel.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.genderComboBox);
        //
        this.survivedComboBox.addActionListener((e) -> {
            String s=(String) survivedComboBox.getSelectedItem();
            List<Passenger> afterFilter1=new ArrayList<>();
            switch (s){
                case "All":
                {
                    break;

                }
                case "1st":{
                    afterFilter1=filter(1);
                    break;
                }
                case "2st":{
                    afterFilter1=filter(2);
                    break;
                }
                case "3st":{
                    afterFilter1=filter(3);
                    break;
                }
            }

        });
        //
        this.survivedComboBox.addActionListener((e) -> {
            String s=(String) survivedComboBox.getSelectedItem();
            List<Passenger> afterFilter1=new ArrayList<>();
            switch (s){
                case "All":
                {
                    break;

                }
                case "1st":{
                    afterFilter1=filter(1);
                    break;
                }
                case "2st":{
                    afterFilter1=filter(2);
                    break;
                }
                case "3st":{
                    afterFilter1=filter(3);
                    break;
                }
            }

        });
    }
    public List<Passenger> filter(int level){
        List<Passenger> afterFilter=new ArrayList<>();
        if (level == 1) {
            afterFilter=this.passengerList.stream().filter(passenger -> passenger.getpClass()==1).collect(Collectors.toList());
            System.out.println(afterFilter);
            try {
                write(afterFilter);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        if (level == 2) {
            afterFilter=this.passengerList.stream().filter(passenger -> passenger.getpClass()==2).collect(Collectors.toList());
            System.out.println(afterFilter);
        }
        if (level == 3) {
            afterFilter=this.passengerList.stream().filter(passenger -> passenger.getpClass()==3).collect(Collectors.toList());
            System.out.println(afterFilter);
        }
        return afterFilter;
    }

    public List<Passenger> filterByPassengerId(int min,int max){
        List<Passenger> afterFilter=new ArrayList<>();
        afterFilter=this.passengerList.stream().filter(passenger -> passenger.getPassengerId()>min && passenger.getPassengerId()<max).collect(Collectors.toList());
        return afterFilter;

    }

    public static void write(List<Passenger> list) throws IOException {
        File filteredFile =new File("/Users/ranhazan/Desktop/filteredFile.csv");
        FileWriter outputFile = new FileWriter(filteredFile);
        CSVWriter writer=new CSVWriter(outputFile);
        List<String[]> x=new LinkedList<>();
        String menuBar="PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked";
        String[] menuBarArray=menuBar.split(",");
        x.add(menuBarArray);
        for (int i=0;i<list.size();i++) {
            String[] s=new String[12];
            Passenger passenger= list.get(i);
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



}
