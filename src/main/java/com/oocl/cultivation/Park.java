package com.oocl.cultivation;

public class Park {
    private int emptyPositionCount;
    private String parkName;

    public Park (String parkName) {
        this.emptyPositionCount = 10;
        this.parkName = parkName;
    }

    public int getEmptyPositionCount() {
        return emptyPositionCount;
    }

    public void setEmptyPositionCount(int emptyPositionCount) {
        this.emptyPositionCount = emptyPositionCount;
    }

    public String getParkName() {
        return parkName;
    }
}
