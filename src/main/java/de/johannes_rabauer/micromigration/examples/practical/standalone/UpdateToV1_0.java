package de.johannes_rabauer.micromigration.examples.practical.standalone;

import de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch;
import de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.Address;
import de.johannes_rabauer.micromigration.scripts.Context;
import de.johannes_rabauer.micromigration.scripts.MigrationScript;
import de.johannes_rabauer.micromigration.version.MigrationVersion;
import de.johannes_rabauer.micromigration.version.VersionedObject;

public class UpdateToV1_0 implements MigrationScript<VersionedObject<Object>>
{
	@Override
	public MigrationVersion getTargetVersion() 
	{
		return new MigrationVersion(1,0);
	}

	@Override
	public void migrate(Context<VersionedObject<Object>> context) 
	{
		System.out.println("Executing Script for v1.0...");
		VersionedObject<Object> versionedBranch = context.getMigratingObject();
		de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch oldBranch = 
				(BusinessBranch) versionedBranch.getObject();
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
		context.getStorageManager().store(versionedBranch);
		System.out.println("Done executing Script for v1.0");
	}
}
