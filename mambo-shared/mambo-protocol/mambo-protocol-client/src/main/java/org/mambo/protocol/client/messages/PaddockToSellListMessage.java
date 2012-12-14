

// Generated on 12/14/2012 18:44:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PaddockToSellListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6138;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short pageIndex;
    public short totalPage;
    public PaddockInformationsForSell[] paddockList;
    
    public PaddockToSellListMessage() { }
    
    public PaddockToSellListMessage(short pageIndex, short totalPage, PaddockInformationsForSell[] paddockList) {
        this.pageIndex = pageIndex;
        this.totalPage = totalPage;
        this.paddockList = paddockList;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(pageIndex);
        writer.writeShort(totalPage);
        writer.writeUnsignedShort(paddockList.length);
        for (PaddockInformationsForSell entry : paddockList) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        pageIndex = reader.readShort();
        if (pageIndex < 0)
            throw new RuntimeException("Forbidden value on pageIndex = " + pageIndex + ", it doesn't respect the following condition : pageIndex < 0");
        totalPage = reader.readShort();
        if (totalPage < 0)
            throw new RuntimeException("Forbidden value on totalPage = " + totalPage + ", it doesn't respect the following condition : totalPage < 0");
        int limit = reader.readUnsignedShort();
        paddockList = new PaddockInformationsForSell[limit];
        for (int i = 0; i < limit; i++) {
            paddockList[i] = new PaddockInformationsForSell();
            paddockList[i].deserialize(reader);
        }
    }
    
}
