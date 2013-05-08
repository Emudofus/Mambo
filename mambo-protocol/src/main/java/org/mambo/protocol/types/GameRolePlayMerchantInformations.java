

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(sellType);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        sellType = buf.readInt();
        if (sellType < 0)
            throw new RuntimeException("Forbidden value on sellType = " + sellType + ", it doesn't respect the following condition : sellType < 0");
    }
    
}
