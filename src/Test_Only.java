class Animal {

    // field and method of the parent class
    String name;
    public void eat() {
        System.out.println("I can eat");
    }
}

// inherit from Animal
class Dog extends Animal {

    // new method in subclass
    public void display() {
        System.out.println("My name is " + name);
    }
}

class Bog extends Dog{
    public void display() {
        System.out.println("My name is " + name);
    }
}

class Main {
    public static void main(String[] args) {

        // create an object of the subclass
        Dog labrador = new Dog();
        Bog labrabogr = new Bog();

        // access field of superclass
        labrador.name = "Rohu";
        labrabogr.name = "Bogu";
        labrador.display();
        labrabogr.display();

        // call method of superclass
        // using object of subclass
        labrador.eat();
        labrabogr.eat();

    }
}