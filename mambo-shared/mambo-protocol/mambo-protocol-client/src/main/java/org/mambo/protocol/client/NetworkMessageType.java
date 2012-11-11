package org.mambo.protocol.client;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 10/11/12
 * Time: 22:53
 */
public enum NetworkMessageType {
    ;

    private int value;
    NetworkMessageType(int value) { this.value = value; }
    public int value() {return value;}

    public static NetworkMessageType valueOf(int value) {
        for (NetworkMessageType val : values()) if (val.value == value) return val;
        return null;
    }
}
