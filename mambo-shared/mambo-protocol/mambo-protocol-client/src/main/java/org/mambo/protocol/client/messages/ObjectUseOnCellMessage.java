

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectUseOnCellMessage extends ObjectUseMessage {
    public static final int MESSAGE_ID = 3013;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cells;
    
    public ObjectUseOnCellMessage() { }
    
    public ObjectUseOnCellMessage(int objectUID, short cells) {
        super(objectUID);
        this.cells = cells;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(cells);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        cells = reader.readShort();
        if (cells < 0 || cells > 559)
            throw new RuntimeException("Forbidden value on cells = " + cells + ", it doesn't respect the following condition : cells < 0 || cells > 559");
    }
    
}
