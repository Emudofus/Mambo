

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        alignmentBonus.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        alignmentBonus = new AlignmentBonusInformations();
        alignmentBonus.deserialize(buf);
    }
    
}
