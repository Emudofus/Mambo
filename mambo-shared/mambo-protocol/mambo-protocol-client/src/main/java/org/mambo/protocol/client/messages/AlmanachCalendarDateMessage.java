

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AlmanachCalendarDateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6341;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int date;
    
    public AlmanachCalendarDateMessage() { }
    
    public AlmanachCalendarDateMessage(int date) {
        this.date = date;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(date);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        date = reader.readInt();
    }
    
}
