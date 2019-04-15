package com.Ayrou.AppleGuild.GUI.Item.enums;

public enum ButtonType {
    BLANK(1),
    ARROW_UP(2),
    ARROW_DOWN(3),
    ARROW_LEFT(4),
    ARROW_RIGHT(5),
    LARROW_UP(6),
    LARROW_DOWN(7),
    LARROW_LEFT(8),
    LARROW_RIGHT(9),
    SORT_NUMBER(10),
    SORT_NAME(11),
    Affirmative(12),
    Negative(13);

    private int Value;

    ButtonType(int i) {
        this.Value = i;
    }

    public int getValue() {
        return this.Value;
    }
}