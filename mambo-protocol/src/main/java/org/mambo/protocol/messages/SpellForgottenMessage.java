

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SpellForgottenMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5834;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] spellsId;
    public short boostPoint;
    
    public SpellForgottenMessage() { }
    
    public SpellForgottenMessage(short[] spellsId, short boostPoint) {
        this.spellsId = spellsId;
        this.boostPoint = boostPoint;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(spellsId.length);
        for (short entry : spellsId) {
            buf.writeShort(entry);
        }
        buf.writeShort(boostPoint);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        spellsId = new short[limit];
        for (int i = 0; i < limit; i++) {
            spellsId[i] = buf.readShort();
        }
        boostPoint = buf.readShort();
        if (boostPoint < 0)
            throw new RuntimeException("Forbidden value on boostPoint = " + boostPoint + ", it doesn't respect the following condition : boostPoint < 0");
    }
    
}
