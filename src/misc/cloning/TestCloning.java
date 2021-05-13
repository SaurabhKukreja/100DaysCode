package misc.cloning;

public class TestCloning {

  public static void main(String[] args){
    Person person = new Person();
    person.name = "Saurabh";
    person.age = 31;

    System.out.println("Person is: " + person);
    try {
      Person person1 = (Person) person.clone();
      person1.name = "Sakshi";
      System.out.println("Person1 is: " + person1);

    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }

}
