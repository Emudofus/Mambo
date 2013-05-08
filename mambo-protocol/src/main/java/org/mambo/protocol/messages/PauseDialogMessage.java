

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PauseDialogMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6012;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte dialogType;
    
    public PauseDialogMessage() { }
    
    public PauseDialogMessage(byte dialogType) {
        this.dialogType = dialogType;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(dialogType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        dialogType = buf.readByte();
        if (dialogType < 0)
            throw new RuntimeException("Forbidden value on dialogType = " + dialogType + ", it doesn't respect the following condition : dialogType < 0");
    }
    
}
