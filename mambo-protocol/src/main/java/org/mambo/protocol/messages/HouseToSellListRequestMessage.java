

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(pageIndex);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        pageIndex = buf.readShort();
        if (pageIndex < 0)
            throw new RuntimeException("Forbidden value on pageIndex = " + pageIndex + ", it doesn't respect the following condition : pageIndex < 0");
    }
    
}
