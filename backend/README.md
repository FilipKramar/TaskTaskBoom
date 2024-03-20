Spring Boot Application Upute za Korištenje

a: Za razvoj u Intelij-u

Potrebno imati: Intelij, Docker,WSL2

1. Klonirati repozitorij
2. git checkout FKramar unutar kloniranog repozitorija (cd u repozitorij ili otvoriti novi bash unutar mape)
3. Otvoriti projekt unutar Intelij-a
4. Otvoriti docker-compose unutar pojekta
5. Kliknuti na zeleni play button pored PostgreSQL: (kreira kontejner za bazu)
6. Otvoriti ProjectPraksaApplication 
7. Kliknuti na zeleni play button pored public class
8.Sada se mogu slati requestovi sa Postmana ili frontenda na api i sprema/dohvaca s baze (pricekati mozda pola minute da se sve učita)


b: Za izvođenje unutar docker kontejnera

1.Klonirati repozitorij
2. git checkout FKramar unutar kloniranog repozitorija (cd u repozitorij ili otvoriti novi bash unutar mape)
3. Otvoriti projekt unutar Intelij-a
4. Otvoriti terminal unutar intelija i upisati naredbu .\mvnw clean package -DskipTests
5. Otvoriti Dockerfile datoteku unutar projekta
6. U terminalu navigirati u folder projekta (ako je na windowsu treba imat Ubuntu i koristiti njegov terminal)
7. Upisati naredbu  docker build -t testni:latest . (bilo koje odabranoime:latest)
8. Otvoriti docker-compose datoteku unutar projekta
    a. Ukoliko se image kreiran zove testni ostaviti docker-compose 
    b. Ukoliko se image kreiran zove drukcije unutar docker-compose kod api: dijela promijeniti testni:latest u odabranoime:latest
9.U terminalu di se izvodio 6. korak (Ubuntu terminal) upisati naredbu docker compose build pa zatim docker compose up -d
10. Sada se mogu slati requestovi sa Postmana ili frontenda na api i sprema/dohvaca s baze (pricekati mozda pola minute da se sve učita)


Common error (barem koje su se dogodile putem):

1) kod docker build:

The command 'docker' could not be found in this WSL 2 distro.
We recommend to activate the WSL integration in Docker Desktop settings.

For details about using Docker Desktop with WSL 2, visit:

https://docs.docker.com/go/wsl2/

Fix: Otići na docker desktop> settings(pored imena ulogiranog korisnika)> resources>WSL integration> Ubuntu treba biti aktivan(plavo)

2) mvnw clean package

JAVA_HOME nije konfiguriran 
WINDOWS: 
        1. search env>enviroment variables> pod system variables>new>imenovati JAVA_HOME staviti putanju na jdk instlairan na PC-u (kod mene je bilo C:\Program Files\Java\jdk17)
