

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameRolePlayNpcWithQuestInformations extends GameRolePlayNpcInformations {
    public static final short TYPE_ID = 383;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GameRolePlayNpcQuestFlag questFlag;
    
    public GameRolePlayNpcWithQuestInformations() { }
    
    public GameRolePlayNpcWithQuestInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, short npcId, boolean sex, short specialArtworkId, GameRolePlayNpcQuestFlag questFlag) {
        super(contextualId, look, disposition, npcId, sex, specialArtworkId);
        this.questFlag = questFlag;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        questFlag.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        questFlag = new GameRolePlayNpcQuestFlag();
        questFlag.deserialize(reader);
    }
    
}
