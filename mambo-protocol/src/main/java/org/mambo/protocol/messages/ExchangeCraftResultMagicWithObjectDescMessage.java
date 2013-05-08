

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(magicPoolStatus);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        magicPoolStatus = buf.readByte();
    }
    
}
