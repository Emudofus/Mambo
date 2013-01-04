

// Generated on 01/04/2013 14:54:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PaddockToSellListRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6141;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short pageIndex;
    
    public PaddockToSellListRequestMessage() { }
    
    public PaddockToSellListRequestMessage(short pageIndex) {
        this.pageIndex = pageIndex;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(pageIndex);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        pageIndex = reader.readShort();
        if (pageIndex < 0)
            throw new RuntimeException("Forbidden value on pageIndex = " + pageIndex + ", it doesn't respect the following condition : pageIndex < 0");
    }
    
}
