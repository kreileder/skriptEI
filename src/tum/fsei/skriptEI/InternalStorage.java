package tum.fsei.skriptEI;

import java.util.Vector;

class InternalStorage {

	// TODO vec zu stativ private umwandeln und dafür get-Methode schreiben

	public static Vector<Skript> vec = new Vector<Skript>();

	public static void setSkript(Skript skript) {
		// TODO Wertebereiche prüfen!
		vec.addElement(skript);
	}

}