

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class LeaveDialogMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5502;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte dialogType;
    
    public LeaveDialogMessage() { }
    
    public LeaveDialogMessage(byte dialogType) {
        this.dialogType = dialogType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(dialogType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dialogType = reader.readByte();
        if (dialogType < 0)
            throw new RuntimeException("Forbidden value on dialogType = " + dialogType + ", it doesn't respect the following condition : dialogType < 0");
    }
    
}
