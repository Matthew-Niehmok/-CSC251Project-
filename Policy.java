/**
 * This class represents an insurance policy.
 */
public class Policy
{
   // Static field to track the number of policies created
   private static int policyCount = 0;
   
   // Fields
   private String policyNumber;
   private String providerName;
   private PolicyHolder holder;
   
   /**
    * Default constructor that initializes a Policy object with default values.
    */
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      holder = new PolicyHolder();
      
      // Increment the policy count
      policyCount++;
   }
   
   /**
    * Constructor that initializes a Policy object with the specified values.
    * @param pNumber The policy number
    * @param pName The provider name
    * @param holder The policyholder
    */
   public Policy(String pNumber, String pName, PolicyHolder holder)
   {
      policyNumber = pNumber;
      providerName = pName;
      
      // Defensive copying to prevent security issues
      this.holder = new PolicyHolder(
         holder.getFirstName(),
         holder.getLastName(),
         holder.getAge(),
         holder.getSmokingStatus(),
         holder.getHeight(),
         holder.getWeight()
      );
      
      // Increment the policy count
      policyCount++;
   }
   
   /**
    * Constructor that initializes a Policy object with the specified values.
    * @param pNumber The policy number
    * @param pName The provider name
    * @param fName The policyholder's first name
    * @param lName The policyholder's last name
    * @param a The policyholder's age
    * @param sStatus The policyholder's smoking status
    * @param h The policyholder's height in inches
    * @param w The policyholder's weight in pounds
    */
   public Policy(String pNumber, String pName, String fName, String lName, int a, String sStatus, double h, double w)
   {
      policyNumber = pNumber;
      providerName = pName;
      holder = new PolicyHolder(fName, lName, a, sStatus, h, w);
      
      // Increment the policy count
      policyCount++;
   }
   
   /**
    * Gets the number of Policy objects created.
    * @return The count of Policy objects
    */
   public static int getPolicyCount()
   {
      return policyCount;
   }
   
   //setters//
   /**
    * Sets the policy number.
    * @param pNumber The policy number
    */
   public void setPolicyNumber(String pNumber)
   {
      policyNumber = pNumber;
   }
   
   /**
    * Sets the provider name.
    * @param pName The provider name
    */
   public void setProviderName(String pName)
   {
      providerName = pName;
   }
   
   /**
    * Sets the policyholder.
    * @param holder The policyholder
    */
   public void setPolicyHolder(PolicyHolder holder)
   {
      // Defensive copying to prevent security issues
      this.holder = new PolicyHolder(
         holder.getFirstName(),
         holder.getLastName(),
         holder.getAge(),
         holder.getSmokingStatus(),
         holder.getHeight(),
         holder.getWeight()
      );
   }
   
   //getters//
   /**
    * Gets the policy number.
    * @return The policy number
    */
   public String getPolicyNumber()
   {
      return policyNumber;
   }
   
   /**
    * Gets the provider name.
    * @return The provider name
    */
   public String getProviderName()
   {
      return providerName;
   }
   
   /**
    * Gets the policyholder.
    * @return A copy of the policyholder
    */
   public PolicyHolder getPolicyHolder()
   {
      // Return a copy to prevent security issues
      return new PolicyHolder(
         holder.getFirstName(),
         holder.getLastName(),
         holder.getAge(),
         holder.getSmokingStatus(),
         holder.getHeight(),
         holder.getWeight()
      );
   }
   
   /**
    * Calculates the Policy's price based on the policyholder's age, smoking status, and BMI.
    * @return The policy price
    */
   public double getPrice()
   {
      final double BASE_PRICE = 600;
      final double ADDITIONAL_FEE_AGE = 75;
      final double ADDITIONAL_FEE_SMOKING = 100;
      final double ADDITIONAL_FEE_PER_BMI = 20;
      
      final int AGE_THRESHOLD = 50;
      final int BMI_THRESHOLD = 35;
      
      double price = BASE_PRICE;
      
      if(holder.getAge() > AGE_THRESHOLD) //over 50 years
         price += ADDITIONAL_FEE_AGE; //75
         
      if(holder.getSmokingStatus().equalsIgnoreCase("smoker")) 
         price += ADDITIONAL_FEE_SMOKING; //100
            
      //call the getBMI method
      if(holder.getBMI() > BMI_THRESHOLD) //BMI over 35
         price += ((holder.getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI); //additional BMI fee - 20
         
      return price;
   }
   
   /**
    * Returns a string representation of the policy.
    * @return A string containing information about the policy
    */
   public String toString()
   {
      return "Policy Number: " + policyNumber + "\n\n" +
             "Provider Name: " + providerName + "\n\n" +
             holder.toString() + "\n\n" +
             String.format("Policy Price: $%.2f", getPrice());
   }
}