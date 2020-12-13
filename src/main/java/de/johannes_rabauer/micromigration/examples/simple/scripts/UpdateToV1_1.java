package de.johannes_rabauer.micromigration.examples.simple.scripts;

import java.util.Date;

import de.johannes_rabauer.micromigration.MicroMigrationScript;
import de.johannes_rabauer.micromigration.MigrationEmbeddedStorageManager;
import de.johannes_rabauer.micromigration.version.MicroMigrationVersion;

public class UpdateToV1_1 implements MicroMigrationScript
{
	public MicroMigrationVersion getTargetVersion() 
	{
		return new MicroMigrationVersion(1,1);
	}

	public void execute(
		Object                          root          ,
		MigrationEmbeddedStorageManager storageManager
	)
	{
		System.out.println("Update " + getTargetVersion().toString() + " executed.");
		storageManager.setRoot("Hello World! @ " + new Date() + " Update 1.1");
	}
}