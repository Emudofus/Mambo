

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ShortcutBarRemoveRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6228;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte barType;
    public int slot;
    
    public ShortcutBarRemoveRequestMessage() { }
    
    public ShortcutBarRemoveRequestMessage(byte barType, int slot) {
        this.barType = barType;
        this.slot = slot;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(barType);
        writer.writeInt(slot);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        barType = reader.readByte();
        if (barType < 0)
            throw new RuntimeException("Forbidden value on barType = " + barType + ", it doesn't respect the following condition : barType < 0");
        slot = reader.readInt();
        if (slot < 0 || slot > 99)
            throw new RuntimeException("Forbidden value on slot = " + slot + ", it doesn't respect the following condition : slot < 0 || slot > 99");
    }
    
}
