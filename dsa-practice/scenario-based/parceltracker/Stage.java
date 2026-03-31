package week03.scenariobased.parceltracker;

class Stage {
	String name;
	Stage next;
	
	Stage(String name) {
        this.name = name;
        this.next = null;
    }
	
}
