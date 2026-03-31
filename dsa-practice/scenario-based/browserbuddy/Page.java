package week03.scenariobased.browserbuddy;

class Page {
	String url;
    Page prev;
    Page next;

    Page(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}
