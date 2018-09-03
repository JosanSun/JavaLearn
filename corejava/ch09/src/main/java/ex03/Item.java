package ex03;

import java.util.Objects;

/**
 * @Author : zs.sun
 * @Date : 2018/8/12 17:26
 * @Package : ex03
 * @ProjectName: corejava
 * @Description: An Item with a description and a part number
 */
public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    /**
     * Constructs an item.
     * @param aDescription the item's description
     * @param aPartNumber  the item's part number
     */
    public Item(String aDescription, int aPartNumber)
    {
        description = aDescription;
        partNumber = aPartNumber;
    }

    /**
     * Gets the description of this item.
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        return "[description = " + description + ", partNumber = " + partNumber + "]";
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if(this == otherObject)
        {
            return true;
        }
        if(null == otherObject)
        {
            return false;
        }
        if(getClass() != otherObject.getClass())
        {
            return false;
        }

        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) &&partNumber == other.partNumber;

    }

    @Override
    public int hashCode()
    {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item other)
    {
        int diff = Integer.compare(partNumber, other.partNumber);        // 通过改变diff的值，可以实现由大到小的排序。默认：由小到大
        return diff != 0? diff : description.compareTo(other.description);
    }
}
