

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TaxCollectorListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5930;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte nbcollectorMax;
    public short taxCollectorHireCost;
    public TaxCollectorInformations[] informations;
    public TaxCollectorFightersInformation[] fightersInformations;
    
    public TaxCollectorListMessage() { }
    
    public TaxCollectorListMessage(byte nbcollectorMax, short taxCollectorHireCost, TaxCollectorInformations[] informations, TaxCollectorFightersInformation[] fightersInformations) {
        this.nbcollectorMax = nbcollectorMax;
        this.taxCollectorHireCost = taxCollectorHireCost;
        this.informations = informations;
        this.fightersInformations = fightersInformations;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(nbcollectorMax);
        buf.writeShort(taxCollectorHireCost);
        buf.writeUShort(informations.length);
        for (TaxCollectorInformations entry : informations) {
            buf.writeShort(entry.getTypeId());
            entry.serialize(buf);
        }
        buf.writeUShort(fightersInformations.length);
        for (TaxCollectorFightersInformation entry : fightersInformations) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        nbcollectorMax = buf.readByte();
        if (nbcollectorMax < 0)
            throw new RuntimeException("Forbidden value on nbcollectorMax = " + nbcollectorMax + ", it doesn't respect the following condition : nbcollectorMax < 0");
        taxCollectorHireCost = buf.readShort();
        if (taxCollectorHireCost < 0)
            throw new RuntimeException("Forbidden value on taxCollectorHireCost = " + taxCollectorHireCost + ", it doesn't respect the following condition : taxCollectorHireCost < 0");
        int limit = buf.readUShort();
        informations = new TaxCollectorInformations[limit];
        for (int i = 0; i < limit; i++) {
            informations[i] = ProtocolTypeManager.getInstance().build(buf.readShort());
            informations[i].deserialize(buf);
        }
        limit = buf.readUShort();
        fightersInformations = new TaxCollectorFightersInformation[limit];
        for (int i = 0; i < limit; i++) {
            fightersInformations[i] = new TaxCollectorFightersInformation();
            fightersInformations[i].deserialize(buf);
        }
    }
    
}
