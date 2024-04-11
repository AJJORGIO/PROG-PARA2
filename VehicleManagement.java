import java.util.*;
public class VehicleManagement {
   public static void main(String[] args) {
      ArrayList<Vehicle> vehicleList = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      int choice;
      do {
         try {
            System.out.println("\nMenu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
               case 1:
                  addVehicle(vehicleList, scanner);
                  break;
               case 2:
                  displayVehicleList(vehicleList);
                  break;
               case 3:
                  deleteVehicle(vehicleList, scanner);
                  break;
               case 4:
                  // sort vehicle list by age
                  while(true) {
                     System.out.println("\nSort Menu:");
                     System.out.println("1. Sort by age (ascending)");
                     System.out.println("2. Sort by age (descending)");
                     System.out.println("3. Back to main menu");
                     System.out.print("Enter your choice: ");
                     int sort = scanner.nextInt();
                     if(sort == 1){
                        System.out.println("List of vehicle details sorted by age (ascending):");
                        Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture));
                        for(int i = 0; i < vehicleList.size(); i++){
                           System.out.println(vehicleList.get(i));
                        }
                     }
                     else if(sort == 2){
                        System.out.println("List of vehicle details sorted by age (descending):");
                        Collections.sort(vehicleList, Comparator.comparingInt(Vehicle::getYearOfManufacture).reversed());
                        for(int i = 0; i < vehicleList.size(); i++){
                           System.out.println(vehicleList.get(i));
                        }
                     }
                     else if(sort == 3){
                        System.out.println("Returning to main menu...\n\n");
                        break;
                     }
                  }
                  break;                  
               case 5:
                  System.out.println("Exiting program...");
                  break;
               default:
                  System.out.println("Invalid choice. Please try again.");
            }
         } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid choice.");
            scanner.nextLine(); // Clear the input buffer
            choice = -1;
         }
      } while (choice != 5);
   
      scanner.close();
   }
   private static void addVehicle(ArrayList<Vehicle> vehicleList, Scanner scanner) {
      System.out.print("Enter registration number: ");
      String regNo = scanner.nextLine();
      System.out.print("Enter make: ");
      String make = scanner.nextLine();
      System.out.print("Enter year of manufacture: ");
      int yearOfManufacture = scanner.nextInt();
      System.out.print("Enter value: ");
      double value = scanner.nextDouble();
      scanner.nextLine(); // Consume newline
      Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
      vehicleList.add(vehicle);
      System.out.println("Vehicle added successfully!");
   }
   private static void displayVehicleList(ArrayList<Vehicle> vehicleList) {
      if (vehicleList.isEmpty()) {
         System.out.println("No vehicles to display.");
      } else {
         System.out.println("List of vehicle details:");
         for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
         }
      }
   }
   private static void deleteVehicle(ArrayList<Vehicle> vehicleList, Scanner scanner) {
      if (vehicleList.isEmpty()) {
         System.out.println("No vehicles to delete.");
      } else {
         System.out.print("Enter the index of the vehicle to delete: ");
         int index = scanner.nextInt();
         if (index >= 0 && index < vehicleList.size()) {
            vehicleList.remove(index);
            System.out.println("Vehicle deleted successfully!");
         } else {
            System.out.println("Invalid index. No vehicle deleted.");
         }
      }
   }
}
