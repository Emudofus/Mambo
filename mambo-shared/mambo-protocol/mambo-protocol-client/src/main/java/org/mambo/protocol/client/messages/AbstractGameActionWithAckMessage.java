

// Generated on 01/04/2013 14:54:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AbstractGameActionWithAckMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 1001;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short waitAckId;
    
    public AbstractGameActionWithAckMessage() { }
    
    public AbstractGameActionWithAckMessage(short actionId, int sourceId, short waitAckId) {
        super(actionId, sourceId);
        this.waitAckId = waitAckId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(waitAckId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        waitAckId = reader.readShort();
    }
    
}
