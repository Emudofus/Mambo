

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
