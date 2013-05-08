

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        questFlag.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        questFlag = new GameRolePlayNpcQuestFlag();
        questFlag.deserialize(buf);
    }
    
}
