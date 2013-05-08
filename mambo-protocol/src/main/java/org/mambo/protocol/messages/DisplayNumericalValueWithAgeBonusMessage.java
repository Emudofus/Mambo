

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DisplayNumericalValueWithAgeBonusMessage extends DisplayNumericalValueMessage {
    public static final int MESSAGE_ID = 6361;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int valueOfBonus;
    
    public DisplayNumericalValueWithAgeBonusMessage() { }
    
    public DisplayNumericalValueWithAgeBonusMessage(int entityId, int value, byte type, int valueOfBonus) {
        super(entityId, value, type);
        this.valueOfBonus = valueOfBonus;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(valueOfBonus);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        valueOfBonus = buf.readInt();
    }
    
}
