

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(infos.getTypeId());
        infos.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        infos = ProtocolTypeManager.getInstance().build(buf.readShort());
        infos.deserialize(buf);
    }
    
}
