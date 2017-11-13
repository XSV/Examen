package com;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
//vrmachado@gmail.com
public class PersonaGenerica {
	public enum Sex{HOMBRE,MUJER};
	private String	nombre;
	private String	primerApellido;
	private String	segundoApellido;
	private Sex sexo;
	private LocalDate nacimiento;
	private String correo;

	public void setNombre(String nombre){this.nombre=nombre;}
	public void setPrimerApellido(String primerApellido) {this.primerApellido=primerApellido;}
	public void setSegundoApellido(String segundoApellido) {this.segundoApellido = segundoApellido;}
	public void setSexo(Sex sexo) {this.sexo = sexo;}
	public void setNacimiento(LocalDate nacimiento) {this.nacimiento = nacimiento;}
	public void setCorreo(String correo) {this.correo = correo;}
	
	public String getNComplet(){return nombre+" "+primerApellido+" "+segundoApellido;}
	public String getNombre(){return nombre;}
	public String getPrimerApellido(){	return primerApellido;}
	public String getSegundoApellido() {return segundoApellido;}
	public Sex getSexo() {return sexo;}
	public LocalDate getNacimiento() {return nacimiento;}
	public int getEdad(){return  Period.between(getNacimiento(), LocalDate.now()).getYears();}
	public String getCorreo() {return correo;}
	
	public PersonaGenerica(String nombre, String primerApellido, String segundoApellido, Sex sexo, LocalDate nacimiento,String correo) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.sexo = sexo;
		this.nacimiento = nacimiento;
		this.correo = correo;
	}
	public PersonaGenerica() {
		sexo = sex();
		nombre = (this.getSexo().equals(PersonaGenerica.Sex.HOMBRE)?nombreH():nombreM()) ;
		nombre =nombre.toUpperCase();
		primerApellido = apellido();
		segundoApellido =apellido();
		nacimiento = nacimiento();
		correo = nombre+"."+primerApellido.substring(0, primerApellido.length()/2)+"."+segundoApellido.substring(segundoApellido.length()/2, (segundoApellido.length()/2)+1)+"."+nacimiento.getYear()+"@UM.com";
		correo=correo.toLowerCase();
	}
	
	public void pintar(String s) {System.out.println(s);}
	public String datos() {return getNombre()+"  "+getPrimerApellido()+"  "+getSegundoApellido()+"  "+getSexo()+"  "+getNacimiento()+"  "+getCorreo()+"  "+getEdad();}
	public String fecha(LocalDate fecha) {
		return fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault())+
				" "+fecha.getDayOfMonth()+" de "+
				   fecha.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault())+
				"  de "+
				   fecha.getYear();}
	
	public static int numeroInt(int min,int max) {return (int) (min+Math.random()*(max-min));}
	public static double numeroDouble(double x) {return (double) (1+Math.random()*x);}
	public static String cadena(int a) {
		String cadena="";
		for(int x=0;x<a;x++) {cadena+=Character.toString((char) (65+numeroInt(0,24)));;}
		return cadena;}
	public static String nombreH() {
		String[]nombres= {
"DANIEL","ALEJANDRO","PABLO","HUGO","ALVARO","ADRIAN","DAVID","JAVIER","SERGIO","DIEGO","IVAN","MARIO","MARCOS","IKER","MANUEL",
"CARLOS","JORGE","MIGUEL","SAMUEL","LUCAS","RUBEN","ANTONIO","NICOLAS","AITOR","MARC","VICTOR","RAUL","JUAN",
"HECTOR","ALEX","ANGEL","IZAN","GONZALO","RODRIGO","GUILLERMO","JESUS","GABRIEL","JOSE","ALBERTO",
"FRANCISCO","ADAM","PAU","AARON","MATEO","JAIME","MARTIN","PEDRO","OSCAR","LUIS","ISMAEL","RAFAEL","MOHAMED",
"ERIC","UNAI","DARIO","FERNANDO","IGNACIO","POL","BRUNO","JOEL","MIGUELANGEL","CRISTIAN","ARNAU","ANDRES","ASIER",
"MARCO","JOAN","ERIK","FRANCISCOJAVIER","SANTIAGO","JOSEMANUEL","RAYAN","ENRIQUE","BIEL","JOSEANTONIO","MARTI","SAUL","EDUARDO","ISAAC",
"JAN","JORDI","ROBERTO","ADRIA","ORIOL","GERARD","JUANJOSE","GUILLEM","OMAR","CHRISTIAN","LEO","JUANMANUEL","ALEIX",
"CESAR","ROGER","JOSELUIS","YERAY","JOSEMARIA","SERGI","MIKEL","KEVIN"};
		return nombres[numeroInt(1,nombres.length)-1];}
	
	public static String nombreM() {
		String[]nombres= {
	"abene","abigail","abril","ada","adega","adela","adelaida","adele","adelina","adoracio","adoracion","africa","agar","agata","agate","aglaia","aglaya","agnes","agueda","agurtzane","aida","aiñes","aintzane",
	"alaia","alazne","alba","alegria","alegries","alice","alicia","alma","almudena","alodi","alodia","amada","amaia","amale","amalia","amanda","amande","amarande","amaranta","amarinda","amaya","ambar","amelia",
	"amparo","ana","anabel","anastase","anastasia","andere","andrea","andreia","andreua","ane","añes","angela","angeles","angelica","angelina","angels","angeriñe","angustias","anthea","anti","antia",
	"anuncia","anunciacio","anunciacion","anuntxi","anxela","apirca","apolone","apolonia","araceli","arantzazu","aranzazu","arene","argia","argiñe","ariadna","armida","arrene","arrosa","arrosane",
	"artemis","artemisa","assumpcio","astrid","estefania","estela","estella","ester","estibaliz","estrela","estrella","eudose","eudoxia","eufemia","eufrosina","eugenia","eukene","eulalia","eulari","eunice",
	"eupeme","euxea","eva","evelina","eztizen","fabiola","fabricia","faina","fara","fatima","fe","fedora","felicidad","felicidade","felicitat","felisa","fernanda","fiammetta","filomena","fiona","flaminia",
	"flavia","flora","florencia","florentina","fontsanta","fortunata","francesca","francisca","fuensanta","gabriela","gaia","gail","gala","gale","garaiñe","garbikunde","garbiñe","gartze","gartzene","geaxi",
	"gemma","genoveva","georgina","geraldine","germana","gertrudis","gerturde","gigliola","gilda","ginebra","gisela","gixane","gizakunde","gizane","gloria","godiva","goizane","goizargi","gotzone","graciela",
	"graciella","santina","sara","sefora","serafina","serena","serene","sibil","sibila","silbe","silvia","simona","simoneta","socorro","socors","sofia","sol","solange","soledad","soledade","soledat","sonia",
	"sope","sorkunde","sorne","sorospen","susana","susanna","talia","tania","tariexa","tatiana","tea","tecla","tegra","tekale","teodora","tereixa","terencia","teresa","terese","thais","todore","todose",
	"tosca","trexa","trindade","trinidad","trinitat","tula","txaro","ursula","urte","urtsule","usoa","uxia","valentina","valeria","vanesa","vanessa","velia","vera","veronica","vicenta","victoria","violant",
	"violante","violeta","virginia","viridiana","virxinia"};
		return nombres[numeroInt(1,nombres.length)-1];}
		
	public static String apellido() {
	String[] apellido= {
"GARCIA","GONZALEZ","RODRIGUEZ","FERNANDEZ","LOPEZ","MARTINEZ","SANCHEZ","PEREZ","PEÑALVER","PEON","GOMEZ",
"MARTIN","JIMENEZ","RUIZ","HERNANDEZ","DIAZ","MORENO","ALVAREZ","MUÑOZ","ROMERO","ALONSO","GUTIERREZ",
"NAVARRO","TORRES","DOMINGUEZ","VAZQUEZ","RAMOS","GIL","RAMIREZ","SERRANO","BLANCO","SUAREZ","MOLINA",
"MORALES","ORTEGA","DELGADO","CASTRO","ORTIZ","RUBIO","MARIN","SANZ","IGLESIAS","NUÑEZ","MEDINA","GARRIDO",
"SANTOS","CASTILLO","CORTES","LOZANO","GUERRERO","CANO","PRIETO","MENDEZ","CALVO","GALLEGO","VIDAL","CRUZ","LEON",
"HERRERA","MARQUEZ","PEÑA","CABRERA","FLORES","CAMPOS","VEGA","DIEZ","FUENTES","CARRASCO","CABALLERO","NIETO",
"AGUILAR","PASCUAL","REYES","HERRERO","SANTANA","LORENZO","HIDALGO","MONTERO","IBAÑEZ","GIMENEZ","FERRER",
"DURAN","VICENTE","BENITEZ","MORA","ARIAS","SANTIAGO","VARGAS","CARMONA","CRESPO","PASTOR","ROMAN","SOTO",
"SAEZ","VELASCO","SOLER","MOYA","ESTEBAN","PARRA","BRAVO","GALLARDO","ROJAS"};
	return apellido[numeroInt(1,/**/11/*/apellido.length/**/)-1];}
	public static Sex sex() {int a=numeroInt(0,2);
	if( a==1)return Sex.HOMBRE;	return Sex.MUJER;
		}
	public static LocalDate nacimiento() {return LocalDate.of(numeroInt(1950,2010), numeroInt(1,12),numeroInt(1,28));}
	public static LocalDate fecha(LocalDate ini,LocalDate fin) {	return LocalDate.of(numeroInt(ini.getYear(),fin.getYear()-1), numeroInt(1,12),numeroInt(1,28));}
	public static LocalTime hora(int inicial) {
		int x;
		do { x=numeroInt(1,3600*24);}
		while (inicial>x); 
		return LocalTime.ofSecondOfDay(x);}
	
	public static String correo() {String cadena="";
	for(int x=0;x<10;x++) {cadena+=Character.toString((char) (65+numeroInt(0,24)));;}
	return cadena+"@um.es";}
	
	public static List<PersonaGenerica> Crear(int personasC) {
		List<PersonaGenerica>personas;
		personas=new ArrayList<>();
			for(int x=0;x<personasC;x++) {personas.add(new PersonaGenerica());}
return personas;}

}
