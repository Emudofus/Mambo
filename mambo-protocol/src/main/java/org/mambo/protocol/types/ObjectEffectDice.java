

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(diceNum);
        buf.writeShort(diceSide);
        buf.writeShort(diceConst);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        diceNum = buf.readShort();
        if (diceNum < 0)
            throw new RuntimeException("Forbidden value on diceNum = " + diceNum + ", it doesn't respect the following condition : diceNum < 0");
        diceSide = buf.readShort();
        if (diceSide < 0)
            throw new RuntimeException("Forbidden value on diceSide = " + diceSide + ", it doesn't respect the following condition : diceSide < 0");
        diceConst = buf.readShort();
        if (diceConst < 0)
            throw new RuntimeException("Forbidden value on diceConst = " + diceConst + ", it doesn't respect the following condition : diceConst < 0");
    }
    
}
