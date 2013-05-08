

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorDialogQuestionBasicMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5619;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public BasicGuildInformations guildInfo;
    
    public TaxCollectorDialogQuestionBasicMessage() { }
    
    public TaxCollectorDialogQuestionBasicMessage(BasicGuildInformations guildInfo) {
        this.guildInfo = guildInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        guildInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(buf);
    }
    
}
