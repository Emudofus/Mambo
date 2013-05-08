

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ShortcutBarRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6224;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte barType;
    public int slot;
    
    public ShortcutBarRemovedMessage() { }
    
    public ShortcutBarRemovedMessage(byte barType, int slot) {
        this.barType = barType;
        this.slot = slot;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(barType);
        buf.writeInt(slot);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        barType = buf.readByte();
        if (barType < 0)
            throw new RuntimeException("Forbidden value on barType = " + barType + ", it doesn't respect the following condition : barType < 0");
        slot = buf.readInt();
        if (slot < 0 || slot > 99)
            throw new RuntimeException("Forbidden value on slot = " + slot + ", it doesn't respect the following condition : slot < 0 || slot > 99");
    }
    
}
