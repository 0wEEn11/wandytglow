# Trader Glow Mod (Fabric, Minecraft 26.2, client-side)

## Build
With JDK 25 and Gradle 9.6+ installed:

    gradle build

The Modrinth-ready jar is `build/libs/traderglow-1.0.0.jar` (not the `-sources` jar).
No local setup? Push this folder to GitHub; the included Action builds the jar (Actions tab > build > Artifacts).

## Upload to Modrinth
Create project > Mod > upload the jar as a version:
Loader: Fabric | Game version: 26.2 | Environments: Client required, Server unsupported | Dependency: Fabric API (required).
To use it in the Modrinth App directly: open an instance > Add content > Add from file > pick the jar.
