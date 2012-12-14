

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(nbcollectorMax);
        writer.writeShort(taxCollectorHireCost);
        writer.writeUnsignedShort(informations.length);
        for (TaxCollectorInformations entry : informations) {
            writer.writeShort(entry.getTypeId());
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(fightersInformations.length);
        for (TaxCollectorFightersInformation entry : fightersInformations) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        nbcollectorMax = reader.readByte();
        if (nbcollectorMax < 0)
            throw new RuntimeException("Forbidden value on nbcollectorMax = " + nbcollectorMax + ", it doesn't respect the following condition : nbcollectorMax < 0");
        taxCollectorHireCost = reader.readShort();
        if (taxCollectorHireCost < 0)
            throw new RuntimeException("Forbidden value on taxCollectorHireCost = " + taxCollectorHireCost + ", it doesn't respect the following condition : taxCollectorHireCost < 0");
        int limit = reader.readUnsignedShort();
        informations = new TaxCollectorInformations[limit];
        for (int i = 0; i < limit; i++) {
            informations[i] = ProtocolTypeManager.getInstance().build(reader.readShort(), TaxCollectorInformations.class);
            informations[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        fightersInformations = new TaxCollectorFightersInformation[limit];
        for (int i = 0; i < limit; i++) {
            fightersInformations[i] = new TaxCollectorFightersInformation();
            fightersInformations[i].deserialize(reader);
        }
    }
    
}
