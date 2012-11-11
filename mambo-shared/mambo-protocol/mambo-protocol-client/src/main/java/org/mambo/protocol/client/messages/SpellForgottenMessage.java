

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(spellsId.length);
        for (short entry : spellsId) {
            writer.writeShort(entry);
        }
        writer.writeShort(boostPoint);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        spellsId = new short[limit];
        for (int i = 0; i < limit; i++) {
            spellsId[i] = reader.readShort();
        }
        boostPoint = reader.readShort();
        if (boostPoint < 0)
            throw new RuntimeException("Forbidden value on boostPoint = " + boostPoint + ", it doesn't respect the following condition : boostPoint < 0");
    }
    
}
