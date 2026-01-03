package week02.gcrcodebase.inheritence;

//Superclass
class Book {
 String title;
 int publicationYear;

 Book(String title, int publicationYear) {
     this.title = title;
     this.publicationYear = publicationYear;
 }

 void displayInfo() {
     System.out.println("Book Title: " + title +
                        ", Publication Year: " + publicationYear);
 }
}

//Subclass
class Author extends Book {
 String name;
 String bio;

 Author(String title, int publicationYear, String name, String bio) {
     super(title, publicationYear);
     this.name = name;
     this.bio = bio;
 }

 @Override
 void displayInfo() {
     System.out.println("Book Title: " + title +
                        ", Publication Year: " + publicationYear +
                        ", Author Name: " + name +
                        ", Bio: " + bio);
 }
}


public class BookAuthorSingle {
 public static void main(String[] args) {

     Author book1 = new Author("JAVA",2018,"NILKAMAL","JAVA EXPERT AND AUTHOR");
     book1.displayInfo();
 }
}


