import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PolicyDemo 
{   
   public static void main(String[] args)
   {
      /*
       * We use a "try" and "catch" process. We "try" to open the file and process it, 
       * but if something goes wrong, an exception will be "thrown" and we can "catch" it 
       * and deal with the problem gracefully.
       */
      try
      {
         // Create an ArrayList to store Policy objects
         ArrayList<Policy> policies = new ArrayList<Policy>();
         
         // Create a File object for the input file
         File file = new File("PolicyInformation.txt");
         
         // Check if the file exists
         if (!file.exists())
         {
            System.out.println("The file PolicyInformation.txt was not found.");
            System.exit(0);
         }
         
         // Create a Scanner object to read from the file
         Scanner inputFile = new Scanner(file);
         
         // Declare variables to store policy information
         String policyNumber, providerName, firstName, lastName, smokingStatus;
         int age;
         double height, weight;
         
         // Read policy information from the file
         while (inputFile.hasNext())
         {
            // Read policy information
            policyNumber = inputFile.nextLine();
            providerName = inputFile.nextLine();
            firstName = inputFile.nextLine();
            lastName = inputFile.nextLine();
            
            // Parse numeric values
            age = Integer.parseInt(inputFile.nextLine().trim());
            smokingStatus = inputFile.nextLine();
            height = Double.parseDouble(inputFile.nextLine().trim());
            weight = Double.parseDouble(inputFile.nextLine().trim());
            
            // Create a Policy object
            Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
            
            // Add the Policy object to the ArrayList
            policies.add(policy);
            
            // Skip the blank line between policies if there is one
            if (inputFile.hasNext())
            {
               inputFile.nextLine();
            }
         }
         
         // Close the file
         inputFile.close();
         
         // Variables to count smokers and non-smokers
         int smokerCount = 0;
         int nonSmokerCount = 0;
         
         // Display information for each policy
         for (int i = 0; i < policies.size(); i++)
         {
            // Get the current policy
            Policy policy = policies.get(i);
            
            // Display policy information
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println();
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println();
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println();
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println();
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println();
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
            System.out.println();
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println();
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.println();
            System.out.printf("Policyholder's BMI: %.2f\n", policy.getBMI());
            System.out.println();
            System.out.printf("Policy Price: $%.2f\n", policy.getPrice());
            System.out.println("\n");
            
            // Count smokers and non-smokers
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker"))
               smokerCount++;
            else if (policy.getSmokingStatus().equalsIgnoreCase("non-smoker"))
               nonSmokerCount++;
         }
         
         // Display the number of smokers and non-smokers
         System.out.println("The number of policies with a smoker is: " + smokerCount);
         System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
      }
      catch (IOException ex)
      {
         // Display an error message if there is a problem with the file
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }
      catch (NumberFormatException ex)
      {
         // Display an error message if there is a problem parsing numeric values
         System.out.println("Error parsing numeric value: " + ex.getMessage());
      }
   }
}
