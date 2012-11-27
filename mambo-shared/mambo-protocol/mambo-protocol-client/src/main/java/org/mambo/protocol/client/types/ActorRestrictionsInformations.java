

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ActorRestrictionsInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 204;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean cantBeAggressed;
    public boolean cantBeChallenged;
    public boolean cantTrade;
    public boolean cantBeAttackedByMutant;
    public boolean cantRun;
    public boolean forceSlowWalk;
    public boolean cantMinimize;
    public boolean cantMove;
    public boolean cantAggress;
    public boolean cantChallenge;
    public boolean cantExchange;
    public boolean cantAttack;
    public boolean cantChat;
    public boolean cantBeMerchant;
    public boolean cantUseObject;
    public boolean cantUseTaxCollector;
    public boolean cantUseInteractive;
    public boolean cantSpeakToNPC;
    public boolean cantChangeZone;
    public boolean cantAttackMonster;
    public boolean cantWalk8Directions;
    
    public ActorRestrictionsInformations() { }
    
    public ActorRestrictionsInformations(boolean cantBeAggressed, boolean cantBeChallenged, boolean cantTrade, boolean cantBeAttackedByMutant, boolean cantRun, boolean forceSlowWalk, boolean cantMinimize, boolean cantMove, boolean cantAggress, boolean cantChallenge, boolean cantExchange, boolean cantAttack, boolean cantChat, boolean cantBeMerchant, boolean cantUseObject, boolean cantUseTaxCollector, boolean cantUseInteractive, boolean cantSpeakToNPC, boolean cantChangeZone, boolean cantAttackMonster, boolean cantWalk8Directions) {
        this.cantBeAggressed = cantBeAggressed;
        this.cantBeChallenged = cantBeChallenged;
        this.cantTrade = cantTrade;
        this.cantBeAttackedByMutant = cantBeAttackedByMutant;
        this.cantRun = cantRun;
        this.forceSlowWalk = forceSlowWalk;
        this.cantMinimize = cantMinimize;
        this.cantMove = cantMove;
        this.cantAggress = cantAggress;
        this.cantChallenge = cantChallenge;
        this.cantExchange = cantExchange;
        this.cantAttack = cantAttack;
        this.cantChat = cantChat;
        this.cantBeMerchant = cantBeMerchant;
        this.cantUseObject = cantUseObject;
        this.cantUseTaxCollector = cantUseTaxCollector;
        this.cantUseInteractive = cantUseInteractive;
        this.cantSpeakToNPC = cantSpeakToNPC;
        this.cantChangeZone = cantChangeZone;
        this.cantAttackMonster = cantAttackMonster;
        this.cantWalk8Directions = cantWalk8Directions;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, cantBeAggressed);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, cantBeChallenged);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, cantTrade);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, cantBeAttackedByMutant);
        flag1 = BooleanByteWrapper.setFlag(flag1, 4, cantRun);
        flag1 = BooleanByteWrapper.setFlag(flag1, 5, forceSlowWalk);
        flag1 = BooleanByteWrapper.setFlag(flag1, 6, cantMinimize);
        flag1 = BooleanByteWrapper.setFlag(flag1, 7, cantMove);
        writer.writeUnsignedByte(flag1);
        short flag2 = 0;
        flag2 = BooleanByteWrapper.setFlag(flag2, 0, cantAggress);
        flag2 = BooleanByteWrapper.setFlag(flag2, 1, cantChallenge);
        flag2 = BooleanByteWrapper.setFlag(flag2, 2, cantExchange);
        flag2 = BooleanByteWrapper.setFlag(flag2, 3, cantAttack);
        flag2 = BooleanByteWrapper.setFlag(flag2, 4, cantChat);
        flag2 = BooleanByteWrapper.setFlag(flag2, 5, cantBeMerchant);
        flag2 = BooleanByteWrapper.setFlag(flag2, 6, cantUseObject);
        flag2 = BooleanByteWrapper.setFlag(flag2, 7, cantUseTaxCollector);
        writer.writeUnsignedByte(flag2);
        short flag3 = 0;
        flag3 = BooleanByteWrapper.setFlag(flag3, 0, cantUseInteractive);
        flag3 = BooleanByteWrapper.setFlag(flag3, 1, cantSpeakToNPC);
        flag3 = BooleanByteWrapper.setFlag(flag3, 2, cantChangeZone);
        flag3 = BooleanByteWrapper.setFlag(flag3, 3, cantAttackMonster);
        flag3 = BooleanByteWrapper.setFlag(flag3, 4, cantWalk8Directions);
        writer.writeUnsignedByte(flag3);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        cantBeAggressed = BooleanByteWrapper.getFlag(flag1, 0);
        cantBeChallenged = BooleanByteWrapper.getFlag(flag1, 1);
        cantTrade = BooleanByteWrapper.getFlag(flag1, 2);
        cantBeAttackedByMutant = BooleanByteWrapper.getFlag(flag1, 3);
        cantRun = BooleanByteWrapper.getFlag(flag1, 4);
        forceSlowWalk = BooleanByteWrapper.getFlag(flag1, 5);
        cantMinimize = BooleanByteWrapper.getFlag(flag1, 6);
        cantMove = BooleanByteWrapper.getFlag(flag1, 7);
        short flag2 = reader.readUnsignedByte();
        cantAggress = BooleanByteWrapper.getFlag(flag2, 0);
        cantChallenge = BooleanByteWrapper.getFlag(flag2, 1);
        cantExchange = BooleanByteWrapper.getFlag(flag2, 2);
        cantAttack = BooleanByteWrapper.getFlag(flag2, 3);
        cantChat = BooleanByteWrapper.getFlag(flag2, 4);
        cantBeMerchant = BooleanByteWrapper.getFlag(flag2, 5);
        cantUseObject = BooleanByteWrapper.getFlag(flag2, 6);
        cantUseTaxCollector = BooleanByteWrapper.getFlag(flag2, 7);
        short flag3 = reader.readUnsignedByte();
        cantUseInteractive = BooleanByteWrapper.getFlag(flag3, 0);
        cantSpeakToNPC = BooleanByteWrapper.getFlag(flag3, 1);
        cantChangeZone = BooleanByteWrapper.getFlag(flag3, 2);
        cantAttackMonster = BooleanByteWrapper.getFlag(flag3, 3);
        cantWalk8Directions = BooleanByteWrapper.getFlag(flag3, 4);
    }
    
}
