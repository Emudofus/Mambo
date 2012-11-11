

// Generated on 11/11/2012 19:16:59
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
