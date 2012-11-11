

// Generated on 11/11/2012 19:06:12
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameRolePlayGroupMonsterInformations extends GameRolePlayActorInformations {
    public static final short TYPE_ID = 160;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int mainCreatureGenericId;
    public byte mainCreatureGrade;
    public MonsterInGroupInformations[] underlings;
    public short ageBonus;
    public byte alignmentSide;
    public boolean keyRingBonus;
    
    public GameRolePlayGroupMonsterInformations() { }
    
    public GameRolePlayGroupMonsterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, int mainCreatureGenericId, byte mainCreatureGrade, MonsterInGroupInformations[] underlings, short ageBonus, byte alignmentSide, boolean keyRingBonus) {
        super(contextualId, look, disposition);
        this.mainCreatureGenericId = mainCreatureGenericId;
        this.mainCreatureGrade = mainCreatureGrade;
        this.underlings = underlings;
        this.ageBonus = ageBonus;
        this.alignmentSide = alignmentSide;
        this.keyRingBonus = keyRingBonus;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(mainCreatureGenericId);
        writer.writeByte(mainCreatureGrade);
        writer.writeUnsignedShort(underlings.length);
        for (MonsterInGroupInformations entry : underlings) {
            entry.serialize(writer);
        }
        writer.writeShort(ageBonus);
        writer.writeByte(alignmentSide);
        writer.writeBoolean(keyRingBonus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        mainCreatureGenericId = reader.readInt();
        mainCreatureGrade = reader.readByte();
        if (mainCreatureGrade < 0)
            throw new RuntimeException("Forbidden value on mainCreatureGrade = " + mainCreatureGrade + ", it doesn't respect the following condition : mainCreatureGrade < 0");
        int limit = reader.readUnsignedShort();
        underlings = new MonsterInGroupInformations[limit];
        for (int i = 0; i < limit; i++) {
            underlings[i] = new MonsterInGroupInformations();
            underlings[i].deserialize(reader);
        }
        ageBonus = reader.readShort();
        if (ageBonus < -1 || ageBonus > 1000)
            throw new RuntimeException("Forbidden value on ageBonus = " + ageBonus + ", it doesn't respect the following condition : ageBonus < -1 || ageBonus > 1000");
        alignmentSide = reader.readByte();
        keyRingBonus = reader.readBoolean();
    }
    
}
