

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class TaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionBasicMessage {
    public static final int MESSAGE_ID = 5615;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short maxPods;
    public short prospecting;
    public short wisdom;
    public byte taxCollectorsCount;
    public int taxCollectorAttack;
    public int kamas;
    public double experience;
    public int pods;
    public int itemsValue;
    
    public TaxCollectorDialogQuestionExtendedMessage() { }
    
    public TaxCollectorDialogQuestionExtendedMessage(BasicGuildInformations guildInfo, short maxPods, short prospecting, short wisdom, byte taxCollectorsCount, int taxCollectorAttack, int kamas, double experience, int pods, int itemsValue) {
        super(guildInfo);
        this.maxPods = maxPods;
        this.prospecting = prospecting;
        this.wisdom = wisdom;
        this.taxCollectorsCount = taxCollectorsCount;
        this.taxCollectorAttack = taxCollectorAttack;
        this.kamas = kamas;
        this.experience = experience;
        this.pods = pods;
        this.itemsValue = itemsValue;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(maxPods);
        writer.writeShort(prospecting);
        writer.writeShort(wisdom);
        writer.writeByte(taxCollectorsCount);
        writer.writeInt(taxCollectorAttack);
        writer.writeInt(kamas);
        writer.writeDouble(experience);
        writer.writeInt(pods);
        writer.writeInt(itemsValue);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        maxPods = reader.readShort();
        if (maxPods < 0)
            throw new RuntimeException("Forbidden value on maxPods = " + maxPods + ", it doesn't respect the following condition : maxPods < 0");
        prospecting = reader.readShort();
        if (prospecting < 0)
            throw new RuntimeException("Forbidden value on prospecting = " + prospecting + ", it doesn't respect the following condition : prospecting < 0");
        wisdom = reader.readShort();
        if (wisdom < 0)
            throw new RuntimeException("Forbidden value on wisdom = " + wisdom + ", it doesn't respect the following condition : wisdom < 0");
        taxCollectorsCount = reader.readByte();
        if (taxCollectorsCount < 0)
            throw new RuntimeException("Forbidden value on taxCollectorsCount = " + taxCollectorsCount + ", it doesn't respect the following condition : taxCollectorsCount < 0");
        taxCollectorAttack = reader.readInt();
        kamas = reader.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
        experience = reader.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        pods = reader.readInt();
        if (pods < 0)
            throw new RuntimeException("Forbidden value on pods = " + pods + ", it doesn't respect the following condition : pods < 0");
        itemsValue = reader.readInt();
        if (itemsValue < 0)
            throw new RuntimeException("Forbidden value on itemsValue = " + itemsValue + ", it doesn't respect the following condition : itemsValue < 0");
    }
    
}
