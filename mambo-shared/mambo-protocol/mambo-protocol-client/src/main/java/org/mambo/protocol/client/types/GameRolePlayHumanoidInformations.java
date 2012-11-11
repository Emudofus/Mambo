

// Generated on 11/11/2012 19:06:12
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameRolePlayHumanoidInformations extends GameRolePlayNamedActorInformations {
    public static final short TYPE_ID = 159;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public HumanInformations humanoidInfo;
    
    public GameRolePlayHumanoidInformations() { }
    
    public GameRolePlayHumanoidInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, HumanInformations humanoidInfo) {
        super(contextualId, look, disposition, name);
        this.humanoidInfo = humanoidInfo;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(humanoidInfo.getTypeId());
        humanoidInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        humanoidInfo = ProtocolTypeManager.getInstance().build(reader.readShort(), HumanInformations.class);
        humanoidInfo.deserialize(reader);
    }
    
}
