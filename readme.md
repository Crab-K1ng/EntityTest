<img align="left" width="80" height="80" src="https://github.com/Crab-K1ng/EntityTest/blob/master/src/main/resources/assets/entity_test/icon.png" alt="icon">

# Entity Test

Mod for game Cosmic Reach.\
Based on the example mod for the [Puzzle Loader](https://github.com/PuzzleLoader/PuzzleLoader)

## Mod requires
- Cosmic Reach (0.1.45)
- Puzzle (1.3.0)

## How to test/build
For testing in the dev env, you can use the `gradle runLoader` task

For building, the usual `gradle buildBundleJar` task can be used. The output will be in the `build/libs/` folder

## Notes
- Most project properties can be changed in the `gradle.properties`
- To change author, description and stuff that is not there, edit `src/main/resources/puzzle.mod.json`
- The project name is defined in `settings.gradle`
- To add Puzzle mods in the build, make sure to use `internal` or `mod` rather than `implementation`
- To bundle your dependencies use `bundle` and run task `gradle buildBundleJar` or `gradle buildSlimJar` for a more cut down version.

## License
Mod Licensed under MIT license .