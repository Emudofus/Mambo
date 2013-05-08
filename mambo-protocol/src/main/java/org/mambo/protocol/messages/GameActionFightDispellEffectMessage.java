

// Generated on 05/08/2013 19:37:39
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameActionFightDispellEffectMessage extends GameActionFightDispellMessage {
    public static final int MESSAGE_ID = 6113;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int boostUID;
    
    public GameActionFightDispellEffectMessage() { }
    
    public GameActionFightDispellEffectMessage(short actionId, int sourceId, int targetId, int boostUID) {
        super(actionId, sourceId, targetId);
        this.boostUID = boostUID;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(boostUID);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        boostUID = buf.readInt();
        if (boostUID < 0)
            throw new RuntimeException("Forbidden value on boostUID = " + boostUID + ", it doesn't respect the following condition : boostUID < 0");
    }
    
}
