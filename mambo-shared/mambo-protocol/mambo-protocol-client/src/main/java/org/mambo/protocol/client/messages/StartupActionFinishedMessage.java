

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class StartupActionFinishedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1304;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean success;
    public boolean automaticAction;
    public int actionId;
    
    public StartupActionFinishedMessage() { }
    
    public StartupActionFinishedMessage(boolean success, boolean automaticAction, int actionId) {
        this.success = success;
        this.automaticAction = automaticAction;
        this.actionId = actionId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, success);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, automaticAction);
        writer.writeUnsignedByte(flag1);
        writer.writeInt(actionId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        success = BooleanByteWrapper.getFlag(flag1, 0);
        automaticAction = BooleanByteWrapper.getFlag(flag1, 1);
        actionId = reader.readInt();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
    }
    
}
