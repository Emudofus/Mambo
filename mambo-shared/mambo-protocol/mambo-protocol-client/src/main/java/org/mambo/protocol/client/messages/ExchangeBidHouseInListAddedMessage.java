

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(itemUID);
        writer.writeInt(objGenericId);
        writer.writeShort(powerRate);
        writer.writeBoolean(overMax);
        writer.writeUnsignedShort(effects.length);
        for (ObjectEffect entry : effects) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(prices.length);
        for (int entry : prices) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        itemUID = reader.readInt();
        objGenericId = reader.readInt();
        powerRate = reader.readShort();
        overMax = reader.readBoolean();
        int limit = reader.readUnsignedShort();
        effects = new ObjectEffect[limit];
        for (int i = 0; i < limit; i++) {
            effects[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), ObjectEffect.class);
            effects[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        prices = new int[limit];
        for (int i = 0; i < limit; i++) {
            prices[i] = reader.readInt();
        }
    }
    
}
