import java.util.ArrayList;
import java.util.List;

interface Iterator {
    boolean hasNext();
    Object next();
}

class IteratorImpl implements Iterator {
    private List<User> users = new ArrayList<>();
    private int index;

    public IteratorImpl(List<User> users) {
        this.users = users;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < users.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return users.get(index++);
        }
        return null;
    }
}

class UserManagement{
    List<User> users = new ArrayList<>();
    
    public void addUser(User user){
        users.add(user);
    }

    public User getUser(int index){
        return users.get(index);
    }

    public Iterator getIterator(){
        return new IteratorImpl(users);
    }
}

class User{
    String name;
    int Id;

    public User(String name, int id) {
        this.name = name;
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

}

public class IteratorDesign {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        userManagement.addUser(new User("Alice", 1));
        userManagement.addUser(new User("Bob", 2));
        userManagement.addUser(new User("Charlie", 3));

        Iterator iterator = userManagement.getIterator();
        while(iterator.hasNext()){
            User user = (User) iterator.next();
            System.out.println("User: [Name: "+user.getName()+", ID: "+user.getId()+"]");
        }
    }
}

// Conclustion:
// The Iterator pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
// The Iterator pattern is used to provide a standard way to traverse a collection of items without exposing its underlying representation.

