package de.johannes_rabauer.micromigration.examples.practical.standalone;

import de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.Address;
import de.johannes_rabauer.micromigration.scripts.MicroMigrationScript;
import de.johannes_rabauer.micromigration.version.MicroMigrationVersion;
import de.johannes_rabauer.micromigration.version.VersionedObject;
import one.microstream.storage.types.EmbeddedStorageManager;

public class UpdateToV1_0 implements MicroMigrationScript
{
	@Override
	public MicroMigrationVersion getTargetVersion() 
	{
		return new MicroMigrationVersion(1,0);
	}

	@Override
	public void execute(
		Object                 root          ,
		EmbeddedStorageManager storageManager
	)
	{
		System.out.println("Executing Script for v1.0...");
		VersionedObject versionedBranch = (VersionedObject)root;
		de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch oldBranch = 
				((de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch)versionedBranch.getObject());
		de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.BusinessBranch newBranch = 
				new de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.BusinessBranch();
		for (de.johannes_rabauer.micromigration.examples.practical.v0.Customer oldCustomer : oldBranch.customers) 
		{
			de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.Customer newCustomer = 
					new de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.Customer();
			newCustomer.name = oldCustomer.name;
			newCustomer.address = new Address();
			newCustomer.address.number = oldCustomer.number;
			newCustomer.address.street = oldCustomer.street;
			newCustomer.address.city   = oldCustomer.city  ;
			newBranch.customers.add(newCustomer);
		}
		versionedBranch.setObject(newBranch);
		storageManager.store(versionedBranch);
		System.out.println("Done executing Script for v1.0");
	}
}
