# gen-iii-event-patcher for dual-region distribution
This README is meant for those who wish to distribute an event to FireRed, LeafGreen, and Emerald.

## Dependencies and Requirements
* Java version 8, obtainable [here](https://adoptopenjdk.net/).
* Ability to use a terminal. The terminal is your friend.
* A compatible ROM, which currently includes:
  * English LeafGreen v1.1
  * English Emerald
* A flash cartridge.

### Step 1: Creating a Save File
Most users will already have a save file. However, it is **vital** that the save file have been saved at least twice. Certain structures within the save file are not initialized until the game has been saved twice. Uniinitialized structures could interfere with the program. Therefore, it is important to boot the game, and save twice.

Once the game has been saved twice, create a backup of your save file. If you are on actual hardware, now is the time to rip your save file.

### Step 2: Running SavPatcher
Open a terminal window in the folder you installed to. Run the following command:
```
java -jar SavPatcher.jar <OldSav> <NewSav> <BinPatch>
```
The program takes three arguments. `<OldSav>` is the file location of the save file to be modified. `<NewSav>` is the file location to store the modified save file. Note that if `<NewSav>` does not exist, the program will create it for you. Also note that `<OldSav>` and `<NewSav>` can be the same, but please make sure you have a backup. `<BinPatch>` is the file to patch in. If you want access to all event islands, the included file `ultimate.bin` will do that.

Make sure that the BIN file is set to be redistributible. `ultimate.bin` has this setting.

### Step 3: Running RomPatcher
In the same terminal window, run the following command:
```
java -jar RomPatcher.jar <OldRom> <NewRom>
```
The program takes two arguments. `<OldRom>` is the file location of the save file to be modified. `<NewRom>` is the file location to store the modified save file. Note that if `<NewRom>` does not exist, the program will create it for you. Also note that `<OldRom>` and `<NewRom>` can be the same, but please make sure you have a backup. The patches are hardcoded, so no BIN file is needed.

### Step 4: Load the Files
Load the save file and the ROM onto a flash cartridge. The method varies across the different models, so detailed advice cannot be given here.

### Step 5: Begin Distribution
Connect a Wireless Adapter, and select `MYSTERY GIFT` in the main menu. (`SavPatcher` will automatically enable Mystery Gift for you.) Select `WONDER CARDS`. On the next screen, press A. In the menu, select `SEND`. Follow on-screen instructions.
