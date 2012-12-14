

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SellerBuyerDescriptor implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 121;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int[] quantities;
    public int[] types;
    public float taxPercentage;
    public int maxItemLevel;
    public int maxItemPerAccount;
    public int npcContextualId;
    public short unsoldDelay;
    
    public SellerBuyerDescriptor() { }
    
    public SellerBuyerDescriptor(int[] quantities, int[] types, float taxPercentage, int maxItemLevel, int maxItemPerAccount, int npcContextualId, short unsoldDelay) {
        this.quantities = quantities;
        this.types = types;
        this.taxPercentage = taxPercentage;
        this.maxItemLevel = maxItemLevel;
        this.maxItemPerAccount = maxItemPerAccount;
        this.npcContextualId = npcContextualId;
        this.unsoldDelay = unsoldDelay;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(quantities.length);
        for (int entry : quantities) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedShort(types.length);
        for (int entry : types) {
            writer.writeInt(entry);
        }
        writer.writeFloat(taxPercentage);
        writer.writeInt(maxItemLevel);
        writer.writeInt(maxItemPerAccount);
        writer.writeInt(npcContextualId);
        writer.writeShort(unsoldDelay);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        quantities = new int[limit];
        for (int i = 0; i < limit; i++) {
            quantities[i] = reader.readInt();
        }
        limit = reader.readUnsignedShort();
        types = new int[limit];
        for (int i = 0; i < limit; i++) {
            types[i] = reader.readInt();
        }
        taxPercentage = reader.readFloat();
        maxItemLevel = reader.readInt();
        if (maxItemLevel < 0)
            throw new RuntimeException("Forbidden value on maxItemLevel = " + maxItemLevel + ", it doesn't respect the following condition : maxItemLevel < 0");
        maxItemPerAccount = reader.readInt();
        if (maxItemPerAccount < 0)
            throw new RuntimeException("Forbidden value on maxItemPerAccount = " + maxItemPerAccount + ", it doesn't respect the following condition : maxItemPerAccount < 0");
        npcContextualId = reader.readInt();
        unsoldDelay = reader.readShort();
        if (unsoldDelay < 0)
            throw new RuntimeException("Forbidden value on unsoldDelay = " + unsoldDelay + ", it doesn't respect the following condition : unsoldDelay < 0");
    }
    
}
