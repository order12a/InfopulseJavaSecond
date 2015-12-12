package lection14;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "productlines")
public class ProductLine {
    @DatabaseField(id = true, canBeNull = false, useGetSet = true) //primary key (id = true)
    private String productLine;

    @DatabaseField(useGetSet = true)
    private String textDescription;

    public static final String PRODUCT_LINE_COLUMN = "productLine";

    ProductLine(){

    }

    public ProductLine(String productLine, String textDescription) {
        super();
        this.productLine = productLine;
        this.textDescription = textDescription;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                '}';
    }
}
