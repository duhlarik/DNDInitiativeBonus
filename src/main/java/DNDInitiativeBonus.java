import java.util.*;

public class DNDInitiativeBonus {

    public static void main(String[] args) throws YesOrNoException {

        startANewGame();
    }

    private static void startANewGame() {

        Scanner scan1 = new Scanner(System.in);
        String choice;
        Battle battle = new Battle();
        CharacterMap characterMap = new CharacterMap();

        System.out.println("Enter the name of the battle: ");

        battle.setBattle(scan1.nextLine());

        System.out.println("Would you like to enter a player? (Type y or n)");

        choice = scan1.nextLine();

        while (choice.equalsIgnoreCase("y")) {

            addAPlayer(characterMap);

            System.out.println("Enter another player? (Type y or n)");
            choice = scan1.nextLine();
        }

        setUpAndPrintTheBattleMap(battle, characterMap);
        next(battle, characterMap);
    }

    private static void addAPlayer(CharacterMap characterMap) {

        Scanner scan1 = new Scanner(System.in);
        DNDCharacter character = new DNDCharacter("", 0);
        int initBonus;

        System.out.println("Type a player's name and press enter.");
        character.setName(scan1.nextLine());

        System.out.println("Type the player's starting initiative bonus as a whole number and press enter.");
        try {
            initBonus = Integer.parseInt(scan1.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Please enter a whole number and press enter.");
            initBonus = Integer.parseInt(scan1.nextLine());
        }

        character.setInitBonus(initBonus);
        characterMap.updateCharacterMap(character);
    }

    private static Map<String, Integer> setUpAndPrintTheBattleMap(Battle battle, CharacterMap characterMap) {

        Map<String, Integer> sortedCharacterMap;
        Map<String, Map<String, Integer>> battleMap;

        sortedCharacterMap = characterMap.sortCharacterMapByValue(characterMap);
        battleMap = battle.assignCharactersToABattle(battle, sortedCharacterMap);
        battle.printBattleCharacterList(battleMap);

        return sortedCharacterMap;
    }

    private static void next(Battle battle, CharacterMap characterMap) {

        Scanner scan1 = new Scanner(System.in);

        System.out.println("\nWhat would you like to do? You can type:" +
                "\n'add' to add another player" +
                "\n'remove' to remove a player" +
                "\nor" +
                "\n'roll' to roll the die\n");

        String response = scan1.nextLine();

        switch (response) {
            case "add":
                addAPlayer(characterMap);
                setUpAndPrintTheBattleMap(battle, characterMap);
                next(battle, characterMap);
                break;
            case "remove":
                System.out.println("Who would you like to remove?");
                String name = scan1.nextLine();
                if (characterMap.getCharacterMap().containsKey(name)) {
                    characterMap.removeACharacterByName(name);
                }
                setUpAndPrintTheBattleMap(battle, characterMap);
                next(battle, characterMap);
                break;
            case "roll":
                roll(battle, characterMap);
                break;
            default:
                System.out.println("Invalid entry.");
                next(battle, characterMap);
                break;
        }
    }

    private static void roll(Battle battle, CharacterMap characterMap) {

        Scanner scan1 = new Scanner(System.in);
        Random random = new Random();
        RollTheDie roll = new RollTheDie(random);
        Map<String, Integer> sortedCharacterMap;

        System.out.println("\nWhat would you like to do? You can type:" +
                "\n'all' to roll for all players" +
                "\nor" +
                "\n'one' to roll for one player by name\n");

        String response = scan1.nextLine();

        switch (response) {
            case "all":
                roll.rollForAllCharacters(characterMap);
                setUpAndPrintTheBattleMap(battle, characterMap);
                break;
            case "one":
                System.out.println("Enter the name of the player:");
                String name = scan1.nextLine();
                int characterValue = 0;
                for (Map.Entry<String, Integer> character : characterMap.getCharacterMap().entrySet()) {
                    if (name.equals(character.getKey())) {
                        characterValue = character.getValue();
                    }
                }
                DNDCharacter character = new DNDCharacter(name, characterValue);
                roll.rollForOneCharacter(characterMap, character);
                break;
            default:
                System.out.println("Invalid entry.");
                roll(battle, characterMap);
                break;
        }

        sortedCharacterMap = setUpAndPrintTheBattleMap(battle, characterMap);
        startTheGame(sortedCharacterMap);
    }

    private static void startTheGame(Map<String, Integer> sortedCharacterMap) {

        Scanner scan1 = new Scanner(System.in);
        List<String> sortedCharacters = new ArrayList<>();
        String response = "";
        String end;

        sortedCharacterMap.forEach((String, Integer) -> sortedCharacters.add(String + " -- " + Integer.toString()));

        while (!response.equalsIgnoreCase("end")) {

            int i = 0;

            System.out.println("\nWhat would you like to do? You can type:" +
                    "\n'next' to see the next player" +
                    "\n'done' to end this player's turn" +
                    "\n'skip' to skip this player" +
                    "\nor" +
                    "\n'end' to end this battle\n");

            response = scan1.nextLine();

            if (response.equalsIgnoreCase("next")) {

                System.out.println("\nThe next player is " + sortedCharacters.get(i));

            } else {

                switch (response) {
                    case "done":
                        if (i < sortedCharacters.size()) {
                            i++;
                        } else i = 0;
                        System.out.println("The next player is " + sortedCharacters.get(i));
                        break;
                    case "skip":
                        if (i < sortedCharacters.size()) {
                            i++;
                        } else i = 0;
                        System.out.println("The next player is " + sortedCharacters.get(i));
                        break;
                    case "end":
                        System.out.println("The battle is over. Would you like to start a new battle? (Type y or n)");
                        end = scan1.nextLine();
                        sortedCharacterMap.clear();
                        if (end.equalsIgnoreCase("y")) {
                            startANewGame();
                        }
                        break;
                    default:
                        System.out.println("Invalid entry.");
                        startTheGame(sortedCharacterMap);
                        break;
                }
            }
        }
    }
}
