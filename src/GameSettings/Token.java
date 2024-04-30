package GameSettings;

public enum Token {
    X("\uD83D\uDD33"),
    O("\uD83D\uDD18"),
    EMPTY("⬜");

    private final String visual;

    Token(String visual) {
        this.visual = visual;
    }

    public String getVisual() {
        return visual;
    }
}