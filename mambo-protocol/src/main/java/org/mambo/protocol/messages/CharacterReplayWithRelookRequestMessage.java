

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(cosmeticId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        cosmeticId = buf.readInt();
        if (cosmeticId < 0)
            throw new RuntimeException("Forbidden value on cosmeticId = " + cosmeticId + ", it doesn't respect the following condition : cosmeticId < 0");
    }
    
}
