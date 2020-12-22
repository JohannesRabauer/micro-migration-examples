package de.johannes_rabauer.micromigration.examples.explicit.scripts;

import java.util.Date;

import de.johannes_rabauer.micromigration.scripts.MigrationScript;
import de.johannes_rabauer.micromigration.version.MigrationVersion;
import one.microstream.storage.types.EmbeddedStorageManager;

public class UpdateToV1_0 implements MigrationScript
{
	@Override
	public MigrationVersion getTargetVersion() 
	{
		return new MigrationVersion(1,0);
	}

	public void execute(
		Object                 root          ,
		EmbeddedStorageManager storageManager
	)
	{
		System.out.println("Update " + getTargetVersion().toString() + " executed.");
		storageManager.setRoot("Hello World! @ " + new Date() + " Update 1.0");
	}
}
