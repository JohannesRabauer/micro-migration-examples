package de.johannes_rabauer.micromigration.examples.practical.standalone;

import de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.BusinessBranch;
import de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.Customer;
import de.johannes_rabauer.micromigration.scripts.MigrationScript;
import de.johannes_rabauer.micromigration.version.MigrationVersion;
import de.johannes_rabauer.micromigration.version.VersionedObject;
import one.microstream.storage.types.EmbeddedStorageManager;

public class UpdateToV2_0 implements MigrationScript
{
	@Override
	public MigrationVersion getTargetVersion() 
	{
		return new MigrationVersion(2,0);
	}

	@Override
	public void execute(
		Object                 root          ,
		EmbeddedStorageManager storageManager
	)
	{
		System.out.println("Executing Script for v2.0...");
		VersionedObject versionedBranch = (VersionedObject)root;
		final BusinessBranch branch = ((BusinessBranch)versionedBranch.getObject());
		Customer newCustomer = new Customer();
		newCustomer.name = "Stevie Nicks";
		newCustomer.address.number = 5;
		newCustomer.address.street = "Fleetwood Street";
		newCustomer.address.city = "Phoenix";
		branch.customers.add(newCustomer);
		storageManager.store(branch.customers);
		System.out.println("Done executing Script for v2.0");
	}
}
