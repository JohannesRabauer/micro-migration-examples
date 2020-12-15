package de.johannes_rabauer.micromigration.examples.reflective.scripts;

import java.util.Date;

import de.johannes_rabauer.micromigration.MigrationEmbeddedStorageManager;
import de.johannes_rabauer.micromigration.scripts.MicroMigrationScript;
import de.johannes_rabauer.micromigration.version.MicroMigrationVersion;

public class UpdateToV1_0 implements MicroMigrationScript
{
	public MicroMigrationVersion getTargetVersion() 
	{
		return new MicroMigrationVersion(1,0);
	}

	public void execute(
		Object                          root          ,
		MigrationEmbeddedStorageManager storageManager
	)
	{
		System.out.println("Update " + getTargetVersion().toString() + " executed.");
		storageManager.setRoot("Hello World! @ " + new Date() + " Update 1.0");
	}
}
