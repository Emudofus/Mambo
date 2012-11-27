

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(barType);
        writer.writeShort(shortcut.getTypeId());
        shortcut.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        barType = reader.readByte();
        if (barType < 0)
            throw new RuntimeException("Forbidden value on barType = " + barType + ", it doesn't respect the following condition : barType < 0");
        shortcut = ProtocolTypeManager.getInstance().build(reader.readShort(), Shortcut.class);
        shortcut.deserialize(reader);
    }
    
}
