

// Generated on 12/14/2012 18:44:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GuildModificationStartedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6324;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean canChangeName;
    public boolean canChangeEmblem;
    
    public GuildModificationStartedMessage() { }
    
    public GuildModificationStartedMessage(boolean canChangeName, boolean canChangeEmblem) {
        this.canChangeName = canChangeName;
        this.canChangeEmblem = canChangeEmblem;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, canChangeName);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, canChangeEmblem);
        writer.writeUnsignedByte(flag1);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        canChangeName = BooleanByteWrapper.getFlag(flag1, 0);
        canChangeEmblem = BooleanByteWrapper.getFlag(flag1, 1);
    }
    
}
