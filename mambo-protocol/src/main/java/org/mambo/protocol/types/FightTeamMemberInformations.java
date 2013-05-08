

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class FightTeamMemberInformations extends NetworkType {
    public static final short TYPE_ID = 44;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    
    public FightTeamMemberInformations() { }
    
    public FightTeamMemberInformations(int id) {
        this.id = id;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(id);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
    }
    
}
