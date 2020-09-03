# gen-iii-event-patcher for developers
This README is meant for those who wish to develop an event.

## Dependencies and Requirements
* A hex editor.

## Usage
I'm going to be altering this heavily at some point in the future, so I dn't feel like investing massive amounts of time into this file right now.

The basics are this:
* Wonder News starts at 0x000
* Wonder Card starts at 0x1C0
* Event script starts at 0x4FC

The format for each can be found in the first post at https://projectpokemon.org/home/forums/topic/35903-gen-3-mystery-eventgift-research/. Leave the checksum blank; the patcher will calculate it for you. Remember the event script must start with 0x33 0xFF 0xFF 0xFF (at 0x500) if you want to distribute it. Remember that in most cases a Wonder Card must accompany an event script.
\[\[TODO\]\]
