

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class BasicSetAwayModeRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5665;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean enable;
    public boolean invisible;
    
    public BasicSetAwayModeRequestMessage() { }
    
    public BasicSetAwayModeRequestMessage(boolean enable, boolean invisible) {
        this.enable = enable;
        this.invisible = invisible;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, enable);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, invisible);
        writer.writeUnsignedByte(flag1);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        enable = BooleanByteWrapper.getFlag(flag1, 0);
        invisible = BooleanByteWrapper.getFlag(flag1, 1);
    }
    
}
