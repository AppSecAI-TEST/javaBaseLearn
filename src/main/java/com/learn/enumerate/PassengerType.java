package com.learn.enumerate;

/**
 * Created by xia_yu on 2017/4/21.
 */
public enum PassengerType {
    Adult(0),
    Child(1),
    InfantInLap(2),
    InfantInSeat(3),
    Senior(4);

    private final int value;

    PassengerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PassengerType findByValue(int value) {
        switch (value) {
            case 0:
                return Adult;
            case 1:
                return Child;
            case 2:
                return InfantInLap;
            case 3:
                return InfantInSeat;
            case 4:
                return Senior;
            default:
                return null;
        }
    }
}
