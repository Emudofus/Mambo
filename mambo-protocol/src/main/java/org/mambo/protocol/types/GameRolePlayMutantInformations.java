

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayMutantInformations extends GameRolePlayHumanoidInformations {
    public static final short TYPE_ID = 3;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int monsterId;
    public byte powerLevel;
    
    public GameRolePlayMutantInformations() { }
    
    public GameRolePlayMutantInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, HumanInformations humanoidInfo, int accountId, int monsterId, byte powerLevel) {
        super(contextualId, look, disposition, name, humanoidInfo, accountId);
        this.monsterId = monsterId;
        this.powerLevel = powerLevel;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(monsterId);
        buf.writeByte(powerLevel);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        monsterId = buf.readInt();
        powerLevel = buf.readByte();
    }
    
}
