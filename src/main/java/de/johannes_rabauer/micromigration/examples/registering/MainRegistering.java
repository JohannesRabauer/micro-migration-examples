package de.johannes_rabauer.micromigration.examples.registering;

import java.util.Date;

import de.johannes_rabauer.micromigration.MigrationEmbeddedStorage;
import de.johannes_rabauer.micromigration.MigrationEmbeddedStorageManager;
import de.johannes_rabauer.micromigration.migrater.AutoRegisteringMigrater;

@Deprecated
public class MainRegistering  
{
	public static void main(String[] args) 
	{
		final MigrationEmbeddedStorageManager storageManager = MigrationEmbeddedStorage.start(AutoRegisteringMigrater.INSTANCE);
		System.out.println(storageManager.root());
		if(storageManager.root() == null)
		{
			storageManager.setRoot("Hello World! @ " + new Date());
		}
		storageManager.storeRoot();
		storageManager.shutdown();
	}
}
