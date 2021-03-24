# Samenvatting

### Algemene principes

**Modularization**

Verdelen van functionaliteit in onafhankelijke modules.

**Information Hiding**

Interne details van een class moeten verborgen blijven voor andere classes.

**High Cohesion**

Cohesion gaat over hoe goed taken in een class of module bij elkaar horen. Je moet dingen bij elkaar stoppen die bij elkaar horen.

**Low Coupling**

Een lage koppeling is belangrijk. Dat houdt in dat een class weinig afhankelijkheden heeft van andere classes.

### SOLID

**Single Responsibility Principle**

Elke klasse moet maar voor één stukje van het geheel verantwoordelijk zijn.
"A class should have only one reason to change."

**Open/Closed Principle**

"Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification."
Gedrag moet kunnen worden uitgebreid maar niet worden aangepast. Er komen dus veel abstracte klasses en interfaces in de code.
Strategy Pattern heeft een sterke relatie met dit principe.

**Dependency Inversion Principle**

"High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend upon abstractions."
Dit principe gaat over het verlagen van de koppeling.

### GRASP

**Information Expert**

Probleem
Ik moet responsibilities aan classes toewijzen
Welk algemeen principe kan ik hierbij gebruiken?

Oplossing:
Wijs een responsibility toe aan die class die de vereiste informatie heeft om aan die responsibility te voldoen.

Voordeel van Expert:
Information hiding wordt dan in stand gehouden

**Creator**

Probleem
Welk object mag een instantie van een class A aanmaken?

Oplossing:
Geef die verantwoordelijkheid aan een class B waarvoor geldt:

-   B ‘bevat' A
-   B legt A vast
-   B gebruikt A het meest
-   B heeft de initialisatie-data voor A

**Controller (Facade, Use Case)**

Probleem:
Welke (niet-UI) class moet de system events afhandelen? Zoals gevonden in een System Sequence Diagram

Oplossing:
Geef de responsibility aan een class die:

-   Het _totale systeem_ representeert
    Façade controller
-   Of de _use case_ representeert
    Use-case controller

### GOF Design Patterns

**Observer Pattern**

Wanneer?

Toestand van objecten is afhankelijk van een ander object.
![Observer](https://github.com/IkBenDeSjaak/OOSE/blob/main/OOAD/Toets%20-%20OO%20Design/patterns/observer.png)

**Strategy Pattern**

Wanneer?

Een object heeft meerdere opties om een operatie uit te voeren.
![Strategy](https://github.com/IkBenDeSjaak/OOSE/blob/main/OOAD/Toets%20-%20OO%20Design/patterns/strategy.png)

**State Pattern**

Wanneer?

Gedrag van een object is afhankelijk van zijn huidige status. Dus bij verandering van zijn state verandert ook zijn gedrag.
![State](https://github.com/IkBenDeSjaak/OOSE/blob/main/OOAD/Toets%20-%20OO%20Design/patterns/state.png)

**Adapter Pattern**

Wanneer?

Een klasse verwacht een bepaalde interface voor een methode maar de service/klasse gebruikt een andere interface. Wordt voornamelijk gebruikt voor externe libraries.
![Adapter](https://github.com/IkBenDeSjaak/OOSE/blob/main/OOAD/Toets%20-%20OO%20Design/patterns/adapter.png)

**Factory Pattern**

Wie mag de Adapters maken?

Factory bepaalt welke adapter er gemaakt wordt. Zo wordt de cohesie verhoogt.
![Factory](https://github.com/IkBenDeSjaak/OOSE/blob/main/OOAD/Toets%20-%20OO%20Design/patterns/factory.png)
