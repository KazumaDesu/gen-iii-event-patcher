# gen-iii-event-patcher
This repository facilitates the transformation of a Generation III Pokémon game ROM to a distribution ROM.
## Background
The Generation III Pokémon games introduced the Mystery Gift feature. Mystery Gift can allow players to receive special Pokémon, or allow them to access otherwise inaccessable locations. The Generation III implementation is unusual in that rather than merely activating a flag or two, it downloads a script into the save data, to be executed at a later time. This 1 kilobyte script can contain any valid script instruction, including ones that enable arbitrary code execution.

While ACE can be achieved through this program, it is not the primary purpose. Rather, this program is designed to (1) patch a script into a Pokémon FireRed, LeafGreen, or Emerald save file for personal use, and (2) patch the ROM and SAV at the same time to create a distribution ROM.
## Requirements and Dependencies
  * A supported ROM, which currently include the following: (Note: the hashes - NOT the ROMs themselves - are linked below. Rip the ROMs yourselves, do NOT pirate.)
    * [English Emerald](https://datomatic.no-intro.org/?page=show_record&s=23&n=1668)
    * [English LeafGreen v1.1](https://datomatic.no-intro.org/?page=show_record&s=23&n=1961)
  * Java version 8 or greater. [Here](https://adoptopenjdk.net/) is a link to a download page.
  * The ability to use a terminal. The terminal is your friend.
  * If you wish to use the ROM as a distribution ROM, a flash cart of some kind. If you are only using the patcher for yourself, a flash cart is unnecessary.
## Installation
1. Download the latest release [here](https://example.com).
2. Unzip the zip file.
3. Profit!
## Usage
\[\[TODO\]\]
## Troubleshooting
  * Help! The program says `Please use a supported ROM`!
    * The ROM you provided is not supported. Here is a list of things you should check:
      * Is the ROM listed as supported? FireRed, LeafGreen v1.0, and international versions are not currently supported.
      * Ruby and Sapphire use Mystery Events, not Mystery Gift. This difference prevents either of them from using the same scripts as FireRed, LeafGreen, or Emerald; or from using them as a distribution server.
      * Are the hashes correct? Check the links above for the correct hashes.
  * How do I make my own BIN file?
    * \[\[TODO\]\]
