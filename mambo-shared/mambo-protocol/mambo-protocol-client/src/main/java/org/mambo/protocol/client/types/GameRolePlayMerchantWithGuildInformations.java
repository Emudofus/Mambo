

// Generated on 01/04/2013 14:54:45
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        guildInformations.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        guildInformations = new GuildInformations();
        guildInformations.deserialize(reader);
    }
    
}
