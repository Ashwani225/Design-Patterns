interface Employee{
    int salary();
    String getName();
}

class BackendDeveloper implements Employee{
    @Override
    public int salary() {
        return 1000;
    }
    public String getName() {
        return "Backend Developer";
    }
}

class FrontendDeveloper implements Employee{
    @Override
    public int salary() {
        return 2000;
    }
    public String getName() {
        return "Frontend Developer";
    }
}

abstract class EmployeeAbstractFactory{
    public abstract Employee getEmployee();
}

class EmployeeFactory{
    public Employee getEmployee(EmployeeAbstractFactory factory){
        return factory.getEmployee();
    }
}

class BackendDeveloperFactory extends EmployeeAbstractFactory{
    @Override
    public Employee getEmployee() {
        return new BackendDeveloper();
    }
}

class FrontendDeveloperFactory extends EmployeeAbstractFactory{
    @Override
    public Employee getEmployee() {
        return new FrontendDeveloper();
    }
}

public class abstractFactoryDesign {
    public static void main(String[] args) {
        Employee e1 = new EmployeeFactory().getEmployee(new BackendDeveloperFactory());
        System.out.println(e1.salary());
        System.out.println(e1.getName());
        e1 = new EmployeeFactory().getEmployee(new FrontendDeveloperFactory());
        System.out.println(e1.salary());
        System.out.println(e1.getName());
    }
}


// conclusion:
// Abstract Factory Design Pattern is used when we have multiple factory classes 
// and if we want to produce a family of related objects.
// abstract factory pattern is “factory of factories” and can be easily extended to accommodate more products,
// advantages of Abstract Factory Design Pattern
// Abstract Factory Design Pattern isolates the client code from concrete (implementation) classes.
// Abstract Factory Design Pattern makes exchanging product families easy.
// Abstract Factory Design Pattern promotes consistency among products.
// Abstract Factory Design Pattern is more scalable.
