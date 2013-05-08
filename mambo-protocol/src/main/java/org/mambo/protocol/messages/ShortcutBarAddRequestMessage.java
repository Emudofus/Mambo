

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ShortcutBarAddRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6225;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte barType;
    public Shortcut shortcut;
    
    public ShortcutBarAddRequestMessage() { }
    
    public ShortcutBarAddRequestMessage(byte barType, Shortcut shortcut) {
        this.barType = barType;
        this.shortcut = shortcut;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(barType);
        buf.writeShort(shortcut.getTypeId());
        shortcut.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        barType = buf.readByte();
        if (barType < 0)
            throw new RuntimeException("Forbidden value on barType = " + barType + ", it doesn't respect the following condition : barType < 0");
        shortcut = ProtocolTypeManager.getInstance().build(buf.readShort());
        shortcut.deserialize(buf);
    }
    
}
