package com.oocl.cultivation;

public class Park {
    private int emptyPositionCount;

    public Park () {
        this.emptyPositionCount = 10;
    }

    public int getEmptyPositionCount() {
        return emptyPositionCount;
    }

    public void setEmptyPositionCount(int emptyPositionCount) {
        this.emptyPositionCount = emptyPositionCount;
    }
}
