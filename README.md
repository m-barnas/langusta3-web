## Langusta3 Web Application

_Convenient and easy to use UI for access to the morphological database_

### Functionality

A user is allowed to enter [word / sentence / regex / pattern] and use various filters in order to view a morhological analysis.

**You can easily find out:**

- How many words belong to a given pattern
- How many words belong to [exactly one pattern / one or more pattterns / exact number of patterns]
- All declined forms of a given word
- All words that belong to a given pattern
- All patterns for a given word 
- And much more

### A Database

Data is stored in [PostgreSQL](https://www.postgresql.org/). Actually, the database contains over 1,3 M rows what is a direct result of more than 100,000 proccesed, the most frequently used, czech words (basically nouns and adjectives).

### Technologies

The app makes heavy use of technologies such as [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) ([Maven](https://maven.apache.org/) Project), the [Hibernate](http://hibernate.org/) framework as the persistence layer and the latest stable release of [Spring Framework](https://projects.spring.io/spring-framework/). It also uses [React.js](https://facebook.github.io/react/) coded in ES6.

### UX backbone

Design of our UX backbone is available for download [here](https://github.com/m-barnas/langusta3-web/issues/1#issuecomment-300812542).

### Support or Contact

Having any trouble? Check out our documentation either for [developers](https://github.com/m-barnas/langusta3-web/wiki/For-developers) or for [users](https://github.com/m-barnas/langusta3-web/wiki/For-users). Feel free to contact [us](https://github.com/m-barnas/langusta3-web/wiki/About-authors) and we’ll help you sort it out.
