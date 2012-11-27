

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class FightTeamMemberInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 44;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    
    public FightTeamMemberInformations() { }
    
    public FightTeamMemberInformations(int id) {
        this.id = id;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
    }
    
}
