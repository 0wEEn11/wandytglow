# Trader Glow Mod (Fabric, Minecraft 1.21.1, client-side)

## Build
With JDK 21 and Gradle 8.10+ installed:

    gradle build

The Modrinth-ready jar is `build/libs/traderglow-1.0.0.jar` (not the `-sources` jar).
No local setup? Push this folder to GitHub; the included Action builds the jar (Actions tab > build > Artifacts).

## Upload to Modrinth
Create project > Mod > upload the jar as a version:
Loader: Fabric | Game version: 1.21.1 | Environments: Client required, Server unsupported | Dependency: Fabric API (required).
To use it in the Modrinth App directly: open an instance > Add content > Add from file > pick the jar.
