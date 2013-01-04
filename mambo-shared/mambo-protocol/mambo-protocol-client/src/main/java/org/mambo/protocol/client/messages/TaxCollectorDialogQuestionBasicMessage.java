

// Generated on 01/04/2013 14:54:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        guildInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        guildInfo = new BasicGuildInformations();
        guildInfo.deserialize(reader);
    }
    
}
