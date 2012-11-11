

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class AccountLoggingKickedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6029;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int days;
    public int hours;
    public int minutes;
    
    public AccountLoggingKickedMessage() { }
    
    public AccountLoggingKickedMessage(int days, int hours, int minutes) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(days);
        writer.writeInt(hours);
        writer.writeInt(minutes);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        days = reader.readInt();
        if (days < 0)
            throw new RuntimeException("Forbidden value on days = " + days + ", it doesn't respect the following condition : days < 0");
        hours = reader.readInt();
        if (hours < 0)
            throw new RuntimeException("Forbidden value on hours = " + hours + ", it doesn't respect the following condition : hours < 0");
        minutes = reader.readInt();
        if (minutes < 0)
            throw new RuntimeException("Forbidden value on minutes = " + minutes + ", it doesn't respect the following condition : minutes < 0");
    }
    
}
