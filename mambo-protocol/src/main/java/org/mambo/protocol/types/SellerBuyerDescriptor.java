

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SellerBuyerDescriptor extends NetworkType {
    public static final short TYPE_ID = 121;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeUShort(quantities.length);
        for (int entry : quantities) {
            buf.writeInt(entry);
        }
        buf.writeUShort(types.length);
        for (int entry : types) {
            buf.writeInt(entry);
        }
        buf.writeFloat(taxPercentage);
        buf.writeInt(maxItemLevel);
        buf.writeInt(maxItemPerAccount);
        buf.writeInt(npcContextualId);
        buf.writeShort(unsoldDelay);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        quantities = new int[limit];
        for (int i = 0; i < limit; i++) {
            quantities[i] = buf.readInt();
        }
        limit = buf.readUShort();
        types = new int[limit];
        for (int i = 0; i < limit; i++) {
            types[i] = buf.readInt();
        }
        taxPercentage = buf.readFloat();
        maxItemLevel = buf.readInt();
        if (maxItemLevel < 0)
            throw new RuntimeException("Forbidden value on maxItemLevel = " + maxItemLevel + ", it doesn't respect the following condition : maxItemLevel < 0");
        maxItemPerAccount = buf.readInt();
        if (maxItemPerAccount < 0)
            throw new RuntimeException("Forbidden value on maxItemPerAccount = " + maxItemPerAccount + ", it doesn't respect the following condition : maxItemPerAccount < 0");
        npcContextualId = buf.readInt();
        unsoldDelay = buf.readShort();
        if (unsoldDelay < 0)
            throw new RuntimeException("Forbidden value on unsoldDelay = " + unsoldDelay + ", it doesn't respect the following condition : unsoldDelay < 0");
    }
    
}
