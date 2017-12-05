# Assignment 3 (CRUD with OOP)
### This assignment implements simple CRUD application and shows encapsulation, inheritance, polymorphism and association properties
#### ps: java version of 1.7 or higher is required

## Command to run the app:
#### Start the crud application
```bash
$ java -jar crud.jar
```
The app allows for creating, deleting, updating and displaying the employee object stored in json format in file empoyee.txt. The count.txt file keeps the count up until which employee id has been assigned so as to maintain its uniqueness

#### Instances of different OOP properties inside the class are:
#### 1.Encapsulation
```java
private static Integer count = 0;
private int employeeID;
private String firstName;
private String lastName;
private String post;
private String department;
```
The above data memebers have been restricted with the ```private``` modifier, such that it is invisible outside the class. Thus, it effectively hides those data memebers from outside the class. 

#### 2.Interface and inheritance
```java
public interface Person {
	public void DisplayName();

	public void DescribePerson();
}
```
```java
public class Employee implements Person, CRUDOps {
````
Here the Employee class inherited from both Person and CRUDOps interfaces, thus, implementing multiple inheritance.

#### 3.Polymorphism
```java
Employee e = new HeadofDep(Integer.parseInt(counter));
```
Here the object ```e``` is an instance of ```HeadofDep``` but of type ```Employee```. Although, it is a type of ```Employee``` it calls on the constructor of ```HeadofDep```. This shows how a object of parent type can morph into instances of children due to the property of ```Polymorphism```.

#### 4.Association
```java
public class HeadofDep extends Employee implements Person {
	// private final String Post = "HOD";
	private int countGuysUnderHim;

	public HeadofDep(int count) throws IOException {
		super("jaa");
		this.countGuysUnderHim = count;
	}
```
Here the constructor ```HeadofDep``` calls the constuctor of its parent ```Employee``` with ```super```. Thus, two classes are one to one associated as the child needs the parent's constructor. 

