# gen-iii-event-patcher for end users
This README is meant for those just looking to patch an event into a save file.

## Dependencies and Requirements
* Java version 8, obtainable [here](https://adoptopenjdk.net/).
* Ability to use a terminal. The terminal is your friend.
* A compatible ROM, which currently includes:
  * Any non-Japanese FireRed
  * Any non-Japanese LeafGreen
  * Any non-Japanese Emerald
* If using actual hardware, a method to backup and restore save data from hardware.
  * If you cannot backup and/or restore save data, create a distribution ROM instead.

## Usage
### Step 1: Creating a Save File
Most users will already have a save file. However, it is **vital** that the save file have been saved at least twice. Certain structures within the save file are not initialized until the game has been saved twice. Uniinitialized structures could interfere with the program. Therefore, it is important to boot the game, and save twice.

Once the game has been saved twice, create a backup of your save file. If you are on actual hardware, now is the time to rip your save file.

### Step 2: Running the program
Open a terminal window in the folder you installed to. Run the following command:
```
java -jar SavPatcher.jar <OldSav> <NewSav> <BinPatch>
```
The program takes three arguments. `<OldSav>` is the file location of the save file to be modified. `<NewSav>` is the file location to store the modified save file. Note that if `<NewSav>` does not exist, the program will create it for you. Also note that `<OldSav>` and `<NewSav>` can be the same, but please make sure you have a backup. `<BinPatch>` is the file to patch in. If you want access to all event islands, the included file `ultimate.bin` will do that.

### Step 3: Restoring the Save File
Replace the save file that you use (be it on hardware or in an emulation folder somewhere) with the modified file that was created. Visit the second floor of the Pokémon Center, and speak to the person on the far left. This will activate the script.
