import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
// Lazy Initialization method to implement Singleton pattern creates the instance in the global access method. Here is the sample code for creating Singleton class with this approach.

class Person{
    private static Person person;

    private Person(){
        System.out.println("Person created");
    }
    public static Person getInstance(){
        if(person==null){
            person = new Person();
        }
        return person;
    }
}

// Eager Initialization method to implement Singleton pattern creates the instance when the class is loaded. Here is the sample code for creating Singleton class with this approach.
class Hello{
    private static Hello hello = new Hello();

    private Hello(){
        System.out.println("Hello created");
    }

    public static Hello getInstance(){
        return hello;
    }
}

// Lazy Inititlization with synchronized method to implement Singleton pattern creates the instance in the global access method with synchronized keyword. Here is the sample code for creating Singleton class with this approach.

class Person1 implements Serializable, Cloneable{
    private static Person1 person;

    private Person1(){
        System.out.println("Person1 created");
        // to avoud breaking of refection API
        // if(person!=null){
        //     throw new RuntimeException("Object already created");
        // }
        // person=this;
    }
    public static Person1 getInstance(){
        if(person==null){
            synchronized (Person1.class){
                if(person==null){
                    person = new Person1();
                }
            }
        }
        return person;
    }

    public Object readResolve(){
        return person;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        //return super.clone(); // change this to return person to avoid cloning
        return person;
    }

}


public class single {
    public static void main(String[] args)  throws Exception{
        // Person person = Person.getInstance();
        // Person person2 = Person.getInstance();
        // System.out.println(person.hashCode());
        // System.out.println(person2.hashCode());

        // Hello hello =  Hello.getInstance();
        // Hello hello2 = Hello.getInstance();
        // System.out.println(hello.hashCode());
        // System.out.println(hello2.hashCode());

        // Person1 person1 = Person1.getInstance();
        // Person1 person12 = Person1.getInstance();
        // System.out.println(person1.hashCode());
        // System.out.println(person12.hashCode());

        // //-----------------------------------
        // // ways to break singleton pattern
        // // 1) Relection API
        // // 2) Serialization and Deserialization
        // // 3) Cloning

        // // Reflection API

        // Constructor<Person1> constructor = Person1.class.getDeclaredConstructor();
        // constructor.setAccessible(true);
        // Person1 person14 = constructor.newInstance();
        // Person1 person15 = constructor.newInstance();
        // System.out.println(person14.hashCode());
        // System.out.println(person15.hashCode());

        // to break this in default constructor add 1 if condition
        // if object is already present then throw exception otherwise create the object

        // Constructor<Person1> constructor1 = Person1.class.getDeclaredConstructor();
        // constructor1.setAccessible(true);
        // Person1 person16 = constructor1.newInstance();
        // System.out.println(person16.hashCode());
        // Person1 person17 = constructor1.newInstance();
        // System.out.println(person17.hashCode());

        // Serialization and Deserialization

        // Person1 person1 = Person1.getInstance();
        // System.out.println("Before Serialization" +"\n"+person1.hashCode());
        // ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person1.ser"));
        // outputStream.writeObject(Person1.getInstance());
        // outputStream.close();

        // System.out.println("Serialization done");

        // ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person1.ser"));
        // Person1 person12 = (Person1)inputStream.readObject();
        // inputStream.close();
        // System.out.println("After Deserailization" +"\n"+person12.hashCode());

        // To avoid this add readResolve method in the class
        // after adding readResolve method in the class, It will return the same object
        
        // Clone method

        Person1 person1 = Person1.getInstance();
        Person1 person12 = (Person1)person1.clone();
        System.out.println(person1.hashCode());
        System.out.println(person12.hashCode());

        // To avoid this, just replace super.clone with person object in clone method

    }
}


// Conclusion

// 1) Singleton pattern is used to create only one instance of a class.
// 2) There are many ways to create Singleton pattern.
// 3) Lazy Initialization method to implement Singleton pattern creates the instance in the global access method.
// 4) Eager Initialization method to implement Singleton pattern creates the instance when the class is loaded.
// 5) Lazy Inititlization with synchronized method to implement Singleton pattern creates the instance in the global access method with synchronized keyword.
// 6) There are many ways to break Singleton pattern.   
// 7) Reflection API, Serialization and Deserialization, Cloning are the ways to break Singleton pattern.
// 8) To avoid breaking of Singleton pattern, add if condition in the constructor, add readResolve method in the class, replace super.clone with object in clone method.
// 9) Singleton pattern is used in logging, driver objects, caching, thread pools, database connections, etc.
// 10) Singleton pattern is used in a factory method, prototype, builder, abstract factory, and facade design patterns.
