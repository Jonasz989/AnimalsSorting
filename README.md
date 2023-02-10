# JezykiProgramowaniaLab2

For english below

Podczas laboratorium należy rozwiązać problem przydziału zwierząt do farm przy znanych ograniczeniach:
ilościowym zapotrzebowaniu na konkretne typy pożywienia przez konkretne zwierząta,
możliwościach ilościowego zapewnienia konkretnego typu pożywienia przez konkretne farmy,
kryteriach oceny dokonanego przydziału.
Nawiasem mówiąc podobny problem występuje w rzeczywistości: jeśli ktoś chce np. założyć farmę dzikich zwierząt, to w zależności od powierzchni tej farmy, rodzaju rosnącej na niej roślinności itp. będzie mógł wprowadzić na teren farmy tylko określoną liczbę odpowiednio dobranych zwierząt.
Zakładamy, że dane zwierząt czekających na przydział do farm podane są w dwóch tabelach. Pierwsza tabela zawiera listę zwierząt (każdemu zwierzęciu odpowiada osobny wiersz w tabeli, z identyfikatorem zwierzęcia oraz identyfikatorem typu tego zwierzęcia).
# Identyfikator zwierzęcia; Identyfikator typu zwierzęcia
1; 1;
2; 1;
3; 2;
...
Druga tabela zawiera informacje o potrzebach żywnościowych kolejnych typów zwierząt. Danemu typowi zwierzęcia może odpowiadać kilka wierszy w tej tabeli, odpowiednio do różnych typów pożywienia, które zwierzę danego typu potrzebuje. Ale uwaga: niekoniecznie wiersze te są posortowane po identyfikatorach zwierząt oraz identyfikatorach pożywienia.
# Identyfikator typu zwierzęcia; Identyfikator typu pożywienia; Wymagana masa pożywienia (w dekagramach)   
1; 1; 30
1; 2; 10
2; 1; 20
2; 2; 10
...
Dane dotyczące dostępności pożywienia na farmach podane są w trzeciej tabeli. W pierwszej jej kolumnie stoi identyfikator danej farmy. Dostępna masa j-tego typu pożywienia na danej farmie pojawiają się w j+1 kolumnie. Jeśli na danej farmie dany typ pożywienia nie występuje, wtedy w odpowiednim wierszu oraz kolumnie tabeli pojawia się 0.
# Identyfikator farmy; Dostępna masa pożywienia typu 1; Dostępna masa pożywienia typu 2; Dostępna masa pożywienia typu 3
1; 400; 300; 900
2; 0; 500; 300
...
Niech kryterium oceny dokonanego przydziału będzie miarą niewykorzystanego potencjału farm, mierzony różnicą tego, co farmy oferują i tego, co wykorzystają przypisane do tych farm zwierzęta:
P=∑i∑j(dij−∑kzijk)
gdzie
dij - masa pożywienia typu j dostępna na farmie i,
zijk - masa pożywienia typu j, które potrzebuje zwierzę k przypisane do farmy i.
Znalezione rozwiązanie, tj. rezultat przydziału zwierząt do farm, należy wypisać na ekranie w postaci tabelarycznej:
# Identyfikator farmy;Niewykorzystany potencjał farmy; Lista przypisanych zwierząt
1; 0; 1, 2
2; 100; 3
...
Jak widać, w żadnym przypadku identyfikator danego zwierzęcia nie może pojawić się wielokrotnie. W szczególności może się zdarzyć, że do danej farmy nie zostanie przypisane żadne zwierzę (wtedy lista przypisanych zwierząt dla tej farmy będzie pusta). Może się też zdarzyć, że nie da się znaleźć żadnego przydziału (gdy nie da się w żaden sposób zapewnić pożywienia dla wszystkich zwierząt). Wtedy program powinie wypisać zestawienie niewykorzystanego potencjału farm, w którym wszystkie listy przypisanych zwierząt są puste.
Pozostałe szczegóły mają być zgodne z ustaleniami poczynionymi na początku zajęć.


During the laboratory, the problem of allocating animals to farms with known constraints has to be solved:
the quantitative demand for specific types of food by specific animals,
the quantitative capacity of specific farms to provide specific types of feed,
criteria for evaluating the allocation made.
Incidentally, a similar problem exists in reality: if someone wants to set up a wildlife farm, for example, he will only be able to introduce a certain number of appropriately selected animals into the farm, depending on the area of the farm, the type of vegetation growing on it, etc.
We assume that the data of the animals waiting to be allocated to the farms are given in two tables. The first table contains a list of animals (each animal corresponds to a separate row in the table, with an animal identifier and an identifier of the type of that animal).
# Animal identifier; Identifier of the type of animal
1; 1;
2; 1;
3; 2;
...
The second table contains information about the food needs of the following animal types. A given animal type may correspond to several rows in this table, according to the different types of food that the animal of that type needs. But note: these rows are not necessarily sorted by animal identifiers and food identifiers.
# Animal type identifier; Food type identifier; Food weight required (in decagrams).   
1; 1; 30
1; 2; 10
2; 1; 20
2; 2; 10
...
Data on the availability of food on the farms are given in the third table. In its first column stands the identifier of the farm in question. The available weight of the jth type of food on the farm appears in the j+1 column. If a particular type of food does not appear on a given farm, then 0 appears in the corresponding row and column of the table.
# Farm ID; Available weight of type 1 food; Available weight of type 2 food; Available weight of type 3 food
1; 400; 300; 900
2; 0; 500; 300
...
Let the criterion for evaluating the allocation made be a measure of the unused potential of the farms, measured by the difference between what the farms offer and what the animals assigned to the farms will use:
P=∑i∑j(dij-∑kzijk)
where
dij - weight of food type j available on farm i,
zijk - the mass of food type j required by animal k assigned to farm i.
The solution found, i.e. the result of the allocation of animals to farms, should be plotted on the screen in tabular form:
# Farm ID;Unused farm potential; List of assigned animals
1; 0; 1, 2
2; 100; 3
...
As can be seen, in no case can the identifier of a given animal appear more than once. In particular, it may happen that no animal is assigned to a farm (in which case the list of assigned animals for that farm will be empty). It can also happen that no allocation can be found (when there is no way to provide food for all animals). In this case, the programme should print out a summary of the unused potential of the farms, in which all lists of allocated animals are empty.
The remaining details are to be as agreed at the beginning of the class.

Translated with www.DeepL.com/Translator (free version)
