class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {

    public String toString() {
        return "Fighter is a Warrior";
    }

    public boolean isVulnerable() {
        return false;
    }

    int getDamagePoints(Fighter target) {
        return target.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter {

    boolean isSpellPrepared = false;

    public String toString() {
        return "Fighter is a Wizard";
    }

    boolean isVulnerable() {
        return !isSpellPrepared;
    }

    int getDamagePoints(Fighter target) {
        return isSpellPrepared ? 12 : 3;
    }

    void prepareSpell() {
        isSpellPrepared = true;
    }
}
