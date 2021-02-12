# gen-iii-event-patcher
This repository facilitates the transformation of a Generation III Pokémon game ROM to a distribution ROM.

# Notice 1
Currently, error reporting is minimal at best. This may be fixed at a later date. However, given current commitments, I cannot fix bugs in the program currently. Therefore, people using this program should have at least some experience in Java development, in the event they need to debug the program.

# Notice 2
Due to a backend change, most documentation became incorrect and had to be deleted. I hope to have documentation in the next few days.

## Background
The Generation III Pokémon games introduced the Mystery Gift feature. Mystery Gift can allow players to receive special Pokémon, or allow players to access otherwise inaccessable locations. The Generation III implementation is unusual in that rather than merely activating a flag or two, it downloads a script into the save data, to be executed at a later time. This 1 kilobyte script can contain any valid script instruction, including ones that enable arbitrary code execution.

While ACE can be achieved through this program, it is not the primary purpose. Rather, this program is designed to (1) patch a script into a Pokémon FireRed, LeafGreen, or Emerald save file for personal use, and (2) patch the ROM and SAV at the same time to create a distribution ROM.

NOTE: Ruby and Sapphire only support Mystery Event (a slightly different mechanic). While I have every reason to believe Ruby and Sapphire are compatible, no testing has been performed.

## Installation
1. Download the latest release [here](https://github.com/superguideguy/gen-iii-event-patcher/releases).
2. Unzip the zip file.
3. Done!

## Usage
Different use cases have different dependencies and instructions. Unless specified below, you will only need to fill in the first 4 boxes (`New ROM File` need not be specified).

### I just want to access all of the event islands
For `Event File`, select the included `ultimate.g3ep`. In Emerald, it will also provide additional benefits if certain conditions are met. Then, press `Patch SAV File`.

### I have a patch file from a trustworthy source
For `Event File`, select the patch file you have obtained. Make sure you trust the contents of the patch! Then, press `Patch SAV File`.

### I want to create a distribution ROM from a patch
First, make sure the patch has the proper flag set for redistribution. By default, `ultimate.g3ep` has this flag set correctly. Second, determine if both FireRed/LeafGreen and Emerald can receive the patch. If the answer is no (that is, the patch is only meant for the Kanto games, or only meant for Emerald), see the above cases (no ROM modification is necessary). If the answer is yes, fill in the fifth box for the location to place the modified ROM (make sure it is a file, not a folder/directory). Then, press both `Patch ROM File` and `Patch SAV File`. Finally, add both ROM and SAV to your choice of flash cart.

To distribute, connect a Wireless Adapter, and select MYSTERY GIFT in the main menu. (SavPatcher will automatically enable Mystery Gift for you.) Select WONDER CARDS. On the next screen, press A. In the menu, select SEND. Follow on-screen instructions.

### I want to create a patch
Currently, patches must be made by hand. The format patches are expected in is specified on the wiki. There is a helper package called `g3sc` that can be found in the source code. It contains a (very basic) compiler for custom event scripts (section 7). The class `ChecksumCreator` in package `g3ec` may also be of assistance. Also check the first post [here](https://projectpokemon.org/home/forums/topic/35903-gen-3-mystery-eventgift-research/).
