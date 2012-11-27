

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(barType);
        writer.writeUnsignedShort(shortcuts.length);
        for (Shortcut entry : shortcuts) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        barType = reader.readByte();
        if (barType < 0)
            throw new RuntimeException("Forbidden value on barType = " + barType + ", it doesn't respect the following condition : barType < 0");
        int limit = reader.readUnsignedShort();
        shortcuts = new Shortcut[limit];
        for (int i = 0; i < limit; i++) {
            shortcuts[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), Shortcut.class);
            shortcuts[i].deserialize(reader);
        }
    }
    
}
