# BrilloconnetzTestSolutions
Brilloconnetz Java Developer Test Solution

## Table of Contents

- [Questions](#questions)
  - [Question One](#question-one)
  - [Question Two](#question-two)
- [Language Used](#language-used)
- [Dependencies](#dependencies)
- [How to Use](#how-to-use)
- [Solution One Snippet](#solution-one)

## Questions

### Question One
Write a java application (console or Gui) that collects the following inputs:
Username: validation required (not empty, min 4 characters)
Email: validation required (not empty, valid email address)
Password: validation required (not empty, strong password with at least 1 upper case, 1 special
characters: e.g., !@#$%^&*, 1 number and must be minimum of 8 characters)
Date of Birth: validation required (not empty, should be 16 years or greater)
- **A**: perform these validations and return true if all validations are passed. If the validation fails, return
        all the fields that failed with a message of which of the validation requirements for each of those
        fields that fails e.g., Email: not empty, Password: not a strong password.
- **B**: Perform the validation checks in A for the 4 fields (username, email, password and date of birth)
  concurrently (Note, do not use Threads, or ExecutorServices).
- **C**: Building on your solution on B, instead of returning true when all validations pass, write a method
to generate a signed JWT and return it.
- **D**: Using the token generated in C, write a method to verify the signed token, return the string
“verification pass” if it passes and “verification fails” if it does not.
- **E**: Write a JUnit Test case for D to check to test a valid and invalid token.

### Question Two
Create a console-based program that allows the shopkeeper to make pancakes, and the 3 users
can eat the pancakes simultaneously. A single user can eat maximum 5 pancakes within 30 seconds.
Also, the shopkeeper can make a maximum of 12 pancakes every 30 seconds. The system should
decide the number of pancakes that each of the 3 users want to eat in the 30 second’s period; but
cannot exceed the maximum 5 pancakes rule (A simple way to decide the numbers of pancakes is to
generate them randomly). The code could output the following.
- starting time of the 30 seconds slots,
- the ending time of the 30 seconds slots
- number of pancakes made by the shop keeper, number of pancakes eaten by the 3 users
- whether the shopkeeper was able to meet the needs of the 3 users or not
- how many pancakes got wasted if any.
- If the shopkeeper was not able to meet the needs of all the customers, how many pancake
orders were not met.

Provide a non-concurrent and concurrent (Note, do not use Threads, or ExecutorServices) Java
program to solve this. Compare and contrast both versions of the code and state your observations.


## Language Used
- Java

## Dependencies

```maven
<dependencies>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.2</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.2</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson if Gson is preferred -->
            <version>0.11.2</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```

## How to Use

1. Clone the ePay repository to your local machine:
```git
git clone https://github.com/gitpeters/BrilloconnetzTestSolutions.git
```

2. Ensure you have the following prerequisites installed:
- Java Development Kit (JDK)
- IntelliJ IDE or any of your favourite IDE that supports JVM
- The listed dependencies

## Solution One
![solution1-snippet](https://github.com/gitpeters/BrilloconnetzTestSolutions/assets/111524304/bbf86f3b-f0fb-4968-a3ff-2d673ea770a0)



