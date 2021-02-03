# Introductie

Deze oefening is deel van de DEA Course aan de Hogeschool Arnhem/Nijmegen. 
Onderwerp is het bekend raken met Test Driven Development.



# Oefening

Voor de volgende TDD Kata uit. Hou je daarbij aan de volgende eisen:

* Lees niet vooruit
* Doe één ding tegelijk. Het gaat erom dat je incrementeel leert werken, niet dat je het snel af krijgt.
* Test alleen voor correcte invoer. Foutieve invoer hoeft niet te worden getest in deze Kata

De Kata bestaat uit vijf stappen, met vier extra stappen voor de gevorderde developers.


1. Maak een nieuw Maven project.
2. Maak een Klasse genaamd `StringCalculator` en een enkele methode `public int add(String numbers)`.
    1. Deze methode kan 0, 1 of 2 getallen verwerken en retourneert hun som. 
    2. Voor een lege String retourneert hij 0. Dus: 

        > ```“” => 0```

        > ```“1” => 1```

        > ```“1,2” => 3```

    3. Begin met de simpelste test, namelijk voor de lege String.
    4. Maak daarna een test voor een enkel getal en pas wanneer deze werkt een test voor twee getallen.
    5. Maak de simpelste oplossingen waardoor een test slaagt.
    6. Vergeet niet te refactoren na iedere geslaagde test.
    
3. Zorg ervoor dat de methode een willekeurig aantal getallen kan verwerken.
4. Zorg ervoor dat de methode ook met een new line (\n) als delimiter werkt. Dus niet enkel komma’s. De 
    volgende invoer is dus correct

    >  ```“1\n2,3” => 6```
        
5. Zorg ervoor dat de methode gebruikt kan worden met verschillende delimiters.
    1. Om een delimiter te gebruiken moet het begin van de invoer er als volgt uit zien:
    
        > ```“//[delimiter]\n[numbers…]”```
        
    2. Dus `“//;\n1;2” => 3`, waarbij de delimiter `‘;’` wordt gebruikt.
    3. De eerste regel met delimiter is optioneel. Alle voorgaande scenario’s 
    moeten nog steeds werken.
6. Getallen groter dan 1000 moeten worden genegeerd. Dus:
    > ```“2 ,1001”  => 2```
7. Delimiters van iedere lengte zijn toegestaan, bijvoorbeeld:
    > ```“//[***]\n1***2***3” => 6```
8. Meerdere delimiters zijn toegestaan, bijvoorbeeld:
    > ```“//[delim1][delim2]\n”``` 
    
    voor de string 
    
    > ```“//[*][%]\n1*2%3” => 6```
