class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

// TODO: define the Warrior class
class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    public boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter target) {
        return target.isVulnerable() ? 10 : 6;
    }
}

// TODO: define the Wizard class
class Wizard extends Fighter {

    boolean isSpellPrepared = false;

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    @Override
    boolean isVulnerable() {
        return !isSpellPrepared;
    }

    @Override
    int getDamagePoints(Fighter target) {
        return isSpellPrepared ? 12 : 3;
    }

    void prepareSpell() {
        isSpellPrepared = true;
    }
}
