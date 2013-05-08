

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(humanoidInfo.getTypeId());
        humanoidInfo.serialize(buf);
        buf.writeInt(accountId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        humanoidInfo = ProtocolTypeManager.getInstance().build(buf.readShort());
        humanoidInfo.deserialize(buf);
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
    }
    
}
