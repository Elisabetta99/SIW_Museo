# Museo
Progetto realizzato per il corso **Sistemi Informativi su Web** *A.A. 2020/2021* da **Chiusoli Elisabetta** e **Giordano Elisabetta**.
***
Caso d’uso **UC1**:  Effettuare l'accesso al Sistema – Attore primario: un *Utente*
1. Un Utente vuole accedere al Sistema. 
2. L'Utente inserisce il suo username e la sua password. Il Sistema verifica la correttezza dei dati immessi e autentica l'Utente. Il Sistema mostra l'elenco delle attività che l'Utente può svolgere. 
Estensione 2a: L'Utente non è registrato al Sistema. Il sistema non lo autentica e non mostra l'elenco delle attività.

Caso d'uso **UC2**: Effettuare la navigazione per collezioni, artisti ed opere – Attore primario: un Utente. 
Un Utente può usare il Sistema per navigare tra collezioni, artisti ed opere in diversi modi, come segue: 
1. può visualizzare tutte le collezioni ed a partire da una collezione può esaminare le opere inserite, visualizzando anche informazioni sull'artista che è l’autore di ciascuna opera; 
2. può visualizzare l'artista ed a partire da ciascun artista può visualizzare le opere che ha creato.

Caso d'uso **UC3**: Aggiungere una collezione – Attore primario: un *Amministratore*  
1. Un Amministratore vuole aggiungere una collezione al Sistema.
2. L'Amministratore inserisce il suo username e la sua password. Il Sistema verifica la correttezza dei dati immessi e autentica l'Amministratore. Il Sistema mostra l'elenco delle attività che l'Amministratore può svolgere.
3. L'Amministratore sceglie l'attività 'inserisci i dati di una collezione'.
4. L'Amministratore inserisce nome e descrizione dell'opera, nonchè seleziona curatore e opera.
5. L'Amministratore conferma la sua volontà di creare una nuova collezione. Il Sistema registra la creazione e mostra l'elenco delle collezioni aggiornato. 
8. L'Amministratore può poi proseguire nell’uso del Sistema.

Caso d'uso **UC4**: Rimuovere una collezione – Attore primario: un *Amministratore* 
1. Un Amministratore vuole rimuovere una collezione dal Sistema.
2. L'Amministratore inserisce il suo username e la sua password. Il Sistema verifica la correttezza dei  dati immessi e autentica l'Amministratore. Il Sistema mostra l'elenco delle attività che l'Amministratore può svolgere.
3. L'Amministratore sceglie l'attività 'elenco collezioni'. Il Sistema mostra l'elenco delle collezioni al momento presenti.
4. L'Amministratore sceglie l'attività 'elimina collezione'. Il Sistema registra l'avvenuta rimozione e mostra l'elenco delle collezioni aggiornato. 
5. L'Amministratore può poi proseguire nell’uso del Sistema.

Caso d'uso **UC5**: Aggiungere un'opera – Attore primario: un *Amministratore* 
1. Un Amministratore vuole aggiungere un'opera al Sistema.
2. L'Amministratore inserisce il suo username e la sua password. Il Sistema verifica la correttezza dei 
dati immessi e autentica l'Amministratore. Il Sistema mostra l'elenco delle attività che l'Amministratore può svolgere.
3. L'Amministratore sceglie l'attività 'inserisci i dati opera'.
4. L'Amministratore inserisce titolo, anno, descrizione e link dell'immagine dell'opera, nonchè seleziona l'artista.
5.  L'Amministratore conferma la sua volontà di creare una nuova opera. Il Sistema registra la creazione e mostra l'elenco delle opere aggiornato. 
8.  L'Amministratore può poi proseguire nell’uso del Sistema.

Caso d'uso **UC6**: Rimuovere un'opera – Attore primario: un *Amministratore*  
1. Un Amministratore vuole rimuovere un'opera al Sistema.
2. L'Amministratore inserisce il suo username e la sua password. Il Sistema verifica la correttezza dei dati immessi e autentica l'Amministratore. Il Sistema mostra l'elenco delle attività che l'Amministratore può svolgere.
3. L'Amministratore sceglie l'attività 'elenco opere'. Il Sistema mostra l'elenco delle opere al momento presenti.
4. L'Amministratore sceglie l'attività 'elimina opera'. Il Sistema registra l'avvenuta rimozione e mostra l'elenco delle opere aggiornato. 
5. L'Amministratore può poi proseguire nell’uso del Sistema.

Caso d'uso **UC7**: Aggiungere un artista – Attore primario: un *Amministratore*  
1. Un Amministratore vuole aggiungere un artista al Sistema.
2. L'Amministratore inserisce il suo username e la sua password. Il Sistema verifica la correttezza dei dati immessi e autentica l'Amministratore. Il Sistema mostra l'elenco delle attività che l'Amministratore può svolgere.
3. L'Amministratore sceglie l'attività 'inserisci i dati artista'.
4. L'Amministratore inserisce nome, cognome, biografia, anno di nascita, anno di morte, luogo di nascita, luogo di morte, nazionalità e citazione dell'artista.
5. L'Amministratore conferma la sua volontà di creare un nuovo artista. Il Sistema registra la creazione e mostra l'elenco degli artisti aggiornato. 
8. L'Amministratore può poi proseguire nell’uso del Sistema.

Caso d'uso **UC8**: Rimuovere un artista – Attore primario: un *Amministratore*  
1. Un Amministratore vuole rimuovere un artista dal Sistema.
2. L'Amministratore inserisce il suo username e la sua password. Il Sistema verifica la correttezza dei dati immessi e autentica l'Amministratore. Il Sistema mostra l'elenco delle attività che l'Amministratore può svolgere.
3. L'Amministratore sceglie l'attività 'elenco artisti'. Il Sistema mostra l'elenco degli artisti al momento presenti.
4. L'Amministratore sceglie l'attività 'elimina artista'. Il Sistema registra l'avvenuta rimozione e mostra l'elenco degli artisti aggiornato. 
5. L'Amministratore può poi proseguire nell’uso del Sistema.
Estensione 4.a: L'artista ha riferimento ad una o più opere. Il sistema non elimina l'artista e mostra messaggio di errore.

