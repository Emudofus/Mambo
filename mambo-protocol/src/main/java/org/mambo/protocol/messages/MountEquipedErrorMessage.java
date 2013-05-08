

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountEquipedErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5963;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte errorType;
    
    public MountEquipedErrorMessage() { }
    
    public MountEquipedErrorMessage(byte errorType) {
        this.errorType = errorType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(errorType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        errorType = buf.readByte();
        if (errorType < 0)
            throw new RuntimeException("Forbidden value on errorType = " + errorType + ", it doesn't respect the following condition : errorType < 0");
    }
    
}
