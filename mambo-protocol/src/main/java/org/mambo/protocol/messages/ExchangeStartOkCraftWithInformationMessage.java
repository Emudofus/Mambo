

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(nbCase);
        buf.writeInt(skillId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        nbCase = buf.readByte();
        if (nbCase < 0)
            throw new RuntimeException("Forbidden value on nbCase = " + nbCase + ", it doesn't respect the following condition : nbCase < 0");
        skillId = buf.readInt();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
