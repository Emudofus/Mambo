

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeByte(barType);
        buf.writeInt(firstSlot);
        buf.writeInt(secondSlot);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        barType = buf.readByte();
        if (barType < 0)
            throw new RuntimeException("Forbidden value on barType = " + barType + ", it doesn't respect the following condition : barType < 0");
        firstSlot = buf.readInt();
        if (firstSlot < 0 || firstSlot > 99)
            throw new RuntimeException("Forbidden value on firstSlot = " + firstSlot + ", it doesn't respect the following condition : firstSlot < 0 || firstSlot > 99");
        secondSlot = buf.readInt();
        if (secondSlot < 0 || secondSlot > 99)
            throw new RuntimeException("Forbidden value on secondSlot = " + secondSlot + ", it doesn't respect the following condition : secondSlot < 0 || secondSlot > 99");
    }
    
}
