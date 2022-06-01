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

    private JComboBox<String> survivedComboBox;
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

    }
    public List<Passenger> filter(int level){
        List<Passenger> afterFilter=new ArrayList<>();
        if (level == 1) {
            afterFilter=this.passengerList.stream().filter(passenger -> passenger.getpClass()==1).collect(Collectors.toList());
            System.out.println(afterFilter);
        }
        if (level == 2) {
            afterFilter=this.passengerList.stream().filter(passenger -> passenger.getpClass()==2).collect(Collectors.toList());
        }
        if (level == 3) {
            afterFilter=this.passengerList.stream().filter(passenger -> passenger.getpClass()==3).collect(Collectors.toList());
        }
        return afterFilter;
    }

}
