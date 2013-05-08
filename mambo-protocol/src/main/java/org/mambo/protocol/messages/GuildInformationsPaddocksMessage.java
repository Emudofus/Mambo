

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildInformationsPaddocksMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5959;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte nbPaddockMax;
    public PaddockContentInformations[] paddocksInformations;
    
    public GuildInformationsPaddocksMessage() { }
    
    public GuildInformationsPaddocksMessage(byte nbPaddockMax, PaddockContentInformations[] paddocksInformations) {
        this.nbPaddockMax = nbPaddockMax;
        this.paddocksInformations = paddocksInformations;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(nbPaddockMax);
        buf.writeUShort(paddocksInformations.length);
        for (PaddockContentInformations entry : paddocksInformations) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        nbPaddockMax = buf.readByte();
        if (nbPaddockMax < 0)
            throw new RuntimeException("Forbidden value on nbPaddockMax = " + nbPaddockMax + ", it doesn't respect the following condition : nbPaddockMax < 0");
        int limit = buf.readUShort();
        paddocksInformations = new PaddockContentInformations[limit];
        for (int i = 0; i < limit; i++) {
            paddocksInformations[i] = new PaddockContentInformations();
            paddocksInformations[i].deserialize(buf);
        }
    }
    
}
