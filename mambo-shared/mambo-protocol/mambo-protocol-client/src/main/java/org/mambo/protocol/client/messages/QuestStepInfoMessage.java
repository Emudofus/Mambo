

// Generated on 01/04/2013 14:54:31
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class QuestStepInfoMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5625;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public QuestActiveInformations infos;
    
    public QuestStepInfoMessage() { }
    
    public QuestStepInfoMessage(QuestActiveInformations infos) {
        this.infos = infos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(infos.getTypeId());
        infos.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        infos = ProtocolTypeManager.getInstance().build(reader.readShort(), QuestActiveInformations.class);
        infos.deserialize(reader);
    }
    
}
