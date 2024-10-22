package jdbc.vo;

public class Employee {

   private int id;
   private String firstName;
   private String lastName;
   private String email;

   public Employee() {}   
   public Employee(int id, String firstName, String lastName, String email) {
      super();
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
   
   public int getId() {
      return id;
   }
   public String getFirstName() {
      return firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public String getEmail() {
      return email;
   }
   
   public static EmployeeBuilder builder() {
      return new EmployeeBuilder();
   }
   
   public static class EmployeeBuilder {      
      private int id;
      private String firstName;
      private String lastName;
      private String email;
      
      public EmployeeBuilder() {}
      
      public EmployeeBuilder id(int id) {
         this.id = id;
         return this;
      }
      public EmployeeBuilder firstName(String firstName) {
         this.firstName = firstName;
         return this;
      }
      public EmployeeBuilder lastName(String lastName) {
         this.lastName = lastName;
         return this;
      }
      public EmployeeBuilder email(String email) {
         this.email = email;
         return this;
      }
      
      public Employee build() {
         return new Employee(id, firstName, lastName, email);
      }
   }
}
