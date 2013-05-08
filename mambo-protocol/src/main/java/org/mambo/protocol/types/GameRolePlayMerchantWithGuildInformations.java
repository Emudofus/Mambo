

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameRolePlayMerchantWithGuildInformations extends GameRolePlayMerchantInformations {
    public static final short TYPE_ID = 146;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public GuildInformations guildInformations;
    
    public GameRolePlayMerchantWithGuildInformations() { }
    
    public GameRolePlayMerchantWithGuildInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, String name, int sellType, GuildInformations guildInformations) {
        super(contextualId, look, disposition, name, sellType);
        this.guildInformations = guildInformations;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        guildInformations.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        guildInformations = new GuildInformations();
        guildInformations.deserialize(buf);
    }
    
}
