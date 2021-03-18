# 10.2.1 AdventureQuest

## Opdracht A
Een karakter kan als vervoermiddel toegewezen krijgen: een auto, een fiets, een scooter of een step. Dit zijn vier verschillende implementaties van een vervoermiddel. Gebruik het Factory Method Pattern om vanuit de Garage de vervoermiddelen te creëren.
  
  
**IVervoermiddel interface:**
````java
public interface IVervoermiddel {

    public void zetInGarage();

    public Vervoermiddel haalUitGarage();
}
````

**Vervoermiddelen implementaties:**
````java
public class Auto implements IVervoermiddel {
    @Override
    public void zetInGarage() {

    }

    @Override
    public Vervoermiddel haalUitGarage() {
        return null;
    }
}

public class Fiets implements IVervoermiddel {
    @Override
    public void zetInGarage() {

    }

    @Override
    public Vervoermiddel haalUitGarage() {
        return null;
    }
}

public class Scooter implements IVervoermiddel {
    @Override
    public void zetInGarage() {

    }

    @Override
    public Vervoermiddel haalUitGarage() {
        return null;
    }
}

public class Step implements IVervoermiddel {
    @Override
    public void zetInGarage() {

    }

    @Override
    public Vervoermiddel haalUitGarage() {
        return null;
    }
}
````

**VervoermiddelenFactory implementatie:**
````java
public class VoertuigenFactory {

    public IVervoermiddel createVervoermiddel(String voertuigtype) {
        switch (voertuigtype) {
            case "Auto":
                return new Auto();

            case "Fiets":
                return new Fiets();

            case "Scooter":
                return new Scooter();

            case "Step":
                return new Step();

            default:
                return null;
        }
    }
}
````

**Garage implementatie:**
````java
public class Garage {
    VoertuigenFactory voertuigFactory = new VoertuigenFactory();
    
    // ... other code ...

    public IVervoermiddel createVervoermiddel(String voertuigtype) {
        return voertuigFactory.createVervoermiddel(voertuigtype);
    }
}
````



## Opdracht B
Er is gekozen om gebruik te maken van een klasse ‘BelangrijkVoorwerp’, die door een externe partij wordt geleverd. We mogen deze code niet wijzigen. Maak gebruik van het Adapter Pattern om deze klasse ongewijzigd te kunnen gebruiken.

**Implementatie van de class BelangrijkVoorwerp**
````java
/**
 * Dit is een "extern" vierkant voorwerp wat niet past bij onze ronde voorwerpen.
 * Hier moet dus een Adapter voor gemaakt worden.
 */
public class BelangrijkVoorwerp {
    private double width;

    public BelangrijkVoorwerp(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}
````

**Implementatie van de Adapter**
````java
public class BelangrijkVoorwerpAdapter extends RondVoorwerp {
    private BelangrijkVoorwerp belangrijkVoorwerp;

    public BelangrijkVoorwerpAdapter(BelangrijkVoorwerp belangrijkVoorwerp) {
        this.belangrijkVoorwerp = belangrijkVoorwerp;
    }

    @Override
    public double getRadius() {
        return (Math.sqrt(Math.pow((belangrijkVoorwerp.getWidth() / 2), 2) * 2)); // <-- Niet getest of het ook echt werkt..
    }
}
````

**Implementatie van onze huidige ronde voorwerpen, wat werkend is in ons programma**
````java
public class RondVoorwerp {
    private double radius;

    public RondVoorwerp() {

    }

    public RondVoorwerp(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
````
