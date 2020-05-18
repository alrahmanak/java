package kar.fileio;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
/**
 * Example program to read a list of images and measure how the memory is affected
 * Until the OutOfMemoryError Java heap space error is thrown
 * @author Acer
 *
 */
public class ImageTest {
	
	 private static String[] FOLDER_ARRAY;
	   static {
		   FOLDER_ARRAY = new String[2];
		   FOLDER_ARRAY[0] = "C://Users/haame/Pictures/2019-06";
		   FOLDER_ARRAY[1] = "C://Users/haame/Pictures/2019-05";
	   }
	   
	   static ArrayList<Image> imagesList = new ArrayList<Image>();
	
	   public static void main(String[] args) throws Exception {
		   		   
		   
		   BufferedImage img;
		   
		   System.out.println("Read Image Folder ");
		   for(int i=0; i < FOLDER_ARRAY.length ; i++){
			   File folder = new File(FOLDER_ARRAY[i]);
			   loadImages(folder);
		   }
		   
	   }
	   
	   
	   public static void loadImages(File folder) throws Exception  {
		   File[] fileNames = folder.listFiles();
	        for(File file : fileNames){
	        	printMemory();
	            // if directory call the same method again
	            System.out.println("Reading file :" + file.getName() + " size " + getFileSizeMegaBytes(file));
	            imagesList.add(ImageIO.read(file));
	        }
	   }
	   
	   
	   public static void printMemory () {
		   int mb = 1024*1024;

			//Getting the runtime reference from system
			Runtime runtime = Runtime.getRuntime();

			System.out.print("##### Heap statistics [MB] ###");

			//Print used memory
			System.out.print("  Used Memory:"
				+ (runtime.totalMemory() - runtime.freeMemory()) / mb);

			//Print free memory
			System.out.print("  Free Memory:"
				+ runtime.freeMemory() / mb);

			//Print total available memory
			System.out.print("  Total Memory:" + runtime.totalMemory() / mb);

			//Print Maximum available memory
			System.out.println(" Max Memory:" + runtime.maxMemory() / mb);
	   }
	   
	   private static String getFileSizeMegaBytes(File file) {
		   double fileSize = (double) file.length() / (1024 * 1024);
			return  Math.round(fileSize) + " mb";
		}
	   
	   
	   
}
