package tum.fsei.skriptEI;

import java.util.Vector;

class parser{
	private static Vector<Skript> parsedSkript = new Vector<Skript>();
	
	
	
	public static void setList(Vector<Skript> List){
		parsedSkript = List;
	}
	
	public static Skript getSkript(int skriptNr){
		return parsedSkript.get(skriptNr);
	}
	
	public static Vector<Skript> getList(){
		return parsedSkript;
	}
}
