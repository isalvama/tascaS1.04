# Tasca S1 04

## Description

This is a project created for academic purposes. More specifically, it is created to complete the exercises included in the fourth Topic (Testing) of IT ACADEMY Java & Spring specialization phase.
The project focuses on implementing unit tests using JUnit 5 to verify the correct behavior of a book collection management system.


## Techonologies

- Java
- Gradle
- JUnit 5 (Jupiter)


## Project Structure
```
TascaS1.03/
src/
└── main/
    └── java/
       └── first_level/
            └── exercise1/
                ├── Book.java
                ├── BooksCollection.java
                └── NameComparator.java
            └── exercise2/
                └── IdCalculation.java
            └── exercise3/
                └── Classroom.java
        └── third_level/
            └── Calculator/
                ├── Main.java
                ├── NameCompare.java
                └── Restaurant.java
test/
└── main/
    └── java/
       └── first_level/
            └── exercise1/
                └── BooksCollectionTest.java
            └── exercise2/
                └── IdCalculationTest.java
            └── exercise3/
                └── ClassroomTest.java
        └── second_level/
            └── SecondLevelTest.java
        └── third_level/
            └── CalculatorTest.java 
```

## Installation

1. Clone the repository: `git clone https://github.com/isalvama/tascaS1.04.git`
2. Navigate to the project directory: `cd TascaS1.04`
3. Build the project using Gradle: `./gradlew build`
4. Run the tests: `./gradlew test`


## Concepts covered

- Unit testing with **JUnit 5** and Assertions.
- Use of annotations like `@Test`, `@DisplayName` and `@forEach` for clear test reporting.
- Implementation of **Parameterized Tests** using `@ParameterizedTest`.
- Providing multiple test data sets using `@CsvSource`.
- Verification of **Exceptions** using `assertThrows()`.
- Advanced object comparison by overriding `equals()` and `hashCode()`.
- Custom sorting logic using the `Comparator` interface.


## First Level

### Exercise 1: Unit Testing a Book Collection

#### Book class
A model class representing a book with `title` and `author`.
- **Equality Logic**: The `equals()` method has been overridden to define that two books are the same if they have the same title, ignoring case sensitivity (`toLowerCase()`).
- **Consistency**: The `hashCode()` method is also overridden to ensure it remains consistent with the equality logic based on the title.

#### BooksCollection class
This class manages a list of books and encapsulates several operations:
- **Adding Books**: Includes methods to add a single book (checking for duplicates via `contains()`), multiple books, or a book at a specific index.
- **Search & Removal**: Allows retrieving a title from a position, removing a book by its title or removing all books in BooksCollection.
- **Defensive Programming**: The `getBookArrayList()` method returns a `copyOf` to prevent external modification of the internal list.
- **Sorting**: Provides a method to get the collection ordered alphabetically without modifying the original list.

#### NameComparator class
A dedicated class that implements `Comparator<Book>`. It provides the logic to compare two `Book` objects alphabetically based on their titles.

#### BooksCollectionTest (Unit Tests)
A comprehensive test suite that validates the entire functionality of the system:
- **Instantiation**: Verifies that the collection is correctly initialized and not null.
- **Size & Content**: Checks that the size of the collection updates correctly as books are added or removed.
- **Index Integrity**: Ensures that books are placed in the correct positions, especially when using index-based insertions.
- **Business Rules**: Validates that the system correctly rejects duplicate books (same title, different author or case) thanks to the custom `equals` implementation.
- **Sorting Accuracy**: Confirms that the `getOrderedCollection` method returns books in alphabetical order while keeping the original collection's order intact.
- **Title Retrieval**: Tests that the system returns the correct title when queried by a specific index.


### Exercise 2: Parameterized Testing for ID Letter Calculation

#### IdCalculation class
This is a utility class designed to calculate the official Spanish ID (DNI) letter based on a numeric input.
- **Validation**: Before calculating, the class ensures the input is valid:
    - It removes leading zeros using regex.
    - It throws an `IllegalArgumentException` if the number is negative or has more than 8 digits.
    - It throws a `NumberFormatException` if the input contains non-digit characters.
- **Calculation**: the remainder maps to its corresponding legal letter.

#### IdCalculationTest (Parameterized Tests)
This test class focuses on efficiency by using parameterized testing, which allows running the same test logic with multiple inputs:
- **Correct Letter Mapping**: A `@ParameterizedTest` with a `@CsvSource` containing 13 real ID examples (including those starting with 0) is used to verify that the `calculateIdLetter` method returns the expected character for each case.
- **Exception Testing (Negative Numbers)**: Verifies that passing negative numbers correctly triggers an `IllegalArgumentException` with the expected error message.
- **Exception Testing (Length)**: Checks that strings exceeding the digit limit are caught and handled by throwing the appropriate exception.
- **Exception Testing (Numbers)**: Verifies strings that contain other digits than numbers are caught and handled by throwing the appropriate `NumberFormatException` exception.

- **Robustness**: These tests ensure that the validation logic and the calculation logic work correctly under both valid and invalid scenarios.


### Exercise 3: Out of Bounds Exception Testing

#### Classroom class
A class representing a group of students in a classroom.
- **Data Structure**: It uses an `Strin[]` to store student names.
- **Custom Exception Handling**: The `getStudentNameInPosition()` method includes a manual check for the getter index. If the provided position is greater than the current size of the list or negative, it explicitly throws an `IndexOutOfBoundsException` with a descriptive custom message, instead of relying solely on the default JVM behavior.

#### ClassroomTest (Exception Validation)
This test suite ensures that the collection's integrity and error handling are robust through two specific types of tests:
- **Exception Verification**: Using `@ParameterizedTest`, it provides indices that are guaranteed to be out of the current list bounds (e.g., trying to insert in position 3 when there are only 2 elements) or negative. The test verifies that the `IndexOutOfBoundsException` is thrown and that its message matches the custom text defined in the `Classroom` class.
- **No-Exception Verification**: It also includes tests using `assertDoesNotThrow()`. This confirms that as long as the position is valid (within the range of 0 to `size`), the student is added correctly without any interruption to the program flow.


## Second Level

### Exercise 1: Advanced Assertions with AssertJ

#### SecondLevelTest class
This test suite utilizes **AssertJ** instead of standard JUnit assertions to provide more readable and expressive tests. The tests cover a wide range of scenarios:

- **Equality vs. Identity**:
    - Demonstrates how to verify that two objects have the same value (`isEqualTo`).
    - Illustrates the difference when checking if two variables point to the exact same memory reference (`isSameAs`) versus different instances with identical content (`isNotSameAs`).
- **Collection Content & Order**:
    - **Order-Sensitive**: Using `containsExactly` to prove that an `ArrayList` maintains the exact sequence in which objects were inserted.
    - **Order-Agnostic**: Using `contains` to verify the presence of elements regardless of their position.
    - **Uniqueness**: Using `containsOnlyOnce` to ensure specific objects are not duplicated within a collection.
- **Map and Optional Validation**:
    - Verifies the existence (or absence) of specific keys within a `HashMap`.
    - Checks the state of `Optional` objects to ensure they are correctly identified as empty when no value is present.
- **Fluent Exception Handling**:
    - Instead of `assertThrows`, this level uses `assertThatThrownBy`, which allows for a more functional approach to verifying that specific methods (like `addInPosition` from the `Classroom` class) trigger an `IndexOutOfBoundsException` under the right conditions.


## Third Level

### Exercise 1: Calculator Logic and State Verification

#### Calculator class
A functional class designed to perform basic arithmetic operations while maintaining a running total.
- **State Management**: The class stores a `total` value that is modified by each operation (`add`, `subtract`, `multiply`, `divide`).
- **Input Validation**: To ensure business logic integrity, the class implements a rule: the `divide` method specifically checks for a zero divisor to throw an `ArithmeticException`, preventing undefined mathematical operations.
- **Reset Logic**: Includes a `reset()` method to restore the total to zero, allowing for new calculation sequences.

#### CalculatorTest class
This test suite uses **AssertJ** to verify the calculator's reliability. It focuses on several critical aspects:
- **Initial State**: Ensures the calculator is instantiated and starts with a total of zero.
- **Cumulative Operations**: Validates that multiple calls to different methods (e.g., adding then subtracting) correctly update the internal `total` and that `getTotal()` returns the expected result.
- **Error Handling**: Uses `assertThatThrownBy` to confirm that division by zero is correctly identified and handled.
- **Functional Flow**: Tests the `reset()` functionality and checks that the methods return the updated total immediately after the operation, ensuring the API behaves as expected for the user.