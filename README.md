# gen-iii-event-patcher
This repository facilitates the transformation of a Generation III Pokémon game ROM to a distribution ROM.

# Notice
Currently, error reporting is minimal at best. This may be fixed at a later date. However, given current commitments, I cannot fix bugs in the program currently. Therefore, people using this program should have at least some experience in Java development, in the event they need to debug the program.

## Background
The Generation III Pokémon games introduced the Mystery Gift feature. Mystery Gift can allow players to receive special Pokémon, or allow players to access otherwise inaccessable locations. The Generation III implementation is unusual in that rather than merely activating a flag or two, it downloads a script into the save data, to be executed at a later time. This 1 kilobyte script can contain any valid script instruction, including ones that enable arbitrary code execution.

While ACE can be achieved through this program, it is not the primary purpose. Rather, this program is designed to (1) patch a script into a Pokémon FireRed, LeafGreen, or Emerald save file for personal use, and (2) patch the ROM and SAV at the same time to create a distribution ROM.

NOTE: Because Ruby and Sapphire only support Mystery Event (a slightly different mechanic), they are incompatible with this program. Please use Emerald instead.

## Installation
1. Download the latest release [here](https://example.com).
2. Unzip the zip file.
3. Done!

## Usage
Different use cases have different dependencies and instructions. Therefore, additional READMEs have been made for various use cases. Please find your use case below, and read the corresponding README.

### I just want to access all of the event islands
See [README-ENDUSER.md](https://example.com)

### A friend provided me an event to patch into my save
See [README-ENDUSER.md](https://example.com)

### I want to distibute an event to FireRed, LeafGreen, AND Emerald
See [README-DUAL-REGION.md](https://example.com)

### I want to distribute an event to only FireRed and LeafGreen (not Emerald)
See [README-SINGLE-REGION.md](https://example.com)

### I want to distribute an event to only Emerald (not FireRed or LeafGreen)
See [README-SINGLE-REGION.md](https://example.com)

### I want to create an event
See [README-DEVELOPER.md](https://example.com)

### I want to know how to use this program for ACE
See [README-DEVELOPER.md](https://example.com)
