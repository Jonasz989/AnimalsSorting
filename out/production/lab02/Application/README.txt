Autor: Damian Jabłoński
!!!!!!!!!!!!!!!!!!!!!!!!!!!WAŻNE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Plik zawierający zwierzęta powinien nazywać się "animals.txt"
Plik zawierający typy zwierząt powinien nazywać się "types.txt"
Plik zawierający farmy powinien nazywać się "farms.txt"
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Zakładamy, że dane, które wczytujemy są w 100% poprawne. Algorytm, który piszemy nie musi być najszybszym na świecie, ale powinien działać wystarczająco szybko.

Podejście do problemu. Struktury, które wczytujemy mogą okazać się bardzo duże, dlatego ważne jest posortowanie ich.

1. Wczytać pliki
2. Posortować typy zwierząt i sprawdzić, które zabiera najwięcej jedzenia. Na podstawie tego będziemy umieszczać zwierzęta do farm.
3. Posortować farmy od największej ilości jedzenia do najmniejszej.
4. Posortować zwierzęta według typu, który zjada najwięcej.
5. Zacząć iterację po zwierzętach. Sprawdzić, ile wymaga pokarmu, potem sprawdzić,
czy w pierwszej farmie (która posiada największą ilość jedzenia) jest tego jedzenia wystarczająco. Jeśli tak, przypisujemy ID zwierzęcia do farmy,
jesli nie sprawdzamy kolejną farmę, aż do końca. Możemy też dodać warunek, który
-kiedy suma wymaganego jedzenia jest większa niż całe jedzenia na farmie to przechodzimy do następnego zwierzęcia
myślę, że dany warunek pozwoli nam zaoszczędzić przeglądanie części farm przez co przyśpieszy działanie programy
6. Posiadamy teraz przypisane i nieprzypisane zwierzęta, więc możemy zabrać się za robienie zestawienia niewykorzystanego potencjału farm
