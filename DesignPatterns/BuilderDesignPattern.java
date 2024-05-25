package DesignPatterns;
/*
* Builder Design Pattern is a Creational Design Pattern Used for creating object,
* when we need to create object with optional parameter or object creation process is complex
*
* When to Use the Builder Design Pattern
* Complex Object Construction,Immutability
* HttpSecurity is an example of Builder Design Pattern cors(),authorizeRequest(),authenticationProvider(),sessionManagement() all these methods
* HttpSecurity Object Itself
* StringBuilder and StringBuffer are also examples of Builder Design Pattern
*/
public class BuilderDesignPattern {
    public static void main(String[] args) {
        Employee emp = new Employee.EmployeeBuilder("Charan",60000.00)
                .setHasVehicle(true)
                .setTaxPayer(true)
                .build();
    }
}

class Employee{
    private String name;

    private double salary;

    private boolean isTaxPayer;

    private boolean hasVehicle;

    private Employee(EmployeeBuilder builder){
        this.name = builder.name;
        this.salary = builder.salary;
        this.isTaxPayer = builder.isTaxPayer;
        this.hasVehicle = builder.hasVehicle;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isTaxPayer() {
        return isTaxPayer;
    }

    public boolean isHasVehicle() {
        return hasVehicle;
    }

    public static class EmployeeBuilder{
        private String name;
        private double salary;
        private boolean isTaxPayer;
        private boolean hasVehicle;

        public EmployeeBuilder(String name,double salary){
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public double getSalary() {
            return salary;
        }

        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public boolean isTaxPayer() {
            return isTaxPayer;
        }

        public EmployeeBuilder setTaxPayer(boolean taxPayer) {
            isTaxPayer = taxPayer;
            return this;
        }

        public boolean isHasVehicle() {
            return hasVehicle;
        }

        public EmployeeBuilder setHasVehicle(boolean hasVehicle) {
            this.hasVehicle = hasVehicle;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
