
package com.waterMark.main;

import java.awt.AlphaComposite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;


public class WaterMark {
   
    public void showFiles(File file, String watermark, String output_image){ //String used for output_image since file manipulation is not needed
        // file - directory containing files to be watermarked
        //watermark - path to watermark image
        //output-image - directory where the watermarked images will be saved
        
        File aFile[] = file.listFiles(); //retrieves the list of files in the "file" directory and stores them in the array
       
        int i = 0;
        //iterates over the files in aFile array  
        for (int j = aFile.length; i<j; i++) {
            //file object created
            File files = aFile[i];
            File originalFile = new File(file + "\\" + files.getName());//representating the path to current file
            //prints out the file name
            System.out.println(files.getName());
            
            File mark = new File(watermark);//a File object named mark representing the watermark image file.
            
            // Output file - unique name 
            int min = 1000, max = 9999;//define the range for generating a random number
            int randomNum = ThreadLocalRandom.current().nextInt(min,max+1);//generate a random number within that range using ThreadLocalRandom.
            
            String filename = "IMG-" + randomNum;//construct the filename for the output watermarked image by appending the random number to the prefix "IMG-".
            File outputFile = new File(output_image + "\\" + filename + ".jpg");//creates a File object named outputFile representing the path to the output image file.
            addMark(mark, "png", originalFile, outputFile);//addMark method with the mark file, file type ("png"), originalFile, and outputFile as arguments
            //This method adds the watermark to the original image and saves the watermarked image to the output file.
        }
    }
    
    public void addMark(File mark, String type, File file, File dest){
        //mark - watermark image file
        //type - representing watermark file type
        //file - representing original image file
        //dest - representing destination output file
        try{
            //stored into BufferedImage objects - image manipulation
            BufferedImage image = ImageIO.read(file);//reads both original file and watermark image file
            BufferedImage overlay = resize(ImageIO.read(mark), 150, 150);//The watermark image is also resized to a specific width and height (150x150 pixels) using the resize method.
            
            //The imageType variable determines the type of the watermarked image based on the type parameter.
            // If the type is "png" (ignoring case), then imageType is set to BufferedImage.TYPE_INT_ARGB. Otherwise, it is set to BufferedImage.TYPE_INT_RGB.
            int imageType = "png".equalsIgnoreCase(type) ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
            //a new BufferedImage named watermarked is created with the same dimensions as the original image.
            BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);
            
            //draw the original image onto a Graphics2D object named w from the watermarked image
            //It allows drawing on the watermarked image.
            Graphics2D w = (Graphics2D) watermarked.getGraphics();
            w.drawImage(image, 0, 0, null);
            //An AlphaComposite is set to make the watermark image fully opaque when drawn onto the watermarked image..
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
            w.setComposite(alphaChannel);
            
            //positionining of watermark using the center coordinates of the original image
            int centerX = image.getWidth()/2;
            int centerY = image.getHeight()/2;
            
            w.drawImage(overlay, 50, 50, null);//draws the watermark at specific coordinates 
            ImageIO.write(watermarked, type, dest);//the watermarked image is saved to the output file (dest) using ImageIO.write.
            //This line releases system resources used by the w graphics context.
            w.dispose();
            //This catch block handles any IOException that may occur during the image reading, writing, or resizing operations and prints the stack trace for debugging purposes.
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    //a private helper method named resize that takes a BufferedImage (img) and the desired height and width for resizing.
    private BufferedImage resize(BufferedImage img, int height, int width){
        //resize the input image (img) to the specified dimensions (width and height) using getScaledInstance. 
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        // a new BufferedImage named resized is created with the same dimensions.
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);//specific color type
        //The resized image is drawn onto the resized image 
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        //Graphics2D context is disposed
        g2d.dispose();
        //the resized image is returned.
        return resized;
    }
}
