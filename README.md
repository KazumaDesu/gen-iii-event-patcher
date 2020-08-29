# gen-iii-event-patcher
This repository facilitates the transformation of a Generation III Pokémon game ROM to a distribution ROM.

# Notice
Currently, error reporting is minimal at best. This may be fixed at a later date. However, given current commitments, I cannot fix bugs in the program currently. Therefore, people using this program should have at least some experience in Java development, in the event they need to debug the program.

## Background
The Generation III Pokémon games introduced the Mystery Gift feature. Mystery Gift can allow players to receive special Pokémon, or allow players to access otherwise inaccessable locations. The Generation III implementation is unusual in that rather than merely activating a flag or two, it downloads a script into the save data, to be executed at a later time. This 1 kilobyte script can contain any valid script instruction, including ones that enable arbitrary code execution.

While ACE can be achieved through this program, it is not the primary purpose. Rather, this program is designed to (1) patch a script into a Pokémon FireRed, LeafGreen, or Emerald save file for personal use, and (2) patch the ROM and SAV at the same time to create a distribution ROM.

## Requirements and Dependencies
Regardless of use case, you will need:
* Java version 8 or greater. [Here](https://adoptopenjdk.net/) is a link to a download page.
* The ability to use a terminal. The terminal is your friend.

If you are only patching for yourself, or creating a single-region distribution ROM (see Step 3), you will also need:
* A supported ROM, which currently includes:
  * Any non-Japanese FireRed, LeafGreen, or Emerald

If you intend to create a dual-region distribution ROM, you will also need:
* A supported distribution base ROM, which currently includes:
  * English Emerald
  * English LeafGreen v1.1
* A flash cart of some kind

## Installation
1. Download the latest release [here](https://example.com).
2. Unzip the zip file.
3. Done!

## Usage
### Step 1: Creating a Save File
In an emulator that supports SAV files, load the game you wish to patch. Select either "New Game" or "Continue". Once you gain control of your character, save the game TWICE. It is ***extremely*** important that you save twice. Failure to do so may result in corruption. Remember to make a backup as well!

### Step 2: Patching the SAV
Open a terminal in the folder downloaded earlier. Type the following command:
```
java -jar PersonalPatcher.jar <OldSav> <NewSav> <BinFile>
```
Where `<OldSav>` is the filepath to the SAV file you created in step 1, `<NewSav>` is the filepath where the modified SAV should go (it may be empty, and it also may be the same as `<OldSav>`), and `<BinFile>` is the location of the patch. You may create your own BIN files, or use the one provided. `ultimate.bin` will grant access to all event islands, regardless of if the receiving game is FireRed, LeafGreen, or Emerald.

If you are only patching for personal use, congratulations! Patching is complete. Simply use the modified SAV file in place of your original SAV file.

### Step 3 (optional): Patching the ROM
If you have an event that is compatible with both FireRed/LeafGreen and Emerald (that is, dual-region, such as `ultimate.bin`), and you intend to distribute it to both FireRed/LeafGreen and Emerald, you will need to patch the distribution ROM itself. However, if the event you wish to use is only meant for one game (that is, single-region), you do not need to patch the ROM. At this point, if you are creating a single-region distribution ROM, continue to Step 4.

The patch works by removing the function `ValidateMEventClientHeader`. As the location and assembly code of this function changes between games, the patch is hardcoded into `DistributionPatcher.jar`. As I only have English Emerald and English LeafGreen v1.1, these are the only ROMs suppported for dual-region distribution.

The command you will need to run is:
```
java -jar DistributionPatcher.jar <OldRom> <NewRom>
```
Where `<OldRom>` is the filepath to the ROM file you used in step 1, and `<NewRom>` is the filepath where the modified ROM should go (it may be empty, and it also may be the same as `<OldRom>`).

### Step 4 (optional): Loading the SAV/ROM onto a(n) original/flash cart
I cannot help you with this. All I can say is that if you patched the ROM, you will need a flash cart.
