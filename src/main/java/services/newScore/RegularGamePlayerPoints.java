package services.newScore;

import lombok.Getter;

@Getter
public enum RegularGamePlayerPoints {
    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("AD");

    public RegularGamePlayerPoints next() {
        if (this == ADVANTAGE) {
            throw new IllegalStateException("Can't call next() on ADVANTAGE");
        } else {
            return RegularGamePlayerPoints.values()[this.ordinal() + 1];
        }
    }

    private final String name;

    private RegularGamePlayerPoints(String name) {
        this.name = name;
    }

}
