# Protocol
### Protocol Pferdefiueranlage
### Version: 1.0.5

## Inhaltsangabe
1. Kommunikationsmanagment  
1.1 Zweck  
1.2 Protocol Daten  
2. Telegram  
2.1 Allgemeine Form der Telegramme  
2.2 Funktionen  
2.2.1 Wasser  
2.2.2 Neues Pferd hinzufügen  
2.2.3 Benutzer registrieren  
2.2.4 Pferd löschen  
2.2.5 Benutzer löschen  
2.2.6 Info Pferd  
2.2.7 Info Benutzer  
2.2.8 Pferd überarbeiten  
2.2.9 Benutzer überarbeiten  
2.2.10 Stop  
2.2.11 Status  
2.2.12 Start  
2.2.13 Anlage
2.2.14 Login    
3. Fehler  

## 1. Kommunikationsmanagment  
### 1.1 Zweck
Zweck dieses Protokolls ist es, dass eine Android App über TCP/IP mit einem Datenbankserver kommunizieren kann. Ein zweiter Client, kann auf den Datenbankserver zugreifen und die Daten abfragen, die auf der Datenbank abgelegt sind, um die Anlage zu starten. Der Server und die Clients bleiben im regelmäßigen Kontakt. Das Timeout beträgt bei dieser Verbindung 100ms, wird eine ausgelöst bleibt die Anlage sofort stehen.

### 1.2 Protocol Daten
Es ist ein Verbindungsorientiertes TCP/IP Protokoll was über das Ethernet funktioniert. Außerdem ist es ein Texorientiertes Zustandsloses Protokoll. Das Port über das dieses Protokoll komuniziert ist "1111".


C = Client  
S = Server

## 2. Telegram  

### 2.1 Allgemeine Form der Telegramme  

| Anweisung  | Daten |
| ------------- |:-------------:|
|anweisung | Daten | 

Dieser String wird dann in json zusammengesetzt und versendet
  
Beispiel:  

{"anweisung":"water","messages":["on"]}
  


### 2.2 Funktionen  

#### 2.2.1 Wasser an/aus
| Anweisung  | Daten|
|-------------|:-----:|
|water| Wasser on/off |  

Antwort:

| Anweisung  | Daten|
|-------------|:-----:|
|water| true/false |  

Beispiel:

C: {"anweisung":"water","messages":["on"]}

S: {"anweisung":"water","messages":["true"]}

Die Anweisung ist dafür da, um die Wassersprühanlage ein oder auszuschalten.  

#### 2.2.2 Neues Pferd hinzufügen

| Anweisung  || Daten||
|-------------|:-----:|--:|--:|
| new | Pferdname | Trainigszeit(s) | Anzahl der Drehrichtungsänderungen | 

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
|new | true/false | 

Beispiel:

C:{"anweisung":"new","messages":["Franz","500","5"]} 

S: {"anweisung":"new","messages":["true"]} 

Sie ist dafür da, um ein neues Pferd in die Datenbank zu schreiben

#### 2.2.3 Benutzer Registrieren

| Anweisung  | | |Daten||
|-------------|:-----:|:----:|:----:|:--:|
| registrate | Vorname | Nachname | Benutzername | Passwort |  

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
|registrate| true/false | 

Beispiel:

C:{"anweisung":"registrate","messages":["Lukas","Freyler","Lukas17","Lukas123"]} 

S: {"anweisung":"registrate","messages":["true"]} 

Sie ist dafür da, um einen neuen Beutzer in die Datenbank hinzuzufügen.

#### 2.2.4 Pferd löschen  
| Anweisung  | Daten|
|-------------|:-----:|
| deletehorse | Name |  

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
|deletehorse| true/false | 

Beispiel:

C: {"anweisung":"deletehorse","messages":["Franz"]}

S: {"anweisung":"deletehorse","messages":["true"]} 

Die Anweisung ist dafür da, um ein Pferd aus der Datenbank zu löschen.  

#### 2.2.5 Benutzer löschen

| Anweisung  | Daten|
|-------------|:-----:|
| deleteuser | Benutzername |  

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
|deleteuser| true/false |

Beispiel:

C: {"anweisung":"deleteuser","messages":["Lukas17"]}

S: {"anweisung":"deleteuser","messages":["true"]} 

Die Anweisung ist dafür da, um einen Benutzer aus der Datenbank zu löschen.  

#### 2.2.6  Info Pferd

| Anweisung  | Daten|
|-------------|:-----:|
| infohorse | Name vom Pferd |  

Antwort:

| Anweisung  | |Daten||
|-------------|:-----:|:---:|:---:|
| infohorse | Name | Traingszeit(s) | Anzahl der Drehrichtungsänderung |  

Beispiel:

C: {"anweisung":"infohorse","messages":["Franz"]}

S: {"anweisung":"infohorse","messages":["Franz","500","5"]} 

Die Anweisung ist dafür da, um alle Daten über das Pferd zu bekommen.  

#### 2.2.7 Info Benutzer

| Anweisung  | Daten|
|-------------|:-----:|
| infouser | Benutzername |

Antwort:  

| Anweisung  | | |Daten||
|-------------|:-----:|:---:|:---:|:---:|
| infouser | Vorname | Nachname | Benutzername | Passwort |  

Beispiel:

C: {"anweisung":"infouser","messages":["Lukas17"]}

S: {"anweisung":"infouser","messages":["Lukas","Freyler","Lukas17","Lukas123"]} 

Die Anweisung ist dafür da, um alle Daten von einem Benutzer zu bekommen

#### 2.2.8 Pferd überarbeiten

| Anweisung  | |Daten| |
|-------------|:-----:|:---:|:---:|
| updatehorse |  Pferdname | Trainigszeit(s) | Anzahl der Drehrichtungsänderungen |  

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
|updatehorse| true/false |

Beispiel:

C: {"anweisung":"updatehorse","messages":["Franz","400","6"]} 

S: {"anweisung":"updatehorse","messages":["true"]} 

Server erhält neue Daten von einem Pferd, die in der Datenbank ausgetauscht werden.

#### 2.2.9 Benutzer überarbeiten

| Anweisung  | Daten|
|-------------|:-----:|
| updateuser | Benutzername |  

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
| updateuser | true/false |  

Beispiel:

C: {"anweisung":"updateuser","messages":["Hannes","Fritz","Lukas17","Schule2"]}

S: {"anweisung":"updateuser","messages":["true"]} 

Server erhält neue Daten von einem Benutzer, die in der Datenbank ausgetauscht werden.

#### 2.2.10 Stop

| Anweisung  | Daten|
|-------------|:-----:|
| stop | Art des stops |  

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
|stop| true/false |  

Beispiel:

C: {"anweisung":"stop","messages":["hardstop"]} 

S: {"anweisung":"stop","messages":["true"]} 

Die Anweisung ist dafür, wie der Benutzer die Maschine stoppen kann (z.B. Notstop, pausieren).

Weitere Arten von Stopps:

werden noch genauer besprochen

#### 2.2.11 Status

| Anweisung  | Daten|
|-------------|:-----:|
| status |  |  

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
|status | Fehler |  

Beispiel:

C: {"anweisung":"status","messages":[" "]} 

S: {"anweisung":"status","messages":["err02"]} 

Die Anweisung ist dafür da, dass das Handy und der Server im regelmäßigen Kontakt bleiben, wenn irgendein Fehler auftritt, dass der Benutzer reagieren kann.  

#### 2.2.12 Start

| Anweisung  | Daten|
|-------------|:-----:|
| start | Pferdename |  

Antwort:  

| Anweisung  | Daten|
|-------------|:-----:|
|start | true/false |  

Beispiel:

C: {"anweisung":"start","messages":["Franz"]} 

S: {"anweisung":"start","messages":["true"]} 

Die Anweisung ist für den Anlagenstart da. Es wird der Name des schwächsten Pferdes übergeben. Die Parameter der Anlage werden auf dieses Pferd eingestellt und gestartet.  

#### 2.2.13 Anlage

| Anweisung  | Daten|
|-------------|:-----:|
| get | Fehler |  

Antwort:  

| Anweisung  | | |Daten| |
|-------------|:-----:|:-:|:-:|:-:|
| get | Stop | Water(on/off) | Trainingszeit |  Anzahl der Drehrichtungsänderung|   

Beispiel

C: {"anweisung":"get","messages":[" "]} 

S: {"anweisung":"get","messages":["nothing","on","400","5"]} 

Die Anweisung ist dafür da um im stetigen Kontakt mit der Anlage zu sein, um die Anlage zu starten(Wasser auch) um gegebenfalls Fehler von der Anlage abzufragen.  

#### 2.2.14 Login

| Anweisung  | Daten||
|-------------|:-----:|:-:|
| login | Bentzername| Passwort |

Antwort:

| Anweisung  |Daten|
|-------------|:-:|
| login | true|

Beispiel:  

C: {"anweisung":"login","messages":["Lukas17","Lukas123"]}

S: {"anweisung":"login","messages":["true"]}

Zum Anmelden

## Fehler  

| Code  | Funktion | beschreibung | Was passiert?|
| ------------- |:-------------:|:-----:|:--:|
|err01 | Timeout Error | Wenn ein Client oder der Server innerhalb des Timeouts keine Rücklmeldung mehr gibt kommt es zu einem Timeout Error| Maschiene wird ausgeschalten |
|err02 | Database not rechable | Datenbank kann nicht erreicht werden | Fehlermeldung an den Client |
|err03 | Telegram fehlerhaft | Das Telergramm vom Server/Client ist fehlerhaft | Der Fehler wird an den Client geschickt und es wird vom Sender verlangt, es erneut zu senden |  