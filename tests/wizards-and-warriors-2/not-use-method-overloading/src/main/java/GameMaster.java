public class GameMaster {

    public String describe(Character character) {
        return "You're a level " + character.getLevel() + " " + character.getCharacterClass() + " with " + character.getHitPoints() + " hit points.";
    }

    public String describe(Destination destination) {
        return "You've arrived at " + destination.getName() + ", which has " + destination.getInhabitants() + " inhabitants.";
    }

    public String describe(TravelMethod travelMethod) {
        if (travelMethod == TravelMethod.WALKING) {
            return "You're traveling to your destination by walking.";
        }
        return "You're traveling to your destination on horseback.";
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return "You're a level " + character.getLevel() + " " + character.getCharacterClass() + " with " + character.getHitPoints() + " hit points. " +
                (travelMethod == TravelMethod.WALKING ? "You're traveling to your destination by walking. " : "You're traveling to your destination on horseback. ") +
                "You've arrived at " + destination.getName() + ", which has " + destination.getInhabitants() + " inhabitants.";
    }

    public String describe(Character character, Destination destination) {
        return "You're a level " + character.getLevel() + " " + character.getCharacterClass() + " with " + character.getHitPoints() + " hit points. " +
                "You're traveling to your destination by walking. " +
                "You've arrived at " + destination.getName() + ", which has " + destination.getInhabitants() + " inhabitants.";
    }
}