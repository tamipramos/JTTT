package GameSettings;

public enum Token {
    X("⬜"),
    O("\uD83D\uDD18"),
    EMPTY("\uD83D\uDD33");

    private final String visual;

    Token(String visual) {
        this.visual = visual;
    }

    public String getVisual() {
        return visual;
    }
}