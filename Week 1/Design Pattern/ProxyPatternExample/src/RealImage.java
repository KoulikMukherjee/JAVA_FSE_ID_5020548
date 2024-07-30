public class RealImage implements Image {
    private String ImagePath;
    public void display() {
        System.out.println("Image Displaying from: " + ImagePath);
    }
    public void loadImage(String Path){
        this.ImagePath = Path;
        System.out.println("Loading image from: " + this.ImagePath);
    }
}
