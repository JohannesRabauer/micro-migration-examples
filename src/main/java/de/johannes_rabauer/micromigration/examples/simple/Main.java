package de.johannes_rabauer.micromigration.examples.simple;

import java.util.Date;

import de.johannes_rabauer.micromigration.MigrationEmbeddedStorage;
import de.johannes_rabauer.micromigration.MigrationEmbeddedStorageManager;

public class Main 
{
	public static void main(String[] args) 
	{
		final MigrationEmbeddedStorageManager storageManager = MigrationEmbeddedStorage.start();
		System.out.println(storageManager.root());
		storageManager.setRoot("Hello World! @ " + new Date());
		storageManager.storeRoot();
		storageManager.shutdown();
	}
}
