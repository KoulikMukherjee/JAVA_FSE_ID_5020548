public class Test {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        RemoteControl remoteControl = new RemoteControl();

        System.out.println("Light On Command");
        remoteControl.setCommand(lightOnCommand);
        remoteControl.executeCommand();
        System.out.println();

        System.out.println("Light Off Command");
        remoteControl.setCommand(lightOffCommand);
        remoteControl.executeCommand();




    }
}