package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ItemType implements Serializable{
    int typeID;
    String typeName;

    public ItemType(String typeName) {
        this.typeName = typeName;
    }

    public ItemType(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }
}
