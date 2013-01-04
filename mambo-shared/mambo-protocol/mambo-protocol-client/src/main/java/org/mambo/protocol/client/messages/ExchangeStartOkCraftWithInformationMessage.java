

// Generated on 01/04/2013 14:54:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeStartOkCraftWithInformationMessage extends ExchangeStartOkCraftMessage {
    public static final int MESSAGE_ID = 5941;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte nbCase;
    public int skillId;
    
    public ExchangeStartOkCraftWithInformationMessage() { }
    
    public ExchangeStartOkCraftWithInformationMessage(byte nbCase, int skillId) {
        this.nbCase = nbCase;
        this.skillId = skillId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(nbCase);
        writer.writeInt(skillId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        nbCase = reader.readByte();
        if (nbCase < 0)
            throw new RuntimeException("Forbidden value on nbCase = " + nbCase + ", it doesn't respect the following condition : nbCase < 0");
        skillId = reader.readInt();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
