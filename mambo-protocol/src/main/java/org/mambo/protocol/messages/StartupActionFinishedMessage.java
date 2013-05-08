

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, success);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, automaticAction);
        buf.writeUByte(flag1);
        buf.writeInt(actionId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        success = BooleanByteWrapper.getFlag(flag1, 0);
        automaticAction = BooleanByteWrapper.getFlag(flag1, 1);
        actionId = buf.readInt();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
    }
    
}
