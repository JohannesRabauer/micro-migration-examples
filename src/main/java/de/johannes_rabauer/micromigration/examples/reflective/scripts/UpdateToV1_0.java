package de.johannes_rabauer.micromigration.examples.reflective.scripts;

import java.util.Date;

import de.johannes_rabauer.micromigration.scripts.Context;
import de.johannes_rabauer.micromigration.scripts.MigrationScript;
import de.johannes_rabauer.micromigration.version.MigrationVersion;

public class UpdateToV1_0 implements MigrationScript<String>
{
	@Override
	public MigrationVersion getTargetVersion() 
	{
		return new MigrationVersion(1,0);
	}

	@Override
	public void migrate(Context<String> context) 
	{
		System.out.println("Update " + getTargetVersion().toString() + " executed.");
		context.getStorageManager().setRoot("Hello World! @ " + new Date() + " Update 1.0");
	}
}
