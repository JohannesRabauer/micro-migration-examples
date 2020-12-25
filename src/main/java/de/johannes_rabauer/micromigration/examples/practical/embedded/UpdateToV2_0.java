package de.johannes_rabauer.micromigration.examples.practical.embedded;

import de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.BusinessBranch;
import de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.Customer;
import de.johannes_rabauer.micromigration.scripts.Context;
import de.johannes_rabauer.micromigration.scripts.MigrationScript;
import de.johannes_rabauer.micromigration.version.MigrationVersion;

public class UpdateToV2_0 implements MigrationScript<BusinessBranch>
{
	@Override
	public MigrationVersion getTargetVersion() 
	{
		return new MigrationVersion(2,0);
	}
	
	@Override
	public void migrate(Context<BusinessBranch> context) 
	{
		System.out.println("Executing Script for v2.0...");
		final BusinessBranch branch = context.getMigratingObject();
		Customer newCustomer = new Customer();
		newCustomer.name = "Stevie Nicks";
		newCustomer.address.number = 5;
		newCustomer.address.street = "Fleetwood Street";
		newCustomer.address.city = "Phoenix";
		branch.customers.add(newCustomer);
		context.getStorageManager().store(branch.customers);
		System.out.println("Done executing Script for v2.0");
	}
}
