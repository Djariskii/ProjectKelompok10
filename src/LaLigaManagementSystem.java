import java.util.Scanner;

public class LaLigaManagementSystem {
    private TeamLinkedList teamList = new TeamLinkedList(); 
    private FixtureQueue fixtures = new FixtureQueue();    
    private FixtureStack history = new FixtureStack();     
    private TeamBinarySearchTree teamTree = new TeamBinarySearchTree(); 

    public void run() {
        initializeTeams(); 
        generateFixtures();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                                        ::::::::::::::           :::::::::::::::.             
                                     .+************=           =**************-              
                                    -*************:          .+*************+:               
                                  .=************+.          -**************=.                
                                 :+************-          .+**************:                  
                                -************+.          :+*************+.                   
                              .+************=           =**************-                     
                             :*************:          .+*************+.                      
                            =************=.          -**************=                        
                          :+************-           +*************+:                         
                         -************+.          :**************=                           
                        +************-          .=**************-                            
                        -***********+:          .+*************+.                             
                        =***********+========-:=**************=                               
                        .****************+-:..+*************+:                                
                        .+**********+=:.   :**************=.                                 
                          :*****+=:.     .=**************-                                   
                           .==:.        :+*************+.                                    
                                       -**************=                                      
                                     .+*************+:                                       
                                     +*************=                                         
                                    :*************+:::::::::::.                              
                                    .*********************+=:.                               
                                     :****************+=-.                                   
                                      .=***********=-.                                       
                                        :+*****=-.                                           
                                          ==-:                                               
            .:::             :::::.     .:::.        ::::     .:----::.       :::::.        
            =***.           -*****+     -***:        +**+   -+*********=     :******.       
            =***.           ***=+**-    -***.        +**+  :***-::::-***-    +**=+**=       
            =***.          -**+ -***    -***.        +**+  -***.            -*** :***:      
            =***.         .***-  +**=   -***:        +**+  -***:  :--=-.    +**=  +**+      
            =***.         =**+   -***.  -***:        +**+  -***:  =****+:  -***.  :***:     
            =***.        .***+----***=  -***.        +**+  -***.  ...***= .***+----+**+     
            =***:::::::  +***+=-. -***: -***-::::::  +**+  :***-....:***- =****=:. :***:    
            =********+ .***-      ***=  =*********  +**+   -**********=  ***=      +**+    
            """);
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Klasemen");
            System.out.println("2. Tampilkan Jadwal Pertandingan");
            System.out.println("3. Bermain Pertandingan");
            System.out.println("4. Tampilkan Pemain dari Setiap Tim");
            System.out.println("5. Cari Pemain");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> displayLeagueTable();
                case 2 -> displayFixtures();
                case 3 -> playMatches(scanner);
                case 4 -> displayAllPlayers();
                case 5 -> searchPlayer(scanner);
                case 6 -> {
                    System.out.println("Keluar dari sistem.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Inisialisasi tim
    private void initializeTeams() {
    Team barcelona = new Team("Barcelona");
    barcelona.addPlayer(new Player("Ter Stegen", "Goalkeeper", 1));
    barcelona.addPlayer(new Player("Pau Cubarsi", "Defender", 2));
    barcelona.addPlayer(new Player("Inigo Martinez", "Defender", 5));
    barcelona.addPlayer(new Player("Jules Kounde", "Defender", 23));
    barcelona.addPlayer(new Player("Alejandro Balde", "Defender", 3));
    barcelona.addPlayer(new Player("Dani Olmo", "Midfielder", 20));
    barcelona.addPlayer(new Player("Frenkie De Jong", "Midfielder", 21));
    barcelona.addPlayer(new Player("Pedri", "Midfielder", 8));
    barcelona.addPlayer(new Player("Lamine Yamal", "Forward", 19));
    barcelona.addPlayer(new Player("Robert Lewandowski", "Forward", 9));
    barcelona.addPlayer(new Player("Raphinha", "Forward", 11));
    teamList.add(barcelona);
    teamTree.insert(barcelona);

    // Real Madrid
    Team realMadrid = new Team("Real Madrid");
    realMadrid.addPlayer(new Player("Thibaut Courtois", "Goalkeeper", 1));
    realMadrid.addPlayer(new Player("Garcia", "Defender", 20));
    realMadrid.addPlayer(new Player("Rudiger", "Defender", 22));
    realMadrid.addPlayer(new Player("Tchouameni", "Defender", 14));
    realMadrid.addPlayer(new Player("Lucas Vazquez", "Defender", 17));
    realMadrid.addPlayer(new Player("Federico Valverde", "Midfielder", 8));
    realMadrid.addPlayer(new Player("Luca Modric", "Midfielder", 10));
    realMadrid.addPlayer(new Player("Camavinga", "Midfielder", 6));
    realMadrid.addPlayer(new Player("Bellingham", "Forward", 5));
    realMadrid.addPlayer(new Player("Vinicius Jr", "Forward", 7));
    realMadrid.addPlayer(new Player("Kylian Mbappe", "Forward", 9));
    teamList.add(realMadrid);
    teamTree.insert(realMadrid);

    // Sevilla
    Team sevilla = new Team("Sevilla");
    sevilla.addPlayer(new Player("Yassine Bounou", "Goalkeeper", 13));
    sevilla.addPlayer(new Player("José Ángel Carmona", "Defender", 3));
    sevilla.addPlayer(new Player("Sergio Ramos", "Defender", 4));
    sevilla.addPlayer(new Player("Nemanja Gudelj", "Midfielder", 27));
    sevilla.addPlayer(new Player("Álex Telles", "Defender", 17));
    sevilla.addPlayer(new Player("Fernando Reges", "Midfielder", 5));
    sevilla.addPlayer(new Player("Jesús Navas", "Midfielder", 16));
    sevilla.addPlayer(new Player("Érik Lamela", "Forward", 18));
    sevilla.addPlayer(new Player("Bryan Gil", "Forward", 11));
    sevilla.addPlayer(new Player("Yaw Yeboah", "Forward", 20));
    teamList.add(sevilla);
    teamTree.insert(sevilla);

    // Atletico Madrid
    Team atleticoMadrid = new Team("Atletico Madrid");
    atleticoMadrid.addPlayer(new Player("Jan Oblak", "Goalkeeper", 13));
    atleticoMadrid.addPlayer(new Player("José María Giménez", "Defender", 2));
    atleticoMadrid.addPlayer(new Player("Stefan Savić", "Defender", 15));
    atleticoMadrid.addPlayer(new Player("Axel Witsel", "Midfielder", 20));
    atleticoMadrid.addPlayer(new Player("Koke", "Midfielder", 6));
    atleticoMadrid.addPlayer(new Player("Saúl Ñíguez", "Midfielder", 8));
    atleticoMadrid.addPlayer(new Player("Antoine Griezmann", "Forward", 7));
    atleticoMadrid.addPlayer(new Player("Memphis Depay", "Forward", 9));
    atleticoMadrid.addPlayer(new Player("Álvaro Morata", "Forward", 19));
    atleticoMadrid.addPlayer(new Player("Ángel Correa", "Forward", 10));
    atleticoMadrid.addPlayer(new Player("Rodrigo de Paul", "Midfielder", 5));
    teamList.add(atleticoMadrid);
    teamTree.insert(atleticoMadrid);

    // Real Sociedad
    Team realSociedad = new Team("Real Sociedad");
    realSociedad.addPlayer(new Player("Álex Remiro", "Goalkeeper", 1));
    realSociedad.addPlayer(new Player("Diego Rico", "Defender", 15));
    realSociedad.addPlayer(new Player("Robin Le Normand", "Defender", 24));
    realSociedad.addPlayer(new Player("Aritz Elustondo", "Defender", 6));
    realSociedad.addPlayer(new Player("Mikel Oyarzabal", "Forward", 10));
    realSociedad.addPlayer(new Player("Martín Zubimendi", "Midfielder", 8));
    realSociedad.addPlayer(new Player("Mikel Merino", "Midfielder", 18));
    realSociedad.addPlayer(new Player("Takefusa Kubo", "Forward", 14));
    realSociedad.addPlayer(new Player("Alexander Isak", "Forward", 11));
    realSociedad.addPlayer(new Player("Brais Méndez", "Midfielder", 21));
    realSociedad.addPlayer(new Player("Carlos Fernández", "Forward", 9));
    teamList.add(realSociedad);
    teamTree.insert(realSociedad);

    Team villarreal = new Team("Villarreal");
    villarreal.addPlayer(new Player("Gerónimo Rulli", "Goalkeeper", 1));
    villarreal.addPlayer(new Player("Pau Torres", "Defender", 15));
    villarreal.addPlayer(new Player("Raúl Albiol", "Defender", 4));
    villarreal.addPlayer(new Player("José Luis Morales", "Forward", 11));
    villarreal.addPlayer(new Player("Dani Parejo", "Midfielder", 10));
    villarreal.addPlayer(new Player("Francis Coquelin", "Midfielder", 19));
    villarreal.addPlayer(new Player("Gerard Moreno", "Forward", 9));
    villarreal.addPlayer(new Player("Yeremy Pino", "Forward", 21));
    villarreal.addPlayer(new Player("Moi Gómez", "Midfielder", 7));
    villarreal.addPlayer(new Player("Arnaut Danjuma", "Forward", 37));
    villarreal.addPlayer(new Player("Samuel Chukwueze", "Forward", 20));
    teamList.add(villarreal);
    teamTree.insert(villarreal);

    // Valencia
    Team valencia = new Team("Valencia");
    valencia.addPlayer(new Player("Giorgi Mamardashvili", "Goalkeeper", 1));
    valencia.addPlayer(new Player("Gabriel Paulista", "Defender", 5));
    valencia.addPlayer(new Player("Cristhian Mosquera", "Defender", 3));
    valencia.addPlayer(new Player("Nacho Vidal", "Midfielder", 14));
    valencia.addPlayer(new Player("Hugo Duro", "Forward", 9));
    valencia.addPlayer(new Player("André Almeida", "Midfielder", 20));
    valencia.addPlayer(new Player("Samu Castillejo", "Forward", 7));
    valencia.addPlayer(new Player("Pepelu", "Midfielder", 17));
    valencia.addPlayer(new Player("Fran Pérez", "Midfielder", 8));
    valencia.addPlayer(new Player("Ilaix Moriba", "Midfielder", 15));
    valencia.addPlayer(new Player("Gonçalo Guedes", "Forward", 11));
    teamList.add(valencia);
    teamTree.insert(valencia);

    // Athletic Bilbao
    Team athleticBilbao = new Team("Athletic Bilbao");
    athleticBilbao.addPlayer(new Player("Unai Simón", "Goalkeeper", 1));
    athleticBilbao.addPlayer(new Player("Yeray Álvarez", "Defender", 4));
    athleticBilbao.addPlayer(new Player("Inigo Martinez", "Defender", 5));
    athleticBilbao.addPlayer(new Player("Ander Herrera", "Midfielder", 11));
    athleticBilbao.addPlayer(new Player("Oihan Sancet", "Midfielder", 8));
    athleticBilbao.addPlayer(new Player("Nico Williams", "Forward", 7));
    athleticBilbao.addPlayer(new Player("Iñaki Williams", "Forward", 9));
    athleticBilbao.addPlayer(new Player("Álex Berenguer", "Forward", 19));
    athleticBilbao.addPlayer(new Player("Raúl García", "Midfielder", 22));
    athleticBilbao.addPlayer(new Player("Dani García", "Midfielder", 14));
    athleticBilbao.addPlayer(new Player("Oscar de Marcos", "Midfielder", 17));
    teamList.add(athleticBilbao);
    teamTree.insert(athleticBilbao);

    // Real Betis
    Team realBetis = new Team("Real Betis");
    realBetis.addPlayer(new Player("Claudio Bravo", "Goalkeeper", 1));
    realBetis.addPlayer(new Player("Aitor Ruibal", "Midfielder", 14));
    realBetis.addPlayer(new Player("Luiz Felipe", "Defender", 3));
    realBetis.addPlayer(new Player("Guido Rodríguez", "Midfielder", 5));
    realBetis.addPlayer(new Player("Sergio Canales", "Midfielder", 10));
    realBetis.addPlayer(new Player("Fekir", "Forward", 8));
    realBetis.addPlayer(new Player("William Carvalho", "Midfielder", 14));
    realBetis.addPlayer(new Player("Juan Miranda", "Defender", 15));
    realBetis.addPlayer(new Player("Ayoze Pérez", "Forward", 17));
    realBetis.addPlayer(new Player("Rodri", "Forward", 9));
    realBetis.addPlayer(new Player("Borja Iglesias", "Forward", 9));
    teamList.add(realBetis);
    teamTree.insert(realBetis);

    Team girona = new Team("Girona");
    girona.addPlayer(new Player("Harnat Manassero", "Goalkeeper", 1));
    girona.addPlayer(new Player("David Lopez", "Defender", 3));
    girona.addPlayer(new Player("Arnau Martinez", "Defender", 4));
    girona.addPlayer(new Player("Ignasi Miquel", "Defender", 5));
    girona.addPlayer(new Player("Aleix Garcia", "Midfielder", 14));
    girona.addPlayer(new Player("Yangel Herrera", "Midfielder", 8));
    girona.addPlayer(new Player("Kike Garcia", "Forward", 9));
    girona.addPlayer(new Player("Savio", "Forward", 11));
    girona.addPlayer(new Player("Cristhian Stuani", "Forward", 10));
    girona.addPlayer(new Player("Yan Couto", "Defender", 2));
    girona.addPlayer(new Player("Alex Balde", "Defender", 15));
    teamList.add(girona);
    teamTree.insert(girona);
    
    Team granada = new Team("Granada");
    granada.addPlayer(new Player("Raul Fernandez", "Goalkeeper", 1));
    granada.addPlayer(new Player("Sergio Ruiz", "Midfielder", 5));
    granada.addPlayer(new Player("Luis Suarez", "Forward", 9));
    granada.addPlayer(new Player("Myrto Uzuni", "Forward", 11));
    granada.addPlayer(new Player("Monchu", "Midfielder", 14));
    granada.addPlayer(new Player("German Sanchez", "Defender", 3));
    granada.addPlayer(new Player("Jorge Molina", "Forward", 19));
    granada.addPlayer(new Player("Bryan Zaragoza", "Midfielder", 8));
    granada.addPlayer(new Player("Alex Collado", "Midfielder", 10));
    granada.addPlayer(new Player("Santiago Arias", "Defender", 4));
    granada.addPlayer(new Player("Luis Abram", "Defender", 2));
    teamList.add(granada);
    teamTree.insert(granada);
    
    Team almeria = new Team("Almeria");
    almeria.addPlayer(new Player("Fernando Martinez", "Goalkeeper", 1));
    almeria.addPlayer(new Player("Edgar Gonzalez", "Midfielder", 8));
    almeria.addPlayer(new Player("Ivan Balliu", "Defender", 3));
    almeria.addPlayer(new Player("Savio Mota", "Forward", 11));
    almeria.addPlayer(new Player("Largie Ramazani", "Forward", 7));
    almeria.addPlayer(new Player("Diego Almeida", "Defender", 4));
    almeria.addPlayer(new Player("Sergio Akieme", "Defender", 19));
    almeria.addPlayer(new Player("Ruben Sanabria", "Forward", 9));
    almeria.addPlayer(new Player("Lucas Robertone", "Midfielder", 14));
    almeria.addPlayer(new Player("Cesar de la Hoz", "Midfielder", 5));
    almeria.addPlayer(new Player("El Bilal Toure", "Forward", 20));
    teamList.add(almeria);
    teamTree.insert(almeria);
    
    Team osasuna = new Team("Osasuna");
    osasuna.addPlayer(new Player("Sergio Herrera", "Goalkeeper", 1));
    osasuna.addPlayer(new Player("David Garcia", "Defender", 4));
    osasuna.addPlayer(new Player("Unai Garcia", "Defender", 5));
    osasuna.addPlayer(new Player("Moncayola", "Midfielder", 8));
    osasuna.addPlayer(new Player("Ruben Garcia", "Midfielder", 11));
    osasuna.addPlayer(new Player("Chimy Avila", "Forward", 9));
    osasuna.addPlayer(new Player("Ante Budimir", "Forward", 19));
    osasuna.addPlayer(new Player("Kike Barja", "Forward", 7));
    osasuna.addPlayer(new Player("Aridane Hernandez", "Defender", 15));
    osasuna.addPlayer(new Player("Jon Moncayola", "Midfielder", 14));
    osasuna.addPlayer(new Player("Dario Ramos", "Defender", 3));
    teamList.add(osasuna);
    teamTree.insert(osasuna);
    
    Team mallorca = new Team("Mallorca");
    mallorca.addPlayer(new Player("Predrag Rajković", "Goalkeeper", 1));
    mallorca.addPlayer(new Player("Vedat Muriqi", "Forward", 9));
    mallorca.addPlayer(new Player("Lee Kang-In", "Midfielder", 19));
    mallorca.addPlayer(new Player("MurQui", "Midfielder", 8));
    mallorca.addPlayer(new Player("Dani Rodriguez", "Midfielder", 10));
    mallorca.addPlayer(new Player("A. Oliveira", "Forward", 11));
    mallorca.addPlayer(new Player("Fer Nino", "Forward", 7));
    mallorca.addPlayer(new Player("Dominik Greif", "Goalkeeper", 13));
    mallorca.addPlayer(new Player("Antonio Raillo", "Defender", 4));
    mallorca.addPlayer(new Player("Kike Garcia", "Forward", 14));
    mallorca.addPlayer(new Player("Amath Ndiaye", "Forward", 20));
    teamList.add(mallorca);
    teamTree.insert(mallorca);

    Team cadiz = new Team("Cadiz");
    cadiz.addPlayer(new Player("Conan Ledesma", "Goalkeeper", 1));
    cadiz.addPlayer(new Player("Lucas Perez", "Forward", 9));
    cadiz.addPlayer(new Player("Ruben Alcaraz", "Midfielder", 8));
    cadiz.addPlayer(new Player("Jose Mari", "Midfielder", 14));
    cadiz.addPlayer(new Player("Brian Ocampo", "Forward", 11));
    cadiz.addPlayer(new Player("Sergio Gonzalez", "Midfielder", 7));
    cadiz.addPlayer(new Player("Fali", "Defender", 4));
    cadiz.addPlayer(new Player("Chris Ramos", "Forward", 17));
    cadiz.addPlayer(new Player("Alfonso Espino", "Defender", 3));
    cadiz.addPlayer(new Player("Alvaro Negredo", "Forward", 19));
    cadiz.addPlayer(new Player("Ruben Sobrino", "Forward", 10));
    teamList.add(cadiz);
    teamTree.insert(cadiz);
    
    Team getafe = new Team("Getafe");
    getafe.addPlayer(new Player("David Soria", "Goalkeeper", 1));
    getafe.addPlayer(new Player("Jaime Mata", "Forward", 9));
    getafe.addPlayer(new Player("Angel Rodriguez", "Forward", 17));
    getafe.addPlayer(new Player("Carles Alena", "Midfielder", 8));
    getafe.addPlayer(new Player("Borja Mayoral", "Forward", 19));
    getafe.addPlayer(new Player("Sofian Chakla", "Defender", 4));
    getafe.addPlayer(new Player("Diego Conde", "Defender", 3));
    getafe.addPlayer(new Player("Okay Yokuslu", "Midfielder", 5));
    getafe.addPlayer(new Player("Erick Cabaco", "Defender", 15));
    getafe.addPlayer(new Player("Portu", "Forward", 7));
    getafe.addPlayer(new Player("Damián Suarez", "Defender", 22));
    teamList.add(getafe);
    teamTree.insert(getafe);
    
    Team espanyol = new Team("Espanyol");
    espanyol.addPlayer(new Player("Diego Lopez", "Goalkeeper", 1));
    espanyol.addPlayer(new Player("Raul de Tomas", "Forward", 9));
    espanyol.addPlayer(new Player("Sergi Darder", "Midfielder", 10));
    espanyol.addPlayer(new Player("Nico Melamed", "Midfielder", 11));
    espanyol.addPlayer(new Player("Miguelon", "Defender", 2));
    espanyol.addPlayer(new Player("Leandro Cabrera", "Defender", 4));
    espanyol.addPlayer(new Player("Victor Gomez", "Defender", 20));
    espanyol.addPlayer(new Player("Edu Exposito", "Midfielder", 14));
    espanyol.addPlayer(new Player("Pol Lozano", "Midfielder", 5));
    espanyol.addPlayer(new Player("Fernando Calero", "Defender", 3));
    espanyol.addPlayer(new Player("Joselu", "Forward", 7));
    teamList.add(espanyol);
    teamTree.insert(espanyol);
    
    Team lasPalmas = new Team("Las Palmas");
    lasPalmas.addPlayer(new Player("Alex Dominguez", "Goalkeeper", 1));
    lasPalmas.addPlayer(new Player("Kirian Rodriguez", "Midfielder", 10));
    lasPalmas.addPlayer(new Player("Jonathan Viera", "Midfielder", 19));
    lasPalmas.addPlayer(new Player("Jese Rodriguez", "Forward", 7));
    lasPalmas.addPlayer(new Player("Raul Navas", "Defender", 4));
    lasPalmas.addPlayer(new Player("Manu Cardoso", "Defender", 5));
    lasPalmas.addPlayer(new Player("Marc Cardona", "Forward", 9));
    lasPalmas.addPlayer(new Player("Benito", "Defender", 3));
    lasPalmas.addPlayer(new Player("Arnau Comas", "Defender", 15));
    lasPalmas.addPlayer(new Player("Alberto Moleiro", "Midfielder", 11));
    lasPalmas.addPlayer(new Player("Fabio", "Midfielder", 8));
    teamList.add(lasPalmas);
    teamTree.insert(lasPalmas);
    
    Team rayoVallecano = new Team("Rayo Vallecano");
    rayoVallecano.addPlayer(new Player("Stole Dimitrievski", "Goalkeeper", 1));
    rayoVallecano.addPlayer(new Player("Andres Alvarez", "Defender", 4));
    rayoVallecano.addPlayer(new Player("Oscar Valentin", "Midfielder", 14));
    rayoVallecano.addPlayer(new Player("Santi Comesana", "Midfielder", 11));
    rayoVallecano.addPlayer(new Player("Randy Nteka", "Forward", 9));
    rayoVallecano.addPlayer(new Player("Alvaro Garcia", "Midfielder", 7));
    rayoVallecano.addPlayer(new Player("Mario Suarez", "Midfielder", 5));
    rayoVallecano.addPlayer(new Player("Fran Garcia", "Defender", 3));
    rayoVallecano.addPlayer(new Player("Trejo", "Midfielder", 8));
    rayoVallecano.addPlayer(new Player("Ivan Balliu", "Defender", 19));
    rayoVallecano.addPlayer(new Player("Diego Lopez", "Forward", 10));
    teamList.add(rayoVallecano);
    teamTree.insert(rayoVallecano);
    
    Team alaves = new Team("Alaves");
    alaves.addPlayer(new Player("Ximo Navarro", "Defender", 4));
    alaves.addPlayer(new Player("Javi Lopez", "Midfielder", 14));
    alaves.addPlayer(new Player("Ruben Sanchez", "Midfielder", 8));
    alaves.addPlayer(new Player("Modibo Sagnan", "Defender", 5));
    alaves.addPlayer(new Player("Domingo Blanco", "Midfielder", 11));
    alaves.addPlayer(new Player("Luis Rioja", "Forward", 7));
    alaves.addPlayer(new Player("Pere Pons", "Midfielder", 19));
    alaves.addPlayer(new Player("Alex Corredera", "Midfielder", 10));
    alaves.addPlayer(new Player("Mamadou Sylla", "Forward", 9));
    alaves.addPlayer(new Player("Jonathan Calleri", "Forward", 17));
    alaves.addPlayer(new Player("Ruben Pelegrin", "Defender", 3));
    teamList.add(alaves);
    teamTree.insert(alaves);
    }
    // Menghasilkan jadwal pertandingan
    private void generateFixtures() {
        TeamLinkedList.Iterator iterator1 = teamList.iterator();
        while (iterator1.hasNext()) {
            Team team1 = iterator1.next();
            TeamLinkedList.Iterator iterator2 = teamList.iterator();
            while (iterator2.hasNext()) {
                Team team2 = iterator2.next();
                if (!team1.equals(team2)) {
                    fixtures.enqueue(new Fixture(team1, team2));
                }
            }
        }
    }

private void playMatches(Scanner scanner) {
    for (int i = 0; i < 3 && !fixtures.isEmpty(); i++) {
        Fixture match = fixtures.dequeue();
        System.out.println("Pertandingan: " + match.displayFixtureInfo());

        int homeScore = -1, awayScore = -1;

        while (homeScore < 0) {
            System.out.print("Masukkan skor tim tuan rumah: ");
            homeScore = scanner.nextInt();
            if (homeScore < 0) {
                System.out.println("Skor tidak boleh negatif. Silakan masukkan lagi.");
            }
        }

        while (awayScore < 0) {
            System.out.print("Masukkan skor tim tamu: ");
            awayScore = scanner.nextInt();
            if (awayScore < 0) {
                System.out.println("Skor tidak boleh negatif. Silakan masukkan lagi.");
            }
        }

        match.playMatch(homeScore, awayScore);
        history.push(match);
        rebuildTree();
    }
}

    private void rebuildTree() {
        teamTree = new TeamBinarySearchTree();
        TeamLinkedList.Iterator iterator = teamList.iterator();
        while (iterator.hasNext()) {
            teamTree.insert(iterator.next());
        }
    }

    private void displayLeagueTable() {
        System.out.println("\nKlasemen La Liga:");
        System.out.println("Team                       P     W     D     L     GF    GA    GD   Pts");
        TeamLinkedList sortedTeams = teamTree.inorderTraversal();
        sortedTeams.displayAllTeams();
    }

    private void displayFixtures() {
        System.out.println("\nJadwal Pertandingan:");
        fixtures.displayAllFixtures();
    }

    private void displayAllPlayers() {
        TeamLinkedList.Iterator iterator = teamList.iterator();
        while (iterator.hasNext()) {
            iterator.next().displayPlayers();
        }
    }

    private void searchPlayer(Scanner scanner) {
        System.out.print("\nMasukkan sebagian nama pemain yang ingin dicari: ");
        String playerNamePart = scanner.nextLine();
    
        TeamLinkedList.Iterator iterator = teamList.iterator();
        boolean found = false;
    
        while (iterator.hasNext()) {
            Team team = iterator.next();
            Player player = team.searchPlayer(playerNamePart); 
            if (player != null) {
                System.out.println("Pemain ditemukan di tim: " + team.getName());
                System.out.println(player);
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("Pemain tidak ditemukan di tim manapun.");
        }
    }   
}