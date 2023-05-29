# Vježbe iz kolegija Programiranje u Javi

**Nositelj kolegija:** [Daniel Vasić](https://github.com/danielvasic)

**Demo programske podrške** [Ovdje](http://204.216.222.226:8080) možete pronaći pokrenut primjerak programa.

Dobro došli u repozitorij vježbi za kolegij **Programiranje u Javi**. Ovaj kolegij se izvodi na Fakultetu prirodoslovno-matematičkih i odgojnih znanosti Sveučilišta u Mostaru. Studijski program očekuje od studenata da se upuste u učenje i istraživanje naprednih koncepta razvoja web aplikacija, koristeći niz modernih tehnologija, uključujući:

- Spring Boot programsko okruženje, snažno i fleksibilno rješenje za razvoj standalone i cloud-ready Spring aplikacija.
- Relacijske baze podataka (MySQL), kao što je MySQL, koji je najpoznatiji open source sustav za upravljanje bazama podataka na svijetu.
- Docker tehnologija, industrijski standard za izradu, pakiranje i distribuciju aplikacija u obliku kontejnera.
- Git sustav za kontrolu verzija, jedan od najraširenijih alata svoje vrste, omogućujući timovima da učinkovito upravljaju izvornim kodom.
- Oracle Cloud Platform (OCP), vrhunska platforma za cloud računalstvo koja nudi širok spektar usluga i rješenja.
- IntelliJ IDEA razvojno okruženje, jedno od najpopularnijih okruženja za razvoj aplikacija u Javi.

## Instalacija i upotreba programa

Program koji smo razvili u sklopu vježbi iz ovog kolegija predstavlja jednostavan, ali učinkovit sustav za upravljanje inventarom restorana. Aplikacija je oblikovana tako da pruža niz funkcionalnosti, uključujući:

- Mogućnost registracije novih korisnika, uz rigoroznu validaciju unosa, kako bi se osigurao integritet korisničkih podataka.
- Mogućnost prijave na sustav nakon uspješne registracije, omogućujući korisnicima pristup osobnim i profesionalnim resursima.
- Mogućnost odjave s sustava, što korisnicima pruža dodatni sloj sigurnosti i privatnosti.
- Omogućavanje korisnicima da dodaju, pregledavaju, ažuriraju i brišu (CRUD - Create, Read, Update, Delete) kategorije, omogućujući dinamičko i prilagodljivo upravljanje resursima.
- Omogućavanje korisnicima da dodaju, pregledavaju, ažuriraju i brišu (CRUD) proizvode, pružajući im alate za efikasno upravljanje proizvodnim inventarom.
- Dodana je podrška, iako nije u potpunosti implementirana, za dodavanje računa, otvarajući put za buduće proširenje funkcionalnosti.
- Mnoge druge značajke koje čine ovu aplikaciju fleksibilnom i moćnom alatkom za upravljanje restoranima.

Ako želite isprobati ovu aplikaciju, jednostavno možete klonirati repozitorij koristeći git naredbu:

```bash
git clone https://github.com/danielvasic/Restoran-FPMOZ-2022-2023.git
```

Nakon što uspješno klonirate repozitorij, sve što je potrebno je pokrenuti Docker Compose naredbu koja će automatski postaviti cijeli sustav. Bez obzira na platformu koju koristite, ako je Docker sustav instaliran, moći ćete bez problema pokrenuti ovu aplikaciju.

```bash
cd Restoran-FPMOZ-2022-2023
[sudo] docker compose up [-d] [--build]
```

Naredbe u uglatim zagradama mogu varirati ovisno o platformi na kojoj se izvršavaju i o tome želi li korisnik pokrenuti aplikaciju u pozadini ili ne. Nakon pokretanja, trebat će pričekati neko vrijeme da se MySQL container podigne kako bi Java aplikacija mogla uspostaviti uspješnu vezu.
