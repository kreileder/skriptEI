package tum.fsei.skriptEI;

import java.util.Date;
import java.util.Vector;

class InternalStorage {

	// TODO vec zu stativ private umwandeln und daf�r get-Methode schreiben

	public static Vector<Skript> vec = new Vector<Skript>();
	public static Date Datum;
	
	public static void setSkript(Skript skript) {
		// TODO Wertebereiche pr�fen!
		vec.addElement(skript);
	}
	
	public static void setDate(Date Datum) {
		Datum = new Date();
	}
	
	public static Date getDate(){
		return Datum;
	}

}