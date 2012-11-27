

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameRolePlayHumanoidInformations extends GameRolePlayNamedActorInformations {
    public static final short TYPE_ID = 159;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public HumanInformations humanoidInfo;
    public int accountId;
    
    public GameRolePlayHumanoidInformations() { }
    
    public GameRolePlayHumanoidInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, HumanInformations humanoidInfo, int accountId) {
        super(contextualId, look, disposition, name);
        this.humanoidInfo = humanoidInfo;
        this.accountId = accountId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(humanoidInfo.getTypeId());
        humanoidInfo.serialize(writer);
        writer.writeInt(accountId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        humanoidInfo = ProtocolTypeManager.getInstance().build(reader.readShort(), HumanInformations.class);
        humanoidInfo.deserialize(reader);
        accountId = reader.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
    }
    
}
