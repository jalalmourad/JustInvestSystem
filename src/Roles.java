public enum Roles {
    CLIENT(1),
    PREMIUM_CLIENT(2),
    FINANCIAL_ADVISOR(3),
    FINANCIAL_PLANNER(4),
    TELLER(5);

    private int value;

    Roles(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
