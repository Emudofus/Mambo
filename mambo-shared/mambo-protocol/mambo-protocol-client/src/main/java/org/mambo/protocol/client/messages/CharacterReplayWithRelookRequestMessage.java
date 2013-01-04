

// Generated on 01/04/2013 14:54:21
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterReplayWithRelookRequestMessage extends CharacterReplayRequestMessage {
    public static final int MESSAGE_ID = 6354;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int cosmeticId;
    
    public CharacterReplayWithRelookRequestMessage() { }
    
    public CharacterReplayWithRelookRequestMessage(int characterId, int cosmeticId) {
        super(characterId);
        this.cosmeticId = cosmeticId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(cosmeticId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        cosmeticId = reader.readInt();
        if (cosmeticId < 0)
            throw new RuntimeException("Forbidden value on cosmeticId = " + cosmeticId + ", it doesn't respect the following condition : cosmeticId < 0");
    }
    
}
