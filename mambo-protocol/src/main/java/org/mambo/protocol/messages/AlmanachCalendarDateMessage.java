

// Generated on 05/08/2013 19:37:40
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(date);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        date = buf.readInt();
    }
    
}
