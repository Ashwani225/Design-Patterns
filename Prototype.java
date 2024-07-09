class Connect implements Cloneable{

    private String name;
    private String password;
    private String url;

    @Override
    public String toString() {
        return "Connect [name=" + name + ", password=" + password + ", url=" + url + "]";
    }

    public Connect(String name, String password, String url) {
        this.name = name;
        this.password = password;
        this.url = url;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


public class Prototype {
    public static void main(String[] args) {
        
        Connect c1 = new Connect("root", "root", "localhost");
        System.out.println(c1);

        try {
            Connect c2 = (Connect) c1.clone();
            System.out.println(c2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

// Prototype Design Pattern
// Prototpype Design Pattern is used when the Object creation is a costly affair 
// and requires a lot of time and resources and you have a similar object already existing.

// Prototype pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs.


// Shallow Copy vs Deep Copy
// Shallow copy is a bit-wise copy of an object. A new object is created that has an exact copy of the values in the original object.
// Deep copy copies all fields, and makes copies of dynamically allocated memory pointed to by the fields. A deep copy occurs when an object is copied along with the objects to which it refers.
// In prototype pattern, new object is created by copying the existing object. So, if the object has any references to other objects, then a shallow copy will copy the reference to the object.
// So, if you do not want the changes in the new object to affect the existing object or vice versa, then a deep copy should be used.
// In the above example, we have used shallow copy. If we want to use deep copy, we can override the clone method as follows:
// @Override
// protected Object clone() throws CloneNotSupportedException {
//     Connect c = (Connect) super.clone();
//     // deep copy
//     // c.setUrl(new String(this.getUrl()));
//     // c.setName(new String(this.getName()));
//     // c.setPassword(new String(this.getPassword()));
//   return c;