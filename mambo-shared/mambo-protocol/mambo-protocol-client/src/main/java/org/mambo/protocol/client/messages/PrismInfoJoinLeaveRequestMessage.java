

// Generated on 01/04/2013 14:54:40
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
