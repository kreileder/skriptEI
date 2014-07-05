package tum.fsei.skriptEI;

public class SemesterPack {

	String name;
	String[] content;
	String[] scripts;
	
	public SemesterPack(){

	}
	
	public void setPack(int number){
		switch (number){
		case 1:
			this.name = "1.Semester";
			this.content = new String[] {	"Digitaltechnik - Skript", 
											"Digitaltechnik - Folien", 
											"Schaltungstechnik - SPICE", 
											"Schaltungstechnik 1 - Skript", 
											"Schaltungstechnik 1 - Uebung"};
			this.scripts = new String[] {	"EI07523", 
											"EI07512", 
											"EI0566", 
											"EI0612", 
											"EI07534"};
			break;
		case 2:
			this.name = "2.Semester";
			this.content = new String[] {	"Computertechnik/Computersysteme 1 - Altes Skript",
											"Computertechnik/Computersysteme 1 - Folien", 
											"Computertechnik/Computersysteme 1 - Uebung", 
											"Elektrizitaet und Magnetismus - Skript", 
											"Elektrizitaet und Magnetismus - Uebung",
											"Schaltungstechnik 2 - Skript",
											"Schaltungstechnik 2 - Uebung",
											"Programmieren in C"};
			this.scripts = new String[] {	"EI08282", 
											"EI08271", 
											"EI08260", 
											"EI08116", 
											"EI06650",
											"EI08293",
											"EI08385",
											"EI08256"};
			break;
		case 3:
			this.name = "3.Semester";
			this.content = new String[] {	"Werkstoffe der Elektrotechnik", 
											"Elektromagnetische Feldtheorie - Skript", 
											"Elektromagnetische Feldtheorie - Uebung", 
											"Stochastische Signale - Uebung", 
											"Stochastische Signale - Skript",
											"Signaldarstellung - Uebung",
											"Signaldarstellung - Skript"};
			this.scripts = new String[] {	"EI0589", 
											"EI07486", 
											"EI07210", 
											"EI07346", 
											"EI07335",
											"EI07232",
											"EI07221"};
			break;
		case 4:
			this.name = "4.Semester";
			this.content = new String[] {	"Computertechnik/Computersysteme 1 - Altes Skript", 
											"Computertechnik/Computersysteme 1 - Folien", 
											"Computertechnik/Computersysteme 1 - Uebung", 
											"Elektrische Energietechnik", 
											"Nachrichtentechnik 1",
											"Regelungssysteme 1",
											"Technische Mechanik",
											"Elektronische Bauelemente - Skript",
											"Elektronische Bauelemente - Uebung"};
			this.scripts = new String[] {	"EI08282", 
											"EI08271", 
											"EI08260", 
											"EI08245", 
											"EI08142",
											"EI08153",
											"EI08024",
											"EI07976",
											"EI07965"};
			break;
		}
	}
}
