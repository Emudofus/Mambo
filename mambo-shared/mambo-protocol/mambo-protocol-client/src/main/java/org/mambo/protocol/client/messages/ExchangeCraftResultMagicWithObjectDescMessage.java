

// Generated on 11/11/2012 19:17:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeCraftResultMagicWithObjectDescMessage extends ExchangeCraftResultWithObjectDescMessage {
    public static final int MESSAGE_ID = 6188;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte magicPoolStatus;
    
    public ExchangeCraftResultMagicWithObjectDescMessage() { }
    
    public ExchangeCraftResultMagicWithObjectDescMessage(byte craftResult, ObjectItemNotInContainer objectInfo, byte magicPoolStatus) {
        super(craftResult, objectInfo);
        this.magicPoolStatus = magicPoolStatus;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(magicPoolStatus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        magicPoolStatus = reader.readByte();
    }
    
}
