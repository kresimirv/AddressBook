# Address Book
Command line contact manager. Allows you to display, create, edit and remove address book contacts.

## Development notes
**IDE:** Eclipse

**Used technologies:** Java 8, jUnit 4

## Demonstrated programming and OOP features
**Design patterns:** Strategy pattern (behavioral) and factory method (creational)

**Class inheritance**

**Method overloading**

**Unit testing**


## How to run application
### Show help

java -jar AddressBook.jar --help

### Show all contacts

java -jar AddressBook.jar --display 

### Add a new contact
java -jar AddressBook.jar --add --category family --name John --surname Doe --telephone 111111 --email john.doe@gmail.com --age 20 --hair-color black --family-relationship son

java -jar AddressBook.jar --add --category friends --name Reed --surname Spencer --telephone 222222 --email reed.spancer@gmail.com --age 30 --friendship-years 10

java -jar AddressBook.jar --add --category acquaintance --name Kathrine --surname Bridges --telephone 333333 --email kathrine.bridges@gmail.com --age 40 --hair-color black

### Edit a existing contact
java -jar AddressBook.jar --edit --id 357b4615-1991-413e-9afd-a4749522a2da --telephone 123456

### Delete a contact
java -jar AddressBook.jar --remove --id 357b4615-1991-413e-9afd-a4749522a2da




