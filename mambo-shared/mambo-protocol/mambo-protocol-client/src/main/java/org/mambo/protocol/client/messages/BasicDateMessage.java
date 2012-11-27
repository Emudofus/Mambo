

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(day);
        writer.writeByte(month);
        writer.writeShort(year);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        day = reader.readByte();
        if (day < 0)
            throw new RuntimeException("Forbidden value on day = " + day + ", it doesn't respect the following condition : day < 0");
        month = reader.readByte();
        if (month < 0)
            throw new RuntimeException("Forbidden value on month = " + month + ", it doesn't respect the following condition : month < 0");
        year = reader.readShort();
        if (year < 0)
            throw new RuntimeException("Forbidden value on year = " + year + ", it doesn't respect the following condition : year < 0");
    }
    
}
