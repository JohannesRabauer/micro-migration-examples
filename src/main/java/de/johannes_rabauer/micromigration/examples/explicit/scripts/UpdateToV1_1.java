package de.johannes_rabauer.micromigration.examples.explicit.scripts;

import java.util.Date;

import de.johannes_rabauer.micromigration.scripts.Context;
import de.johannes_rabauer.micromigration.scripts.MigrationScript;
import de.johannes_rabauer.micromigration.version.MigrationVersion;

public class UpdateToV1_1 implements MigrationScript<String>
{
	@Override
	public MigrationVersion getTargetVersion() 
	{
		return new MigrationVersion(1,1);
	}
	
	@Override
	public void migrate(Context<String> context) 
	{
		System.out.println("Update " + getTargetVersion().toString() + " executed.");
		context.getStorageManager().setRoot("Hello World! @ " + new Date() + " Update 1.1");
	}
}
