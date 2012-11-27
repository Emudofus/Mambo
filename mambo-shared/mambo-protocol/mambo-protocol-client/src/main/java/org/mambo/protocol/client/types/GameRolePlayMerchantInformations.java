

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class GameRolePlayMerchantInformations extends GameRolePlayNamedActorInformations {
    public static final short TYPE_ID = 129;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int sellType;
    
    public GameRolePlayMerchantInformations() { }
    
    public GameRolePlayMerchantInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, int sellType) {
        super(contextualId, look, disposition, name);
        this.sellType = sellType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(sellType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        sellType = reader.readInt();
        if (sellType < 0)
            throw new RuntimeException("Forbidden value on sellType = " + sellType + ", it doesn't respect the following condition : sellType < 0");
    }
    
}
