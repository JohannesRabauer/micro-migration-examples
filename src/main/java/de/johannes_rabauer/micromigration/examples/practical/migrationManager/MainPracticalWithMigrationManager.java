package de.johannes_rabauer.micromigration.examples.practical.migrationManager;

import de.johannes_rabauer.micromigration.MigrationManager;
import de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch;
import de.johannes_rabauer.micromigration.examples.practical.v0.Customer;
import de.johannes_rabauer.micromigration.migrater.ExplicitMigrater;
import de.johannes_rabauer.micromigration.version.VersionedObject;
import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;

/**
 * A practical example of usage in a few steps:
 * <ul>
 * <li> v0.0: Storage is created without any updates. Only stores a new {@link de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch}
 * <li> v1.0: The BusinessBranch has a new implementation {@link de.johannes_rabauer.micromigration.examples.practical.v1AndHigher.BusinessBranch}.
 * The old branch is converted to the new implementation through the {@link UpdateToV1_0} script.
 * <li> v2.0: A new customer is added through the {@link UpdateToV2_0} script.
 * </ul>
 * The storage is restarted after every update to simulate a complete lifecycle of the datastore.
 * @author Johannes Rabauer
 *
 */
public class MainPracticalWithMigrationManager 
{
	/**
	 * Suppressed Warning "unchecked" because it is given, that the correct object is returned.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		//V0.0
		try(EmbeddedStorageManager storageManager = EmbeddedStorage.start())
		{
			VersionedObject<BusinessBranch> versionedBranch = new VersionedObject<>(createDummyBranch());
			storageManager.setRoot(versionedBranch);
			storageManager.storeRoot();
			System.out.println(storageManager.root().toString());
		}
		
		
		//V1.0
		try(EmbeddedStorageManager storageManager = EmbeddedStorage.start())
		{
			final ExplicitMigrater migraterWithV1 = new ExplicitMigrater(new UpdateToV1_0());
			VersionedObject<BusinessBranch> versionedBranch = (VersionedObject<BusinessBranch>)storageManager.root();
			new MigrationManager(versionedBranch, migraterWithV1, storageManager)
				.migrate(versionedBranch);
			System.out.println(storageManager.root().toString());
		}
		
		
		//V2.0
		try(EmbeddedStorageManager storageManager = EmbeddedStorage.start())
		{
			final ExplicitMigrater migraterWithV2 = new ExplicitMigrater(new UpdateToV1_0(), new UpdateToV2_0());
			VersionedObject<BusinessBranch> versionedBranch = (VersionedObject<BusinessBranch>)storageManager.root();
			new MigrationManager(versionedBranch, migraterWithV2, storageManager)
				.migrate(versionedBranch);
			System.out.println(storageManager.root().toString());
		}
	}
	
	private static BusinessBranch createDummyBranch()
	{
		de.johannes_rabauer.micromigration.examples.practical.v0.BusinessBranch branch = new BusinessBranch();
		Customer customer1 = new Customer();
		customer1.name   = "Mick Fleetwood";
		customer1.number = 1;
		customer1.street = "Fleetwood Street";
		customer1.city   = "Redruth";
		branch.customers.add(customer1);
		Customer customer2 = new Customer();
		customer2.name   = "Lindsey Buckingham";
		customer2.number = 2;
		customer2.street = "Mac Street";
		customer2.city   = "Palo Alto";
		branch.customers.add(customer2);
		return branch;
	}
}
