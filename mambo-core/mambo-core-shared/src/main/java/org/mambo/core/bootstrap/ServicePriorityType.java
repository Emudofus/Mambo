package org.mambo.core.bootstrap;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 17/11/12
 * Time: 18:29
 */
public enum ServicePriorityType {
    HIGHEST(4),
    HIGH(3),
    NORMAL(2),
    LOW(1),
    LOWEST(0);

    private int value;
    ServicePriorityType(int value) { this.value = value; }
    public int value() { return value; }
}
