/**
 * The Policy class models an insurance policy for one person.
 * It maintains information about the policy and policyholder,
 * and provides methods to calculate BMI and policy price.
 */
public class Policy {
    // Constants for policy calculations
    private static final double BASE_POLICY_PRICE = 600.0;
    private static final double AGE_THRESHOLD_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_THRESHOLD = 35.0;
    private static final double BMI_FEE_MULTIPLIER = 20.0;
    private static final double BMI_MULTIPLIER = 703.0;
    
    // Instance variables
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;  // in inches
    private double weight;  // in pounds
    
    /**
     * No-argument constructor that sets default values
     */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }
    
    /**
     * Constructor that accepts arguments to initialize all fields
     */
    public Policy(int policyNumber, String providerName, String firstName, 
                 String lastName, int age, String smokingStatus, 
                 double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }
    
    // Getter and Setter methods
    public int getPolicyNumber() {
        return policyNumber;
    }
    
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    public String getProviderName() {
        return providerName;
    }
    
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getSmokingStatus() {
        return smokingStatus;
    }
    
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    /**
     * Calculates the BMI of the policyholder
     * @return The calculated BMI value
     */
    public double calculateBMI() {
        if (height <= 0) {
            return 0.0;
        }
        return (weight * BMI_MULTIPLIER) / (height * height);
    }
    
    /**
     * Calculates the price of the insurance policy based on various factors
     * @return The total price of the policy
     */
    public double calculatePolicyPrice() {
        double totalPrice = BASE_POLICY_PRICE;
        
        // Add age-based fee
        if (age > 50) {
            totalPrice += AGE_THRESHOLD_FEE;
        }
        
        // Add smoker fee
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            totalPrice += SMOKER_FEE;
        }
        
        // Add BMI-based fee
        double bmi = calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            totalPrice += (bmi - BMI_THRESHOLD) * BMI_FEE_MULTIPLIER;
        }
        
        return totalPrice;
    }
}
