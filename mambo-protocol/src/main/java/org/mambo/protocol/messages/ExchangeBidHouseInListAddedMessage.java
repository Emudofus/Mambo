

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeBidHouseInListAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5949;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int itemUID;
    public int objGenericId;
    public short powerRate;
    public boolean overMax;
    public ObjectEffect[] effects;
    public int[] prices;
    
    public ExchangeBidHouseInListAddedMessage() { }
    
    public ExchangeBidHouseInListAddedMessage(int itemUID, int objGenericId, short powerRate, boolean overMax, ObjectEffect[] effects, int[] prices) {
        this.itemUID = itemUID;
        this.objGenericId = objGenericId;
        this.powerRate = powerRate;
        this.overMax = overMax;
        this.effects = effects;
        this.prices = prices;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(itemUID);
        buf.writeInt(objGenericId);
        buf.writeShort(powerRate);
        buf.writeBoolean(overMax);
        buf.writeUShort(effects.length);
        for (ObjectEffect entry : effects) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeUShort(prices.length);
        for (int entry : prices) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        itemUID = buf.readInt();
        objGenericId = buf.readInt();
        powerRate = buf.readShort();
        overMax = buf.readBoolean();
        int limit = buf.readUShort();
        effects = new ObjectEffect[limit];
        for (int i = 0; i < limit; i++) {
            effects[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            effects[i].deserialize(buf);
        }
        limit = buf.readUShort();
        prices = new int[limit];
        for (int i = 0; i < limit; i++) {
            prices[i] = buf.readInt();
        }
    }
    
}
