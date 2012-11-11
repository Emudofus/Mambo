

// Generated on 11/11/2012 19:17:03
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class HouseToSellListRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6139;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short pageIndex;
    
    public HouseToSellListRequestMessage() { }
    
    public HouseToSellListRequestMessage(short pageIndex) {
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
