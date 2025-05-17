public class GameMaster {

    public String describe(Character character) {
        return "You're a level %d %s with %d hit points.".formatted(character.getLevel(),
                character.getCharacterClass(), character.getHitPoints());
    }

    public String describe(Destination destination) {
        return "You've arrived at %s, which has %d inhabitants.".formatted(destination.getName(),
                destination.getInhabitants());
    }

    public String describe(TravelMethod travelMethod) {
        if (travelMethod == TravelMethod.WALKING) {
            return "You're traveling to your destination by walking.";
        }
        return "You're traveling to your destination on horseback.";

    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return "You're a level %d %s with %d hit points. ".formatted(character.getLevel(),
                character.getCharacterClass(), character.getHitPoints()) +
                (travelMethod == TravelMethod.WALKING ? "You're traveling to your destination by walking. "
                        : "You're traveling to your destination on horseback. ") +
                "You've arrived at %s, which has %d inhabitants.".formatted(destination.getName(),
                        destination.getInhabitants());
    }

    public String describe(Character character, Destination destination) {
        return "You're a level %d %s with %d hit points. You're traveling to your destination by walking. You've arrived at %s, which has %d inhabitants."
                .formatted(character.getLevel(), character.getCharacterClass(), character.getHitPoints(),
                        destination.getName(), destination.getInhabitants());
    }
}
