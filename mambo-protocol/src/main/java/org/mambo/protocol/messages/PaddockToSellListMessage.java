

// Generated on 05/08/2013 19:37:48
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(pageIndex);
        buf.writeShort(totalPage);
        buf.writeUShort(paddockList.length);
        for (PaddockInformationsForSell entry : paddockList) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        pageIndex = buf.readShort();
        if (pageIndex < 0)
            throw new RuntimeException("Forbidden value on pageIndex = " + pageIndex + ", it doesn't respect the following condition : pageIndex < 0");
        totalPage = buf.readShort();
        if (totalPage < 0)
            throw new RuntimeException("Forbidden value on totalPage = " + totalPage + ", it doesn't respect the following condition : totalPage < 0");
        int limit = buf.readUShort();
        paddockList = new PaddockInformationsForSell[limit];
        for (int i = 0; i < limit; i++) {
            paddockList[i] = new PaddockInformationsForSell();
            paddockList[i].deserialize(buf);
        }
    }
    
}
