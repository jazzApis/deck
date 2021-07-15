# deck
Szkielet webowego api do kolejkowanego drukowania dokumentów 

# requerements
* Java Spring boot
* Maven

# endpoints
root: printer

printer
* get: {{root}}/list  - lista drukarek
* get: {{root}} - drukarka domyślna
* put: {{root}}/{{printer}} - ustawienie domyslnej drukarki

task
* get: {{root}}/tasks - pobranie kolejki wydruków
* post: {{root}}/{{title}} - wstawienie wydruku do kolejki (tekst wydruku w body)
* delete: {{root}}/{{taskId}} - usunięcie zadania #taskId z kolejki
