package de.johannes_rabauer.micromigration.examples.reflective.scripts;

import java.util.Date;

import de.johannes_rabauer.micromigration.scripts.MicroMigrationScript;
import de.johannes_rabauer.micromigration.version.MicroMigrationVersion;
import one.microstream.storage.types.EmbeddedStorageManager;

public class UpdateToV1_0 implements MicroMigrationScript
{
	@Override
	public MicroMigrationVersion getTargetVersion() 
	{
		return new MicroMigrationVersion(1,0);
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
