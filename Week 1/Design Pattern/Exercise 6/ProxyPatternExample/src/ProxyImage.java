public class ProxyImage implements Image{
    private RealImage realImage;
    private final String imagePath;

    public ProxyImage(String Path){
        this.imagePath = Path;
    }

    public void display(){
        if(realImage == null){
            this.realImage = new RealImage();
            realImage.loadImage(this.imagePath);
        }
        realImage.display();
    }
}
