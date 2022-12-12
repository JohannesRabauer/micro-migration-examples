[![No Maintenance Intended](http://unmaintained.tech/badge.svg)](http://unmaintained.tech/)
# DEPRECATED
This is no longer supported, please consider using https://github.com/xdev-software/micro-migration instead.

# micro-migration-examples
Examples for the MicroMigration-Library

Currently contains four major examples:
## Example with `ExplicitMigrater`
In the package `de.johannes_rabauer.micromigration.examples.explicit` there is a simple example with explicitly listed upgrade scripts.
This is the most straight forward approach to use migration scripts.

## Example with `ReflectiveMigrater`
In package `de.johannes_rabauer.micromigration.examples.reflective` a migrater which finds it's scripts through reflection is used.
So here all `MicroMigrationScript`s in the defined  `de.johannes_rabauer.micromigration.examples.reflective.scripts` package are used.

Since the `ReflectiveMigrater` uses the [Reflections library](https://github.com/ronmamo/reflections) it is extracted to its [own repository](https://github.com/JohannesRabauer/micro-migration-reflection).

## Practical examples
The package `de.johannes_rabauer.micromigration.examples.practical.embedded` contains examples
that are just a bit more complex than the other examples and should allow an insight about the usage in a 
practical environment.

There is one example implemented with the `MigrationEmbeddedStorageManager` and another with the
plain `MigrationManager`, so it is clear what the difference between these two approaches is.
In both implementations the first update migrates from version 0 to 1 and converts an "old" `BusinessBranch`
to a newer one. The second update only adds more `Customer`s to the existing `BusinessBranch`.