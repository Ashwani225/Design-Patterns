interface Employee {

    public int salary();
    
}

class BackendDeveloper implements Employee{
    @Override
    public int salary() {
        return 1000;
    }
}

class FrontendDeveloper implements Employee{
    @Override
    public int salary() {
        return 2000;
    }
}

class EmployeeFactory{
    public Employee getEmployee(String type){
        if(type.equalsIgnoreCase("Backend Developer")){
            return new BackendDeveloper();
        }else if(type.equalsIgnoreCase("Frontend Developer")){
            return new FrontendDeveloper();
        }else{
            return null;
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        Employee employee = new EmployeeFactory().getEmployee("Backend Developer");
        System.out.println(employee.salary());
        employee = new EmployeeFactory().getEmployee("Frontend Developer");
        System.out.println(employee.salary());
    }
}


// Conclusion:
// Factory Design Pattern is used when we have a parent class with 
// multiple child-classes and based on input, we need to return one of the child-class.
// This pattern take out the responsibility of instantiation of a class from client

// Factory Design Pattern provides approach to code for interface rather than implementation.
// Factory Design Pattern removes the instantiation of actual implementation classes from client code.
// Advantages of Factory Design Pattern
// It provide Loose Coupling which is the most important advantage of Factory Pattern.
// Focus on more creating objects rather implementation part.