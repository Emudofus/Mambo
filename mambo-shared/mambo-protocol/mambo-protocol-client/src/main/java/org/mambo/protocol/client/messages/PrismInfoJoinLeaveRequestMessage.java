

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PrismInfoJoinLeaveRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5844;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean join;
    
    public PrismInfoJoinLeaveRequestMessage() { }
    
    public PrismInfoJoinLeaveRequestMessage(boolean join) {
        this.join = join;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(join);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        join = reader.readBoolean();
    }
    
}
