/**
 * This class represents a policyholder associated with an insurance policy.
 */
public class PolicyHolder
{
   // Fields
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus;
   private double height;
   private double weight;
   
   /**
    * Default constructor that initializes a PolicyHolder object with default values.
    */
   public PolicyHolder()
   {
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0;
      weight = 0;
   }
   
   /**
    * Constructor that initializes a PolicyHolder object with the specified values.
    * @param fName The policyholder's first name
    * @param lName The policyholder's last name
    * @param a The policyholder's age
    * @param sStatus The policyholder's smoking status
    * @param h The policyholder's height in inches
    * @param w The policyholder's weight in pounds
    */
   public PolicyHolder(String fName, String lName, int a, String sStatus, double h, double w)
   {
      firstName = fName;
      lastName = lName;
      age = a;
      smokingStatus = sStatus;
      height = h;
      weight = w;
   }
   
   //setters//
   /**
    * Sets the policyholder's first name.
    * @param fName The policyholder's first name
    */
   public void setFirstName(String fName)
   {
      firstName = fName;
   }
   
   /**
    * Sets the policyholder's last name.
    * @param lName The policyholder's last name
    */
   public void setLastName(String lName)
   {
      lastName = lName;
   }
   
   /**
    * Sets the policyholder's age.
    * @param a The policyholder's age
    */
   public void setAge(int a)
   {
      age = a;
   }
   
   /**
    * Sets the policyholder's smoking status.
    * @param sStatus The policyholder's smoking status
    */
   public void setSmokingStatus(String sStatus)
   {
      smokingStatus = sStatus;
   }
   
   /**
    * Sets the policyholder's height.
    * @param h The policyholder's height in inches
    */
   public void setHeight(double h)
   {
      height = h;
   }
   
   /**
    * Sets the policyholder's weight.
    * @param w The policyholder's weight in pounds
    */
   public void setWeight(double w)
   {
      weight = w;
   }
   
   //getters//
   /**
    * Gets the policyholder's first name.
    * @return The policyholder's first name
    */
   public String getFirstName()
   {
      return firstName;
   }
   
   /**
    * Gets the policyholder's last name.
    * @return The policyholder's last name
    */
   public String getLastName()
   {
      return lastName;
   }
   
   /**
    * Gets the policyholder's age.
    * @return The policyholder's age
    */
   public int getAge()
   {
      return age;
   }
   
   /**
    * Gets the policyholder's smoking status.
    * @return The policyholder's smoking status
    */
   public String getSmokingStatus()
   {
      return smokingStatus;
   }
   
   /**
    * Gets the policyholder's height.
    * @return The policyholder's height in inches
    */
   public double getHeight()
   {
      return height;
   }
   
   /**
    * Gets the policyholder's weight.
    * @return The policyholder's weight in pounds
    */
   public double getWeight()
   {
      return weight;
   }
   
   /**
    * Calculates the Policyholder's BMI.
    * @return The policyholder's BMI
    */
   public double getBMI()
   {
      final double CONVFACTOR = 703;
      
      return (weight * CONVFACTOR) / (height * height);
   }
   
   /**
    * Returns a string representation of the policyholder.
    * @return A string containing information about the policyholder
    */
   public String toString()
   {
      return "Policyholder's First Name: " + firstName + "\n\n" +
             "Policyholder's Last Name: " + lastName + "\n\n" +
             "Policyholder's Age: " + age + "\n\n" +
             "Policyholder's Smoking Status (smoker/non-smoker): " + smokingStatus + "\n\n" +
             "Policyholder's Height: " + height + " inches\n\n" +
             "Policyholder's Weight: " + weight + " pounds\n\n" +
             String.format("Policyholder's BMI: %.2f", getBMI());
   }
}
