

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(monsterId);
        writer.writeByte(powerLevel);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        monsterId = reader.readInt();
        powerLevel = reader.readByte();
    }
    
}
