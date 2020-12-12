package de.johannes_rabauer.micromigration.examples.simple;

import java.util.Date;

import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;

public class Main 
{
	public static void main(String[] args) 
	{
		final EmbeddedStorageManager storageManager = EmbeddedStorage.start();
		System.out.println(storageManager.root());
		storageManager.setRoot("Hello World! @ " + new Date());
		storageManager.storeRoot();
	}
}
