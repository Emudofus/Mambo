

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class LockableShowCodeDialogMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5740;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean changeOrUse;
    public byte codeSize;
    
    public LockableShowCodeDialogMessage() { }
    
    public LockableShowCodeDialogMessage(boolean changeOrUse, byte codeSize) {
        this.changeOrUse = changeOrUse;
        this.codeSize = codeSize;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(changeOrUse);
        buf.writeByte(codeSize);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        changeOrUse = buf.readBoolean();
        codeSize = buf.readByte();
        if (codeSize < 0)
            throw new RuntimeException("Forbidden value on codeSize = " + codeSize + ", it doesn't respect the following condition : codeSize < 0");
    }
    
}
