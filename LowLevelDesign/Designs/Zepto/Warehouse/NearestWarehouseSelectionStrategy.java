package Designs.Zepto.Warehouse;

import java.util.List;

import Designs.Zepto.Warehouse;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy{

    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {
       //algo to pick the nearest algo, for now I am just picking the first warehouse for demo purpose
        return warehouseList.get(0);
    }


}
