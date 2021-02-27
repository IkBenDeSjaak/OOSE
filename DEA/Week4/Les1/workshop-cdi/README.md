# Introductie
Deze workshop is deel van de DEA Course aan de Hogeschool Arnhem/Nijmegen. 

Onderwerp is het bekend raken met CDI en het unittesten van een JavaEE applicatie.

# Oefening
Deze oefening is het vervolg op de oefening [Simply the Rest](https://github.com/HANICA-DEA/workshop-simply-the-rest). 
De startcode van deze oefening is de eindcode van Simply the Rest.

## 1: Unittests toevoegen
We beginnen met het toevoegen van unittests voor de klassen `HealthCheckResource` en `ItemResource`.

### 1.1: `HealthCheckResource`
Voeg aan je project een dependency op jUnit toe en schrijf een unittest voor de methode uit de klasse `HealthCheckResource`.

### 1.2: `ItemResource`
Schrijf voor iedere methode uit de klasse `ItemResource` een zinnige unittest. Omdat deze methode gebruik maakt van de `ItemService` en daar ook hard aan is gekopppeld, kun je alleen de happy-flow testen. Voor **nu** is dat voldoende!

Waarschijnlijk loop je nog wel tegen een probleem aan bij het testen van de methodes die een `Response` teruggeven.
Lees de stacktrace goed door en gebruik Google om een oplossing te vinden.

Om je alvast in de goede richting te helpen: 
- Je JavaEE container levert een implementatie van `Response` op runtime:
   - in je `pom.xml` is dit de `javaee-api` artifact met de scope `provided`
- In de context van een unittest, maak je **geen** heb je niet de beschikking over deze JavaEE Container. Dit zorgt voor de `Exceptie` ergens in de teruggeven stacktrace, die klaagt over een missende *implementerende klasse*.
- Om dit op te lossen breid je zelf je `pom.xml` uit, zoals de google zoekactie je vertelt:
   - extra `dependency` toevoegen met de scope `test`, zodat ook in de test de `Response` klasse een implementatie heeft).

## 2: Toevoegen Dependency Injection
In het vorige onderdeel schreef je unittests en mogelijk liep je tegen het probleem aan dat je niet goed wist wat je nu eigenlijk moest testen. Waarschijnlijk kwam je niet veel verder dan het testen of het `Response` de te verwachten status-code bevatte. Maar of ook daadwerkelijk de juiste methodes op de `ItemService`, met de juiste parameters werden aangeroepen, heb je vast niet getest.

In de huidige vorm is dat ook uitzonderlijk lastig te testen. Dit komt omdat de `ItemService` hard gekoppeld is aan de `ItemResource`. Wanneer je nu de `ItemResource` test, test je eigenlijk ook de `ItemService`. Buiten het probleem dat je nu niet eens kan testen of de `ItemResource` correct gebruik maakt van de `ItemService`, heb je daarmee ook het probleem dat je, wanneer een test faalt, niet goed weet of de fout nu in `ItemResource` of in de `ItemService` zit.

We lossen dit probleem op door de `ItemService` los te koppelen van de `ItemResource`, met behulp van Dependency Injection.
Hiermee kunnen we de code beter laten voldoen aan de **D** van **SOLID**, het **D**ependency Inversion Principle. In het volgende onderdeel zie je hoe je de `ItemResource` apart kunt testen.

### 2.1: Het omkeren van de afhankelijkheid (Dependency Inversion)
Momenteel is de `ItemResource` afhankelijk van de `ItemService`. Stel dat de methode `getAll()` uit de `ItemService` van naam verandert, dan moet je ook de `ItemResource` aanpassen. Dit gaan we mooier opzetten; we maken een interface die vastlegt welke methodes de `ItemResource` verwacht. Het type van de instantievariabele van de `ItemService` in de `ItemResource` pas je daarna aan naar de Interface. Tot slot moet de `ItemService` de interface implementeren.
* Hernoem de `ItemService` naar `HardCodedItemService`. De waarden zijn tenslotte hard-coded en dit geeft dus beter aan wat je van de klasse kunt verwachten.
* Creëer een interface op basis van de `HardCodedItemService` en noem deze `ItemService`. Gebruik bij voorkeur de refactor-functies van je IDE.
* Zorg dat de `HardCodedItemService` de interface `ItemService` implementeerd.
* Pas het type van de instantievariabele op de `ItemResource` aan.

### 2.2: Toepassen Dependency Injection
De constructor van de `ItemResource` instantieert een nieuwe instantie van de `HardCodedItemService` en wijst deze toe aan een instatievariabele. Deze verantwoordelijkheid dragen we over aan de JavaEE container, door gebruik te maken van CDI:
* Verwijder de volledige constructor van de `ItemResource`.
* Creëer een setter voor de instantievariabele genaamd `itemService`.
* Annoteer de setter met `@Inject`.
* Om CDI 'aan' te zetten is het nog nodig om een *beans.xml* bestand op de juiste plek te zetten. Lees dit artikel voor meer informatie hierover: [An Introduction to CDI ](https://www.baeldung.com/java-ee-cdi).

## 3: Repareren van de unittests
Door het toevoegen van Dependency Injection in stap 2 leveren nu de unittests `NullPointerException`s op.  In dit onderdeel repareer je dat en daarbij maak je ook gebruik dat de `ItemResource` niet langer hard gekoppeld is aan de `ItemService`. Om de tests nog zinniger te maken introduceren we het concept van [Mocking](https://medium.com/@piraveenaparalogarajah/what-is-mocking-in-testing-d4b0f2dbe20a), waarvoor we gebruik gaan maken van het framework [Mockito](https://site.mockito.org/)

### 3.1: Mocken van een `ItemService`
In iedere unittest maak je naast een instantie van de SUT ook een `ItemService`, die je vervolgens via een *setter* op de SUT plaatst. Wanneer we een instantie maken van een `ItemService`, bijvoorbeeld de `HardCodedItemService`, dan blijft onze
unittest afhankelijk van die `HardCodedItemService`. Wanneer een test faalt, dan kan dit nog steeds komen doordat er een bug zit in de `ItemResource` of de `HardCodedItemService`. Een zeer onwenselijke situatie!

Dit los je op door geen *echte* `ItemService` te gebruiken, maar een gemockte:
* Voeg een dependency toe op de laatste versie van [Mockito](https://site.mockito.org/) (kies voor het artifactId: *mockito-core*)
* Voeg aan je testklasse de volgende instantie variabele toe:
```        
    private ItemService mockedItemService;
```
* Gebruik de `setup()` methode om een gemockte `ItemService` aan je SUT toe te voegen:
```
    @BeforeEach
    void setup() {
        this.sut = new ItemResource();
        
        // Gebruik Mockito om een instantie te maken
        this.mockedItemService = Mockito.mock(ItemService.class);
        
        // Gebruik de setter om de mockedItemService te zetten
        this.sut.setItemService(mockedItemService);
    }
```

Run je tests. Mogelijk zijn er al test die nu slagen. Als dat zo is, dan toont dit voornamelijk aan dat de unittests slecht zijn en weinig waarde toevoegen. De methodes in de gemockte `ItemService` bevatten namelijk nog geen gedrag.

### 3.2 Toevoegen van zinnige unittests voor `getJsonItems()`
Nu we via Mockito een gemockte `ItemService` hebben gemaakt, kunnen we al het gewenste gedrag van de `ItemResource` testen. We doen dit voor de tests van de methode `getJsonItems()`.

Hiervoor schrijven we de volgende tests schrijven, die al het gewenste gedrag van de methode vastleggen:
1. Wanneer je de methode `getJsonItems()` aanroept, moet deze op de `ItemService` de methode `getAll()` aanroepen.
2. Wanneer je de methode `getJsonItems()` aanroept **en** de methode `getAll()` op de `ItemService` retourneert een Object, dan:
    * Is de status code van de `Response` 200
    * Levert de `getEntity()` methode van de `Response` het Object terug dat de `getAll()` retourneerde

Haal hiervoor de bestaande unittest voor de betreffende methode weg. We vervangen deze door twee nieuwe unittests.

* Schrijf een nieuwe unittest genaamd `getJsonItemsCallsGetAll`
* In de *Arrange* hoeft niks te gebeuren.
* In de *Act* roep je op de SUT de te testen methode aan. 
* In de *Assert* test je of deze methode de methode `getAll()` daadwerkelijk aanriep: 
```
    Mockito.verify(mockedItemService).getAll(); 
```
* Schrijf een nieuwe unittest genaamd `getJsonReturnsObjectFromServiceAsEntity()`
* In de *Arrange* zorg je m.b.v. Mockito dat je gemockte `ItemService` een specifiek Object retourneert:
```
    var itemsToReturn = new ArrayList<ItemDTO>();
    Mockito.when(mockedItemService.getAll()).thenReturn(itemsToReturn);
```
* In de *Act* roep je op de SUT de te testen methode aan. 
* In de *Assert* test je of de Entity in de `Response` hetzelfde Object is als die je mock teruggeeft

### 3.2 Toevoegen van zinnige unittests voor de overige methodes
Maak nu ook zinnige unittests voor de overige methodes. Deze zijn vergelijkbaar met de hierboven beschreven tests.

### 3.3 Toevoegen unittests voor de foutafhandeling
Waarschijnlijk heb je nu alleen de happy-flow getest. Door het gebruik van de ExceptionMappers is het ook van belang dat de `ItemResource` de gegooide exepties van het type `IdAlreadyInUseException` en `ItemNotAvailableException` niet vangt, maar gewoon doorgooit.

* In de *Arrange* zorg je ervoor dat wanneer de sut de methode op zijn/haar gemochte dependency aanroept, deze de exceptie van het juiste type gooit. Gebruik eventueel deze [tutorial](https://www.baeldung.com/mockito-exceptions).
* De *Act* en de *Assert* vallen enigzins samen door de API van jUnit. In het *Assert* deel test je of de sut de verwachtte exceptie ook daadwerkelijk gooit. Gebruik eventueel deze [tutorial](https://howtodoinjava.com/junit5/expected-exception-example/).

## 4: Injecteren van een alternatieve `ItemService`
In deze opgave maak je een tweede klasse maken die de interface `ItemService` implementeert. Vervolgens configureer je via de `beans.xml` welke van de twee implementaties te injecteren.

### 4.1 Een tweede implementatie
Maak een tweede klasse die de interface `ItemService` implementeert. Zorg voor een zinnige implementatie.

Deploy je applicatie op TomEE en bekijk wat er gebeurt. Lees de stacktrace. Is dit wat je verwacht?

### 4.2 Toevoegen van de benodigde annotaties
Je merkt als het goed is dat je de applicatie nu niet meer kan deployen. De applicatiecontainer weet namelijk niet welke `ItemService` hij moet instantiëren en injecteren. Los dit op door aan te geven welke de *Default* implementatie is en welke de *Alternative*.

* Bekijk weer: [An Introduction to CDI ](https://www.baeldung.com/java-ee-cdi) en zorg dat de `HardCodedItemService` de *Default* implementatie is. De andere is dan de *Alternative*.

### 4.3 Configuratie via de `beans.xml
Gebruik de `beans.xml` om te configuren dat CDI bij injectie gebruik maakt van de *Alternative*.

* De eerder genoemde tutorial bevat deze informatie niet. Gebruik google om uit te zoeken hoe je dit moet doen.
