IDK0051 eksamitöö „Päikesesüsteemi postkontor”

Sügis 2015
Töös on oluline demonstreerida, et oskate
• kasutada lihtsaid disainiprintsiipe ja -mustreid (kapseldamine, kompositsioon, sõltuvuse
sisestamine, polümorfne käitumine)
• luua, valida ja kasutada andmetüüpe
• valida ja kasutada funktsionaalseid liideseid, viiteid meetodile ja lambdasid
• kirjutada töötavat ja efektiivset mitmelõimelist programmikoodi

Hindamine
Punkte saab ainult juhul, kui üliõpilane saab aru ja oskab täielikult seletada eksamitöö
programmikoodi. Kellegi teise kirjutatud koodi esitamine tähendab aines hinnet 0.
Esitamine

Töö tuleb gitiga esitada git.ttu.ee serverisse IDK0051 kausta vähemalt viies erinevas etapis tehtud
commitiga (et oleks näha töö edenemine) hiljemalt 17. jaanuaril 23:59, kuid vähemalt 8h enne
kaitsmist (kui tulete kaitsma varem). Vt täpsemalt dokumendi lõpust. Enne alustamist kontrollige,
kas teil on giti konto olemas ja töökorras (vt lõpus). Kui ei ole, kontakteeruge kohe
martin.rebane@ttu.ee ja andke teada oma uni-id kasutajanimi ja matrikli nr.


Ülesanne
Päikesesüsteemi postkontor teenindab kõiki Päikesesüsteemi planeete, lisaks Maa Kuud, Jupiteri
kuud Io ja kääbusplaneeti Pluuto.

Posti veetakse spetsiaalsete postirakettidega. Päikese peal on liiga kuum – sinna posti ei viida.
Baasosa (kohustuslik, maksimaalne tulemus 13 punkti)

1. Igal teenindataval planeedil ja kuul on postipunkt, kus saab:

• pakke raketti laadida

• pakke raketist maha laadida

• rakketti teenindada, mille käigus tangitakse raketi kütusepaak täis

◦ Erisus täispunktide saamiseks (baasversioonis pole vaja): Jupiteril ja Neptuunil asuvates
teeninduspunktides vahetatakse teeninduse käigus lisaks ka raketi kosmilise kiirguse
andur kui selle ressurss on 2 starti või vähem

2. Rakett kasutab kütusena tumeainet, mida talle teeninduse ajal tangitakse. Tumeaine paagi suurus
liitrites ei ole teada, kuid on teada, et

• 100% täis paagiga saab rakett teha 5 starti (iga start kulutab 20% kütust)

• võib mõelda nii, et 100% täis paak sisaldab 100 ühikut kütust

• iga 5 tankimise järel peab raketti teenindama (kuid loomulikult võib teenindada sagedamini)

• tähtis on, et rakett peaks arvet, mitu ühikut talle kokku kütust on tangitud ja mis on tema
hetkeline kütusevaru

3. Merkuurile ja Veenusele on suutelised sõitma vaid erilist tüüpi kuumakindlad raketid

• selliste rakettide kütusekulu igal stardil on 25% mahust

• start Merkuurilt ja Veenuselt kulutab aga lausa utoopilised 50% kütusest

4. Raketi kandevõime

• Rakett suudab korraga peale võtta 100 kg pakke

◦ Spetsiaalne kuumakindel rakett tänu oma raskusele vaid 80 kg pakke

Pakk
5. Igal transporditaval pakil on:

• lähtepunkt

• sihtpunkt

• kaal (vahemikus 1 – 80 kg)

Postipunktid
6. Iga postipunkt peab arvestust vastuvõetud pakkide kohta. Igal ajahetkel saab pärida:

• mitu pakki on vastu võetud

• mis on nende kogukaal

• mis on nende keskmine kaal

• planeetide nimekiri, kust siia pakke on saadetud

• küsija saab pärida oma kriteeriumitele vastavate pakkide arvu, näited:

◦ Mitu pakki on saadetud Pluutolt?

◦ Mitu üle 7kg pakki on saadetud?

◦ Mitu alla 60 kg pakki on saadetud Veenuselt?

NB! Vaja ei ole luua neid kolme näiteks toodud meetodit, vaid ühte meetodit, mille abil saaks need
3 näitepäringut teostada kui küsija annab sisendiks oma tingimused (mõelge 2. KT lahendusele).

7. Lend ühelt planeedilt teisele

• Kaine loogika vastaselt võtavad kõik lennud (teie õnneks) ühesuguse 15 ms, sõltumata
läbitud vahemaast

8. Süsteemi käivitamine ja reeglid

• Mõistagi peavad kõik raketid töötama samaaegselt

• Korraga teenindatakse ühes postipunktis ühte raketti, teised peavad ootama kui samal ajal
sinna satuvad

• Ükski rakett ei stardi tühjalt – alati pakiga. Erisuse võib täisversiooni realiseerimisel teha kui
on vaja lennata teenindusjaama, kus saab vahetada kosmilise kiirguse andurit – samas võib
sinna lennata ka täislastiga ning viimastel teenindusringidel

• Tavarakett ei tohi peale võtta pakke, mis on mõeldud saatmiseks Merkuurile või Veenusele

◦ looge süsteemi käivitamisel 20 tavalist raketti

• Kuumakindel rakett võtab peale vaid pakke, mille lähte- või sihtpunkt on Merkuur või

Veenus

◦ looge süsteemi käivitamisel 5 kuumakindlat raketti

• Looge eraldi lõim, mis pakke looks. Igale pakile määrab ta juhuvalikuga:

◦ lähtekoha

◦ sihtkoha

◦ kaalu

◦ ... ja asetab paki lähtekoha postipunkti ootejärjekorda.

◦ Iga paki loomise vahel on 3 ms, kokku luuakse 1500 pakki

• Baasversioonis (kui olete rahul max 13 punktiga) võite teha lihtsustuse, et üks rakett võtab
korraga peale ainult ühe postipaki.
