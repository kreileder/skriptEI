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
			this.content = new String[] {	"Dummy 1", 
											"Dummy 2", 
											"Dummy 3", 
											"Dummy 4", 
											"Dummy 5"};
			this.scripts = new String[] {	"EI1234", 
											"EI1234", 
											"EI1234", 
											"EI1234", 
											"EI1234"};
		case 2:
			this.name = "2.Semester";
			this.content = new String[] {	"Schaltungstechnik 2",
											"Schaltungstechnik 2 - Übung", 
											"Computertechnik/Computersysteme 1 - Folien", 
											"Computertechnik/Computersysteme 1 - Übung", 
											"Elektrizität und Magnetismus - Skript",
											"Elektrizität und Magnetismus - Übung"};
			this.scripts = new String[] {	"EI08293", 
											"EI08385", 
											"EI08271", 
											"EI08260", 
											"EI08116",
											"EI06650"};
		case 3:
			this.name = "3.Semester";
			this.content = new String[] {	"Dummy 1", 
											"Dummy 2", 
											"Dummy 3", 
											"Dummy 4", 
											"Dummy 5"};
			this.scripts = new String[] {	"EI1234", 
											"EI1234", 
											"EI1234", 
											"EI1234", 
											"EI1234"};
		case 4:
			this.name = "4.Semester";
			this.content = new String[] {	"Regelungssysteme 1", 
											"Nachrichtentechnik 1", 
											"Dummy 1", 
											"Dummy 2", 
											"Dummy 3"};
			this.scripts = new String[] {	"EI08153", 
											"EI08142", 
											"EI1234", 
											"EI1234", 
											"EI1234"};
		}
	}
}
