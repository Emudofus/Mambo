

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HouseKickIndoorMerchantRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5661;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cellId;
    
    public HouseKickIndoorMerchantRequestMessage() { }
    
    public HouseKickIndoorMerchantRequestMessage(short cellId) {
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(cellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        cellId = buf.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
    }
    
}
