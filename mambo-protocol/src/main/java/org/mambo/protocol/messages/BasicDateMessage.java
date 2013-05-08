

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class BasicDateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 177;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte day;
    public byte month;
    public short year;
    
    public BasicDateMessage() { }
    
    public BasicDateMessage(byte day, byte month, short year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(day);
        buf.writeByte(month);
        buf.writeShort(year);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        day = buf.readByte();
        if (day < 0)
            throw new RuntimeException("Forbidden value on day = " + day + ", it doesn't respect the following condition : day < 0");
        month = buf.readByte();
        if (month < 0)
            throw new RuntimeException("Forbidden value on month = " + month + ", it doesn't respect the following condition : month < 0");
        year = buf.readShort();
        if (year < 0)
            throw new RuntimeException("Forbidden value on year = " + year + ", it doesn't respect the following condition : year < 0");
    }
    
}
