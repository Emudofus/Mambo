

// Generated on 11/11/2012 19:17:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ShortcutBarSwapRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6230;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte barType;
    public int firstSlot;
    public int secondSlot;
    
    public ShortcutBarSwapRequestMessage() { }
    
    public ShortcutBarSwapRequestMessage(byte barType, int firstSlot, int secondSlot) {
        this.barType = barType;
        this.firstSlot = firstSlot;
        this.secondSlot = secondSlot;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(barType);
        writer.writeInt(firstSlot);
        writer.writeInt(secondSlot);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        barType = reader.readByte();
        if (barType < 0)
            throw new RuntimeException("Forbidden value on barType = " + barType + ", it doesn't respect the following condition : barType < 0");
        firstSlot = reader.readInt();
        if (firstSlot < 0 || firstSlot > 99)
            throw new RuntimeException("Forbidden value on firstSlot = " + firstSlot + ", it doesn't respect the following condition : firstSlot < 0 || firstSlot > 99");
        secondSlot = reader.readInt();
        if (secondSlot < 0 || secondSlot > 99)
            throw new RuntimeException("Forbidden value on secondSlot = " + secondSlot + ", it doesn't respect the following condition : secondSlot < 0 || secondSlot > 99");
    }
    
}
