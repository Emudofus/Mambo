

// Generated on 01/04/2013 14:54:21
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterCreationResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 161;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte result;
    
    public CharacterCreationResultMessage() { }
    
    public CharacterCreationResultMessage(byte result) {
        this.result = result;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(result);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        result = reader.readByte();
        if (result < 0)
            throw new RuntimeException("Forbidden value on result = " + result + ", it doesn't respect the following condition : result < 0");
    }
    
}
