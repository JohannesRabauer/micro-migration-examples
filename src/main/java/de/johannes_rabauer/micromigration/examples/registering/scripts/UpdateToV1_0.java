package de.johannes_rabauer.micromigration.examples.registering.scripts;

import java.util.Date;

import de.johannes_rabauer.micromigration.AutoRegisteringMigrationScript;
import de.johannes_rabauer.micromigration.MigrationEmbeddedStorageManager;
import de.johannes_rabauer.micromigration.version.MicroMigrationVersion;

@Deprecated
public class UpdateToV1_0 extends AutoRegisteringMigrationScript
{
	public static final AutoRegisteringMigrationScript INSTANCE = AutoRegisteringMigrationScript.registerSelf(new UpdateToV1_0());
	
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