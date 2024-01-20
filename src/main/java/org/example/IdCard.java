package org.example;

import java.time.LocalDate;

public class IdCard extends Card{

    private String town;
    private String height;
    private String id;
    private LocalDate deliveredDate;

    public void setDeliveredDate(LocalDate deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public void setTown(String town){
        this.town = town;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void displayIdCard(){
        System.out.print(" _________________________________________________\n");
        System.out.print("|");
        System.out.print("               REPUBLIC OF CAMEROON");
        System.out.print("              |\n\n");
        System.out.printf("     %s", this.id);
        System.out.printf("               %s\n", this.deliveredDate.toString());

        System.out.printf("     %s", this.getFirstName());
        System.out.printf("                         %s\n", this.getLastName());

        System.out.printf("     %s", this.getBirthDate());
        System.out.printf("                    %s\n", this.town);

        System.out.printf("     %s", this.getSex());
        System.out.printf("                           %s\n", this.height);

        System.out.print("|");
        System.out.print("                                                 |\n");
        System.out.print(" -------------------------------------------------\n");
    }

}
