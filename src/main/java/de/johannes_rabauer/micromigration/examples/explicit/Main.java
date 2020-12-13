package de.johannes_rabauer.micromigration.examples.explicit;

import java.util.Date;

import de.johannes_rabauer.micromigration.MigrationEmbeddedStorage;
import de.johannes_rabauer.micromigration.MigrationEmbeddedStorageManager;
import de.johannes_rabauer.micromigration.examples.explicit.scripts.UpdateToV1_0;
import de.johannes_rabauer.micromigration.examples.explicit.scripts.UpdateToV1_1;
import de.johannes_rabauer.micromigration.migrater.ExplicitMigrater;

public class Main 
{
	public static void main(String[] args) 
	{
		final ExplicitMigrater migrater = new ExplicitMigrater(
				new UpdateToV1_0(),
				new UpdateToV1_1()
		);
		final MigrationEmbeddedStorageManager storageManager = MigrationEmbeddedStorage.start(migrater);
		System.out.println(storageManager.root());
		if(storageManager.root() == null)
		{
			storageManager.setRoot("Hello World! @ " + new Date());
		}
		storageManager.storeRoot();
		storageManager.shutdown();
	}
}
