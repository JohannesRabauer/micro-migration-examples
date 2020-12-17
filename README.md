# micro-migration-examples
Examples for the MicroMigration-Library

Currently contains three major examples:
## Example with `ExplicitMigrater`
In the package `de.johannes_rabauer.micromigration.examples.explicit` there is a simple example with explicitly listed upgrade scripts.
This is the most straight forward approach to use migration scripts.

## Example with `ReflectiveMigrater`
In package `de.johannes_rabauer.micromigration.examples.reflective` a migrater which finds it's scripts through reflection is used.
So here all `MicroMigrationScript`s in the defined  `de.johannes_rabauer.micromigration.examples.reflective.scripts` package are used.

Since the `ReflectiveMigrater` uses the [Reflections library](https://github.com/ronmamo/reflections) it is extracted to its [own repository](https://github.com/JohannesRabauer/micro-migration-reflection).

## Example with `AutoRegisteringMigrater`
Package `de.johannes_rabauer.micromigration.examples.registering` contains a experimental migrater which uses a global, static list
where scripts register themselves. Unfortunatly this currently doesn't work. Don't use this yet!