

// Generated on 11/11/2012 19:17:11
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PrismAlignmentBonusResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5842;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public AlignmentBonusInformations alignmentBonus;
    
    public PrismAlignmentBonusResultMessage() { }
    
    public PrismAlignmentBonusResultMessage(AlignmentBonusInformations alignmentBonus) {
        this.alignmentBonus = alignmentBonus;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        alignmentBonus.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        alignmentBonus = new AlignmentBonusInformations();
        alignmentBonus.deserialize(reader);
    }
    
}
