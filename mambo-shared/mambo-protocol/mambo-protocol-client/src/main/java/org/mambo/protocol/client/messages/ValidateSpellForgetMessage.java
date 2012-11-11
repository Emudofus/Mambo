

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ValidateSpellForgetMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1700;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short spellId;
    
    public ValidateSpellForgetMessage() { }
    
    public ValidateSpellForgetMessage(short spellId) {
        this.spellId = spellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(spellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        spellId = reader.readShort();
        if (spellId < 0)
            throw new RuntimeException("Forbidden value on spellId = " + spellId + ", it doesn't respect the following condition : spellId < 0");
    }
    
}
