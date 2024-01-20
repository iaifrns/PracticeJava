package org.example;

import java.time.LocalDate;

public class CarLicenceCard extends Card{

    private String town;
    private String category;
    private String id;
    private LocalDate deliveredDate;

    public void setDeliveredDate(LocalDate deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void displayLicenceCard(){
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
        System.out.printf("                           %s\n", this.category);

        System.out.printf("     %s\n", this.getOccupation());

        System.out.print("|");
        System.out.print("                                                 |\n");
        System.out.print(" -------------------------------------------------\n");
    }

}
