package tum.fsei.skriptEI;

import android.content.SharedPreferences;

public class restore {
	
	public static void save(SharedPreferences storage){
		
		SharedPreferences.Editor editor = storage.edit();
		
		int i = 0;
		for(Skript skript : InternalStorage.vec){
			editor.putInt(i + "-ID", skript.getId());
			editor.putString(i + "-Title", skript.getTitle());
			editor.putFloat(i + "-Price", (float) skript.getPrice());
			editor.putInt(i + "-Stock", skript.getStock());
			editor.putString(i + "-Ident", skript.getIdent());
			editor.putBoolean(i + "-Selected", skript.getSelected());
			i = i + 1;
		}
		editor.putInt("MaxKey",i-1);
		editor.commit();
	}
	
	public static void load(SharedPreferences storage){
		 int maxKey = storage.getInt("MaxKey", 0);
		 Skript mySkript = new Skript(0, null, 0, null, 0, false);
		 
		 if (maxKey > 0){
			 for(int i = 0; i <= maxKey; i++){
				 mySkript.setId(storage.getInt(i+"-ID", 0));
				 mySkript.setTitle(storage.getString(i+"-Title", null));
				 mySkript.setStock(storage.getInt(i+"-Stock", 0));
				 mySkript.setPrice(storage.getFloat(i+"-Price",0));
				 mySkript.setIdent(storage.getString(i+"-Ident", null));
				 mySkript.setSelected(storage.getBoolean(i+"-Selected", false));
				 
				 InternalStorage.setSkript(new Skript(	mySkript.getId(),
														mySkript.getTitle(), 
														mySkript.getPrice(), 
														mySkript.getIdent(), 
														mySkript.getStock(), 
														false));
				 
			 }
			 System.out.print("ID: |" + InternalStorage.vec.elementAt(2).getId() + "|\n");
		 }
		 System.out.print("MaxKey: |" + maxKey + "|\n");
	}
}