

// Generated on 11/11/2012 20:41:24
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterSelectedSuccessMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 153;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public CharacterBaseInformations infos;
    
    public CharacterSelectedSuccessMessage() { }
    
    public CharacterSelectedSuccessMessage(CharacterBaseInformations infos) {
        this.infos = infos;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        infos.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        infos = new CharacterBaseInformations();
        infos.deserialize(reader);
    }
    
}
