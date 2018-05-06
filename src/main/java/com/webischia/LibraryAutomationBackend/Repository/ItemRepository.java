package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.ItemType;
import com.webischia.LibraryAutomationBackend.Domains.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // thanks Java 8, look the custom RowMapper
    public List<ItemType> getAllItemTypes() {

        List<ItemType> result = jdbcTemplate.query(
                "SELECT typeID,typeName FROM ITEMTYPE",
                (rs, rowNum) -> new ItemType(rs.getInt("typeID"),rs.getString("typeName")) );

        return result;

    }

    public ItemType getItemType(int id){

        return jdbcTemplate.queryForObject("select typeID,typeName from ITEMTYPE where typeID ="+id,
                (rs,rowNum) ->new ItemType(rs.getInt("typeID"),rs.getString("typeName")));

    }
    public ItemType addItemType(String name)
    {
        jdbcTemplate.execute("INSERT INTO ITEMTYPE(typeName) VALUES("+name+")");
        return jdbcTemplate.queryForObject("select typeID,typeName from ITEMTYPE where typeName ="+name,
                (rs,rowNum) ->new ItemType(rs.getInt("typeID"),rs.getString("typeName")));
    }
    public void deleteItemType(int id){
        jdbcTemplate.execute("DELETE FROM ITEMTYPE WHERE typeID ="+id);
    }

    public ItemType updateItemType(ItemType itemType , int id){
        jdbcTemplate.execute("UPDATE ITEMTYPE SET typeName="+itemType.getTypeName()+" WHERE typeID="+id);
        return getItemType(id);
    }

    public Items addItem(Items item,int typeID){
        jdbcTemplate.execute("INSERT INTO ITEMS(itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang)"+
        "VALUES("+item.getItemName()+","+typeID+","+item.getItemDesc()+","+item.getISBN()+","+item.getStockNo()+","+item.getSizeValue()+
                ","+item.getPageNumber()+","+item.getPrintYear()+","+item.getEditionNo()+","+item.getItemLang()+")");

        return getItem(jdbcTemplate
                .queryForObject("SELECT itemID FROM ITEMS WHERE stockNo="+item.getStockNo(),Integer.class));
    }
    public Items updateItem(Items item,int id)
    {
        jdbcTemplate.execute("UPDATE ITEMS SET itemName="+item.getItemName()+","+"typeID="+item.getTypeID()+","+"itemDesc="+item.getItemDesc()+","+
        "ISBN="+item.getISBN()+","+"stockNo="+item.getISBN()+","+"sizeValue="+item.getSizeValue()+","+"pageNumber="+item.getPageNumber()+","+
        "printYear="+item.getPrintYear()+","+"editionNo="+item.getEditionNo()+","+"itemLang="+item.getItemLang());
        return getItem(jdbcTemplate
                .queryForObject("SELECT itemID FROM ITEMS WHERE itemID="+id,Integer.class));
    }

    public void deleteItem(int id)
    {
        jdbcTemplate.execute("DELETE FROM ITEMS WHERE itemID ="+id);
    }
    public List<Items> getAllItems(){
        List<Items> result = jdbcTemplate.query("select itemID,itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang,editDate from ITEMS",
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang")));
        return result;
    }
//    itemID int not null,
//    itemName varchar2(80) not null,
//    typeID int not null,
//    itemDesc varchar2(300),
//    ISBN varchar2(60) unique,
//    stockNo varchar2(60) unique, ---filmlerde isbn yok
//    sizeValue varchar2(10), --- 30cm 10cm 10in
//    pageNumber varchar2(10) not null, ---300 + sayfa veya 400 + dk
//    printYear char(4) not null, ---2000
//    editionNo varchar2(10) not null, --- XX1 veya 10.basım iii.
//    itemLang char(2) not null, ---ISO 639-1
//    editDate timestamp not null,
    public Items getItem(int id){
        return jdbcTemplate.queryForObject("select itemID,itemName,typeID,itemDesc,ISBN,stockNo,sizeValue,pageNumber,printYear,editionNo,itemLang,editDate from ITEMS",
                (rs,rowNum) -> new Items(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("typeID"),rs.getString("itemDesc"),
                        rs.getString("ISBN"),rs.getString("stockNo"),rs.getString("sizeValue"),rs.getString("pageNumber"),
                        rs.getString("printYear"),rs.getString("editionNo"),rs.getTimestamp("editDate"),rs.getString("itemLang")));

    }


}
