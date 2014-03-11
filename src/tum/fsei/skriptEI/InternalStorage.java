package tum.fsei.skriptEI;

import java.util.Vector;

class InternalStorage {

	// TODO vec zu stativ private umwandeln und dafür get-Methode schreiben

	public static Vector<Skript> vec = new Vector<Skript>();

	//Skript skript = new Skript(0,null,0,null,0,false);

	public static void setSkript(Skript skript) {

		// TODO Wertebereiche prüfen!
		vec.add(skript);
		
	}

}