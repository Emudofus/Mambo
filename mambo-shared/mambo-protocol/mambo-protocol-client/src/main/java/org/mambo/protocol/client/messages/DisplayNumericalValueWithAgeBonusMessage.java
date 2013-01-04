

// Generated on 01/04/2013 14:54:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(valueOfBonus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        valueOfBonus = reader.readInt();
    }
    
}
