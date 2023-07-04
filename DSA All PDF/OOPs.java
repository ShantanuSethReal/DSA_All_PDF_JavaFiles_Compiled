public static void main(String[] args) {
    class Car{
        int model_no;
        String color;
        String company;
        boolean hasSunroof;
        int mileage;
        //Attributes/Properties+Methods/Functions
    }
    class Student{
        int roll_no;
        int section_no;
        String name;
    }
    class Teacher{
        String name;
        String subject;
    }

    Student samrat;
    samrat=new Student();

    Student s1=new Student();
    s1.name="Prateek";
    s1.roll_no=1;
    s1.section_no=1;

    Student s2=new Student();
    s2.name="Pratik";
    s2.roll_no=2;
    s2.section_no=1;
    //STACK MEMORY and HEAP MEMORY
    //Access Specifiers -Public Private Protected default
    // Public - can be accessed anywhere, Private - can be accessed only within class, Protected - can be accessed only by sub classes , Default- within same package only

    //Constructor - A function inside a class with the same name as class and no return type
    //Types-default and parameterized
    class StudentA{
        int roll;
        String name;

        StudentA(){
            System.out.println("Constructor is called");
            roll=1;
            name="Anonymous"
        }
        StudentA(int r,String s){
            System.out.println("Parametrized Constructor is called");
            roll=r;
            name=s;
        }
        
    }
    StudentA s1=new StudentA();
    StudentA s2=new StudentA(1,"Ram");
    //This keyword -used to access properties/methods of class
    //Static Keyword
    //static functions belong to classes
    //static functions can change only static variables
    //statiic functions can be called without creating object
    class Main{
        public static void main(String[] args) {
            
        }
    }
    Main.main()

    //Pillars of OOPs;
    //Inheritace-Parent/Super Class Child/Sub clas
    class Vehicle{
        int wheels_no;
        String color;
        int seats;
    }
    class Car extends Vehicle{
        
    }
    class Bike extends Vehicle{

    }
    class Truck extends Vehicle{

    }
    //Types-Single,Multi level,Hierarchial,Multiple,Hybrid
    //Java is platform independent JDK JDBC JVM JRF
    //Constructor chaining-Rules

    //Polymorphism
    //Many forms
    //Method Overloading
    //Increase/Decrease no of parameters
    class Adder {
        static int add(int a, int b) {
            return a + b;
        }

        static int add(int a, int b, int c) {
            return a + b + c;
        }
    }
    //Change data type of parameter 
    class Adder2 {
        static int add(int a, int b) {
            return a + b;
        }

        static double add(double a, double b) {
            return a + b;
        }
    }
    //Method Overriding
    //Compile Time - Overriding Run Time- Overloading
    class Vehicle{
        String model;
        String color;
        public honk(){
            System.out.println("Honking from Vehicle Class")
        }
    }
    class Cars extends Vehicle{
        int wheels;
        public honk(){
            System.out.println("Honking from Car Class")
        }
        
    }
    class Bike extends Vehicle{
        int wheels;
        public honk(){
            System.out.println("Honking from Bike Class")
        }
        
    }

    //Encapsulation
    //Wrapping code or hiding code inside a single unit;
    //Achieved using private keyword
    
    //Abstraction
    //Hiding details,Hiding Implementation
    //Showing only functions
    //Abstract Classes/Interface-classes which have only abstract methods no body of function
    //Interface-only abstract methods,to achieve 100% abstraction
    


}