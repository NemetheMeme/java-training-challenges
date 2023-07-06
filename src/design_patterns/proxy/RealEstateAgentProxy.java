package design_patterns.proxy;

import java.util.ArrayList;
import java.util.List;

public class RealEstateAgentProxy {

    private List<Apartment> apartments = new ArrayList<>();

    public RealEstateAgentProxy() {
    }

    protected void represent(Apartment apartment){
        apartments.add(apartment);
    }

    protected Apartment rent(Student student, Apartment apartmentToBeRented){

        Apartment rentedApartment = null;
            if(apartments.contains(apartmentToBeRented)){
                if(
                        student.getName().startsWith("P") ||  //  student's name starts with P
                        apartmentToBeRented.isRented() ||  // apartment is already rented
                        student.getMoney() < apartmentToBeRented.getMonthlyRentCost()){  // student can't afford the apartment

                                System.out.println("The agent won't rent this place to " + student.getName());
            }

             else{

                  apartmentToBeRented.setRented(true);
                  apartmentToBeRented.setRentedBy(student);

                  System.out.println("The agent rented this place to " +  student.getName());

                  rentedApartment = apartmentToBeRented;

                 }
            }
            else{
                System.out.println("Apartment " + apartmentToBeRented + " is not owned by the agent!");
            }

        return rentedApartment;
    }
}
