<img align="left" width="80" height="80" src="https://github.com/Crab-K1ng/EntityTest/blob/master/src/main/resources/assets/entity_test/icon.png" alt="icon">

# Entity Test 

Mod for game Cosmic Reach.\
Based on the example mod for the [Cosmic Quilt](https://codeberg.org/CRModders/cosmic-quilt) Loader

## Mod requires
- Cosmic Reach (0.1.40)
- Cosmic Quilt (2.0.2)


## How to test/build
For testing in the dev env, you can use the `gradle run` task

For building, the usual `gradle build` task can be used. The output will be in the `build/libs/` folder

## Wiki
For a wiki on how to use Cosmic Quilt & Quilt, please look at the [Cosmic Quilt wiki](https://codeberg.org/CRModders/cosmic-quilt/wiki)

## Notes
- Most project properties can be changed in the `gradle.properties`
- To change author, description and stuff that is not there, edit `src/main/resources/quilt.mod.json`
- The project name is defined in `settings.gradle`
- To add Quilt mods in the build, make sure to use `internal` rather than `implementation`

## License
Mod Licensed under MIT license .
