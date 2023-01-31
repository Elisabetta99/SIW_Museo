/*
package it.uniroma3.siw.spring.start;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.CuratoreService;
import it.uniroma3.siw.spring.service.OperaService;
import it.uniroma3.siw.spring.service.UserService;

@Component
public class Inizializzazione implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserService userService;

	@Autowired
	private CredentialsService credentialService;

	@Autowired
	private CuratoreService curatoreService;

	@Autowired
	private CollezioneService collezioneService;

	@Autowired
	private ArtistaService artistaService;

	@Autowired
	private OperaService operaService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		User user1 = new User();
		user1.setNome("user1");
		user1.setCognome("user1");
		userService.saveUser(user1);

		Credentials credentials1 = new Credentials();
		credentials1.setUsername("admin");
		credentials1.setRole("ADMIN");
		credentials1.setPassword("admin");
		credentials1.setUser(user1);
		credentialService.saveCredentials2(credentials1);

		User user2 = new User();
		user2.setNome("user2");
		user2.setCognome("user2");
		userService.saveUser(user2);

		Credentials credentials2 = new Credentials();
		credentials2.setUsername("default");
		credentials2.setPassword("default");
		credentials2.setRole("DEFAULT");
		credentials2.setUser(user2);
		credentialService.saveCredentials2(credentials2);

		Curatore curatore1=new Curatore();
		curatore1.setNome("Serena");
		curatore1.setCognome("Bruni");
		curatore1.setDataDiNascita(LocalDate.of(1975, 10, 20));
		curatore1.setLuogoDiNascita("Roma");
		curatore1.setEmail("serena@gmail.com");
		curatore1.setNumeroDiTelefono(38845621);
		curatore1.setMatricola(123);
		curatoreService.inserisci(curatore1);

		Collezione collezione1 = new Collezione();
		collezione1.setCuratore(curatore1);
		collezione1.setNome("Galleria dell'arte impressionista e post-impressionista");
		collezione1.setDescrizione("Dal 16 giugno al Museo dell'arte impressionista apre la mostra Impressionisti e Post-impressionisti, prodotta e organizzata da Serena Bruni. \r\n"
				+ "Per celebrare l'apertura del Museo saranno esposte oltre 50 opere dei più grandi maestri dell’impressionismo (Claude Monet, Edgar Degas, Edouard Manet, Pierre Auguste Renoir) e del post impressionismo ( Vincent van Gogh).\r\n"
				+ "Opere provenienti da collezioni private raramente accessibili e concessi eccezionalmente per questa mostra.");
		collezioneService.inserisci(collezione1);


		Collezione collezione2 = new Collezione();
		collezione2.setCuratore(curatore1);
		collezione2.setNome("Degas e Monet");
		collezione2.setDescrizione("Dal 16 giugno al Museo dell'arte impressionista apre la mostra Degas e Monet, prodotta e organizzata da Serena Bruni. \r\n"
				+ "Per celebrare l'apertura del Museo saranno esposte oltre 50 opere dei più grandi maestri dell’impressionismo");
		collezioneService.inserisci(collezione2);

		Collezione collezione3 = new Collezione();
		collezione3.setCuratore(curatore1);
		collezione3.setNome("Le più belle opere di Van Gogh");
		collezione3.setDescrizione("Terminata");
		collezioneService.inserisci(collezione3);

		Collezione collezione4 = new Collezione();
		collezione4.setCuratore(curatore1);
		collezione4.setNome("Collezioni passegere");
		collezione4.setDescrizione("Collezione itinerante tra i musei italiani");
		collezioneService.inserisci(collezione4);



		Artista artista1 = new Artista();
		artista1.setNome("Vincent");
		artista1.setCognome("van Gogh");
		artista1.setDataDiNascita("30 marzo 1853");
		artista1.setLuogoDiNascita("Zundert, Paesi Bassi");
		artista1.setDataDiMorte("29 luglio 1890");
		artista1.setLuogoDiMorte("Auvers-sur-Oise, Francia");
		artista1.setNazionalita("Olandese");
		artista1.setDescrizione("Fu autore di quasi novecento dipinti e di più di mille\r\n"
				+ "disegni, senza contare i numerosi schizzi non portati a termine.\r\n"
				+ "Tanto geniale quanto incompreso se non addirittura disprezzato in\r\n"
				+ "vita, Van Gogh influenzò profondamente l'arte del XX secolo.\r\n"
				+ "Iniziò a disegnare da bambino nonostante le critiche del padre,\r\n"
				+ "pastore protestante che continuo' ad impartirgli delle norme severe.\r\n"
				+ "Iniziò a dipingere tardi, all'età di ventisette anni,realizzando\r\n"
				+ "molte delle sue opere più note nel corso degli ultimi due anni di\r\n"
				+ "vita. Dopo aver trascorso diversi anni soffrendo di frequenti\r\n"
				+ "disturbi mentali, morì all'età di trentasette anni. I suoi\r\n"
				+ "soggetti consistevano in autoritratti, paesaggi, nature morte di\r\n"
				+ "fiori, dipinti con cipressi, rappresentazione di campi di grano e\r\n"
				+ "girasoli.");
		artistaService.inserisci(artista1);

		Artista artista2 = new Artista();
		artista2.setNome("Edgar");
		artista2.setCognome("Degas");
		artista2.setDataDiNascita("19 luglio 1834");
		artista2.setLuogoDiNascita("Parigi, Francia");
		artista2.setDataDiMorte("27 settembre 1917");
		artista2.setLuogoDiMorte("Parigi, Francia");
		artista2.setNazionalita("Francese");
		artista2.setDescrizione("Una volta superato il tracollo economico dovuto alla morte del padre, a causa del quale patì ristrettezze e sacrifici, Degas riuscì a consolidare la propria notorietà. Particolarmente fortunata fu la quinta mostra degli Impressionisti, allestita nell'aprile 1880 in rue des Pyramides, dove Degas espose una decina di opere attirandosi l'entusiasmo di Joris-Karl Huysmans, astro letterario del tempo, che nove anni dopo avrebbe dedicato ai nudi del pittore pagine tracimanti di ammirazione. Durante gli anni ottanta del XIX secolo, infatti, l'interesse di Degas fu catturato soprattutto da «nudi di donna intente a bagnarsi, lavarsi, asciugarsi, strofinarsi pettinarsi o farsi pettinare»: nudi naturalistici, dunque, intenti in attività quotidiane e in gesti prosaici e spontanei.");
		artistaService.inserisci(artista2);

		Artista artista3 = new Artista();
		artista3.setNome("Claude");
		artista3.setCognome("Monet");
		artista3.setDataDiNascita("14 novembre 1840");
		artista3.setLuogoDiNascita("Parigi,Francia");
		artista3.setDataDiMorte("5 dicembre 1926");
		artista3.setLuogoDiMorte("Giverny, Francia");
		artista3.setNazionalita("Francese");
		artista3.setDescrizione("Fu solo nell'autunno del 1871 che Monet tornò in Francia soggiornando per un breve periodo a Parigi, dove approfondì la sua fraterna amicizia con Renoir e Pissarro, ponendo in questo modo le basi per l'età d'oro dell'Impressionismo.");
		artistaService.inserisci(artista3);

		Artista artista4 = new Artista();
		artista4.setNome("Pierre-Auguste");
		artista4.setCognome("Renoir");
		artista4.setDataDiNascita("25 febbraio 1841");
		artista4.setLuogoDiNascita("Limoges,Francia");
		artista4.setDataDiMorte("3 dicembre 1919");
		artista4.setLuogoDiMorte("Cagnes-sur-Mer, Francia");
		artista4.setNazionalita("Francese");
		artista4.setDescrizione("Nonostante i periodi di difficoltà, Renoir seguitò a dipingere - come, d'altronde, aveva sempre fatto - e si accostò irreversibilmente alla poetica impressionista. Con Monet e Manet si ritirò ad Argenteuil, villaggio che lo convertì definitivamente all'en plein air: ne è testimonianza la Vele ad Argenteuil, tela dove la tavolozza si schiarisce e le pennellate sono brevi e corsive, secondo una maniera che si può definire propriamente impressionista. ");
		artistaService.inserisci(artista4);


		Opera opera1 = new Opera();
		opera1.setArtista(artista1);
		opera1.setTitolo("Notte stellata");
		opera1.setAnno(1889);
		opera1.setCollezioni(collezione1);
		opera1.setDescrizione("Nel 1888, prima dell'internamento a Saint-Rémy, van Gogh scrisse: \r\n"
				+ "Con un quadro vorrei poter esprimere qualcosa di commovente come una musica. Vorrei dipingere uomini e donne con un non so che di eterno, di cui un tempo era simbolo l’aureola, e che noi cerchiamo di rendere con lo stesso raggiare, con la vibrazione dei colori [...].Ah il ritratto, il ritratto che mostri i pensieri, l’anima del modello: ecco cosa credo debba vedersi\"\r\n"
				+ "\r\n"
				+ "La Notte stellata, certamente una delle opere vangoghiane più celebri, risponde perfettamente a quest'esigenza. In questo dipinto, infatti, il pittore ha certamente cercato il contatto diretto con la realtà, dipingendo quello che si poteva vedere dalla finestra della sua stanza nel manicomio di Saint-Rémy. Van Gogh, tuttavia, non ha ripreso fedelmente questa veduta notturna, bensì l'ha manipolata con mezzi plastici, interiorizzandola fino allo spasimo e trasformandola in una potente visione onirica in cui poter fare affiorare le sue emozioni, le sue paure, i suoi viaggi dell'anima. La Notte stellata, pertanto, non offre all'osservatore un'immagine fedele della realtà, quanto una forma di «espressione» di quest'ultima.");
		opera1.setFile("https://www.milanoplatinum.com/wp-content/uploads/2016/12/Vincent-van-Gogh-Notte-stellata.jpg");
		operaService.inserisci(opera1);

		Opera opera2 = new Opera();
		opera2.setArtista(artista2);
		opera2.setTitolo("Lezione di danza");
		opera2.setAnno(1875);
		opera2.setCollezioni(collezione1);
		opera2.setCollezioni(collezione2);
		opera2.setDescrizione("È tra i primi quadri del pittore a rivolgersi al tema delle ballerine e, come si può facilmente dedurre dal titolo, raffigura proprio una lezione di danza.");
		opera2.setFile("https://mywowo.net/media/images/cache/parigi_museo_orsay_05_lezione_danza_jpg_1200_630_cover_85.jpg");
		operaService.inserisci(opera2);

		Opera opera3 = new Opera();
		opera3.setArtista(artista3);
		opera3.setTitolo("La passeggiata");
		opera3.setAnno(1875);
		opera3.setCollezioni(collezione2);
		opera3.setDescrizione("La passeggiata (Camille Monet con il figlio Jean sulla collina) è un dipinto a olio su tela (100xcm 81 cm) realizzato nel 1875 da Claude Monet. È conservato nella National Gallery di Washington.\r\n"
				+ "\r\n"
				+ "Il bagliore dorato delle nuvole e i vibranti riverberi gialli nella vegetazione, ci fanno capire che il sole è molto caldo e che Camille Monet e il figlio Jean hanno fatto bene a proteggersi con il cappellino e l'ombrello.");
		opera3.setFile("https://cabiriams.files.wordpress.com/2019/05/monet-il-pittore-delle28099attimo-eterno-versione-sx.jpg?w=1200");
		operaService.inserisci(opera3);

		Opera opera4 = new Opera();
		opera4.setArtista(artista4);
		opera4.setTitolo("Bal au moulin de la Galette");
		opera4.setAnno(1876);
		opera4.setDescrizione("Il Bal au moulin de la Galette (Ballo al moulin de la Galette) è un dipinto del pittore francese Pierre-Auguste Renoir, realizzato nel 1876 e conservato al museo d'Orsay di Parigi.");
		opera4.setFile("http://www.allaroundkaarl.com/wp-content/uploads/2017/03/Renoir-Muolin-de-la-Galette-678x339.jpg");
		operaService.inserisci(opera4);     

		Opera opera5 = new Opera();
		opera5.setArtista(artista1);
		opera5.setTitolo("Campo di grano con volo di corvi");
		opera5.setAnno(1890);
		opera5.setCollezioni(collezione1);
		opera5.setDescrizione("Campo di grano con volo di corvi è considerato come il testamento spirituale di Vincent Van Gogh. Secondo alcuni critici si tratterebbe dell’ultimo quadro dell’artista, che lo avrebbe realizzato come preannuncio del suo suicidio o come ideale lettera di addio.");
		opera5.setFile("https://www.analisidellopera.it/wp-content/uploads/2019/01/Van_Gogh_Campo_di_grano_con_volo_do_corvi-2000x1200.jpg");
		operaService.inserisci(opera5);

		Opera opera6 = new Opera();
		opera6.setArtista(artista1);
		opera6.setTitolo("Girasoli");
		opera6.setAnno(1888);
		opera6.setCollezioni(collezione1);
		opera6.setDescrizione("I Girasoli sono una serie di dipinti ad olio su tela realizzati tra il 1888 e il 1889 dal pittore Vincent van Gogh. Tra i soggetti preferiti dal pittore, sono oggi tra le sue opere più riconoscibili e note presso il grande pubblico.");
		opera6.setFile("https://ilchaos.com/wp-content/uploads/2021/04/Vaso-con-dodici-girasoli-di-van-gogh-vincent-1888.jpg");
		operaService.inserisci(opera6);

		collezione1.getOpere().add(opera1);
        collezione1.getOpere().add(opera2);
        collezione1.getOpere().add(opera3);
        collezione2.addOpera(opera3);
        collezione2.addOpera(opera2);
        collezione3.addOpera(opera1);
        collezione4.addOpera(opera2);
        collezioneService.inserisci(collezione1);
        collezioneService.inserisci(collezione2);
        collezioneService.inserisci(collezione3);
        collezioneService.inserisci(collezione4);
	}
}*/
