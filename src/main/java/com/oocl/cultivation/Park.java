package com.oocl.cultivation;

public class Park {
    private int emptyPositionCount;
    private String parkName;
    private int capacity;

    public Park (String parkName, int capacity) {
        this.parkName = parkName;
        this.capacity = capacity;
        this.emptyPositionCount = capacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
