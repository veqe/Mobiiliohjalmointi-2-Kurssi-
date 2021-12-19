# Mobiiliohjalmointi-2-Kurssi-
Harjoitustyö Mobiiliohjelmointi 2 kurssista.

embedded-tomcat-template-Harkka ja sen tietokanta on Chinook_Sqlite.sqlite

embedded-tomcat-template ja sen tietokanta on shoppingList.sqlite

Jos jommankumman haluaa kloonata ja toimimaan pitää mennä projektissa 
scr/main/java/database
kansioon ja sieltä 
database.java 
tiedostoon.
scr/main/java/database/database.java

embedded-tomcat-template-Harkka projektissa 
database.java tiedoston rivillä 11 pitää muuttaa url oikeaksi. 
Riippuen siitä minne tallentaa Chinook_Sqlite.sqlite tiedoston omalla tietokoneella.

embedded-tomcat-template projektissa taas
database.java tiedoston rivillä 10 pitää muuttaa url oikeaksi.

Täällä se on tallennettu ympäristömuuttujaan. Jos ei tunne ympäristömuuttujia, niin voi rivin koodia muokata käsin seuraavaksi.
private static final String JDBC_URL = System.getenv("JDBC_DATABASE_URL");  
--->
private static final String JDBC_URL = "jdbc:sqlite:C:\\sQlite\\Chinook_Sqlite.sqlite";

Tuo loppu osa eli C:\\sQlite\\Chinook_Sqlite.sqlite"; on oman tiedoston C hakemiston kansio sQlite minne olen tallentanut tietokannan.
Riippuen siitä minne tallentaa Chinook_Sqlite.sqlite tiedoston omalla tietokoneella.

