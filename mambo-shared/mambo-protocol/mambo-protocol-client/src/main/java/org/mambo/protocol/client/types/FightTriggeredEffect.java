

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(arg1);
        writer.writeInt(arg2);
        writer.writeInt(arg3);
        writer.writeShort(delay);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        arg1 = reader.readInt();
        arg2 = reader.readInt();
        arg3 = reader.readInt();
        delay = reader.readShort();
    }
    
}
