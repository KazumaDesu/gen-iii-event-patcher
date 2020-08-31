# gen-iii-event-patcher
This repository facilitates the transformation of a Generation III Pokémon game ROM to a distribution ROM.

# Notice
Currently, error reporting is minimal at best. This may be fixed at a later date. However, given current commitments, I cannot fix bugs in the program currently. Therefore, people using this program should have at least some experience in Java development, in the event they need to debug the program.

## Background
The Generation III Pokémon games introduced the Mystery Gift feature. Mystery Gift can allow players to receive special Pokémon, or allow players to access otherwise inaccessable locations. The Generation III implementation is unusual in that rather than merely activating a flag or two, it downloads a script into the save data, to be executed at a later time. This 1 kilobyte script can contain any valid script instruction, including ones that enable arbitrary code execution.

While ACE can be achieved through this program, it is not the primary purpose. Rather, this program is designed to (1) patch a script into a Pokémon FireRed, LeafGreen, or Emerald save file for personal use, and (2) patch the ROM and SAV at the same time to create a distribution ROM.

NOTE: Because Ruby and Sapphire only support Mystery Event (a slightly different mechanic), they are incompatible with this program. Please use Emerald instead.

## Installation
1. Download the latest release of Assets.zip [here](https://github.com/superguideguy/gen-iii-event-patcher/releases).
2. Unzip the zip file.
3. Done!

## Usage
Different use cases have different dependencies and instructions. Therefore, additional READMEs have been made for various use cases. Please find your use case below, and read the corresponding README.

### I just want to access all of the event islands
See [README-END-USERS.md](https://github.com/superguideguy/gen-iii-event-patcher/blob/main/READMEs/README-END-USERS.md)

### A friend provided me an event to patch into my save
See [README-END-USERS.md](https://github.com/superguideguy/gen-iii-event-patcher/blob/main/READMEs/README-END-USERS.md)

### I want to distribute an event to FireRed, LeafGreen, AND Emerald
See [README-DUAL-REGION.md](https://github.com/superguideguy/gen-iii-event-patcher/blob/main/READMEs/README-DUAL-REGION.md)

### I want to distribute an event to only FireRed and LeafGreen (not Emerald)
See [README-KANTO-REGION.md](https://github.com/superguideguy/gen-iii-event-patcher/blob/main/READMEs/README-KANTO-REGION.md)

### I want to distribute an event to only Emerald (not FireRed nor LeafGreen)
See [README-HOENN-REGION.md](https://github.com/superguideguy/gen-iii-event-patcher/blob/main/READMEs/README-HOENN-REGION.md)

### I want to create an event
See [README-DEVELOPERS.md](https://github.com/superguideguy/gen-iii-event-patcher/blob/main/READMEs/README-DEVELOPERS.md)

### I want to know how to use this program for ACE
See [README-DEVELOPERS.md](https://github.com/superguideguy/gen-iii-event-patcher/blob/main/READMEs/README-DEVELOPERS.md)

## How you can help
Right now, the best way you can help is to provide information about different ROMs. Only two ROMs are currently supported for distributing to all games, so more information is key. If you have access to one of the following ROMs, please reply to issue [#7](https://github.com/superguideguy/gen-iii-event-patcher/issues/7). PLEASE DO NOT SEND ME THE ROMS. THAT IS ILLEGAL.
| ROM     | CRC32    | MD5 | SHA-1 | SHA-256 | Hash Source |
|-------------------------|----------|-----|-------|---------|-------------|
|English FireRed BPRE v1.0|`DD88761C`|`E26EE0D44E809351C8CE2D73C7400CDD`|`41CB23D8DCCC8EBD7C649CD8FBB58EEACE6E2FDC`|`3D0C79F1627022E18765766F6CB5EA067F6B5BF7DCA115552189AD65A5C3A8AC`|https://datomatic.no-intro.org/index.php?page=show_record&s=23&n=1616 |
|English FireRed BPRE v1.1|`84EE4776`|`51901A6E40661B3914AA333C802E24E8`|`DD5945DB9B930750CB39D00C84DA8571FEEBF417`|`729041B940AFE031302D630FDBE57C0C145F3F7B6D9B8ECA5E98678D0CA4D059`|https://datomatic.no-intro.org/index.php?page=show_record&s=23&n=1672 |
|English LeafGreen BPGE v1.0|`D69C96CC`|`612CA9473451FA42B51D1711031ED5F6`|`574FA542FFEBB14BE69902D1D36F1EC0A4AFD71E`| Not Listed | https://datomatic.no-intro.org/index.php?page=show_record&s=23&n=1617 |
