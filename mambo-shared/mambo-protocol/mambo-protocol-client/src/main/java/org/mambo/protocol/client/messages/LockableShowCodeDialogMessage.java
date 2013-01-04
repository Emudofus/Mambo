

// Generated on 01/04/2013 14:54:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(changeOrUse);
        writer.writeByte(codeSize);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        changeOrUse = reader.readBoolean();
        codeSize = reader.readByte();
        if (codeSize < 0)
            throw new RuntimeException("Forbidden value on codeSize = " + codeSize + ", it doesn't respect the following condition : codeSize < 0");
    }
    
}
