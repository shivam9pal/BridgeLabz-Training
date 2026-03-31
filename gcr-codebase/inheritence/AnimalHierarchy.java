package week02.gcrcodebase.inheritence;


//superclass
class Animal{
	String name;
	int age;
	
	Animal(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	void makeSound() {
		System.out.println("The Animal Sounds !");
	}
	
}
//child class
class Dog extends Animal{
	Dog(String name,int age){
		super(name,age);
	}
	
	void makeSound() {
		System.out.println("The Animal Sounds Dog !");
	}
}
//child class
class Cat extends Animal{
	
	Cat(String name,int age){
		super(name,age);
	}
	void makeSound() {
		System.out.println("The Animal Sounds Cat !");
	}
}
//child class
class Bird extends Animal{
	
	Bird(String name,int age){
		super(name,age);
	}
	void makeSound() {
		System.out.println("The Animal Sounds Bird !");
	}
}
//main
public class AnimalHierarchy {

	public static void main(String[] args) {
		Animal dog=new Dog("Kalu",9);
		Animal cat=new Cat("kitty",9);
		Animal bird=new Bird("chirpu",9);
		
		dog.makeSound();
		cat.makeSound();
		bird.makeSound();

	}

}
