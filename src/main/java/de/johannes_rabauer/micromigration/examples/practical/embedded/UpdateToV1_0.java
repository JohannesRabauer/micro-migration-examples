package de.johannes_rabauer.micromigration.examples.practical.embedded;

import de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.Address;
import de.johannes_rabauer.micromigration.scripts.Context;
import de.johannes_rabauer.micromigration.scripts.MigrationScript;
import de.johannes_rabauer.micromigration.version.MigrationVersion;

public class UpdateToV1_0 implements MigrationScript<de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch>
{
	@Override
	public MigrationVersion getTargetVersion() 
	{
		return new MigrationVersion(1,0);
	}
	
	@Override
	public void migrate(Context<de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch> context) 
	{
		System.out.println("Executing Script for v1.0...");
		de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch oldBranch = context.getMigratingObject();
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
		context.getStorageManager().setRoot(newBranch);
		context.getStorageManager().storeRoot();
		System.out.println("Done executing Script for v1.0");
	}
}
