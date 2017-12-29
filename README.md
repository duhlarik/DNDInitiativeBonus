## DND Initiative Tracker
# Value Story: 
As a Dungeon Master I want to track the initiative of every character in a battle so that I can let my players know whose turn it is and perform the appropriate monsters' actions.

# Context: 
Initiative in Dungeons and Dragons is how the DM figures out who goes in what order for a battle, which is turn-based.
Every character/enemy has an initiative bonus (this could be negative). Then for each character/enemy a 20-sided die is rolled and the bonus is added to figure out that character's Initiative. Finally, every entity in the battle is sorted by their Initiatives, highest first.

# Constraints:
I don't care much about the UI, it could be console app or web app as you see fit. Don't worry about saving state beyond memory.
Bonus points if you build this in "thin slice" way that cuts across all scenarios (e.g. I will build an initiative tracker for 1 character, then for many).

# Scenarios:
I want to add and possibly remove characters to a battle by name.
I want to assign and/or roll initiative for the characters in the battle. Feel free to either roll for the DM or let them specify the initiative value or both.
I want to see the characters in a battle in Initiative order descending.

# Bonus:
I want to know whose turn it is.
I want to be able to change whose turn it is in Initiative order.
I want to be able to end the battle and start the next one.

# Super-bonus:
I want to save the current battle and be able to play it later if the session ends before we can finish.
