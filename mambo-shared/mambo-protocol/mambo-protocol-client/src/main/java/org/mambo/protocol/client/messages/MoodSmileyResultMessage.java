

// Generated on 01/04/2013 14:54:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MoodSmileyResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6196;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte resultCode;
    public byte smileyId;
    
    public MoodSmileyResultMessage() { }
    
    public MoodSmileyResultMessage(byte resultCode, byte smileyId) {
        this.resultCode = resultCode;
        this.smileyId = smileyId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(resultCode);
        writer.writeByte(smileyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        resultCode = reader.readByte();
        if (resultCode < 0)
            throw new RuntimeException("Forbidden value on resultCode = " + resultCode + ", it doesn't respect the following condition : resultCode < 0");
        smileyId = reader.readByte();
    }
    
}
