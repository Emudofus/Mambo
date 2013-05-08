

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ShortcutBarContentMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6231;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte barType;
    public Shortcut[] shortcuts;
    
    public ShortcutBarContentMessage() { }
    
    public ShortcutBarContentMessage(byte barType, Shortcut[] shortcuts) {
        this.barType = barType;
        this.shortcuts = shortcuts;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(barType);
        buf.writeUShort(shortcuts.length);
        for (Shortcut entry : shortcuts) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        barType = buf.readByte();
        if (barType < 0)
            throw new RuntimeException("Forbidden value on barType = " + barType + ", it doesn't respect the following condition : barType < 0");
        int limit = buf.readUShort();
        shortcuts = new Shortcut[limit];
        for (int i = 0; i < limit; i++) {
            shortcuts[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            shortcuts[i].deserialize(buf);
        }
    }
    
}
