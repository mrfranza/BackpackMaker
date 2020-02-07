_Franzin Alberto_        _5BIA, 6/02/2020_

[Documentazione Tecnica (Link)](https://docs.google.com/document/d/1Ik2FCUSA7D1e7oXsPwGSOXhLZ0HD6IrKTNauzZjuDDg/edit?usp=sharing/)

[Presentazione Back Pack Maker (link)](https://docs.google.com/presentation/d/1lvxRPlc33xVTagd2AjKHb-xJPV2R7pc3IjUEZymRA2g/edit?usp=sharing)


**Sviluppo App Android**

*Specifiche tecniche*

**Informazioni**

L&#39;idea di &quot;Backpack Maker&quot; è nata da una necessità personale di un planner che funzionasse solo per la settimana (quindi non un calendario). Nell&#39;app si possono aggiungere,modificare e visualizzare delle memo per ogni giorno della settimana.

**General Technical Data**

Choose the features and components included in your app:

- Activity (specify the number of activities in you app)
Nell&#39;app ci sono 2 Activity e 3 Fragment Activity:

		-activity\_principal\_menu
		-activity\_day\_content

- Service (specify the operations performed by the services)
(Per un possibile aggiornamento) Gestione della notifica giornaliera quando l&#39;app è in background.
- Broadcast Receiver (specify the purpose)
(Per un possibile aggiornamento) Gestione della notifica giornaliera + gestione per l&#39;invio e download di dati da firebase.
- Intent (to pass data between activities, to run another app, to run a service.. specify)

su ShareFragment.java
per l&#39;invio di un messaggio con il link dell&#39;app.

Su ui/HomeFragment.java
```java
       Intent myInt=new Intent(getContext(),DayContent.class);
       String g = Integer._toString_(i+1);

       switch (g){
           case &quot;1&quot;:
               myInt.putExtra(&quot;name\_of\_day\_of\_week&quot;,&quot;1&quot;);
               break;
                 //etc
});
```

Passa il giorno della settimana selezionato e avvia la activity\_day\_content.
Su DayContent.java
```java
final Intent itnt = getIntent(); ← Per la ricezione del giorno della settimana dalla home
```
- Fragments (specify the purpose)
	
		fragment\_home
		fragment\_tools
		fragment\_share

Tutti i fragment sono stati creati per la gestione della navigazione nel side menu:
Appartengono quindi all activity principale &quot;activity\_principal\_menu &quot;.
Il fragment home si avvia al lancio dell&#39;applicazione.

- SQLite database engine (specify the kind of data stored into SQLite db)
Nel database, stanziato nella classe MySQLiteHelper  , c&#39;è una tabella avente due campi colonna (ID [sono 7 -\&gt; come i giorni della settimana],Contenuto).
- External DBMS connection (MySQL, PostgreSQL, or specify others..)
(per un possibile aggiornamento) Firebase
- Internet Connectivity (specify the purpose)
(per un possibile aggiornamento) per la connessione a Firebase
- Multiple device layout and resolution support (tablet, smartphone, ..specify)
Dispositivi Android con versione API 25 in su.

Ratio supportate: Smartphone e Tablet.

**Key Features**

Personalmente, ritengo che la mia app sia comoda perchè è semplice da usare e non richiede conoscenze tecniche informatiche.

Inoltre l&#39;app è guidata in ogni suo punto e a differenza di molti planner che si possono scaricare non è un calendario ma gestisce una sola settimana ---\&gt; delle routine.

**Code fragments**

All&#39;onclick del floating button dell&#39;activity principale prende il numero del giorno della settimana (es. Domenica = 7/Lunedì = 1) ---\&gt; invia una notifica (sendonchannel1) con il contenuto del zaino di quel giorno e un toast con lo stesso contenuto.
```java
Calendar calendar = Calendar._getInstance_();

int day = calendar.get(Calendar._DAY\_OF\_WEEK_);

MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());

switch (day) {
   case Calendar._MONDAY_:
       // Current day is Sunday
       String lunedi = db.DAI(1);    ←---------------Prende dal database il contenuto di lunedi
	Toast._makeText_(getApplicationContext(),lunedi,Toast._LENGTH\_LONG_).show();
       _sendOnChannel1_(&quot;IL TUO ZAINO DEL LUNEDI&#39; ! &quot;,lunedi);
       break;
```
Per mandare una notifica servono 2 classi, un NotificationManager e una classe per creare il canale (contenente le priorità). ---\&gt; per l&#39;effettivo invio di una notifica ho creato questa funzione nella launcher activity che richiede titolo e contenuto.
```java
public static void sendOnChannel1(String title,String content){
   Notification notification = new NotificationCompat.Builder(_context2_, _CHANNEL\_2\_ID_)
           .setSmallIcon(R.mipmap._ic\_launcher\_foreground_)
           .setContentTitle(title)
           .setContentText(content)
           .setPriority(NotificationCompat._PRIORITY\_HIGH_)
           .setCategory(NotificationCompat._CATEGORY\_ALARM_)
           //.setSound()
           .build();
   _notificationManager_.notify(1,notification);
}
```
Nella seconda activity istanzio il database sqlite e controllo il giorno della settimana che è stato selezionato nella main activity (passato con un intent) ---\&gt;setto poi il contenuto della editext con la stringa presa dal database.
```java
_db_ = new MySQLiteHelper(this);
final EditText et = findViewById(R.id._dayofweekitemspos_);
final Intent itnt = getIntent();
if(itnt.hasExtra(&quot;name\_of\_day\_of\_week&quot;)){
   String m = itnt.getStringExtra(&quot;name\_of\_day\_of\_week&quot;);
   switch (m){
       case &quot;1&quot;:
           et.setText(_db_.DAI(1));
           break;
```
Qui invece succede il contrario: al click del floating button nella seconda activity → se modifico il contenuto della edit text , viene tutto aggiornato nel database (in base al giorno della settimana selezionato)
```java
final FloatingActionButton continua = findViewById(R.id._permevabene_);
continua.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
       String g = itnt.getStringExtra(&quot;name\_of\_day\_of\_week&quot;)
       switch (g){
           case &quot;1&quot;:
               _db_.Aggiungi(et.getText().toString(),1);
               break;
```


**Development**

Target API level: \&gt;= 29

Minimum API level: 25

IDE: Android Studio

Man-hours: 120 hours

**Problems and difficulties**

Settaggio di una notifica con allarme di sistema per l&#39;invio della tale quando l&#39;app è chiusa.

Settaggio dei canali per l&#39;invio della notifica.

**Further development**

Notifica con tempo inserito dall&#39;utente.

DBMS Online con Firebase,

**Self-rating**

Per quello che deve fare e per il fatto che mi serve personalmente … 3,7/5

**References**

[https://developer.android.com/](https://developer.android.com/)

[https://stackoverflow.com/](https://stackoverflow.com/)
