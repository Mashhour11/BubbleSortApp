    public class Animal {
        public int age;
        public String gender;
    
        public void isMammal() {
            System.out.println("This is the isMammal() method from Animal class.");
        }
    
        public void mate() {
            System.out.println("This is the mate() method from Animal class.");
        }
    
        public static void main(String[] args) {
            // Create Animal object
            Animal myAnimal = new Animal();
            myAnimal.age = 5;
            myAnimal.gender = "Male";
            myAnimal.isMammal();
            myAnimal.mate();
    
            // Create Fish object
            Fish myFish = new Fish();
            myFish.displayInfo(); // Calls a public method that uses the private method
    
            // Create Zebra object
            Zebra myZebra = new Zebra();
            myZebra.age = 4;
            myZebra.gender = "Female";
            myZebra.is_wild = true;
            myZebra.isMammal();
            myZebra.mate();
            myZebra.run();
        }
    }
    
    // Subclass Fish
    class Fish extends Animal {
        private final double sizeInFeet = 2.5;
    
        private void canEat() {
            System.out.println("This is a private method canEat() from class Fish.");
        }
    
        public void displayInfo() {
            System.out.println("Fish size: " + sizeInFeet + " feet.");
            canEat();
        }
    }
    
    // Subclass Zebra
    class Zebra extends Animal {
        public boolean is_wild;
    
        public void run() {
            System.out.println("This is the run() method from class Zebra.");
        }    
}
