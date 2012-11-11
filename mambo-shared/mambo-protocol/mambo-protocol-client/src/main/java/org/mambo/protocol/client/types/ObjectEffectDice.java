

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectEffectDice extends ObjectEffect {
    public static final short TYPE_ID = 73;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short diceNum;
    public short diceSide;
    public short diceConst;
    
    public ObjectEffectDice() { }
    
    public ObjectEffectDice(short actionId, short diceNum, short diceSide, short diceConst) {
        super(actionId);
        this.diceNum = diceNum;
        this.diceSide = diceSide;
        this.diceConst = diceConst;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(diceNum);
        writer.writeShort(diceSide);
        writer.writeShort(diceConst);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        diceNum = reader.readShort();
        if (diceNum < 0)
            throw new RuntimeException("Forbidden value on diceNum = " + diceNum + ", it doesn't respect the following condition : diceNum < 0");
        diceSide = reader.readShort();
        if (diceSide < 0)
            throw new RuntimeException("Forbidden value on diceSide = " + diceSide + ", it doesn't respect the following condition : diceSide < 0");
        diceConst = reader.readShort();
        if (diceConst < 0)
            throw new RuntimeException("Forbidden value on diceConst = " + diceConst + ", it doesn't respect the following condition : diceConst < 0");
    }
    
}
