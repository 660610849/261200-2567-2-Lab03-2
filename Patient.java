public class Patient {
    private int id;
    private String name;
    private int birthYear;
    private double height;
    private double weight;

    private String bloodGroup;
    private String phoneNumber;

    public Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber) {
        this.id = id;
        this.name = name;

        if (birthYear > 0 && birthYear <= 2024) {
            this.birthYear = birthYear;
        } else {
            this.birthYear = 3000;
        }

        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height cannot be negative.");
        }

        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }

        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBMI() {
        if (height <= 0 || weight <= 0) {
            return 0.0;
        }
        double heightInMeters = height / 100;
        return weight / (heightInMeters * heightInMeters);
    }

    public int getAge(int currentYear) {
        if (currentYear >= birthYear) {
            return currentYear - birthYear;
        } else {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
    }

    public void displayDetails(int currentYear) {
        System.out.println("Patient Name: " + name);
        int age = getAge(currentYear);
        if (age >= 0) {
            System.out.println("Patient Age: " + age);
        } else {
            System.out.println("Patient Age: Invalid current year");
        }
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
        System.out.println("Patient Blood Group: " + bloodGroup);
        System.out.println("Patient Phone Number: " + phoneNumber);
        System.out.printf("Patient BMI: %.2f\n", getBMI());
    }
}
