package week08.gcrcodebase.filedownlaoder;

import java.util.Random;

class FileDownloaderThread extends Thread {
	
	public final String fileName;
	private final Random random=new Random();
	
	public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }
	public void run() {
	try {
        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println(
                Thread.currentThread().getName() +
                " downloading " + fileName +
                " : " + progress + "%"
            );

            // Random delay to simulate download time
            Thread.sleep(200 + random.nextInt(500));
        }
        System.out.println(Thread.currentThread().getName() +
                " completed download of " + fileName);
    } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName() +
                " interrupted while downloading " + fileName);
    	}	
    }
}
