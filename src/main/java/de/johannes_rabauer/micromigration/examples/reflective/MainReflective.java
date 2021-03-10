package de.johannes_rabauer.micromigration.examples.reflective;

import java.util.Date;

import de.johannes_rabauer.micromigration.MigrationEmbeddedStorage;
import de.johannes_rabauer.micromigration.MigrationEmbeddedStorageManager;
import de.johannes_rabauer.micromigration.migrater.ReflectiveMigrater;
import de.johannes_rabauer.micromigration.migrater.ScriptInstantiationException;

public class MainReflective 
{
	public static void main(String[] args) 
	{
		try {
			final ReflectiveMigrater migrater = new ReflectiveMigrater("de.johannes_rabauer.micromigration.examples.reflective.scripts");
			final MigrationEmbeddedStorageManager storageManager = MigrationEmbeddedStorage.start(migrater);
			System.out.println(storageManager.root());
			if(storageManager.root() == null)
			{
				storageManager.setRoot("Hello World! @ " + new Date());
			}
			storageManager.storeRoot();
			storageManager.shutdown();			
		} 
		catch (IllegalArgumentException | SecurityException | ScriptInstantiationException e) 
		{
			throw new Error("Could not initiate migration script", e);
		}
	}
}
