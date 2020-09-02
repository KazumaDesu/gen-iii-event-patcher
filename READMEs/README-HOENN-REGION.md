# gen-iii-event-patcher for Hoenn region distribution
This README is meant for those who wish to distribute an event to Emerald.

## Dependencies and Requirements
* Java version 8, obtainable [here](https://adoptopenjdk.net/).
* A compatible ROM, which currently includes:
  * English Emerald (Other non-Japanese copies may or may not work)
* A flash cartridge, or a method of restoring save data to an original cartridge.

## Usage
### Step 1: Creating a Save File
Most users will already have a save file. However, it is **vital** that the save file have been saved at least twice. Certain structures within the save file are not initialized until the game has been saved twice. Uniinitialized structures could interfere with the program. Therefore, it is important to boot the game, and save twice.

Once the game has been saved twice, create a backup of your save file. If you are on actual hardware, now is the time to rip your save file.

### Step 2: Running the Program
Double-click on the file `G3EP.jar`. If on linux, make sure the execute bit is set. In the first tab, supply your current save file, the location to place the modified save file, and the patch file; in that order. Your current save file and location to place the modified save file may be the same, but please make sure you have a backup. Note that if the location to place the modified file does not exist, the program should be able to create it for you.

If you want access to all event islands, `ultimate.bin` is the patch file to use. Otherwise, use a patch file provided to you by a trusted third-party. Make sure that the patch is designed to be (re)distributible. `ultimate.bin` is designed for this.

### Step 3: Restoring the Save File
Either restore the save file to the original cartridge, or load the save file and ROM onto a flash cartridge.

### Step 4: Begin Distribution
Connect a Wireless Adapter, and select `MYSTERY GIFT` in the main menu. (`SavPatcher` will automatically enable Mystery Gift for you.) Select `WONDER CARDS`. On the next screen, press A. In the menu, select `SEND`. Follow on-screen instructions.
