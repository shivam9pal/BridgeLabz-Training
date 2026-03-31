package week08.gcrcodebase.filedownlaoder;

class MainThread {
	public static void main(String[] args) throws InterruptedException{
		FileDownloaderThread t1=new FileDownloaderThread("Document.pdf");
		FileDownloaderThread t2=new FileDownloaderThread("image.jpg");
		FileDownloaderThread t3=new FileDownloaderThread("play.mp4");
		
		t1.setName("Thread-Document");
        t2.setName("Thread-Image");
        t3.setName("Thread-Video");
        
        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
        
        
        
        System.out.println(" Now Using Runnable Interface");
        
        Thread t4=new Thread(new FileDownloaderThread(("Document.pdf")));
        Thread t5=new Thread(new FileDownloaderThread(("image.jpg")));
        Thread t6=new Thread(new FileDownloaderThread(("play.mp4")));
        
        t4.start();
        t5.start();
        t6.start();
        
        
	}
}
