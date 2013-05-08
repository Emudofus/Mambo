

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightTriggeredEffect extends AbstractFightDispellableEffect {
    public static final short TYPE_ID = 210;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int arg1;
    public int arg2;
    public int arg3;
    public short delay;
    
    public FightTriggeredEffect() { }
    
    public FightTriggeredEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, int arg1, int arg2, int arg3, short delay) {
        super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid);
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        this.delay = delay;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(arg1);
        buf.writeInt(arg2);
        buf.writeInt(arg3);
        buf.writeShort(delay);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        arg1 = buf.readInt();
        arg2 = buf.readInt();
        arg3 = buf.readInt();
        delay = buf.readShort();
    }
    
}
