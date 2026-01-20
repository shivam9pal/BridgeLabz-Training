package week04.gcrcodebase.generics.smartwarehouse;

class Electronics extends WarehouseItem{

	Electronics(String name) {
		super(name);
	}

	@Override
	String getType() {
		return "Electronics";
	}

}
