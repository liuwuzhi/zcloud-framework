package org.zcloud.framework.logging.event;

/**
 * .
 *
 * @author liuwz
 */
public enum BusinessType {
    OPERATION(10, "operation"),

    DEBUGGING(20, "debugging"),

    EXCEPTION(30, "exception"),

    BUSINESS(40, "business");

    private final int value;
    private final String notes;

    BusinessType(int value, String notes) {
        this.value = value;
        this.notes = notes;
    }

    public int getValue() {
        return value;
    }

    public String getNotes() {
        return notes;
    }
}
